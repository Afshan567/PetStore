package TestScripts;


import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.EndPointsLibrary;
import PojoPackage.PojoClass;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class CRUDOperations extends BaseClass {
@Test
public void crudOpr() {
	//Post Operation
	int id=jutil.getRandomNo();
	String name="cat";
	String[] photoUrls= {"https://cat.com","https://dog.com"};
	String status="available";
	
	PojoClass pc=new PojoClass(id, name, photoUrls, status);
	
Response res1=	given().spec(req).body(pc)
	.when().post(EndPointsLibrary.addPet);
	int expData=res1.jsonPath().get("id");
	res1.then().spec(resp).assertThat().statusCode(200).time(Matchers.lessThan(4000L),TimeUnit.MILLISECONDS)
	.log().all();
	
	//get Operation
	Response res2=given().spec(req)
			.when().get(EndPointsLibrary.getPet+expData);
	int getId=res2.jsonPath().get("id");
	Assert.assertEquals(expData, getId);
	System.out.println("Both put and get method data are matching");
	res2.then().spec(resp).assertThat().statusCode(200).time(Matchers.lessThan(4000L),TimeUnit.MILLISECONDS)
	.log().all();
	
	//put operation
	String[] photoUrls1= {"abc.com","def.com"};
	PojoClass pc2=new PojoClass(expData, "dog", photoUrls1, "not in stock");
	Response res3=given().spec(req).body(pc2)
			.when().put(EndPointsLibrary.updatePet);
	
	res3.then().spec(resp).assertThat().statusCode(200).time(Matchers.lessThan(4000L),TimeUnit.MILLISECONDS)
	.log().all();
	
	//delete operation
	given().spec(req)
	.when().delete(EndPointsLibrary.deletePet+expData)
	.then().spec(resp).assertThat().statusCode(200).time(Matchers.lessThan(4000L),TimeUnit.MILLISECONDS)
	.log().all();
	
}

}
