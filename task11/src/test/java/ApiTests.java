import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import javax.xml.ws.Response;

public class ApiTests {

    @Test
    public void testGetRequest() {
        String baseUrl = "https://reqres.in/";
        String postUser = "/api/users";
        String testBody = "{\n" +
                            "\"name\": \"Peter\",\n" +
                            "\"job\": \"qa automation\"\n" +
                            "" +
                "}";
        String jsonScheme = "{\n" +
                "    \"type\": \"object\",\n" +
                "    \"title\": \"Post user\",\n" +
                "    \"required\": [\n" +
                "        \"name\",\n" +
                "        \"job\",\n" +
                "        \"createdAt\"\n" +
                "    ],\n" +
                "    \"properties\": {\n" +
                "        \"name\": {\n" +
                "            \"type\": \"string\",\n" +
                "            \"title\": \"User name\"\n" +
                "        },\n" +
                "        \"job\": {\n" +
                "            \"type\": \"string\",\n" +
                "            \"title\": \"Job position\"\n" +
                "        },\n" +
                "        \"createdAt\": {\n" +
                "            \"type\": \"string\",\n" +
                "            \"title\": \"User created time\"\n" +
                "        }\n" +
                "    },\n" +
                "    \"additionalProperties\": true\n" +
                "}";
        given().baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .body(testBody)
                .log().all()
                .post(postUser)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_CREATED)
                .body(matchesJsonSchema(jsonScheme));
    }
}
