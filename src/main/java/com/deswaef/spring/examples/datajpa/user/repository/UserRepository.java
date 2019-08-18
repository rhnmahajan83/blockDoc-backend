package com.deswaef.spring.examples.datajpa.user.repository;

import com.deswaef.spring.examples.datajpa.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<User, Long>{

    User findByEmailAndPassword
            (
                @Param("email") String email,
                @Param("password") String password
            );
    User findByEmail(
    		 	@Param("email") String email
    		);

}
