import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AccessModifierJ5Test {

    @Test
    protected void protectedTest() {
        Service service = new Service();
        Assertions.assertEquals(2, service.addition(1, 1), "1 + 1 = 2");
    }

    @Test
    void privatePackageTest() {
        Service service = new Service();
        Assertions.assertEquals(2, service.addition(1, 1), "1 + 1 = 2");
    }

    @Test
    public void publicTest() {
        Service service = new Service();
        Assertions.assertEquals(2, service.addition(1, 1), "1 + 1 = 2");
    }
}
