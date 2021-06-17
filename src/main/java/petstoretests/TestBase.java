package petstoretests;

public abstract class TestBase {
    private static final String BASE_URL_PET_STORE = "http://petstore.swagger.io/v2";
    private static final String BASE_URL_LOCAL_PET_STORE = "http://localhost:8080/v2";

    public static String getBaseUrlPetStore() {
        return BASE_URL_PET_STORE;
    }

    public static String getBaseUrlLocalPetStore() {
        return BASE_URL_LOCAL_PET_STORE;
    }
}
