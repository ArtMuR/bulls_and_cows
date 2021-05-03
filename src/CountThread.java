import java.util.Date;

public class CountThread extends Thread {
    private static long start;

    public CountThread(long start) {
        this.start = start;
    }


    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                long result = System.currentTimeMillis() - start;
                interpretateDate(result);
                break;
            }
        }

    }

    private void interpretateDate(long time) {
        Date date = new Date(time);
        System.out.print("Ваше время игры составило: ");
        if (date.getHours() - 3 != 0) {
            System.out.println(date.getHours() - 3 + " ч, ");
        }
        if (date.getMinutes() != 0) {
            System.out.print(date.getMinutes() + " мин, ");
        }
        System.out.print(date.getSeconds() + " сек.");


    }
}
