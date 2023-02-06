package org.example.service;

import org.example.entities.Customer;
import org.example.entities.Invoice;
import org.example.enums.Months;
import org.example.enums.Sectors;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class GeneralService {

    ArrayList<Customer> customers =  new ArrayList<>();

    public void newCustomer(String customerName) {
        customers.add(new Customer(customerName));
    } //New customer

    public void newInvoice(int customerIndex, Months month, int price, int daysLefttoPay, Sectors sector) { //New Invoice
        customers.get(customerIndex).invoices.add(new Invoice(month,price,daysLefttoPay,sector));
    }

    public void getAllCustomers() { //Prints all customers
        customers.stream().forEach(e -> {
            System.out.println("Customer Name : " + e.getCustomerName());
        });
    }

    public void filterCustomersByLetter(char letter) { // Prints customers with any letter in their name
        AtomicInteger count = new AtomicInteger();
        customers.stream().forEach(e -> {
            for(int i = 0; i < e.getCustomerName().length(); i++){
                if(e.getCustomerName().charAt(i) == letter){
                    System.out.println("Customer Name with " + letter + " in it : " + e.getCustomerName());
                    count.getAndIncrement();
                }
            }
        });
        if(count.get() == 0){
            System.out.println("No customer found.");
        }
    }
    public void filterInvoiceTotalByMonth(Months month) { // Prints total price in a month
        AtomicInteger count = new AtomicInteger();
        AtomicInteger total = new AtomicInteger();
        customers.stream().forEach(e -> {
                for(int i = 0; i < e.invoices.size(); i++){
                    if(e.invoices.get(i).getMonth() == month){
                    total.getAndAdd(e.invoices.get(i).getPrice());
                    count.getAndIncrement();
                }
            }
        });
        if(count.get() == 0){
            System.out.println("No invoice found.");
        }else{
            System.out.println("Total price in " + month + " is " + total);
        }
    }

    public void getAllInvoiceTotal() { // Prints total price
        AtomicInteger total = new AtomicInteger();
        customers.stream().forEach(e -> {
            for(int i = 0; i < e.invoices.size(); i++){
                    total.getAndAdd(e.invoices.get(i).getPrice());
            }
        });
        System.out.println("Total price for all the invoices is : " + total);
    }

    public void getAllInvoices() { // Prints all invoices
        customers.stream().forEach(e -> {
            for(int i = 0; i < e.invoices.size(); i++){
                System.out.println(e.invoices.get(i));
            }
        });
    }

    public void getTotalAbove(int limit) { //Print invoices with their price higher than 1500
        customers.stream().forEach(e -> {
            for(int i = 0; i < e.invoices.size(); i++){
                if(e.invoices.get(i).getPrice() > limit){
                    System.out.println(e.invoices.get(i));
                }
            }
        });
    }

    public void getTotalAverageAbove(int averageLimit) {//Print the average of invoices that are over 1500
        AtomicInteger total = new AtomicInteger();
        AtomicInteger count = new AtomicInteger(1);
        customers.stream().forEach(e -> {
            for(int i = 0; i < e.invoices.size(); i++){
                if(e.invoices.get(i).getPrice() > averageLimit){
                    total.getAndAdd(e.invoices.get(i).getPrice());
                    count.getAndIncrement();
                }
            }
        });
        System.out.println("Average of invoices that are above " + averageLimit + " is " + total.get()/count.get());
    }

    public void getCustomersWithUnderLimitInvoices(int upperLimit) {// Print customers with invoices lower than 500
        customers.stream().forEach(e -> {
            for(int i = 0; i < e.invoices.size(); i++){
                if(e.invoices.get(i).getPrice() < upperLimit){
                    System.out.println(e);
                    i = e.invoices.size();
                }
            }
        });
    }

    public void getSectorAboveAverageInMonth(Months month, int averageLimit) {// Print the sectors that have above 750 average in June
        AtomicInteger totalAutomotive = new AtomicInteger();
        AtomicInteger countAutomotive = new AtomicInteger(1);
        AtomicInteger totalClothing = new AtomicInteger();
        AtomicInteger countClothing = new AtomicInteger(1);
        AtomicInteger totalSportswear = new AtomicInteger();
        AtomicInteger countSportswear = new AtomicInteger(1);
        AtomicInteger totalShoes = new AtomicInteger();
        AtomicInteger countShoes = new AtomicInteger(1);

        customers.stream().forEach(e -> {
            for(int i = 0; i < e.invoices.size(); i++){

                if(e.invoices.get(i).getPrice() < averageLimit){

                    if(e.invoices.get(i).getSector() == Sectors.AUTOMOTIVE){
                        totalAutomotive.getAndAdd(e.invoices.get(i).getPrice());
                        countAutomotive.getAndIncrement();
                    }else if(e.invoices.get(i).getSector() == Sectors.CLOTHING){
                        totalClothing.getAndAdd(e.invoices.get(i).getPrice());
                        countClothing.getAndIncrement();
                    }else if(e.invoices.get(i).getSector() == Sectors.SPORTSWEAR){
                        totalSportswear.getAndAdd(e.invoices.get(i).getPrice());
                        countSportswear.getAndIncrement();
                    }else if(e.invoices.get(i).getSector() == Sectors.SHOES){
                        totalShoes.getAndAdd(e.invoices.get(i).getPrice());
                        countShoes.getAndIncrement();
                    }
                }
            }
        });
        System.out.println("Companies with lower average sales than " + averageLimit + " are as follows : ");
        if(totalAutomotive.get()/countAutomotive.get() < 750){
            System.out.println("Automotive");
        }
        if(totalClothing.get()/countClothing.get() < 750){
            System.out.println("Clothing");
        }
        if(totalSportswear.get()/countSportswear.get() < 750){
            System.out.println("Sportswear");
        }
        if(totalShoes.get()/countShoes.get() < 750){
            System.out.println("Automotive");
        }

    }


}
