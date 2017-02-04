package pt.ezn.apps.servicereports;

import java.io.Serializable;

/**
 * Created by Emilio on 15/01/2017.
 ServiceReports
 */

public class Client implements Serializable {

    private String clientName,clientType, clientAdress, clientContacts, clientEquipments, clientNotes;
    private int clientId, clientPhone, clientMobil, clientKms;

    public Client() {
    }

    public void setClientAdress(String clientAdress) {
        this.clientAdress = clientAdress;
    }

    public void setClientContacts(String clientContacts) {
        this.clientContacts = clientContacts;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public void setClientEquipments(String clientEquipments) {
        this.clientEquipments = clientEquipments;
    }

    public void setClientKms(int clientKms) {
        this.clientKms = clientKms;
    }

    public void setClientMobil(int clientMobil) {
        this.clientMobil = clientMobil;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setClientPhone(int clientPhone) {
        this.clientPhone = clientPhone;
    }

    public void setClientNotes(String clientNotes) {
        this.clientNotes = clientNotes;
    }

    public int getClientId() {
        return clientId;
    }


    public String getClientAdress() {
        return clientAdress;
    }

    public String getClientContacts() {
        return clientContacts;
    }

    public String getClientEquipments() {
        return clientEquipments;
    }

    public int getClientKms() {
        return clientKms;
    }

    public int getClientMobil() {
        return clientMobil;
    }

    public String getClientName() {
        return clientName;
    }

    public int getClientPhone() {
        return clientPhone;
    }

    public String getClientNotes() {
        return clientNotes;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
}
