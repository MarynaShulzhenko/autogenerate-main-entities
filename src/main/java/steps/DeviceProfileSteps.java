package steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import utils.BaseTest;

import java.util.Map;

import static endpoints.Endpoints.POST_DEVICE_PROFILE;
import static utils.ApiServices.postRequest;
import static utils.BaseTest.body;

public class DeviceProfileSteps {

    @SneakyThrows
    @Step("Create new device profile")
    public Response createDeviceProfile(Map<String, Object> headers) {
        body = "{\"name\":\"New test device profile\", \n" +
                "\"type\":\"DEFAULT\",\n" +
                "\"image\":null,\n" +
                "\"defaultQueueName\":null,\n" +
                "\"transportType\":\"DEFAULT\",\n" +
                "\"provisionType\":\"DISABLED\",\n" +
                "\"description\":\"my test device profile\",\n" +
                "\"profileData\":{\"configuration\":{\"type\":\"DEFAULT\"},\"transportConfiguration\":{\"type\":\"DEFAULT\"}, \"alarms\":[{\"alarmType\":\"High Temperature\", \"createRules\":{\"CRITICAL\":{\"condition\":{\"condition\":[{\"key\":{\"type\":\"TIME_SERIES\",\"key\":\"temperature\"},\"valueType\":\"NUMERIC\",\"value\":null,\"predicate\":{\"operation\":\"GREATER\",\"value\":{\"defaultValue\":25,\"dynamicValue\":null},\"type\":\"NUMERIC\"}}],\"spec\": {\"type\":\"SIMPLE\"}},\n" +
                "\"schedule\":null,\n" +
                "\"alarmDetails\":null,\n" +
                "\"dashboardId\":null}},\n" +
                "\"clearRule\":null,\n" +
                "\"propagate\":null,\n" +
                "\"propagateRelationTypes\":null,\n" +
                "\"propagateToOwner\":null, \n" +
                "\"propagateToOwnerHierarchy\":null,\n" +
                "\"propagateToTenant\":null}],\n" +
                "\"provisionConfiguration\":{\"type\":\"DISABLED\"}}}";
        return postRequest(POST_DEVICE_PROFILE, headers, body, null, null);
    }
}
