
import java.time.LocalDateTime;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.BeforeClass;
import org.junit.Test;

public class SampleJ4Test
{


    private static Service service;


    @BeforeClass
    public static  void beforeAll() {
        service = new Service();
    }

    @Test(expected = Exception.class)
    public void exceptionTest() {
        String var = null;
        var.toLowerCase();
        service.castStringToInt("1");
    }

    @Test(timeout = 1000)
    public void timeoutTest1000() throws InterruptedException {
        Service service = new Service();
        service.timeout(500);
    }

    @Test(timeout = 2000)
    public void timeoutTest2000() throws InterruptedException {
        service.timeout(500);
    }

    @Test
    public void leapYearTest()  {
        Assume.assumeTrue(new GregorianCalendar().isLeapYear(LocalDateTime.now().getYear()));
        service.addition(1, 1);
    }


    @Test
    public void test()  {
        Assert.assertEquals( "1 + 1 = 2", 2, service.addition(1, 1));
    }
}




