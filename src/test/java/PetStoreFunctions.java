import static com.jayway.restassured.RestAssured.given;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.http.ContentType;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author RohithSrinath
 */
public class PetStoreFunctions {

	public Response addPetResponse = null;
	PetStoreRequestSpecs petStoreRequestSpecs = null;
	RequestSpecification builder = null;

	public void buildAddPetRequest() {
		petStoreRequestSpecs = new PetStoreRequestSpecs();
		petStoreRequestSpecs.buildAddPetRequest();
	}
		
	public void callAddPetService() {
		addPetResponse = given().log().all().contentType(ContentType.JSON).accept(ContentType.JSON)
				.spec(petStoreRequestSpecs.buildAddPetRequest()).when().post();		
		System.out.println("RESPONSE::::"+ addPetResponse.getStatusCode());			
	}

	public void validateHttp200Status() {		
		addPetResponse.then().spec(
				PetStoreResponseSpecs.validateResponse200Spec());
	}

	public void buildFindPetByStatusRequest() {
		petStoreRequestSpecs = new PetStoreRequestSpecs();
		petStoreRequestSpecs.buildFindPetByStatusRequest();
	}

	public void callFindPetByStatus() {
		addPetResponse = given().log().all()
				.spec(petStoreRequestSpecs.buildFindPetByStatusRequest())
				.when().get("/findByStatus");
	}

	public void buildFindPetByIdRequest(int arg1) {
		petStoreRequestSpecs = new PetStoreRequestSpecs();
		builder  = petStoreRequestSpecs.buildFindPetByIdRequest(arg1);
	}

	public void callFindPetById() {
		addPetResponse = given().log().all()
				.spec(builder)
				.when().get();
		System.out.println("RESPONSE::::"+ addPetResponse.getStatusCode());	
	}

}
