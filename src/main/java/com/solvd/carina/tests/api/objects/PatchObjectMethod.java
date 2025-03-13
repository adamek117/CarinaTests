package com.solvd.carina.tests.api.objects;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/objects/${object_id}", methodType = HttpMethodType.PATCH)
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PatchObjectMethod extends AbstractApiMethodV2{
    public PatchObjectMethod() {
        super("api/objects/_patch/rq.json", "api/objects/_patch/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }
    public void setObjectId(String objectId) {
        replaceUrlPlaceholder("object_id", objectId);
    }

}
