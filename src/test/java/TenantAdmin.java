import objects.TenantId;
import org.testng.annotations.Test;
import steps.DeviceProfileSteps;
import steps.EntitySteps;
import steps.TenantSteps;
import utils.BaseTest;

import java.util.Map;

import static properties.TestData.*;
import static utils.ApiServices.getResponseValue;
import static utils.ApiServices.getResponseValueInObject;
import static utils.AssertsUtil.assertStatusCode;

public class TenantAdmin extends BaseTest {

    private final TenantSteps tenantSteps = new TenantSteps();
    private final EntitySteps entitySteps = new EntitySteps();
    private final DeviceProfileSteps deviceProfileSteps = new DeviceProfileSteps();

    @Test(groups = {"userLogin"})
    public void createTenantAdmin1() {
        //create tenant
        createTenant = tenantSteps.createTenant(testProp.tenantTitle1(), headersSysadmin);
        tenantIdString = getResponseValueInObject(createTenant, ID_KEY, ID_KEY);
        assertStatusCode(createTenant, 200);

        //create tenant admin
        TenantId tenantId = new TenantId(tenantIdString, ENTITY_TYPE_TENANT);
        createTenantAdmin = tenantSteps.createTenantAdmin(tenantAdmin1, tenantId, headersSysadmin);
        tenantAdminIdString = getResponseValueInObject(createTenantAdmin, ID_KEY, ID_KEY);
        assertStatusCode(createTenantAdmin, 200);

        // login as created tenant admin
        loginCreatedUser = tenantSteps.loginCreatedTenant(tenantAdminIdString, headersSysadmin);
        token = getResponseValue(loginCreatedUser, TOKEN_KEY);
        headers = Map.of(X_AUTHORIZATION_KEY, BEARER_KEY + token);
        refreshToken = getResponseValue(loginCreatedUser, REFRESH_TOKEN_KEY);
        assertStatusCode(loginCreatedUser, 200);

        // create device profile
        createDeviceProfile = deviceProfileSteps.createDeviceProfile(headers);
        deviceProfileId = getResponseValueInObject(createDeviceProfile, ID_KEY, ID_KEY);
        assertStatusCode(createDeviceProfile, 200);

        // create device group
        createDeviceGroup = entitySteps.createDeviceGroup(headers);
        deviceGroupId = getResponseValueInObject(createDeviceGroup, ID_KEY, ID_KEY);
        assertStatusCode(createDeviceGroup, 200);

        // create devices
        createDevice1 = entitySteps.createDevice(deviceName + "1", deviceGroupId, deviceProfileId, headers);
        deviceId1 = getResponseValueInObject(createDevice1, ID_KEY, ID_KEY);
        assertStatusCode(createDevice1, 200);

        createDevice2 = entitySteps.createDevice(deviceName + "2", deviceGroupId, deviceProfileId, headers);
        deviceId2 = getResponseValueInObject(createDevice2, ID_KEY, ID_KEY);
        assertStatusCode(createDevice2, 200);

        createDevice3 = entitySteps.createDevice(deviceName + "3", deviceGroupId, deviceProfileId, headers);
        deviceId3 = getResponseValueInObject(createDevice3, ID_KEY, ID_KEY);
        assertStatusCode(createDevice3, 200);

        createDevice4 = entitySteps.createDevice(deviceName + "4", deviceGroupId, deviceProfileId, headers);
        deviceId4 = getResponseValueInObject(createDevice4, ID_KEY, ID_KEY);
        assertStatusCode(createDevice4, 200);

        createDevice5 = entitySteps.createDevice(deviceName + "5", deviceGroupId, deviceProfileId, headers);
        deviceId5 = getResponseValueInObject(createDevice5, ID_KEY, ID_KEY);
        assertStatusCode(createDevice5, 200);

        createDevice6 = entitySteps.createDevice(deviceName + "6", deviceGroupId, deviceProfileId, headers);
        deviceId6 = getResponseValueInObject(createDevice6, ID_KEY, ID_KEY);
        assertStatusCode(createDevice6, 200);

        // create customer group

        createCustomerGroup = entitySteps.createCustomerGroup(headers);
        customerGroupId = getResponseValueInObject(createCustomerGroup, ID_KEY, ID_KEY);
        assertStatusCode(createCustomerGroup, 200);

        // create new customer

        createCustomer1 = entitySteps.createCustomer(customerName + "1", customerGroupId, headers);
        customerId1 = getResponseValueInObject(createCustomer1, ID_KEY, ID_KEY);
        assertStatusCode(createCustomer1, 200);

        customerUserGroupId = getResponseValueInObject(entitySteps.getCustomerUserGroups(customerId1, headers), ID_KEY, ID_KEY);
        addCustomerUser1 = entitySteps.createCustomerUser("my_new_customer_user1@test.io", customerUserGroupId, customerId1, headers);
        customerUserId1 = getResponseValueInObject(addCustomerUser1, ID_KEY, ID_KEY);
        assertStatusCode(addCustomerUser1, 200);

        addCustomerUser2 = entitySteps.createCustomerUser("my_new_customer_user2@test.io", customerUserGroupId, customerId1, headers);
        customerUserId2 = getResponseValueInObject(addCustomerUser2, ID_KEY, ID_KEY);
        assertStatusCode(addCustomerUser1, 200);

        createCustomer2 = entitySteps.createCustomer(customerName + "2", customerGroupId, headers);
        customerId2 = getResponseValueInObject(createCustomer2, ID_KEY, ID_KEY);
        assertStatusCode(createCustomer2, 200);

        customerUserGroupId = getResponseValueInObject(entitySteps.getCustomerUserGroups(customerId1, headers), ID_KEY, ID_KEY);
        addCustomerUser1 = entitySteps.createCustomerUser("my_new_customer_user3@test.io", customerUserGroupId, customerId2, headers);
        customerUserId1 = getResponseValueInObject(addCustomerUser1, ID_KEY, ID_KEY);
        assertStatusCode(addCustomerUser1, 200);

        addCustomerUser2 = entitySteps.createCustomerUser("my_new_customer_user4@test.io", customerUserGroupId, customerId2, headers);
        customerUserId2 = getResponseValueInObject(addCustomerUser2, ID_KEY, ID_KEY);
        assertStatusCode(addCustomerUser1, 200);

        createCustomer3 = entitySteps.createCustomer(customerName + "3", customerGroupId, headers);
        customerId3 = getResponseValueInObject(createCustomer3, ID_KEY, ID_KEY);
        assertStatusCode(createCustomer3, 200);

        customerUserGroupId = getResponseValueInObject(entitySteps.getCustomerUserGroups(customerId1, headers), ID_KEY, ID_KEY);
        addCustomerUser1 = entitySteps.createCustomerUser("my_new_customer_user5@test.io", customerUserGroupId, customerId3, headers);
        customerUserId1 = getResponseValueInObject(addCustomerUser1, ID_KEY, ID_KEY);
        assertStatusCode(addCustomerUser1, 200);

        addCustomerUser2 = entitySteps.createCustomerUser("my_new_customer_user61@test.io", customerUserGroupId, customerId3, headers);
        customerUserId2 = getResponseValueInObject(addCustomerUser2, ID_KEY, ID_KEY);
        assertStatusCode(addCustomerUser1, 200);

    }

    @Test(groups = {"userLogin"})
    public void createTenantAdmin2() {
        //create tenant
        createTenant = tenantSteps.createTenant(testProp.tenantTitle2(), headersSysadmin);
        tenantIdString = getResponseValueInObject(createTenant, ID_KEY, ID_KEY);
        assertStatusCode(createTenant, 200);

        //create tenant admin
        TenantId tenantId = new TenantId(tenantIdString, ENTITY_TYPE_TENANT);
        createTenantAdmin = tenantSteps.createTenantAdmin(tenantAdmin2, tenantId, headersSysadmin);
        tenantAdminIdString = getResponseValueInObject(createTenantAdmin, ID_KEY, ID_KEY);
        assertStatusCode(createTenantAdmin, 200);

        // login as created tenant admin
        loginCreatedUser = tenantSteps.loginCreatedTenant(tenantAdminIdString, headersSysadmin);
        token = getResponseValue(loginCreatedUser, TOKEN_KEY);
        headers = Map.of(X_AUTHORIZATION_KEY, BEARER_KEY + token);
        refreshToken = getResponseValue(loginCreatedUser, REFRESH_TOKEN_KEY);
        assertStatusCode(loginCreatedUser, 200);

        // create device profile
        createDeviceProfile = deviceProfileSteps.createDeviceProfile(headers);
        deviceProfileId = getResponseValueInObject(createDeviceProfile, ID_KEY, ID_KEY);
        assertStatusCode(createDeviceProfile, 200);

        // create device group
        createDeviceGroup = entitySteps.createDeviceGroup(headers);
        deviceGroupId = getResponseValueInObject(createDeviceGroup, ID_KEY, ID_KEY);
        assertStatusCode(createDeviceGroup, 200);

        // create devices
        createDevice1 = entitySteps.createDevice(deviceName + "1", deviceGroupId, deviceProfileId, headers);
        deviceId1 = getResponseValueInObject(createDevice1, ID_KEY, ID_KEY);
        assertStatusCode(createDevice1, 200);

        createDevice2 = entitySteps.createDevice(deviceName + "2", deviceGroupId, deviceProfileId, headers);
        deviceId2 = getResponseValueInObject(createDevice2, ID_KEY, ID_KEY);
        assertStatusCode(createDevice2, 200);

        createDevice3 = entitySteps.createDevice(deviceName + "3", deviceGroupId, deviceProfileId, headers);
        deviceId3 = getResponseValueInObject(createDevice3, ID_KEY, ID_KEY);
        assertStatusCode(createDevice3, 200);

        createDevice4 = entitySteps.createDevice(deviceName + "4", deviceGroupId, deviceProfileId, headers);
        deviceId4 = getResponseValueInObject(createDevice4, ID_KEY, ID_KEY);
        assertStatusCode(createDevice4, 200);

        createDevice5 = entitySteps.createDevice(deviceName + "5", deviceGroupId, deviceProfileId, headers);
        deviceId5 = getResponseValueInObject(createDevice5, ID_KEY, ID_KEY);
        assertStatusCode(createDevice5, 200);

        createDevice6 = entitySteps.createDevice(deviceName + "6", deviceGroupId, deviceProfileId, headers);
        deviceId6 = getResponseValueInObject(createDevice6, ID_KEY, ID_KEY);
        assertStatusCode(createDevice6, 200);

        // create customer group

        createCustomerGroup = entitySteps.createCustomerGroup(headers);
        customerGroupId = getResponseValueInObject(createCustomerGroup, ID_KEY, ID_KEY);
        assertStatusCode(createCustomerGroup, 200);

        // create new customer

        createCustomer1 = entitySteps.createCustomer(customerName + "1", customerGroupId, headers);
        customerId1 = getResponseValueInObject(createCustomer1, ID_KEY, ID_KEY);
        assertStatusCode(createCustomer1, 200);

        customerUserGroupId = getResponseValueInObject(entitySteps.getCustomerUserGroups(customerId1, headers), ID_KEY, ID_KEY);
        addCustomerUser1 = entitySteps.createCustomerUser("my_new_customer_user11@test.io", customerUserGroupId, customerId1, headers);
        customerUserId1 = getResponseValueInObject(addCustomerUser1, ID_KEY, ID_KEY);
        assertStatusCode(addCustomerUser1, 200);

        addCustomerUser2 = entitySteps.createCustomerUser("my_new_customer_user22@test.io", customerUserGroupId, customerId1, headers);
        customerUserId2 = getResponseValueInObject(addCustomerUser2, ID_KEY, ID_KEY);
        assertStatusCode(addCustomerUser1, 200);

        createCustomer2 = entitySteps.createCustomer(customerName + "2", customerGroupId, headers);
        customerId2 = getResponseValueInObject(createCustomer2, ID_KEY, ID_KEY);
        assertStatusCode(createCustomer2, 200);

        customerUserGroupId = getResponseValueInObject(entitySteps.getCustomerUserGroups(customerId1, headers), ID_KEY, ID_KEY);
        addCustomerUser1 = entitySteps.createCustomerUser("my_new_customer_user33@test.io", customerUserGroupId, customerId2, headers);
        customerUserId1 = getResponseValueInObject(addCustomerUser1, ID_KEY, ID_KEY);
        assertStatusCode(addCustomerUser1, 200);

        addCustomerUser2 = entitySteps.createCustomerUser("my_new_customer_user44@test.io", customerUserGroupId, customerId2, headers);
        customerUserId2 = getResponseValueInObject(addCustomerUser2, ID_KEY, ID_KEY);
        assertStatusCode(addCustomerUser1, 200);

        createCustomer3 = entitySteps.createCustomer(customerName + "3", customerGroupId, headers);
        customerId3 = getResponseValueInObject(createCustomer3, ID_KEY, ID_KEY);
        assertStatusCode(createCustomer3, 200);

        customerUserGroupId = getResponseValueInObject(entitySteps.getCustomerUserGroups(customerId1, headers), ID_KEY, ID_KEY);
        addCustomerUser1 = entitySteps.createCustomerUser("my_new_customer_user55@test.io", customerUserGroupId, customerId3, headers);
        customerUserId1 = getResponseValueInObject(addCustomerUser1, ID_KEY, ID_KEY);
        assertStatusCode(addCustomerUser1, 200);

        addCustomerUser2 = entitySteps.createCustomerUser("my_new_customer_user66@test.io", customerUserGroupId, customerId3, headers);
        customerUserId2 = getResponseValueInObject(addCustomerUser2, ID_KEY, ID_KEY);
        assertStatusCode(addCustomerUser1, 200);

    }

    @Test(groups = {"userLogin"})
    public void createTenantAdmin3() {
        //create tenant
        createTenant = tenantSteps.createTenant(testProp.tenantTitle3(), headersSysadmin);
        tenantIdString = getResponseValueInObject(createTenant, ID_KEY, ID_KEY);
        assertStatusCode(createTenant, 200);

        //create tenant admin
        TenantId tenantId = new TenantId(tenantIdString, ENTITY_TYPE_TENANT);
        createTenantAdmin = tenantSteps.createTenantAdmin(tenantAdmin3, tenantId, headersSysadmin);
        tenantAdminIdString = getResponseValueInObject(createTenantAdmin, ID_KEY, ID_KEY);
        assertStatusCode(createTenantAdmin, 200);

        // login as created tenant admin
        loginCreatedUser = tenantSteps.loginCreatedTenant(tenantAdminIdString, headersSysadmin);
        token = getResponseValue(loginCreatedUser, TOKEN_KEY);
        headers = Map.of(X_AUTHORIZATION_KEY, BEARER_KEY + token);
        refreshToken = getResponseValue(loginCreatedUser, REFRESH_TOKEN_KEY);
        assertStatusCode(loginCreatedUser, 200);

        // create device profile
        createDeviceProfile = deviceProfileSteps.createDeviceProfile(headers);
        deviceProfileId = getResponseValueInObject(createDeviceProfile, ID_KEY, ID_KEY);
        assertStatusCode(createDeviceProfile, 200);

        // create device group
        createDeviceGroup = entitySteps.createDeviceGroup(headers);
        deviceGroupId = getResponseValueInObject(createDeviceGroup, ID_KEY, ID_KEY);
        assertStatusCode(createDeviceGroup, 200);

        // create devices
        createDevice1 = entitySteps.createDevice(deviceName + "1", deviceGroupId, deviceProfileId, headers);
        deviceId1 = getResponseValueInObject(createDevice1, ID_KEY, ID_KEY);
        assertStatusCode(createDevice1, 200);

        createDevice2 = entitySteps.createDevice(deviceName + "2", deviceGroupId, deviceProfileId, headers);
        deviceId2 = getResponseValueInObject(createDevice2, ID_KEY, ID_KEY);
        assertStatusCode(createDevice2, 200);

        createDevice3 = entitySteps.createDevice(deviceName + "3", deviceGroupId, deviceProfileId, headers);
        deviceId3 = getResponseValueInObject(createDevice3, ID_KEY, ID_KEY);
        assertStatusCode(createDevice3, 200);

        createDevice4 = entitySteps.createDevice(deviceName + "4", deviceGroupId, deviceProfileId, headers);
        deviceId4 = getResponseValueInObject(createDevice4, ID_KEY, ID_KEY);
        assertStatusCode(createDevice4, 200);

        createDevice5 = entitySteps.createDevice(deviceName + "5", deviceGroupId, deviceProfileId, headers);
        deviceId5 = getResponseValueInObject(createDevice5, ID_KEY, ID_KEY);
        assertStatusCode(createDevice5, 200);

        createDevice6 = entitySteps.createDevice(deviceName + "6", deviceGroupId, deviceProfileId, headers);
        deviceId6 = getResponseValueInObject(createDevice6, ID_KEY, ID_KEY);
        assertStatusCode(createDevice6, 200);

        // create customer group

        createCustomerGroup = entitySteps.createCustomerGroup(headers);
        customerGroupId = getResponseValueInObject(createCustomerGroup, ID_KEY, ID_KEY);
        assertStatusCode(createCustomerGroup, 200);

        // create new customer

        createCustomer1 = entitySteps.createCustomer(customerName + "1", customerGroupId, headers);
        customerId1 = getResponseValueInObject(createCustomer1, ID_KEY, ID_KEY);
        assertStatusCode(createCustomer1, 200);

        customerUserGroupId = getResponseValueInObject(entitySteps.getCustomerUserGroups(customerId1, headers), ID_KEY, ID_KEY);
        addCustomerUser1 = entitySteps.createCustomerUser("my_new_customer_user111@test.io", customerUserGroupId, customerId1, headers);
        customerUserId1 = getResponseValueInObject(addCustomerUser1, ID_KEY, ID_KEY);
        assertStatusCode(addCustomerUser1, 200);

        addCustomerUser2 = entitySteps.createCustomerUser("my_new_customer_user222@test.io", customerUserGroupId, customerId1, headers);
        customerUserId2 = getResponseValueInObject(addCustomerUser2, ID_KEY, ID_KEY);
        assertStatusCode(addCustomerUser1, 200);

        createCustomer2 = entitySteps.createCustomer(customerName + "2", customerGroupId, headers);
        customerId2 = getResponseValueInObject(createCustomer2, ID_KEY, ID_KEY);
        assertStatusCode(createCustomer2, 200);

        customerUserGroupId = getResponseValueInObject(entitySteps.getCustomerUserGroups(customerId1, headers), ID_KEY, ID_KEY);
        addCustomerUser1 = entitySteps.createCustomerUser("my_new_customer_user333@test.io", customerUserGroupId, customerId2, headers);
        customerUserId1 = getResponseValueInObject(addCustomerUser1, ID_KEY, ID_KEY);
        assertStatusCode(addCustomerUser1, 200);

        addCustomerUser2 = entitySteps.createCustomerUser("my_new_customer_user444@test.io", customerUserGroupId, customerId2, headers);
        customerUserId2 = getResponseValueInObject(addCustomerUser2, ID_KEY, ID_KEY);
        assertStatusCode(addCustomerUser1, 200);

        createCustomer3 = entitySteps.createCustomer(customerName + "3", customerGroupId, headers);
        customerId3 = getResponseValueInObject(createCustomer3, ID_KEY, ID_KEY);
        assertStatusCode(createCustomer3, 200);

        customerUserGroupId = getResponseValueInObject(entitySteps.getCustomerUserGroups(customerId1, headers), ID_KEY, ID_KEY);
        addCustomerUser1 = entitySteps.createCustomerUser("my_new_customer_user555@test.io", customerUserGroupId, customerId3, headers);
        customerUserId1 = getResponseValueInObject(addCustomerUser1, ID_KEY, ID_KEY);
        assertStatusCode(addCustomerUser1, 200);

        addCustomerUser2 = entitySteps.createCustomerUser("my_new_customer_user666@test.io", customerUserGroupId, customerId3, headers);
        customerUserId2 = getResponseValueInObject(addCustomerUser2, ID_KEY, ID_KEY);
        assertStatusCode(addCustomerUser1, 200);

    }
}