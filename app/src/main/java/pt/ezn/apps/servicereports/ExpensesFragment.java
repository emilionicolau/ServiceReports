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
public class ExpensesFragment extends Fragment {

    RecyclerView expensesRecycler;
    ArrayList<DailyExpense> serviceExpensesArrayList;


    public ExpensesFragment() {
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
        ((MainActivity) getActivity()).setActionBarTitle("Expenses");
        //colocar o respectivo item em checked do drawer menu
        ((MainActivity) getActivity()).navigationView.setCheckedItem(R.id.nav_expenses);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_expenses, container, false);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab_exp);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).loadFragmentExpense();
            }
        });

        expensesRecycler = (RecyclerView) view.findViewById(R.id.rv_expenses);
        expensesRecycler.setHasFixedSize(true);
        //criar layout manager e associa-lo ao Recycler
        LinearLayoutManager manager = new LinearLayoutManager(view.getContext());
        expensesRecycler.setLayoutManager(manager);

        ReportsDatabaseAdapter reportAdapter = new ReportsDatabaseAdapter(this.getContext());

        ExpensesAdapter expenseAdapter = new ExpensesAdapter(this.getContext(), serviceExpensesArrayList);
        expensesRecycler.setAdapter(expenseAdapter);





        return view;
    }



}
