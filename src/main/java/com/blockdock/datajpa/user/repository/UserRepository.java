package com.blockdock.datajpa.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.blockdock.datajpa.user.model.User;


public interface UserRepository extends JpaRepository<User, Long>{
    
    User findByEmail(@Param("email") String email);
 
    @Query("SELECT u FROM User u WHERE u.phone = :phone AND u.password = :password")
    User findByPhoneAndPassword(@Param("phone") String email, @Param("password") String password);

}
