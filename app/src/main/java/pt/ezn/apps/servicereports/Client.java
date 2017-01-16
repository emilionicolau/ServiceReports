package pt.ezn.apps.servicereports;

/**
 * Created by Emilio on 15/01/2017.
 */

public class Client {

    private String clientName, clientAdress, clientContacts, clientEquipments;
    private int clientPhone, clientMobil, clientKms;



    public void setClientAdress(String clientAdress) {
        this.clientAdress = clientAdress;
    }

    public void setClientContacts(String clientContacts) {
        this.clientContacts = clientContacts;
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
}
