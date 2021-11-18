package reqres.tests;

import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import reqres.logic.dto.AuthDto;

import static org.hamcrest.Matchers.equalTo;
import static reqres.logic.Endpoints.LOGIN;
import static reqres.logic.Endpoints.REGISTER;
import static reqres.utils.providers.RequestProvider.*;

@Listeners(ApiListener.class)
public class AuthenticationTests extends BaseAPITest {

    @Test
    @Description(value = "Registration with correct credentials")
    public void registerWithCorrectData() {
        AuthDto requestBody = getDefaultCorrectAuthDtoForRegister();
        getBaseURI()
                .contentType("application/json")
                .body(requestBody)
                .when().post(REGISTER)
                .then().statusCode(200)
                .body("id", equalTo(4))
                .body("token", equalTo("QpwL5tke4Pnpja7X4"));
    }

    @Test
    @Description(value = "Registration with incorrect credentials")
    public void registerWithIncorrectData() {
        AuthDto requestBody = getDefaultIncorrectAuthDto();
        getBaseURI()
                .contentType("application/json")
                .body(requestBody)
                .when().post(REGISTER)
                .then().statusCode(400)
                .body("error", equalTo("Missing password"));
    }

    @Test
    @Description(value = "Login with correct credentials")
    public void loginWithCorrectData() {
        AuthDto requestBody = getDefaultCorrectAuthDtoForLogin();
        getBaseURI()
                .contentType("application/json")
                .body(requestBody)
                .when().post(LOGIN)
                .then().statusCode(200)
                .body("token", equalTo("QpwL5tke4Pnpja7X4"));
    }

    @Test
    @Description(value = "Login with incorrect credentials")
    public void loginWithIncorrectData() {
        AuthDto requestBody = getDefaultIncorrectAuthDto();
        getBaseURI()
                .contentType("application/json")
                .body(requestBody)
                .when().post(LOGIN)
                .then().statusCode(400)
                .body("error", equalTo("Missing password"));
    }
}
