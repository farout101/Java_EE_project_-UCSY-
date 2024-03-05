package com.cashnex.daoTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.cashnex.dao.ConnectionManager;
import com.cashnex.dao.UserDao;
import com.cashnex.model.User;

public class UserDaoTest {

//    private static final ConnectionManager connectionManager = ConnectionManager.getInstance();
//    private final UserDao userDao = new UserDao(connectionManager);
//
//    @Test
//    public void testInsertUser() {
//        User testUser = new User();
//        testUser.setUsername("test_user");
//        testUser.setEmail("test@example.com");
//        testUser.setPassword("test_password"); 
////
//        boolean isInserted = userDao.createUser(testUser);
////
//        if(isInserted) {
//        	assertTrue(isInserted, "User should be inserted successfully");
//        	
//        	
//        	User retrievedUser = userDao.getUserByUserId(2);
//        	assertNotNull(retrievedUser, "User should be retrieved from the database");
//        	assertEquals("test@example.com", retrievedUser.getEmail(), "Email should match");
//        }
//    }

}
