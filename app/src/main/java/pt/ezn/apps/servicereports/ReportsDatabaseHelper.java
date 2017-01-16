package pt.ezn.apps.servicereports;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Emilio on 16/01/2017.
 */

public class ReportsDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "ServiceReports.db";

    public static final String TABLE_1_NAME = "ServiceActivity_Table";
    public static final String COL_ID = "_ID";
    public static final String COL_CLIENT_ID = "Client_ID";
    public static final String COL_EQUIPMENT = "Equipment";
    public static final String COL_DATE = "Date";
    public static final String COL_HOUR_BEGIN = "Hour_Begin";
    public static final String COL_HOUR_END = "Hour_End";
    public static final String COL_TRAVEL_TIME = "Travel_Time";
    public static final String COL_TRAVEL_DISTANCE = "Travel_Distance";
    public static final String COL_WORK_DESC = "Work_Desc";
    public static final String COL_NOTES = "Notes";

    public static final String TABLE_2_NAME = "Clients";
    public static final String COL_NAME = "Name";
    public static final String COL_ADDRESS = "Address";
    public static final String COL_CONTACTS = "Contacts";
    public static final String COL_EQUIPMENTS = "Equipments";
    public static final String COL_PHONE = "Phone";
    public static final String COL_MOBIL = "Mobil";
    public static final String COL_KMS = "Kms";

    public static final String TABLE_3_NAME = "DailyExpenses";
    public static final String COL_MEALS = "Meals";
    public static final String COL_FUEL = "Fuel";
    public static final String COL_FUELAMOUNT = "FuelAmount";
    public static final String COL_HOTEL = "Hotel";
    public static final String COL_PARKING = "Parking";
    public static final String COL_CAREXPENSES = "CarExpenses";
    public static final String COL_TRAVEL = "Travel";
    public static final String COL_OTHER_EXPENSES = "Other_Expenses";


    public static final int VERSION = 1;


    public ReportsDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

