package reqres.tests;

import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Listeners;

import static io.restassured.RestAssured.given;
import static reqres.logic.Endpoints.BASE_PATH;

@Listeners(ApiListener.class)
public class BaseAPITest {

    public RequestSpecification getBaseURI() {
        return given().baseUri(BASE_PATH);
    }
}
