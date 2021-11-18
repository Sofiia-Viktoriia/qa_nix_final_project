package reqres.tests;


import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import reqres.logic.dto.CreateUserDto;

import static org.hamcrest.Matchers.*;
import static reqres.logic.Endpoints.*;
import static reqres.utils.providers.RequestProvider.getDefaultCreateUserDto;

@Listeners(ApiListener.class)
public class UserTests extends BaseAPITest {

    private static final int CORRECT_USER_ID = 2;
    private static final int WRONG_USER_ID = 23;

    @Test
    @Description(value = "Getting list of users")
    public void getUsersList() {
        getBaseURI().when()
                .get(GET_USERS_LIST)
                .then().statusCode(200)
                .assertThat()
                .body("page", equalTo(2))
                .body("data", hasSize(6));
    }

    @Test
    @Description(value = "Getting the existing user by id")
    public void getUserByIdSuccess() {
        getBaseURI().when()
                .get(GET_USER_BY_ID, CORRECT_USER_ID)
                .then().statusCode(200)
                .body("data.id", equalTo(CORRECT_USER_ID))
                .body("data.email", equalTo("janet.weaver@reqres.in"));
    }

    @Test
    @Description(value = "Getting the nonexistent user by id")
    public void getUserByIdFailed() {
        getBaseURI().when()
                .get(GET_USER_BY_ID, WRONG_USER_ID)
                .then().statusCode(404);
    }

    @Test
    @Description(value = "Creating new user")
    public void createUser() {
        CreateUserDto requestBody = getDefaultCreateUserDto();
        getBaseURI()
                .contentType("application/json")
                .body(requestBody)
                .when().post(CREATE_USER)
                .then().statusCode(201)
                .body("name", equalTo(requestBody.getName()))
                .body("job", equalTo(requestBody.getJob()));
    }

    @Test
    @Description(value = "Deleting the user by its id")
    public void deleteUser() {
        getBaseURI().when()
                .delete(DELETE_USER_BY_ID, CORRECT_USER_ID)
                .then().statusCode(204);
    }
}
