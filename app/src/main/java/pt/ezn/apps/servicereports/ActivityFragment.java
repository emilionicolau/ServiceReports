package pt.ezn.apps.servicereports;

import android.app.DatePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ActivityFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ActivityFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private int day, month, year;
    private Calendar todayCalendar = Calendar.getInstance();
    private TextView tvDate;
    private Spinner clientSpinner;


    private OnFragmentInteractionListener mListener;

    public ActivityFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ActivityFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ActivityFragment newInstance(String param1, String param2) {
        ActivityFragment fragment = new ActivityFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((MainActivity) getActivity()).setActionBarTitle("Activity");
        ((MainActivity) getActivity()).navigationView.setCheckedItem(R.id.nav_activities);
        setHasOptionsMenu(true);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_activity, container, false);

        //inicializar a base de dados
        ReportsDatabaseAdapter database = new ReportsDatabaseAdapter(getContext());

        //view da data
        tvDate = (TextView) view.findViewById(R.id.tvFragActDate);

        //colocar a data actual
        updateDate();
        //ler a data
        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readDate();
            }
        });

        lerSpinner(view, database);


        return view;

    }


    //metodo para ler o spinner
    public void lerSpinner(View view, ReportsDatabaseAdapter database) {
        clientSpinner = (Spinner) view.findViewById(R.id.spinnerClient);
        final ArrayList<String> clientslist = database.getAllClients();
        clientslist.add(0," ");
        clientslist.add(1,"-- New client --");
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter(getActivity(), R.layout.support_simple_spinner_dropdown_item,
                clientslist);
        clientSpinner.setAdapter(adapter);
        clientSpinner.setSelection(0,false);
        clientSpinner.setOnItemSelectedListener(new OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
            {
                if(position == 1){
                    clientSpinner.setSelection(0,false);
                    ((MainActivity) getActivity()).loadFragmentClient();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView)
            {

            }
        });
    }

    public void updateDate() {
        day = todayCalendar.get(Calendar.DAY_OF_MONTH);
        month = todayCalendar.get(Calendar.MONTH) + 1;
        year = todayCalendar.get(Calendar.YEAR);
        String fDate = String.valueOf(day) + '-' + String.valueOf(month) + '-' + String.valueOf(year);
        tvDate.setText(fDate);
    }

    private void readDate() {
        DatePickerDialog datePicker = new DatePickerDialog(getActivity(),d, todayCalendar.get(Calendar.DAY_OF_MONTH), todayCalendar.get(Calendar.MONTH),
                todayCalendar.get(Calendar.YEAR));
        datePicker.updateDate(year,month-1,day);
        datePicker.show();

    }

    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            todayCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            todayCalendar.set(Calendar.MONTH, month);
            todayCalendar.set(Calendar.YEAR, year);
            updateDate();

        }
    };

    //acrescentar opcoes ao menu da toolbar
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_add_activity, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }


    }



    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



}
