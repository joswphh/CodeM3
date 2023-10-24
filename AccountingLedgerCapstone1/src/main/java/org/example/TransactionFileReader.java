package org.example;


import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


public class TransactionFileReader {

    private ArrayList<AccountingConstructors> transactionItems;


    private String transactionFilePath = "src/main/resources/transaction.csv";
    public void Transaction(){
        transactionItems = new ArrayList<>();
    }

    public void ClearTransactions(){
        transactionItems.clear();
    }

    public ArrayList<AccountingConstructors> getTransactionItems() {
        return transactionItems;
    }
}

