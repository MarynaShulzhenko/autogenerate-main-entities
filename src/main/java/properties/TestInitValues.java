package properties;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:testing.properties")
public interface TestInitValues extends Config {
    @Key("BASE_URL")
    String BASE_URL();

    @Key("sysadmin_email")
    String sysadmin_email();

    @Key("sysadmin_pass")
    String sysadmin_pass();

    @Key("tenant_title1")
    String tenantTitle1();

    @Key("tenant_title2")
    String tenantTitle2();

    @Key("tenant_title3")
    String tenantTitle3();

    @Key("tenantId")
    String tenantId();

    @Key("tenant1_email")
    String tenant1_email();

    @Key("tenant1_pass")
    String tenant1_pass();

    @Key("tenant1_first_name")
    String tenant1_first_name();

    @Key("tenant1_last_name")
    String tenant1_last_name();

    @Key("tenant2_email")
    String tenant2_email();

    @Key("tenant2_pass")
    String tenant2_pass();

    @Key("tenant2_first_name")
    String tenant2_first_name();

    @Key("tenant2_last_name")
    String tenant2_last_name();


    @Key("tenant3_email")
    String tenant3_email();

    @Key("tenant3_pass")
    String tenant3_pass();

    @Key("tenant3_first_name")
    String tenant3_first_name();

    @Key("tenant3_last_name")
    String tenant3_last_name();

    @Key("consoleLog")
    Boolean consoleLog();
}
