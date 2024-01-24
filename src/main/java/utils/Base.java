package utils;

import objects.AdditionalInfo;
import objects.TenantId;
import objects.User;
import org.aeonbits.owner.ConfigFactory;
import properties.TestInitValues;

import static properties.TestData.AUTHORIRY_TENANT_ADMIN;
import static properties.TestData.ENTITY_TYPE_TENANT;
import static utils.BaseTest.tenantIdString;

public class Base {
    public static final TestInitValues testProp = ConfigFactory.create(TestInitValues.class);
    public static final User sysadminUser = new User(testProp.sysadmin_email(), testProp.sysadmin_pass());

    public static final AdditionalInfo additionalInfo = new AdditionalInfo(false, null, "my test description", true, null);
    public static final User tenantAdmin1 = new User(testProp.tenant1_email(), AUTHORIRY_TENANT_ADMIN, testProp.tenant1_first_name(), testProp.tenant1_last_name(), additionalInfo);
    public static final User tenantAdmin2 = new User(testProp.tenant2_email(), AUTHORIRY_TENANT_ADMIN, testProp.tenant2_first_name(), testProp.tenant2_last_name(), additionalInfo);
    public static final User tenantAdmin3 = new User(testProp.tenant3_email(), AUTHORIRY_TENANT_ADMIN, testProp.tenant3_first_name(), testProp.tenant3_last_name(), additionalInfo);
}
