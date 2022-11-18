package com.example.springjpa.dto;

import com.example.springjpa.entity.User;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class PostUserReq {
    String userName;
    String password;

    public User toEntity(){
        User user = User.builder()
                .userName(this.getUserName())
                .password(this.getPassword())
                .build();
        return user;
    }
}
