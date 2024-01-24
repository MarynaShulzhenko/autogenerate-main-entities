package utils;

import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import steps.SysadminSteps;

import java.util.Map;

import static properties.TestData.*;
import static utils.ApiServices.getResponseValue;

public class BaseTest extends Base {

    public static Response userLogin;
    public static String refreshToken;
    public Map<String, Object> headersSysadmin;
    public Map<String, Object> headers;
    public static Response createTenant;
    public static Response createTenantAdmin;
    public static String id;
    public static Response loginCreatedUser;
    public static Response createDeviceProfile;
    public static String token;
    public static String deviceProfileId;
    public static String body;
    public static String tenantIdString;
    public static String tenantAdminIdString;
    public static Response createDeviceGroup;
    public static Response createCustomerGroup;
    public static Response createDevice1;
    public static String deviceId1;
    public static Response createDevice2;
    public static String deviceId2;
    public static Response createDevice3;
    public static String deviceId3;
    public static Response createDevice4;
    public static String deviceId4;
    public static Response createDevice5;
    public static String deviceId5;
    public static Response createDevice6;
    public static String deviceId6;
    public static String deviceGroupId;

    public static String customerGroupId;
    public static Response createCustomer1;
    public static String customerId1;
    public static Response createCustomer2;
    public static String customerId2;
    public static Response createCustomer3;
    public static String customerId3;
    public static String customerUserId1;
    public static String customerUserId2;

    public static String customerUserGroupId;
    public static Response addCustomerUser1;
    public static Response addCustomerUser2;

    public static Response deviceConnectivity;
    public static String http;
    public static String mqtt;
    public static String coap;

    @BeforeMethod(alwaysRun = true, onlyForGroups = "userLogin")
    public void sysadminLogin() {
        userLogin = SysadminSteps.userLogin(sysadminUser);
        headersSysadmin = Map.of(X_AUTHORIZATION_KEY, BEARER_KEY + getResponseValue(userLogin, TOKEN_KEY));
        refreshToken = getResponseValue(userLogin, REFRESH_TOKEN_KEY);
    }
}
