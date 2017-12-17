package alarmclock.pempproject.ru.alarmclock;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class SettingClock extends AppCompatActivity {

    private Button startClock;
    private TextView updateText;
    private TimePicker timePicker;
    private AlarmManager alarmManager;
    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_clock);

        startClock = (Button) findViewById(R.id.startClock);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        final Calendar calendar = Calendar.getInstance();


        final Intent intent = new Intent(this, AlarmReceiver.class);
        final SingleAlarm singleAlarm = new SingleAlarm();
        final DaoSession daoSession = ((App) getApplication()).getDaoSession();

        startClock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar.set(Calendar.HOUR_OF_DAY, timePicker.getHour());
                calendar.set(Calendar.MINUTE, timePicker.getMinute());

                int hour = timePicker.getHour();
                int minute = timePicker.getMinute();

                String hour_string = String.valueOf(hour);
                String minute_string = String.valueOf(minute);

                singleAlarm.setHour_string(hour_string);

                if (hour > 12) {
                    hour_string = String.valueOf(hour - 12);
                }

                if (minute < 10) {
                    minute_string = "0" + String.valueOf(minute);
                }

                singleAlarm.setMinute_string(minute_string);
                daoSession.insert(singleAlarm);

                Toast.makeText(SettingClock.this, "Clock start" + hour_string + minute_string, Toast.LENGTH_LONG).show();

                pendingIntent = PendingIntent.getBroadcast(SettingClock.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
                intent.putExtra("PI",pendingIntent);
                startActivity(new Intent(SettingClock.this,MainActivity.class));

            }
        });
    }
}
