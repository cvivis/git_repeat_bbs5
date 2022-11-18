package com.example.springjpa.dto;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class PostUserRes {
//    long id;
    String userName;
    String message;

    @Override
    public String toString() {
        return "PostUserRes{" +
                "userName='" + userName + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
