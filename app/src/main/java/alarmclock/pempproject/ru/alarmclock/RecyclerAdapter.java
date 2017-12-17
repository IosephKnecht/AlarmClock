package alarmclock.pempproject.ru.alarmclock;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import static android.content.Context.ALARM_SERVICE;

/**
 * Created by Andre on 17.12.2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    List<SingleAlarm> singleAlarmList;

    public RecyclerAdapter(List<SingleAlarm> singleAlarmList){
        this.singleAlarmList=singleAlarmList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_clock, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.textView.setText(singleAlarmList.get(position).toString());
        final DaoSession daoSession = ((App) holder.context.getApplicationContext()).getDaoSession();

        Intent pIntent=((MainActivity)holder.context).getIntent();
        final PendingIntent pendingIntent=pIntent.getParcelableExtra("PI");
        final AlarmManager alarmManager = (AlarmManager) holder.context.getSystemService(ALARM_SERVICE);

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               daoSession.delete(singleAlarmList.get(position));
               Intent intent=new Intent(holder.context.getApplicationContext(),MainActivity.class);
               intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               holder.context.getApplicationContext().startActivity(intent);
               alarmManager.cancel(pendingIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return singleAlarmList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;
        private Button btnDelete;
        final Context context;

        public ViewHolder(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tvClockInfo);
            btnDelete=itemView.findViewById(R.id.btbDelete);
            this.context=btnDelete.getContext();
        }
    }
}
