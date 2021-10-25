import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class TestAutomation {

    final String baseURI = "http://127.0.0.1:8088";

    @Test
    public void shutdown() {

        final String shutdownCommand = "shutdown";

        given()
                .body(shutdownCommand)
                .when()
                .post(baseURI + "/hash")
                .then()
                .statusCode(200);
    }

    @Test
    public void getStats() {

        Response response = get( baseURI + "/stats");

        given()
                .get(baseURI + "/stats")
                .then()
                .statusCode(200)
                .log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void getHashedPassword() {

        Response response = get(baseURI + "/hash/1");

        given()
                .get(baseURI + "/hash/1")
                .then()
                .statusCode(200)
                .log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.asString().length(), 88);
    }

    @Test
    public void returnJobIdentifier() {

        Map<String, Object> map = new HashMap<String, Object>();

        JSONObject request = new JSONObject();

        request.put("password", "morpheus");

        given()
                .body(request.toJSONString())
                .when()
                .post(baseURI + "/hash")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void post_test() {

        JSONObject request = new JSONObject();

        request.put("password", "morpheus");

        Response response = given()
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post(baseURI + "/hash");
        System.out.println("Job identifier is " + response.asString());
        long responseTime = response.time();
        System.out.println("Response time is " + responseTime);
    }
}