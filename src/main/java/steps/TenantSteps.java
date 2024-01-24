package steps;

import builders.CreateUser;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import objects.TenantId;
import objects.User;
import utils.BuilderUtil;

import java.util.HashMap;
import java.util.Map;

import static endpoints.Endpoints.*;
import static properties.TestData.*;
import static utils.ApiServices.getRequest;
import static utils.ApiServices.postRequest;
import static utils.BaseTest.body;

public class TenantSteps {

    private final BuilderUtil builderUtil = new BuilderUtil();

    @SneakyThrows
    @Step("Create new tenant")
    public Response createTenant(String tenantTitle, Map<String, Object> headers) {
        body = "{\"title\":\"" + tenantTitle + "\"}";
        return postRequest(SAVE_TENANT, headers, body, null, null);
    }

    @SneakyThrows
    @Step("Create new user")
    public Response createTenantAdmin(User newUser, TenantId tenantId, Map<String, Object> headers) {
        CreateUser saveAdmin = builderUtil.buildCreateUser(newUser.getUsername(), newUser.getPassword(), newUser.getFirstName(), newUser.getLastName(),
                tenantId, newUser.getAdditionalInfo());
        return postRequest(SAVE_USER, headers, saveAdmin, null, null);
    }

    @SneakyThrows
    @Step("Login created tenant admin")
    public Response loginCreatedTenant(String tenantId, Map<String, Object> headers) {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(USER_ID_KEY, tenantId);
        return getRequest(GET_USER_TOKEN, headers, null, pathParams);
    }
}
