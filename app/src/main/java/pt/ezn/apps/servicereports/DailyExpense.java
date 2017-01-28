package pt.ezn.apps.servicereports;

import java.io.Serializable;

/**
 * Created by Emilio on 15/01/2017.
 ServiceReports
 */

public class DailyExpense implements Serializable{

    private int expenseId, date, kms;
    private float meal, fuel, fuelAmount, hotel, parking, carExpenses, travel, otherExpenses, totalExpenses;
    private String notes;

    public DailyExpense() {
    }

    public void setDate(int date) {
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

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public float getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(float totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public int getDate() {
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

    public String getNotes() {
        return notes;
    }
}
