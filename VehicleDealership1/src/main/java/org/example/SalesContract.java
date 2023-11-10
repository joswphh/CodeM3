package org.example;

public class SalesContract extends Contract {
    private boolean isFinance;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold,boolean isFinance) {
        super(date, customerName, customerEmail, vehicleSold);
        this.isFinance = isFinance;
    }


    public boolean isFinance() {
        return isFinance;
    }
    public int recordingFee() {
        return 100;
    }
    public double salesTax() {
        return getVehicleSold().getPrice() * 0.05;
    }

    public double processingFee(){
     double price = getVehicleSold().getPrice();
     double processingFee = 0;
    if (price < 10000){
        processingFee = 295;
        } else {
            processingFee = 495;
        }
    return processingFee;
    }
    @Override
    public double getMonthlyPayment(){
        double basePrice = getVehicleSold().getPrice();
        double monthlyPayment;
        if(isFinance) {
            if (basePrice >= 10000) {
                //for 48 months
               monthlyPayment = getTotalPrice() / 48;
            } else {
                //for 24 months
                monthlyPayment = getTotalPrice() / 24;
            }
        }else {
            // cash no finance $$
            return 0;
        }
        return monthlyPayment;
    }

    @Override
    public double getTotalPrice(){
        double basePrice = getVehicleSold().getPrice();
        double totalPrice;
        if(isFinance) {
            if (basePrice >= 10000) {
                //4.25% at 48 months
                double r = 0.0425 / 12;
                totalPrice = (48*(basePrice*r*Math.pow(1+r,48))/(Math.pow(1+r,48)-1))
                        + recordingFee() + processingFee() + salesTax();
            } else {
                //5.25% at 24 months
                double r = 0.0525 / 12;
                totalPrice = (24*(basePrice*r*Math.pow(1+r,24))/(Math.pow(1+r,24)-1))
                        + recordingFee() + processingFee() + salesTax();
            }
        } else{
        //Straight cash baby.
        totalPrice = basePrice + recordingFee() + processingFee() + salesTax();
    }
        return totalPrice;
    }
}
