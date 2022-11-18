package com.example.springjpa.controller;


import com.example.springjpa.dto.GetUserRes;
import com.example.springjpa.dto.PostUserReq;
import com.example.springjpa.dto.PostUserRes;
import com.example.springjpa.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<GetUserRes> getUserById(@PathVariable Long id){
        GetUserRes getUserRes = userService.getUserById(id);
        return ResponseEntity.ok().body(getUserRes);
    }

    @PostMapping("")
    public ResponseEntity<PostUserRes> addUser(@RequestBody PostUserReq postUserReq){
        PostUserRes postUserRes = userService.addUser(postUserReq);
        return  ResponseEntity.ok().body(postUserRes);
    }

}
