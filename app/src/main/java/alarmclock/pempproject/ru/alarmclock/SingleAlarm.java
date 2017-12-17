package alarmclock.pempproject.ru.alarmclock;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Andre on 17.12.2017.
 */

@Entity
public class SingleAlarm {
    @NotNull
    private String hour_string;
    @NotNull
    private String minute_string;

    public SingleAlarm() {

    }

    @Generated(hash = 1627176979)
    public SingleAlarm(@NotNull String hour_string, @NotNull String minute_string) {
        this.hour_string = hour_string;
        this.minute_string = minute_string;
    }

    public String getHour_string() {
        return hour_string;
    }

    public String getMinute_string() {
        return minute_string;
    }

    public void setHour_string(String hour_string) {
        this.hour_string = hour_string;
    }

    public void setMinute_string(String minute_string) {
        this.minute_string = minute_string;
    }

    @Override
    public String toString() {
        return hour_string + ":" + minute_string;
    }
}
