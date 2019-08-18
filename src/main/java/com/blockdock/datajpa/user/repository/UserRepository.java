package com.blockdock.datajpa.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.blockdock.datajpa.user.model.User;


public interface UserRepository extends JpaRepository<User, Long>{

    User findByEmailAndPassword
            (
                @Param("email") String email,
                @Param("password") String password
            );

}
