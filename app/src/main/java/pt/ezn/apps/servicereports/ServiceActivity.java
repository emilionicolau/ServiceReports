package pt.ezn.apps.servicereports;

import java.util.Date;

/**
 * Created by Emilio on 15/01/2017.
 ServiceReports
 */

public class ServiceActivity {

    private Date date;
    private String client, equipment, workDesc, notes;
    private int hourBegin, hourEnd, travelTime, travelDistance;

    public void setClient(String client) {
        this.client = client;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public String getClient() {
        return client;
    }

    public Date getDate() {
        return date;
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
}
