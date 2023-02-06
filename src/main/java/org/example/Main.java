package org.example;

import org.example.enums.Months;
import org.example.service.GeneralService;

import static org.example.enums.Months.JUNE;
import static org.example.enums.Months.MARCH;
import static org.example.enums.Sectors.SHOES;

public class Main {
    public static void main(String[] args) {

        GeneralService generalService = new GeneralService();

        generalService.newCustomer("Kaan"); // Created customers
        generalService.newCustomer("Ege");
        generalService.getAllCustomers(); //Prints out all customers

        generalService.newInvoice(1,MARCH,200,5,SHOES); // Created Invoice

        generalService.filterCustomersByLetter('c'); // Print customers with 'c' in their name
        generalService.filterInvoiceTotalByMonth(JUNE); // Print total price in June

        generalService.getAllInvoiceTotal(); // Print total price of the year
        generalService.getAllInvoices(); // Print all invoices
        generalService.getTotalAbove(1500); // Print invoices with their price higher than 1500
        generalService.getTotalAverageAbove(1500); // Print the average of invoices that are over 1500
        generalService.getCustomersWithUnderLimitInvoices(500); // Print customers with invoices lower than 500
        generalService.getSectorAboveAverageInMonth(JUNE , 750); // Print the sectors that have above 750 average in June
    }
}