package GenericUtility;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseClass {
public RequestSpecification req;
public ResponseSpecification resp;
public RestAssuredLibrary rlib=new RestAssuredLibrary();
public JavaUtility jutil=new JavaUtility();

@BeforeSuite
public void configBM() {
	req=new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2")
			.setContentType(ContentType.JSON).build();
	resp=new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
}
@AfterSuite
public void configAM() {
	System.out.println("Operation perfomed successfully");
}
}