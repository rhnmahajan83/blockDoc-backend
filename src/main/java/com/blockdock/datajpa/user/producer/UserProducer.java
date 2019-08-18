package com.blockdock.datajpa.user.producer;
//package com.blockdock.datajpa.user.producer;
//
//import com.blockdock.datajpa.user.model.User;
//import com.blockdock.datajpa.user.service.UserService;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.util.List;
//
//
//@Component
//public class UserProducer {
//    private Log logger = LogFactory.getLog(UserProducer.class);
//
//    private UserService userService;
//
//    @Autowired
//    public UserProducer(UserService userService) {
//        this.userService = userService;
//    }
//
//    @PostConstruct
//    public void produceData() {
//        findUsers();
//        findUsers();
//    }
//
//    private void findUsers() {
//        logger.info("Trying to find all users.");
//        List<User> allUsers = userService.getAllUsers();
//        if(allUsers.isEmpty()) {
//            logger.info("--No users found--");
//        } else {
//            for (User foundUser : allUsers) {
//                logger.info(String.format("user with id %d and name %s found :)", foundUser.getId(), foundUser.getName()));
//            }
//        }
//    }
//}
