package alarmclock.pempproject.ru.alarmclock;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

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
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(singleAlarmList.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return singleAlarmList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tvClockInfo);
        }
    }
}
