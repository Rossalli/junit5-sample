import java.util.Random;

public class Service {

    public int addition(int n1, int n2) {
        return n1 + n2;
    }

    public int castStringToInt(String value) {
        return Integer.parseInt(value);
    }

    public String castIntToString(Integer value) {
        return String.valueOf(value);
    }

    public void timeout(int timeout) throws InterruptedException {
        Thread.sleep(timeout);
    }

    public int random() {
        return new Random().ints(1, 100).findFirst().getAsInt();
    }

    public void retry(int retryNumber) throws Exception {
            if(retryNumber == 3) {
            throw new Exception();
        }

    }
}
