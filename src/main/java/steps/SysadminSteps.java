package steps;

import builders.LoginUser;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import objects.User;
import utils.BuilderUtil;

import static endpoints.Endpoints.LOGIN_USER;
import static utils.ApiServices.postRequest;

public class SysadminSteps {

    private static final BuilderUtil builderUtil = new BuilderUtil();

    @SneakyThrows
    @Step("Log in")
    public static Response userLogin(User user) {
        LoginUser loginUser = builderUtil.buildLoginUser(user.getUsername(), user.getPassword());
        return postRequest(LOGIN_USER, null, loginUser, null, null);
    }
}
