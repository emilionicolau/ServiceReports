package pt.ezn.apps.servicereports;

import java.io.Serializable;

/**
 * Created by Emilio on 15/01/2017.
 ServiceReports
 */

public class ServiceActivity implements Serializable{


    private String client, equipment, workDesc, notes;
    private int serviceId, cliendId, day, month, year, timeBegin, timeEnd, totalTime, travelTime, travelDistance;

    public ServiceActivity() {

    }


    public String Date(){
        String day, month;
        if (getDay()<10){
            day = "0"+getDay();
        }
        else day = String.valueOf(getDay());
        if (getMonth()<10){
            month = "0"+getMonth();
        }
        else month = String.valueOf(getMonth());

        return day + "-" + month + "-" + getYear();
    }


    public void setClient(String client) {
        this.client = client;
    }



    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public void setTimeBegin(int timeBegin) {
        this.timeBegin = timeBegin;
    }

    public void setTimeEnd(int timeEnd) {
        this.timeEnd = timeEnd;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setTravelDistance(int travelDistance) {
        this.travelDistance = travelDistance;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    public void setWorkDesc(String workDesc) {
        this.workDesc = workDesc;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void computeTotalTime() {
        this.totalTime = timeEnd - timeBegin;;
    }

    public String getClient() {
        return client;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getEquipment() {
        return equipment;
    }

    public int getTimeBegin() {
        return timeBegin;
    }

    public int getTimeEnd() {
        return timeEnd;
    }

    public String getNotes() {
        return notes;
    }

    public int getTravelDistance() {
        return travelDistance;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public String getWorkDesc() {
        return workDesc;
    }

    public int getCliendId() {
        return cliendId;
    }

    public void setCliendId(int cliendId) {
        this.cliendId = cliendId;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }
}
