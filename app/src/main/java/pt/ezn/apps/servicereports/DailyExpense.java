package pt.ezn.apps.servicereports;

import java.util.Date;

/**
 * Created by Emilio on 15/01/2017.
 */

public class DailyExpense {

    private Date date;
    private float meal, fuel, fuelAmount, hotel, parking, otherExpense;

    public void setDate(Date date) {
        this.date = date;
    }

    public void setFuel(float fuel) {
        this.fuel = fuel;
    }

    public void setFuelAmount(float fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public void setHotel(float hotel) {
        this.hotel = hotel;
    }

    public void setMeal(float meal) {
        this.meal = meal;
    }

    public void setOtherExpense(float otherExpense) {
        this.otherExpense = otherExpense;
    }

    public void setParking(float parking) {
        this.parking = parking;
    }

    public Date getDate() {
        return date;
    }

    public float getFuel() {
        return fuel;
    }

    public float getFuelAmount() {
        return fuelAmount;
    }

    public float getHotel() {
        return hotel;
    }

    public float getMeal() {
        return meal;
    }

    public float getOtherExpense() {
        return otherExpense;
    }

    public float getParking() {
        return parking;
    }
}
