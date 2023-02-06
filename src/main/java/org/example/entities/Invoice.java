package org.example.entities;

import lombok.Data;
import org.example.enums.Months;
import org.example.enums.Sectors;

@Data
public class Invoice{

    public Months month;
    public int price;
    public int daysLefttoPay;

    public Sectors sector;

    public Invoice(Months month, int price, int daysLefttoPay, Sectors sector) {
        this.month = month;
        this.price = price;
        this.daysLefttoPay = daysLefttoPay;
        this.sector = sector;
    }
    @Override
    public String toString(){
        return "This invocie was bougth in " + this.month + ", It's price is " + this.price + "the sector is "
                + this.sector + " and " + this.daysLefttoPay + " days left to pay.";
    }
}
