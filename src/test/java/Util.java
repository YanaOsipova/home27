public class Util {
    private Util() {
    }
    public static void waitSecond(int sec) {
        try {
            Thread.sleep(sec * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
