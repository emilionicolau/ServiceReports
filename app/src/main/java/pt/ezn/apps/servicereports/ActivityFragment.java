package pt.ezn.apps.servicereports;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

import static android.R.attr.name;


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

    private String mParam1;
    private String mParam2;
    private int day, month, year, hourBegin, hourEnd, minBegin, minEnd;
    private Calendar todayCalendar = Calendar.getInstance();
    private TextView tvDate, tvTimeBegin, tvTimeEnd;
    private Spinner clientSpinner;
    private ServiceActivity serviceActivity = new ServiceActivity();
    private EditText etEquipment;
    private ReportsDatabaseAdapter database;

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
        ((MainActivity) getActivity()).setActionBarTitle(getString(R.string.service_activity));
        ((MainActivity) getActivity()).navigationView.setCheckedItem(R.id.nav_activities);
        setHasOptionsMenu(true);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_activity, container, false);

        //inicializar a base de dados
        database = new ReportsDatabaseAdapter(getContext());

        //views
        tvDate = (TextView) view.findViewById(R.id.tvFragActDate);
        etEquipment = (EditText) view.findViewById(R.id.etFragActEquips);
        tvTimeBegin = (TextView) view.findViewById(R.id.etFragActTimeBegin);
        tvTimeEnd = (TextView) view.findViewById(R.id.etFragActTimeEnd);


        //colocar a data actual
        updateDate();
        //ler a data
        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readDate();
            }
        });

        //ler o cliente ou criar um novo
        lerSpinner(view, database);

        updateTimeBegin();
        tvTimeBegin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readTimeBegin();
            }
        });

        updateTimeEnd();
        tvTimeEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readTimeEnd();
            }
        });


        return view;

    }




    //metodo para ler o spinner
    public void lerSpinner(View view, final ReportsDatabaseAdapter database) {
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
                else{
                    String name = clientslist.get(position);
                    int client_id = database.getClientId(name);
                    serviceActivity.setClient(name);
                    serviceActivity.setCliendId(client_id);
                    //Toast.makeText(getContext(), name + " - " + String.valueOf(client_id), Toast.LENGTH_LONG).show();
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
        //escrever os valores da data na variavel serviceActivity
        serviceActivity.setDay(day);
        serviceActivity.setMonth(month);
        serviceActivity.setYear(year);
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

    private void readTimeBegin() {
        TimePickerDialog timePicker = new TimePickerDialog(getActivity(), hb,todayCalendar.get(Calendar.HOUR_OF_DAY),
                todayCalendar.get(Calendar.MINUTE),true);
        timePicker.updateTime(hourBegin, minBegin);
        timePicker.show();
    }

    TimePickerDialog.OnTimeSetListener hb = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            todayCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
            todayCalendar.set(Calendar.MINUTE, minute);
            updateTimeBegin();
        }
    };

    private void updateTimeBegin() {
        hourBegin = todayCalendar.get(Calendar.HOUR_OF_DAY);
        minBegin = todayCalendar.get(Calendar.MINUTE);
        serviceActivity.setHourBegin(hourBegin);
        serviceActivity.setMinBegin(minBegin);
        String time = String.valueOf(hourBegin)+":"+String.valueOf(minBegin);
        tvTimeBegin.setText(time);
    }

    private void readTimeEnd() {
        TimePickerDialog timePicker = new TimePickerDialog(getActivity(), he,todayCalendar.get(Calendar.HOUR_OF_DAY),
                todayCalendar.get(Calendar.MINUTE),true);
        timePicker.updateTime(hourEnd, minEnd);
        timePicker.show();
    }

    TimePickerDialog.OnTimeSetListener he = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            todayCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
            todayCalendar.set(Calendar.MINUTE, minute);
            updateTimeEnd();
        }
    };

    private void updateTimeEnd() {
        hourEnd = todayCalendar.get(Calendar.HOUR_OF_DAY);
        minEnd = todayCalendar.get(Calendar.MINUTE);
        serviceActivity.setHourEnd(hourEnd);
        serviceActivity.setMinEnd(minEnd);
        String time = String.valueOf(hourEnd)+":"+String.valueOf(minEnd);
        tvTimeEnd.setText(time);
    }

    //acrescentar opcoes ao menu da toolbar
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_add_activity, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_cancel_add_activity:
                // Not implemented here
                return false;
            case R.id.action_save_activity:
                saveServiceActivity();
                return true;
            default:
                break;
        }

        return false;
    }

    private void saveServiceActivity() {
        serviceActivity.setEquipment(etEquipment.getText().toString());
        //calcular o tempo total
        serviceActivity.totalTime();

        long feedback = database.insertServiceActicity(serviceActivity);
        clearForm();

        //getActivity().onBackPressed();
        Toast.makeText(getContext(), name + " - " + String.valueOf(feedback), Toast.LENGTH_LONG).show();
    }

    private void clearForm() {
        todayCalendar = Calendar.getInstance();
        updateDate();
        updateTimeBegin();
        updateTimeEnd();
        clientSpinner.setSelection(0);
        etEquipment.getText().clear();

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
