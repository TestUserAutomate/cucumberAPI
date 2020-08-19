import com.jayway.restassured.authentication.AuthenticationScheme;
import com.jayway.restassured.authentication.PreemptiveBasicAuthScheme;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.specification.ProxySpecification;
import com.jayway.restassured.specification.RequestSpecification;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.entity.StringEntity;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.jayway.restassured.http.ContentType;

/**
 *
 * @author RohithSrinath
 */
public class PetStoreRequestSpecs {

	public RequestSpecification buildAddPetRequest() {
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setBaseUri(ConfigProp.getPropertyValue("baseURI"));
		builder.setBasePath(ConfigProp.getPropertyValue("basePath"));
		
		try {
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader("./addpet.json");
		Object obj = jsonParser.parse(reader);
		JSONArray petsList = (JSONArray) obj;
		for (int i = 0; i < 1; i++) {
			JSONObject pet = (JSONObject) petsList.get(i);
			String petString = pet.toString();
			StringEntity params = new StringEntity(petString);
			builder.setBody(petString);
		}
		} catch (Exception e){
			e.printStackTrace();
		}
		System.out.println("INPUT REQUEST:::"+ builder.toString().toString());
		return builder.build();
	}

	public RequestSpecification buildFindPetByStatusRequest() {
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setBaseUri(ConfigProp.getPropertyValue("baseURI"));
		builder.setBasePath(ConfigProp.getPropertyValue("basePath"));
		System.out.println("INPUT REQUEST:::"+ builder.toString());
		return builder.build();
	}

	public RequestSpecification buildFindPetByIdRequest(int arg1) {
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setBaseUri(ConfigProp.getPropertyValue("baseURI"));
		builder.setBasePath(ConfigProp.getPropertyValue("basePath") + "/"
				+ arg1);
		System.out.println("INPUT REQUEST:::"+ builder.toString().toString());
		return builder.build();
	}

}
