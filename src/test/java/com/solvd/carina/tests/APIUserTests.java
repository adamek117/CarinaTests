package com.solvd.carina.tests;

import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

import com.solvd.carina.tests.api.users.DeleteUserMethod;
import com.solvd.carina.tests.api.users.GetUserMethod;
import com.solvd.carina.tests.api.users.GetUsersMethod;
import com.solvd.carina.tests.api.users.PostUserMethod;
import com.solvd.carina.tests.api.users.PutUserMethod;
import com.zebrunner.carina.api.APIMethodPoller;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;

public class APIUserTests implements IAbstractTest {
    private static final Logger LOGGER = LogManager.getLogger(APIUserTests.class);

    @Test()
    @MethodOwner(owner = "adam")
    public void testCreateUser() throws Exception{
        LOGGER.info("Test - create user");
        setCases("1");
        PostUserMethod api = new PostUserMethod();
        //api.setProperties("api/users/user.properties");

        AtomicInteger counter = new AtomicInteger(0);

        api.callAPIWithRetry().withLogStrategy(APIMethodPoller.LogStrategy.ALL).peek(rs -> counter.getAndIncrement())
                .until(rs -> counter.get() == 3)
                .pollEvery(1, ChronoUnit.SECONDS).stopAfter(10, ChronoUnit.SECONDS).execute();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "adam")
    public void testGetUsers(){
        LOGGER.info("Test - get users");
        GetUsersMethod getUserMethods = new GetUsersMethod();
        getUserMethods.callAPIExpectSuccess();
        getUserMethods.validateResponse();
        getUserMethods.validateResponseAgainstSchema("api/users/_get/all/rs.schema");
        
    }

    @Test()
    @MethodOwner(owner = "adam")
    public void testGetUser(){
        LOGGER.info("Test - get user");
        GetUserMethod getUserMethod = new GetUserMethod();
        getUserMethod.setUserId("1");
        getUserMethod.callAPIExpectSuccess();
        getUserMethod.validateResponse();
        getUserMethod.validateResponseAgainstSchema("api/users/_get/single/rs.schema");
    }
    
    @Test()
    @MethodOwner(owner = "adam")
    @TestPriority(Priority.P1)
    public void testDeleteUser(){
        LOGGER.info("Test - delete user");
        DeleteUserMethod deleteUserMethod = new DeleteUserMethod();
        deleteUserMethod.setUserId("1");
        deleteUserMethod.callAPIExpectSuccess();
        deleteUserMethod.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "adam")
    public void testUpdateUser(){
        LOGGER.info("Test - update user");
        PutUserMethod putUserMethod = new PutUserMethod();
        putUserMethod.setUserId("1");
        putUserMethod.callAPIExpectSuccess();
        putUserMethod.validateResponse();
    }


}
