package RealEstateROI_Project;

import java.text.DecimalFormat;
import java.util.ArrayList;

public abstract class RealEstate extends Object {
//All real estate share these parameters
    protected double monthTaxRate = 0.0175008;  //Duval County Tax Rate
    protected String name,
                     type;
    protected double price,
                     monthRate;
//Some real estate has the addition of the following
    protected double monthHOA,
                     monthSiteFee;
//Different classes of real estate have built in parameters below
    protected double monthIns,
                     appraisalCost,
                     loanAmount,
                     downPayment,
                     payment,
                     taxTitleFL,
                     monthlyTax,
                     monthlyAppreciation;
    public int timeROI;
    protected DecimalFormat decimal = new DecimalFormat("0.00");

    public RealEstate(String name, String type, double price, double monthRate) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.monthRate = monthRate;
    }

    public double getMonthTax() {
        return (monthTaxRate * price) / 12;
    }

//Calculate title/tax for property purchase
    public double calcTitleTaxFL() {
        double tax = 0.0094 * price;
        double title = 0.0110 * price;
        return tax + title;
    }

//Calculates payment
    public double calcPayment() {
        double tempRate = (monthRate / 100) / 12;
        double a = (Math.pow((1 + tempRate), 360)-1);
        double b = tempRate * (Math.pow((1 + tempRate), 360));
        return loanAmount / (a/b);
    }

//Calculates time to recuperate initial investment
    public double calcRecuperationTime() {
        return (cashOutPocket() / monthlyAppreciation) * 30.417;
    }

//Calculates total cash out of pocket needed to make property purchase
    public double cashOutPocket() {
        return calcInitialEscrow() + calcTitleTaxFL() + downPayment + appraisalCost;
    }

//Calculates initial escrow needed for purchase
    public double calcInitialEscrow() {
        double tax = 6 * getMonthTax();
        double insurance = 14 * monthIns;
        return tax + insurance;
    }

    public int getTimeROI() {
        return this.timeROI;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

}
