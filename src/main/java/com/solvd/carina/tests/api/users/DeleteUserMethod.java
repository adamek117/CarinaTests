package com.solvd.carina.tests.api.users;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;


@Endpoint(url = "${base_url}/users/${user_id}", methodType = HttpMethodType.DELETE)
@RequestTemplatePath(path = "api/users/_delete/rq.json")
@ResponseTemplatePath(path = "api/users/_delete/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class DeleteUserMethod extends AbstractApiMethodV2{
    public DeleteUserMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }

    public void setUserId(String userId) {
        replaceUrlPlaceholder("user_id", userId);
    }
}
