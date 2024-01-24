package steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Map;

import static endpoints.Endpoints.*;
import static properties.TestData.*;
import static utils.ApiServices.getRequest;
import static utils.ApiServices.postRequest;
import static utils.BaseTest.body;

public class EntitySteps {

    @SneakyThrows
    @Step("Create new device group")
    public Response createDeviceGroup(Map<String, Object> headers) {
        body = "{\"name\":\"My_new_test_device_group\",\"type\":\"DEVICE\"}";
        return postRequest(POST_DEVICE_GROUP, headers, body, null, null);
    }

    @SneakyThrows
    @Step("Create new customer group")
    public Response createCustomerGroup(Map<String, Object> headers) {
        body = "{\"name\":\"My_new_customer_group\",\"type\":\"CUSTOMER\"}}";
        return postRequest(POST_DEVICE_GROUP, headers, body, null, null);
    }

    @SneakyThrows
    @Step("Create new customer")
    public Response createCustomer(String name, String customerGroupId, Map<String, Object> headers) {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put(ENTITY_GROUP_ID, customerGroupId);
        body = "{\"title\":\"" + name + "\",\"additionalInfo\":{\"description\":\"test_description\",\"allowWhiteLabeling\":true}}";
        return postRequest(POST_CUSTOMER_GROUP, headers, body, queryParams, null);
    }

    @SneakyThrows
    @Step("Create new device")
    public Response createDevice(String name, String deviceGroupId, String deviceProfile, Map<String, Object> headers) {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put(ENTITY_GROUP_ID, deviceGroupId);
        body = "{\"name\":\"" + name + "\",\"label\":\"\",\"deviceProfileId\":{\"entityType\":\"DEVICE_PROFILE\",\"id\":\"" + deviceProfile + "\"},\"additionalInfo\":{\"gateway\":false,\"overwriteActivityTime\":false,\"description\":\"My test description\"},\"customerId\":null}";
        return postRequest(POST_DEVICE, headers, body, queryParams, null);
    }

    @SneakyThrows
    @Step("Get Customer user groups by customer ID")
    public Response getCustomerUserGroups(String customerId, Map<String, Object> headers) {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(CUSTOMER_ID, customerId);
        return getRequest(GET_CUSTOMER_USER_GROUPS_BY_ID, headers, null, pathParams);
    }

    @SneakyThrows
    @Step("Create new customer")
    public Response createCustomerUser(String email, String customerGroupUserId, String customerId, Map<String, Object> headers) {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(ENTITY_GROUP_ID, customerGroupUserId);
        body = "{\"email\":\"" + email + "\",\"additionalInfo\":{\"description\":\"\",\"defaultDashboardId\":null,\"defaultDashboardFullscreen\":false,\"homeDashboardId\":null,\"homeDashboardHideToolbar\":true}," +
                "\"authority\":\"CUSTOMER_USER\",\"customerId\":{\"entityType\":\"CUSTOMER\",\"id\":\"" + customerId + "\"}}";
        return postRequest(POST_USER, headers, body, null, pathParams);
    }
}
