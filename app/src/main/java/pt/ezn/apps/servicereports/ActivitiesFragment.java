package pt.ezn.apps.servicereports;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ActivitiesFragment extends Fragment {




    RecyclerView recycler;
    ArrayList<ServiceActivity> serviceActivityArrayList;


    public ActivitiesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((MainActivity) getActivity()).setActionBarTitle("Activities");
        //colocar o respectivo item em checked do drawer menu
        ((MainActivity) getActivity()).navigationView.setCheckedItem(R.id.nav_activities);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_activities, container, false);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab_act);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).loadFragmentActivity();
            }
        });

        //criar um recyclerview
        recycler = (RecyclerView) view.findViewById(R.id.rv_activities);
        recycler.setHasFixedSize(true);
        //criar layout manager e associa-lo ao recycler
        LinearLayoutManager manager = new LinearLayoutManager(view.getContext());
        recycler.setLayoutManager(manager);

        ReportsDatabaseAdapter reportAdapter = new ReportsDatabaseAdapter(this.getContext());

        ActivityAdapter activityAdapter = new ActivityAdapter(this.getContext(), serviceActivityArrayList);



        return view;
    }




}
