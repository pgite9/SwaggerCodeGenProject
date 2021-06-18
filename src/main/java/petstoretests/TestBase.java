package petstoretests;

public abstract class TestBase {
    // If you want to point pet store application hosted across
    private static final String BASE_URL_PET_STORE = "https://petstore.swagger.io/v2";

    // If you want to point to locally running Pet store in Docker.
    private static final String BASE_URL_LOCAL_PET_STORE = "http://localhost:8080/v2";

    public static String getBaseUrlPetStore() {
        return BASE_URL_PET_STORE;
    }

    public static String getBaseUrlLocalPetStore() {
        return BASE_URL_LOCAL_PET_STORE;
    }
}
