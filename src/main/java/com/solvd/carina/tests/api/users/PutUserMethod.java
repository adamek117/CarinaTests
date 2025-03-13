package com.solvd.carina.tests.api.users;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${base_url}/users/${user_id}", methodType = HttpMethodType.PUT)
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PutUserMethod extends AbstractApiMethodV2{
    public PutUserMethod() {
        super("api/users/_put/rq.json", "api/users/_put/rs.json", "api/users/user.properties");
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }

    public void setUserId(String userId) {
        replaceUrlPlaceholder("user_id", userId);
    }

}
