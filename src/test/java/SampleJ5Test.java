import java.time.Duration;
import java.time.LocalDateTime;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

class SampleJ5Test {

    private static Service service;

    @BeforeAll
    static void beforeAll() {
        service = new Service();
    }

    @Test()
    void exceptionTest() {
        String var = null;
        var.toLowerCase();
        Assertions.assertThrows(Exception.class,
                () -> service.castStringToInt("1"));
    }


    @Test()
    void timeoutTest() {
        Assertions.assertAll(
                () -> Assertions.assertTimeout(Duration.ofMillis(1000), () -> service.timeout(500)),
                () -> Assertions.assertTimeout(Duration.ofMillis(2000), () -> service.timeout(500))
        );
    }

    @Test
    void leapYearTest() {
        Assumptions.assumeTrue(new GregorianCalendar().isLeapYear(LocalDateTime.now().getYear()));
        service.addition(1, 1);
    }


    @Test
    void test() {
        Assertions.assertEquals(2, service.addition(1, 1), "1 + 1 = 2");
    }

    @RepeatedTest(1000)
    void repeatedTest() {
        int random = service.random();
        Assertions.assertTrue(random >= 1 && random <= 100);
    }

    @RepeatedTest(3)
    void repeatedTest(RepetitionInfo info) throws Exception {
        if (info.getCurrentRepetition() == 3) {
            Assertions.assertThrows(Exception.class,
                    () -> service.retry(info.getCurrentRepetition()));
        } else {
            service.retry(info.getCurrentRepetition());
        }

    }


}




