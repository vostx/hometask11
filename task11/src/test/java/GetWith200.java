import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetWith200 {

    @Test
    public void getScenarioWith200(){
        given()
                .baseUri("https://reqres.in/")
                .pathParam("user_id", 2)
                .log().all()
                .get("api/users/{user_id}")
                .then()
                .log().all();

    }
}
