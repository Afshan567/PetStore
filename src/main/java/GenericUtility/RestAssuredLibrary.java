package GenericUtility;

import io.restassured.response.Response;

public class RestAssuredLibrary {
	
public String getJsonData(Response response,String path) {
	return response.jsonPath().get(path);
}

}
