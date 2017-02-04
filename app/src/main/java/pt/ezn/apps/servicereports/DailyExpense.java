package pt.ezn.apps.servicereports;

import java.io.Serializable;

/**
 * Created by Emilio on 15/01/2017.
 ServiceReports
 */

public class DailyExpense implements Serializable{

    private int expenseId, day, month, year, kms;
    private float meal, fuel, fuelAmount, hotel, parking, carExpenses, travel, otherExpenses, totalExpenses;
    private String notes;

    public DailyExpense() {
        meal=0;
        fuel=0;
        fuelAmount=0;
        hotel=0;
        parking=0;
        carExpenses=0;
        travel=0;
        otherExpenses=0;
        totalExpenses=0;
    }

    public String getDate(){
        return getDay() + "/" + getMonth() + "/" + getYear();
    }

    public void updateTotal(){
        totalExpenses = meal+fuel+hotel+parking+carExpenses+travel+otherExpenses;
    }


    public void setKms(int kms) {
        this.kms = kms;
    }

    public void setFuel(float fuel) {
        this.fuel = fuel;
        updateTotal();
    }

    public void setFuelAmount(float fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public void setHotel(float hotel) {
        this.hotel = hotel;
        updateTotal();
    }

    public void setMeal(float meal) {
        this.meal = meal;
        updateTotal();
    }

    public void setOtherExpenses(float otherExpenses) {
        this.otherExpenses = otherExpenses;
        updateTotal();
    }

    public void setParking(float parking) {
        this.parking = parking;
        updateTotal();
    }

    public void setTravel(float travel) {
        this.travel = travel;
        updateTotal();
    }

    public void setCarExpenses(float carExpenses) {
        this.carExpenses = carExpenses;
        updateTotal();
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getExpenseId() {
        return expenseId;
    }


    public float getTotalExpenses() {
        return totalExpenses;
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

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }
}
