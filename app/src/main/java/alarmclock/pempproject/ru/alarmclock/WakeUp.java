package alarmclock.pempproject.ru.alarmclock;

import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WakeUp extends AppCompatActivity implements View.OnClickListener{

    private Ringtone ringtone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wake_up);

        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        ringtone = RingtoneManager.getRingtone(getApplicationContext(), notification);
        ringtone.play();

        ((Button)findViewById(R.id.stopAlarmButton)).setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        this.onClick((View) findViewById(R.id.stopAlarmButton));
        super.onStop();
    }

    @Override
    public void onClick(View view) {
        ringtone.stop();
        finish();
    }
}
