package pt.ezn.apps.servicereports;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Emilio on 28/01/2017.
 * ServiceReports
 */

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.ActivityViewHolder> {

    private Context mcontext;
    private ArrayList<ServiceActivity> serviceActivitList;

    //construtor do adapter
    public ActivityAdapter (Context context, ArrayList<ServiceActivity> serviceList){
        this.mcontext = context;
        this.serviceActivitList = serviceList;

    }

    //seters para o caso de queremos atribuir valores a context e serviceActivitList sem ser pelo construtor
    public void setMcontext(Context mcontext) {
        this.mcontext = mcontext;
    }

    public void setServiceActivitList(ArrayList<ServiceActivity> serviceActivitList) {
        this.serviceActivitList = serviceActivitList;
    }


    @Override
    public ActivityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.from(parent.getContext()).inflate(R.layout.activity_cardview_layout, parent, false);
        ActivityViewHolder activityViewHolder = new ActivityViewHolder(view);
        return activityViewHolder;
    }

    @Override
    public void onBindViewHolder(ActivityViewHolder holder, int position) {
        //criar um objecto serviceactivity da position do arraylist
        ServiceActivity serviceActivity = serviceActivitList.get(position);
        //colocar no cardview os valores do objecto serviceactivity
        holder.tvDate.setText(serviceActivity.Date());
        holder.tvClient.setText(serviceActivity.getClient());
        holder.tvDescr.setText(serviceActivity.getWorkDesc());
    }

    @Override
    public int getItemCount() {
        if (serviceActivitList != null){
            return serviceActivitList.size();
        }
        return 0;
    }

    //view holder class
    public static class ActivityViewHolder extends RecyclerView.ViewHolder {
        public CardView activityCardview;
        public TextView tvDate;
        public TextView tvClient;
        public TextView tvDescr;

        //ligar o view holder aos campos do cardview
        public ActivityViewHolder(View itemView) {
            super(itemView);
            activityCardview = (CardView)itemView.findViewById(R.id.cardview_activity);
            tvDate = (TextView)itemView.findViewById(R.id.tvDate);
            tvClient = (TextView)itemView.findViewById(R.id.tvClient);
            tvDescr = (TextView)itemView.findViewById(R.id.tvDescr);
        }


    }
}
