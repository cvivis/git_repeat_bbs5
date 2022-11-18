package com.example.springjpa.service;

import com.example.springjpa.dto.GetUserRes;
import com.example.springjpa.dto.PostUserReq;
import com.example.springjpa.dto.PostUserRes;
import com.example.springjpa.entity.User;
import com.example.springjpa.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public GetUserRes getUserById(Long id) {
        Optional<User> optUserRes = userRepository.findById(id);
        User user  = optUserRes.get();
        System.out.println(user.getId()+ " "+ user.getUserName()+ " "+ user.getPassword());
        GetUserRes getUserRes = GetUserRes.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .build();
        return getUserRes;
    }

    public PostUserRes addUser(PostUserReq postUserReq) {
        PostUserRes postUserRes;
        if(nameCheck(postUserReq)){
            postUserRes = PostUserRes.builder()
                    .userName(postUserReq.getUserName())
                    .message("중복된 이름입니다.")
                    .build();
        }else{
            User userEntity = postUserReq.toEntity();
            User userRes = userRepository.save(userEntity);
            postUserRes = PostUserRes.builder()
                    .userName(userRes.getUserName())
                    .message("가입이 완료되었습니다.")
                    .build();
        }
        return postUserRes;
    }

    public boolean nameCheck(PostUserReq postUserReq){
        if(userRepository.countByUserName(postUserReq.getUserName())>0)return true;
        else return false;
    }
}
