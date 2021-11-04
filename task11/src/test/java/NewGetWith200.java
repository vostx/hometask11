import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class NewGetWith200 {

    @Test
    public void newGetWith200(){
        given()
                .baseUri("https://reqres.in/")
                .pathParam("unknown_id", 2)
                .log().all()
                .get("api/unknown/{unknown_id}")
                .then()
                .log().all();
    }
}
