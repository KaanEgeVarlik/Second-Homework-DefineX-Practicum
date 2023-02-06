package org.example.entities;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Customer {

    public String customerName;
    public ArrayList<Invoice> invoices = new ArrayList<>();

    public Customer(String customerName) {
        this.customerName = customerName;
    }
    @Override
    public String toString(){
        return "Customer's name is " + this.customerName;
    }
}
