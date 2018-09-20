import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;

class TagJ5Test {

    private static Service service;

    @BeforeAll
    static void beforeAll() {
        service = new Service();
    }


    @Tag("dev")
    @RepeatedTest(1000)
    void repeatedTestDev() {
        int random = service.random();
        Assertions.assertTrue(random >= 1 && random <= 100);
    }

    @Tag("hml")
    @RepeatedTest(500)
    void repeatedTestHml() {
        int random = service.random();
        Assertions.assertTrue(random >= 1 && random <= 100);
    }

    @Tag("prd")
    @RepeatedTest(100)
    void repeatedTestPrd() {
        int random = service.random();
        Assertions.assertTrue(random >= 1 && random <= 100);
    }
}
