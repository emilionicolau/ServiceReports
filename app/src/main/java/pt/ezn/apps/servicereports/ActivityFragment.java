package pt.ezn.apps.servicereports;

import android.app.AlertDialog;
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
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

import static pt.ezn.apps.servicereports.SupportMethodes.getHourString;


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
    private int day, month, year, hourBegin, hourEnd, minBegin, minEnd, kms, hourTravel, minTravel;
    private int kmstemp=0;
    private Calendar todayCalendar = Calendar.getInstance();
    private Calendar endCalendar = Calendar.getInstance();
    private TextView tvDate, tvTimeBegin, tvTimeEnd, etkms, tvTravelTime;
    private Spinner clientSpinner;
    private ServiceActivity serviceActivity = new ServiceActivity();
    private EditText etEquipment, etdescription, etnotes;
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
        tvTravelTime = (TextView) view.findViewById(R.id.tvFragActTravelTime);
        etkms = (TextView) view.findViewById(R.id.etFragActTravelKms);
        etdescription = (EditText) view.findViewById(R.id.etFragActDescr);
        etnotes = (EditText) view.findViewById(R.id.etFragActNotes);

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

        tvTravelTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readTravelTime();
            }
        });

        etkms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kms=0;
                readTravelDistance();
            }
        });



        return view;

    }






    //metodo para ler o spinner
    public void lerSpinner(View view, final ReportsDatabaseAdapter database) {
        clientSpinner = (Spinner) view.findViewById(R.id.spinnerClient);
        final ArrayList<String> clientslist = database.getAllClients();
        clientslist.add(0," ");
        clientslist.add(1,getString(R.string.new_client));
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
        String fDate = SupportMethodes.getDateString(day,month,year);
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
        serviceActivity.setTimeBegin(hourBegin*60+minBegin);
        String time = SupportMethodes.getHourString(hourBegin, minBegin);
        tvTimeBegin.setText(time);
    }



    private void readTimeEnd() {
        TimePickerDialog timePicker = new TimePickerDialog(getActivity(), he,endCalendar.get(Calendar.HOUR_OF_DAY),
                endCalendar.get(Calendar.MINUTE),true);
        timePicker.updateTime(hourEnd, minEnd);
        timePicker.show();
    }

    TimePickerDialog.OnTimeSetListener he = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            endCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
            endCalendar.set(Calendar.MINUTE, minute);
            updateTimeEnd();
        }
    };

    private void updateTimeEnd() {
        hourEnd = endCalendar.get(Calendar.HOUR_OF_DAY);
        minEnd = endCalendar.get(Calendar.MINUTE);
        serviceActivity.setTimeEnd(hourEnd*60+minEnd);
        String time = getHourString(hourEnd, minEnd);
        tvTimeEnd.setText(time);
    }

    private void resetTime() {
        todayCalendar = Calendar.getInstance();
        endCalendar = Calendar.getInstance();
        updateTimeBegin();
        updateTimeEnd();

    }

    private void timeInputError() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View mView = getLayoutInflater(null).inflate(R.layout.dialog_error, null);
        TextView tv = (TextView) mView.findViewById(R.id.tv_dialog_msg);
        Button bt = (Button) mView.findViewById(R.id.bt_ok_error_dialog);
        tv.setText(getString(R.string.time_flow_error));
        builder.setView(mView);
        final AlertDialog dialog = builder.create();
        dialog.show();
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }



    private void readTravelTime() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View mView = getLayoutInflater(null).inflate(R.layout.time_picker, null);
        NumberPicker picker1 = (NumberPicker) mView.findViewById(R.id.tp_numberpicker1);
        NumberPicker picker2 = (NumberPicker) mView.findViewById(R.id.tp_numberpicker2);
        picker1.setMinValue(0);
        picker1.setMaxValue(23);
        picker2.setMinValue(0);
        picker2.setMaxValue(59);

        //ler os valores dos number pickers 1 e 2
        picker1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

                hourTravel = newVal;
            }
        });
        picker2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                minTravel = newVal;
            }
        });

        Button btok = (Button) mView.findViewById(R.id.bt_timepicker_ok);
        Button btcancel = (Button) mView.findViewById(R.id.bt_timepicker_cancel);
        builder.setView(mView);
        final AlertDialog dialog = builder.create();
        dialog.show();

        //sentinelas para reagirem aos botoes cancel e ok
        btok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvTravelTime.setText(SupportMethodes.getHourString(hourTravel,minTravel));
                serviceActivity.setTravelTime(SupportMethodes.computeTime(hourTravel,minTravel));
                dialog.dismiss();
            }
        });
        btcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }



    private void readTravelDistance(){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View mView = getLayoutInflater(null).inflate(R.layout.distance_picker, null);
        NumberPicker picker = (NumberPicker) mView.findViewById(R.id.dp_numberpicker);
        picker.setMinValue(0);
        picker.setMaxValue(999);

        //ler os valores do number picker
        picker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

                kms = newVal;
            }
        });


        Button btok = (Button) mView.findViewById(R.id.dp_timepicker_ok);
        Button btcancel = (Button) mView.findViewById(R.id.dp_timepicker_cancel);
        builder.setView(mView);
        final AlertDialog dialog = builder.create();
        dialog.show();

        //sentinelas para reagirem aos botoes cancel e ok
        btok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etkms.setText(" "+ kms +" Kms");
                serviceActivity.setTravelDistance(kms);
                dialog.dismiss();
            }
        });
        btcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }




    private void saveServiceActivity() {
        serviceActivity.setEquipment(etEquipment.getText().toString());
        //calcular o tempo total
        serviceActivity.computeTotalTime();
        serviceActivity.setWorkDesc(etdescription.getText().toString());
        serviceActivity.setNotes(etnotes.getText().toString());

        long feedback = database.insertServiceActicity(serviceActivity);
        if(feedback == -1){
           Toast.makeText(getContext(), R.string.fail_save_item,Toast.LENGTH_LONG).show();
        }
        clearForm();

    }

    private void clearForm() {
        todayCalendar = Calendar.getInstance();
        updateDate();
        resetTime();
        clientSpinner.setSelection(0);
        etEquipment.getText().clear();
        etdescription.getText().clear();
        etnotes.getText().clear();

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
                if(serviceActivity.getTimeEnd()<serviceActivity.getTimeBegin()){
                    //inputError = true;
                    resetTime();
                    timeInputError();
                }
                else{
                    saveServiceActivity();
                    clearForm();
                }

                return true;
            default:
                break;
        }

        return false;
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
