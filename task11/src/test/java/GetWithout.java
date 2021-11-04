import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetWithout {

    @Test
    public void getScenarioWithout200() {

        given()
                .baseUri("https://reqres.in/")
                .pathParam("user_id", 23)
                .log().all()
                .get("api/users/{user_id}")
                .then()
                .log().all();
    }
}