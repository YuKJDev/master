import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimerTask;

class MyTimerTask extends TimerTask {

    @Override
    public void run() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                "dd:MMMM:yyyy HH:mm:ss a", Locale.getDefault());
        final String strDate = simpleDateFormat.format(calendar.getTime());



    }

    private void completeTask() {
        try {
            // допустим, выполнение займет 20 секунд
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
