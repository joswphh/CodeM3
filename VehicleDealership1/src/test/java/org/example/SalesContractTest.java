package org.example;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SalesContractTest {
    //Arrange
    //Create a vehicle price = 10000
    //create a sales contract
    //hand it the vehicle

    //act
    //run get total price

    //assert
    //compare what it gives me to what I expect

@Test
    public void Test_GetTotalPrice(){
    //arrange
    SalesContract salesContract = new SalesContract("10/12/2012", "sa.@gmail.org", "eyg",
            new Vehicle(12345, 2024, "Ford", "Mustang gt","Black", "car", 0 , 10000  ), true);
    SalesContract salesContract2 = new SalesContract("10/12/2012", "sa.@gmail.org", "eyg",
            new Vehicle(12345, 2024, "Ford", "Mustang gt","Black", "car", 0 , 20000  ), false);
    SalesContract salesContract3 = new SalesContract("10/12/2012", "sa.@gmail.org", "eyg",
            new Vehicle(12345, 2024, "Ford", "Mustang gt","Black", "car", 0 , 5000  ), true);

    //act
    double expectedPrice = (48*(10000*(0.0425/12)*Math.pow(1+(0.0425/12),48))/(Math.pow(1+(0.0425/12),48)-1)) + 100 + 495 + 500;
    double actual = salesContract.getTotalPrice();
    double expectedPrice2 = 20000 + 100 + 495 + 1000;
    double actual2 = salesContract2.getTotalPrice();
    double expectedPrice3 = (24*(5000*(0.0525/12)*Math.pow(1+(0.0525/12),24))/(Math.pow(1+(0.0525/12),24)-1)) + 100 + 295 + 250;
    double actual3 = salesContract3.getTotalPrice();


    //assert
    assertEquals(expectedPrice, actual);
    assertEquals(expectedPrice2,actual2);
    assertEquals(expectedPrice3,actual3);
}

@Test
    public void Test_GetMonthlyPayment(){
    //Arrange
    SalesContract salesContract = new SalesContract("10/12/2012", "sa.@gmail.org", "eyg",
            new Vehicle(12345, 2024, "Ford", "Mustang gt","Black", "car", 0 , 10000  ), true);
    SalesContract salesContract2 = new SalesContract("10/12/2012", "sa.@gmail.org", "eyg",
            new Vehicle(12345, 2024, "Ford", "Mustang gt","Black", "car", 0 , 20000  ), false);
    SalesContract salesContract3 = new SalesContract("10/12/2012", "sa.@gmail.org", "eyg",
            new Vehicle(12345, 2024, "Ford", "Mustang gt","Black", "car", 0 , 5000  ), true);

    //act
    double expectedPrice = ((48*(10000*(0.0425/12)*Math.pow(1+(0.0425/12),48))/(Math.pow(1+(0.0425/12),48)-1)) + 100 + 495 + 500) / 48;
    double actual = salesContract.getMonthlyPayment();
    double expectedPrice2 = 0;
    double actual2 = salesContract2.getMonthlyPayment();
    double expectedPrice3 = ((24*(5000*(0.0525/12)*Math.pow(1+(0.0525/12),24))/(Math.pow(1+(0.0525/12),24)-1)) + 100 + 295 + 250) / 24;
    double actual3 = salesContract3.getMonthlyPayment();

    //assert
    assertEquals(expectedPrice, actual);
    assertEquals(expectedPrice2,actual2);
    assertEquals(expectedPrice3,actual3);
}

}