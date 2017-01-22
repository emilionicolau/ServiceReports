package pt.ezn.apps.servicereports;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Emilio on 22/01/2017.
 * ServiceReports
 */

public class Message {

    public static void message(Context context, String message){

        Toast.makeText(context, message,Toast.LENGTH_LONG).show();
    }
}
