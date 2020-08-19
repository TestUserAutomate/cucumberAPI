import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PetStoreStepDefs {

	PetStoreFunctions petStoreFunctions = new PetStoreFunctions();

	@Given("^I build a valid request for adding a pet in the petstore$")
	public void i_build_a_valid_request_for_adding_a_pet_in_the_petstore() throws Throwable {
		petStoreFunctions.buildAddPetRequest();
	}

	@When("^trigger the add pet service$")
	public void trigger_the_add_pet_service() throws Throwable {	    
		petStoreFunctions.callAddPetService();
	}

	@Then("^I validate the response after adding the pet$")
	public void i_validate_the_response_after_adding_the_pet() throws Throwable {	    
		petStoreFunctions.validateHttp200Status();
	}
	
	@Given("^I build a valid request for Finding a Pet with Id (\\d+)$")
	public void i_build_a_valid_request_for_Finding_a_Pet_with_Id(int arg1) throws Throwable {
		petStoreFunctions.buildFindPetByIdRequest(arg1);
	}

	@When("^trigger the findById service$")
	public void trigger_the_findById_service() throws Throwable {	    
		petStoreFunctions.callFindPetById();
	}

	@Then("^I validate the Id (\\d+) of the  Pet$")
	public void i_validate_the_Id_of_the_Pet(int arg1) throws Throwable {	    
		petStoreFunctions.validateHttp200Status();
	}

	
}
