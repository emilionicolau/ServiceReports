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
 * Created by Emilio on 02/02/2017.
 * ServiceReports
 */

public class ClientsAdapter extends RecyclerView.Adapter<ClientsAdapter.ClientsViewHolder> {


    private Context mcontext;
    private ArrayList<Client> clientsList;

    //construtor do adapter
    public ClientsAdapter(Context context, ArrayList<Client> clientsList){
        this.mcontext = context;
        this.clientsList = clientsList;

    }

    public void setMcontext(Context mcontext) {
        this.mcontext = mcontext;
    }

    public void setClientActivitList(ArrayList<Client> clientList) {
        this.clientsList = clientList;
    }

    @Override
    public ClientsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.from(parent.getContext()).inflate(R.layout.client_cardview_layout, parent, false);
        ClientsAdapter.ClientsViewHolder clientsViewHolder = new ClientsAdapter.ClientsViewHolder(view);
        return clientsViewHolder;
    }

    @Override
    public void onBindViewHolder(ClientsViewHolder holder, int position) {
        Client client = clientsList.get(position);
        holder.tvClientName.setText(client.getClientName());
        holder.tvClientType.setText(client.getClientType());
        holder.tvClientEquip.setText(client.getClientEquipments());
    }

    @Override
    public int getItemCount() {
        if (clientsList != null){
            return clientsList.size();
        }
        return 0;
    }

    public static class ClientsViewHolder extends RecyclerView.ViewHolder {
        public CardView clientCardView;
        public TextView tvClientName;
        public TextView tvClientType;
        public TextView tvClientEquip;

        public ClientsViewHolder(View itemView) {
            super(itemView);
            clientCardView = (CardView) itemView.findViewById(R.id.cardview_client);
            tvClientName = (TextView) itemView.findViewById(R.id.tvClientCVName);
            tvClientType = (TextView) itemView.findViewById(R.id.tvClientCVType);
            tvClientEquip = (TextView) itemView.findViewById(R.id.tvClientCVEquips);
        }
    }

}
