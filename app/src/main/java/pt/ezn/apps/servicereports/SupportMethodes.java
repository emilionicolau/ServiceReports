package pt.ezn.apps.servicereports;

/**
 * Created by Emilio on 05/02/2017.
 * ServiceReports
 */

public class SupportMethodes {


    public static String getHourString(int hour, int min) {
        String stringhour, stringmin;
        if(hour < 10){
            stringhour = '0'+String.valueOf(hour);
        }
        else{
            stringhour = String.valueOf(hour);
        }
        if (min < 10){
            stringmin = '0'+String.valueOf(min);
        }
        else{
            stringmin = String.valueOf(min);
        }

        return stringhour +":"+ stringmin;
    }


    public static int computeTime(int hour, int min){
        return hour*60+min;
    }

    public static int getMin (int time){
        return time%60;
    }

    public static int getHour (int time){
        return time/60;
    }


    public static String getDateString(int day,int month,int year) {
        String date =String.valueOf(day) + '-' + String.valueOf(month) + '-' + String.valueOf(year);
        return date;
    }




}
