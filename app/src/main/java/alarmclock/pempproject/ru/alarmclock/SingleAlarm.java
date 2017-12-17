package alarmclock.pempproject.ru.alarmclock;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by Andre on 17.12.2017.
 */

@Entity
public class SingleAlarm {
    @Id
    private Long Id;
    @NotNull
    private String hour_string;
    @NotNull
    private String minute_string;

    @Generated(hash = 1026301571)
    public SingleAlarm(Long Id, @NotNull String hour_string,
                       @NotNull String minute_string) {
        this.Id = Id;
        this.hour_string = hour_string;
        this.minute_string = minute_string;
    }

    @Generated(hash = 1479574057)
    public SingleAlarm() {
    }

    public Long getId() {
        return this.Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getHour_string() {
        return this.hour_string;
    }

    public void setHour_string(String hour_string) {
        this.hour_string = hour_string;
    }

    public String getMinute_string() {
        return this.minute_string;
    }

    public void setMinute_string(String minute_string) {
        this.minute_string = minute_string;
    }

    @Override
    public String toString() {
        return hour_string + ":" + minute_string;
    }
}
