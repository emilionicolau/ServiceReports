package pt.ezn.apps.servicereports;

import java.util.Date;

/**
 * Created by Emilio on 15/01/2017.
 */

public class DailyExpenses {

    private Date date;
    private int kms;
    private float meal, fuel, fuelAmount, hotel, parking, carExpenses, travel, otherExpenses;

    public void setDate(Date date) {
        this.date = date;
    }

    public void setKms(int kms) {
        this.kms = kms;
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

    public void setOtherExpenses(float otherExpenses) {
        this.otherExpenses = otherExpenses;
    }

    public void setParking(float parking) {
        this.parking = parking;
    }

    public void setTravel(float travel) {
        this.travel = travel;
    }

    public void setCarExpenses(float carExpenses) {
        this.carExpenses = carExpenses;
    }

    public Date getDate() {
        return date;
    }

    public int getKms() {
        return kms;
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

    public float getOtherExpenses() {
        return otherExpenses;
    }

    public float getParking() {
        return parking;
    }

    public float getTravel() {
        return travel;
    }

    public float getCarExpenses() {
        return carExpenses;
    }
}
