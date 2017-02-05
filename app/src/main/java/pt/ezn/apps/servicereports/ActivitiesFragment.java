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

    RecyclerView activitiesRecycler;
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
        ((MainActivity) getActivity()).setActionBarTitle(getString(R.string.activities));
        //colocar o respectivo item em checked do drawer menu
        ((MainActivity) getActivity()).navigationView.setCheckedItem(R.id.nav_activities);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_activities, container, false);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab_act);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).fragmentType = 'N';
                ((MainActivity) getActivity()).loadFragmentActivity();
            }
        });

        //criar um recyclerview
        activitiesRecycler = (RecyclerView) view.findViewById(R.id.rv_activities);
        activitiesRecycler.setHasFixedSize(true);
        //criar layout manager e associa-lo ao activitiesRecycler
        LinearLayoutManager manager = new LinearLayoutManager(view.getContext());
        activitiesRecycler.setLayoutManager(manager);

        ReportsDatabaseAdapter reportAdapter = new ReportsDatabaseAdapter(this.getContext());

        ActivitiesAdapter activityAdapter = new ActivitiesAdapter(this.getContext(), serviceActivityArrayList);
        activitiesRecycler.setAdapter(activityAdapter);



        return view;
    }




}
