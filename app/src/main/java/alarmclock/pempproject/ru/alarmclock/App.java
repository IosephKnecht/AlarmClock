package alarmclock.pempproject.ru.alarmclock;

import android.app.Application;

import org.greenrobot.greendao.database.Database;

/**
 * Created by Andre on 17.12.2017.
 */

public class App extends Application {

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "alarm-db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
