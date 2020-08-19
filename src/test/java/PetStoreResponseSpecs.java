import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.specification.ResponseSpecification;


public class PetStoreResponseSpecs {

    public static ResponseSpecification validateResponse400Spec() {
        ResponseSpecBuilder builder = new ResponseSpecBuilder();
        builder.expectStatusCode(400);
        return builder.build();
    }

    public static ResponseSpecification validateResponse200Spec() {
        ResponseSpecBuilder builder = new ResponseSpecBuilder();
        builder.expectStatusCode(200);
        return builder.build();
    }   

}
