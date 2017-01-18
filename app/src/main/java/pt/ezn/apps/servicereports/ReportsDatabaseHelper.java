package pt.ezn.apps.servicereports;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Emilio on 16/01/2017.
 ServiceReports
 */

public class ReportsDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ServiceReports.db";

    private static final String TABLE_1_NAME = "ServiceActivity_Table";
    private static final String COL_ID = "_id";
    private static final String COL_CLIENT_ID = "Client_id";
    private static final String COL_EQUIPMENT = "Equipment";
    private static final String COL_DATE = "Date";
    private static final String COL_HOUR_BEGIN = "Hour_Begin";
    private static final String COL_HOUR_END = "Hour_End";
    private static final String COL_TRAVEL_TIME = "Travel_Time";
    private static final String COL_TRAVEL_DISTANCE = "Travel_Distance";
    private static final String COL_WORK_DESC = "Work_Desc";
    private static final String COL_NOTES = "Notes";

    private static final String TABLE_2_NAME = "Clients";
    private static final String COL_NAME = "Name";
    private static final String COL_ADDRESS = "Address";
    private static final String COL_CONTACTS = "Contacts";
    private static final String COL_EQUIPMENTS = "Equipments";
    private static final String COL_PHONE = "Phone";
    private static final String COL_MOBIL = "Mobil";
    private static final String COL_KMS = "Kms";

    private static final String TABLE_3_NAME = "DailyExpenses";
    private static final String COL_MEALS = "Meals";
    private static final String COL_FUEL = "Fuel";
    private static final String COL_FUELAMOUNT = "FuelAmount";
    private static final String COL_HOTEL = "Hotel";
    private static final String COL_PARKING = "Parking";
    private static final String COL_CAREXPENSES = "CarExpenses";
    private static final String COL_TRAVEL = "Travel";
    private static final String COL_OTHER_EXPENSES = "Other_Expenses";

    private static final String CREATE_TABLE_1 = "CREATE TABLE "+TABLE_1_NAME+"("+
            COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT "+
            COL_CLIENT_ID+" INTEGER "+
            COL_EQUIPMENT+" TEXT "+
            COL_DATE+" INTEGER "+
            COL_HOUR_BEGIN+" INTEGER "+
            COL_HOUR_END+" INTEGER "+
            COL_TRAVEL_TIME+" INTEGER "+
            COL_TRAVEL_DISTANCE+" INTEGER "+
            COL_WORK_DESC+" TEXT "+
            COL_NOTES+" TEXT "+
            ");";

    private static final String CREATE_TABLE_2 = "CREATE TABLE "+TABLE_2_NAME+"("+
            COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT "+
            COL_CLIENT_ID+" INTEGER "+
            COL_NAME+" TEXT "+
            COL_ADDRESS+" TEXT "+
            COL_CONTACTS+" TEXT "+
            COL_EQUIPMENTS+" TEXT "+
            COL_PHONE+" INTEGER "+
            COL_MOBIL+" INTEGER "+
            COL_KMS+" INTEGER "+
            COL_NOTES+" TEXT "+
            ");";

    private static final String CREATE_TABLE_3 = "CREATE TABLE "+TABLE_3_NAME+"("+
            COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT "+
            COL_DATE+" INTEGER "+
            COL_KMS+" INTEGER "+
            COL_MEALS+" INTEGER "+
            COL_FUEL+" INTEGER "+
            COL_FUELAMOUNT+" INTEGER "+
            COL_HOTEL+" INTEGER "+
            COL_PARKING+" INTEGER "+
            COL_CAREXPENSES+" INTEGER "+
            COL_TRAVEL+" INTEGER "+
            COL_OTHER_EXPENSES+" INTEGER "+
            COL_NOTES+" TEXT "+
            ");";


    public static final int VERSION = 1;


    public ReportsDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_1);
        db.execSQL(CREATE_TABLE_2);
        db.execSQL(CREATE_TABLE_3);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i1, int i2) {

    }
}

