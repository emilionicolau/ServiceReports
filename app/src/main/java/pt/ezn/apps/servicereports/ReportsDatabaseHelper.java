package pt.ezn.apps.servicereports;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Emilio on 16/01/2017.
 ServiceReports
 */

public class ReportsDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ServiceReports.db";

    private static final String TABLE_1_NAME = "ServiceActivity";
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

    private static final String TABLE_3_NAME = "DailyExpense";
    private static final String COL_MEAL = "Meals";
    private static final String COL_FUEL = "Fuel";
    private static final String COL_FUELAMOUNT = "FuelAmount";
    private static final String COL_HOTEL = "Hotel";
    private static final String COL_PARKING = "Parking";
    private static final String COL_CAREXPENSES = "CarExpenses";
    private static final String COL_TRAVEL = "Travel";
    private static final String COL_OTHER_EXPENSES = "Other_Expenses";

    private static final String CREATE_TABLE_1 = "CREATE TABLE "+TABLE_1_NAME+"("+
            COL_ID+" INTEGER PRIMARY KEY,  "+
            COL_CLIENT_ID+" INTEGER, "+
            COL_EQUIPMENT+" TEXT, "+
            COL_DATE+" INTEGER NOT NULL, "+
            COL_HOUR_BEGIN+" INTEGER, "+
            COL_HOUR_END+" INTEGER, "+
            COL_TRAVEL_TIME+" INTEGER, "+
            COL_TRAVEL_DISTANCE+" INTEGER, "+
            COL_WORK_DESC+" TEXT, "+
            COL_NOTES+" TEXT) " +
            " FOREIGN KEY("+COL_ID+") REFERENCES "+TABLE_1_NAME+"("+COL_ID+"))";


    private static final String CREATE_TABLE_2 = "CREATE TABLE "+TABLE_2_NAME+"("+
            COL_ID+" INTEGER PRIMARY KEY,  "+
            COL_NAME+" TEXT NOT NULL, "+
            COL_ADDRESS+" TEXT, "+
            COL_CONTACTS+" TEXT, "+
            COL_EQUIPMENTS+" TEXT, "+
            COL_PHONE+" INTEGER, "+
            COL_MOBIL+" INTEGER, "+
            COL_KMS+" INTEGER, "+
            COL_NOTES+" TEXT, ";


    private static final String CREATE_TABLE_3 = "CREATE TABLE "+TABLE_3_NAME+"("+
            COL_ID+" INTEGER PRIMARY KEY,  "+
            COL_DATE+" INTEGER NOT NULL, "+
            COL_KMS+" INTEGER, "+
            COL_MEAL +" INTEGER, "+
            COL_FUEL+" INTEGER, "+
            COL_FUELAMOUNT+" INTEGER, "+
            COL_HOTEL+" INTEGER, "+
            COL_PARKING+" INTEGER, "+
            COL_CAREXPENSES+" INTEGER, "+
            COL_TRAVEL+" INTEGER, "+
            COL_OTHER_EXPENSES+" INTEGER, "+
            COL_NOTES+" TEXT)";



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
    //inserir uma actividade diária
    public long insertServiceActicity (ServiceActivity serviceActivity){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COL_CLIENT_ID, serviceActivity.getClient());
        cv.put(COL_EQUIPMENT, serviceActivity.getEquipment());
        cv.put(COL_DATE, serviceActivity.getDate());
        cv.put(COL_HOUR_BEGIN, serviceActivity.getHourBegin());
        cv.put(COL_HOUR_END, serviceActivity.getHourEnd());
        cv.put(COL_TRAVEL_TIME, serviceActivity.getTravelTime());
        cv.put(COL_TRAVEL_DISTANCE, serviceActivity.getTravelDistance());
        cv.put(COL_WORK_DESC, serviceActivity.getWorkDesc());
        cv.put(COL_NOTES, serviceActivity.getNotes());

        long result = db.insert(TABLE_1_NAME, null, cv);
        return result;


    }

    //inserir um cliente
    public long insertClient (Client client){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COL_NAME, client.getClientName());
        cv.put(COL_ADDRESS, client.getClientAdress());
        cv.put(COL_CONTACTS, client.getClientContacts());
        cv.put(COL_EQUIPMENTS, client.getClientEquipments());
        cv.put(COL_PHONE, client.getClientPhone());
        cv.put(COL_MOBIL, client.getClientMobil());
        cv.put(COL_KMS, client.getClientKms());
        cv.put(COL_NOTES, client.getClientNotes());

        long result = db.insert(TABLE_2_NAME, null, cv);
        return result;

    }

    //inserir uma despesa
    public long insertDailyExpense (DailyExpense dailyExpense){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COL_DATE, dailyExpense.getDate());
        cv.put(COL_KMS, dailyExpense.getKms());
        cv.put(COL_MEAL, dailyExpense.getMeal());
        cv.put(COL_FUEL, dailyExpense.getFuel());
        cv.put(COL_FUELAMOUNT, dailyExpense.getFuelAmount());
        cv.put(COL_HOTEL, dailyExpense.getHotel());
        cv.put(COL_PARKING, dailyExpense.getParking());
        cv.put(COL_CAREXPENSES, dailyExpense.getCarExpenses());
        cv.put(COL_TRAVEL, dailyExpense.getTravel());
        cv.put(COL_OTHER_EXPENSES, dailyExpense.getOtherExpenses());
        cv.put(COL_NOTES, dailyExpense.getNotes());

        long result = db.insert(TABLE_2_NAME, null, cv);
        return result;

    }


}

