package pt.ezn.apps.servicereports;

import java.io.Serializable;

/**
 * Created by Emilio on 15/01/2017.
 ServiceReports
 */

public class ServiceActivity implements Serializable{


    private String client, equipment, workDesc, notes;
    private int serviceId, cliendId, day, month, year, hourBegin, minBegin, hourEnd, minEnd, totalHour,
            totalMin,travelTime, travelDistance;

    public ServiceActivity() {

    }
    public void totalTime(){
        if (minEnd < minBegin){
            int mintemp = minEnd + 60;
            int hourtemp = hourEnd - 1;
            totalHour = hourtemp - hourBegin;
            totalMin = mintemp - minBegin;
        }
        else{
            totalHour = hourEnd - hourBegin;
            totalMin = minEnd - minBegin;
        }

    }

    public String Date(){
        return getDay() + "/" + getMonth() + "/" + getYear();
    }


    public void setClient(String client) {
        this.client = client;
    }



    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public void setHourBegin(int hourBegin) {
        this.hourBegin = hourBegin;
    }

    public void setHourEnd(int hourEnd) {
        this.hourEnd = hourEnd;
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

    public int getTotalHour() {
        return totalHour;
    }

    public void setTotalHour(int totalHour) {
        this.totalHour = totalHour;
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

    public int getHourBegin() {
        return hourBegin;
    }

    public int getHourEnd() {
        return hourEnd;
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

    public int getMinBegin() {
        return minBegin;
    }

    public void setMinBegin(int minBegin) {
        this.minBegin = minBegin;
    }

    public int getMinEnd() {
        return minEnd;
    }

    public void setMinEnd(int minEnd) {
        this.minEnd = minEnd;
    }

    public int getTotalMin() {
        return totalMin;
    }
}
