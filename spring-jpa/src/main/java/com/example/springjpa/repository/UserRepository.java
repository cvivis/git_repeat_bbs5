package com.example.springjpa.repository;

import com.example.springjpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Long countByUserName(String userName);
}
