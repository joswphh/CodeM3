package org.example;

public class LeaseContract extends Contract{
    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
    }

    public double expectedEndingValue(){
        return getVehicleSold().getPrice() * .50;
    }
    public double leaseFee(){
        return getVehicleSold().getPrice() * 0.07;
    }
    @Override
    public double getTotalPrice(){
        return (getMonthlyPayment() * 36);
    }
    @Override
    public double getMonthlyPayment(){
        return (getVehicleSold().getPrice() - expectedEndingValue() + leaseFee())/36+((getVehicleSold().getPrice() + expectedEndingValue() + leaseFee())* (4/2400));
    }
}
