import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;

public class TestAutomation {

    // Run the broken-hashserve application before running the tests. They are set it priority so the whole file can run

    final String baseURI = "http://127.0.0.1:8088";

    @Test(priority = 5)
    public void shutdown() {

        final String shutdownCommand = "shutdown";

        given()
                .body(shutdownCommand)
                .when()
                .post(baseURI + "/hash")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 4)
    public void getStats() {

        Response response = get( baseURI + "/stats");

        given()
                .get(baseURI + "/stats")
                .then()
                .statusCode(200)
                .log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println(response);
    }

    @Test(priority = 3)
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

    @Test(priority = 1)
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

    @Test(priority = 2)
    public void refactoredReturnJobIdentifier() {

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