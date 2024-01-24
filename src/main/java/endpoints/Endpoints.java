package endpoints;

public class Endpoints {

    //login-endpoint
    public static final String LOGIN_USER = "api/auth/login";

    //admin-controller
    public static final String SAVE_TENANT = "api/tenant";
    public static final String SAVE_USER = "api/user?sendActivationMail=false";
    public static final String GET_USER_TOKEN = "api/user/{userId}/token";
    public static final String POST_DEVICE_PROFILE = "api/deviceProfile";
    public static final String POST_DEVICE = "api/device";
    public static final String POST_DEVICE_GROUP = "api/entityGroup";
    public static final String POST_CUSTOMER_GROUP = "api/customer/";
    public static final String GET_CUSTOMER_USER_GROUPS_BY_ID = "api/entityGroupInfos/CUSTOMER/{customerId}/USER?pageSize=50&page=0&sortProperty=name&sortOrder=ASC";
    public static final String POST_USER = "api/user?sendActivationMail=false&entityGroupIds={entityGroupId}";
}
