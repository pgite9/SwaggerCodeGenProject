package petstoretests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.junit.Assert.*;

import io.restassured.specification.RequestSpecification;
import io.swagger.client.model.Category;
import io.swagger.client.model.Pet;
import io.swagger.client.model.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class PetStoreUserTest extends TestBase {


    @Test
    public void createPetRequestPostTest() {

        // Creating the Category Object
        Category category = new Category();
        category.setId(1L);
        category.setName("Cats");


        // Creating the Tags Object
        Tag tags = new Tag();
        tags.setId(1L);
        tags.setName("Tag 1");

        Pet pet = new Pet();
        pet.setCategory(category);
        pet.setName("Testing"+1);
        pet.setPhotoUrls(Collections.singletonList("List1 Photo Url"));
        pet.setStatus(Pet.StatusEnum.AVAILABLE);
        pet.setTags(Collections.singletonList(tags));

        Pet createdPet  = RestAssured.given()
                .contentType("application/json")
                .body(pet)
                .post(TestBase.getBaseUrlLocalPetStore()+"/pet")
                .then()
                .statusCode(200)
                .extract().body().as(Pet.class);

        //System.out.println(createdPet);
        assertNotNull(createdPet);

        Response response = RestAssured.given()
                .pathParam("id",createdPet.getId())
                .get(TestBase.getBaseUrlLocalPetStore()+"/pet/{id}")
                .then()
                .statusCode(200)
                .extract().response();

        //System.out.println(response.jsonPath().get().toString());
        System.out.println(response.getBody().as(Pet.class));

        assertNotNull("Pet Creation is failed.", response.jsonPath().get().toString());
        assertEquals(response.getStatusLine().toString(),"HTTP/1.1 200 OK");
        assertEquals("Code do not match",response.getStatusCode(),200);
    }

    @Test
    public void getAllPetsByStatus()
    {
        List<Pet> petListByStatus = RestAssured.given()
                //.pathParam("status", Pet.StatusEnum.AVAILABLE)
                .queryParam("status",Pet.StatusEnum.SOLD)
                .get(TestBase.getBaseUrlLocalPetStore()+"/pet/findByStatus")
                .then()
                .statusCode(200)
                .extract().body().jsonPath().getList("$");
        System.out.println(petListByStatus);
        assertNotNull(petListByStatus);
    }
}
