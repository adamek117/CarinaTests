package com.solvd.carina.tests.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

import com.solvd.carina.tests.api.objects.PatchObjectMethod;
import com.solvd.carina.tests.api.objects.PostObjectMethod;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;


public class APIObjectTests {
    private static final Logger LOGGER = LogManager.getLogger(APIObjectTests.class);

    
    @Test()
    @MethodOwner(owner = "adam")
    public void testCreateObject(){
        LOGGER.info("Test - partially update object");
        PostObjectMethod postObjectMethod = new PostObjectMethod();
        postObjectMethod.callAPI();
        postObjectMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        postObjectMethod.validateResponse();

    }
    
    @Test()
    @MethodOwner(owner = "adam")
    public void testPartiallyUpdateObject(){
        LOGGER.info("Test - partially update object");
        PatchObjectMethod patchObjectMethod = new PatchObjectMethod();
        patchObjectMethod.setObjectId("ff808181932badb601958f7078f740f4");
        patchObjectMethod.callAPI();
        patchObjectMethod.validateResponse();
    }

}
