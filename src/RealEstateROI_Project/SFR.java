package RealEstateROI_Project;

public class SFR extends RealEstate {
//different characteristics of a Single Family Residence
    private double yearAppreciation = 0.16;
    private double downPaymentPercent = 0.035;
    protected double monthIns = price * (0.008 / 12);
    private double appraisalSFR = 700.00;
    protected int creditScore = 660;

    SFR (String name, String type, double price, double monthRate) {
        super(name, type, price, monthRate);
        this.downPayment = price * downPaymentPercent;
        this.loanAmount = price - downPayment;
        this.monthlyAppreciation = (price * yearAppreciation) / 12;
        this.payment = calcPayment();
        this.taxTitleFL = calcTitleTaxFL();
        this.monthlyTax = getMonthTax();
        this.appraisalCost = appraisalSFR;
        this.timeROI = (int)(Math.ceil(calcRecuperationTime()));
    }

    public String toString() {
        return "**************************************************************************************" +
                "\n" + "\n" + name +
                "\nType: " + type +
                "\nCredit Score Required: " + creditScore +
                "\nDown Payment Required: 3.5%" +
                "\nAppraisal Cost: " + decimal.format(appraisalSFR) +
                "\nProperty unattached to other buildings and does not share plot of land." +

                "\n\nPrice: " + decimal.format(price) +
                "\nDown Payment (3.5%): " + decimal.format(downPayment) +
                "\nLoan Amount: " + decimal.format(loanAmount) +
                "\nPayment Rate: " + monthRate +
                "\nMortgage Payment : " + decimal.format(payment) +
                "\nMonthly Taxes & Insurance: " + decimal.format(monthlyTax + monthIns) +
                "\nOverall Payment: " + decimal.format(payment + monthlyTax + monthIns) +

                "\n\n*Investment Details*" +
                "\nDown Payment: " + decimal.format(downPayment) +
                "\nTitle and Sales Tax: " + decimal.format(taxTitleFL) +
                "\nInitial Escrow: " + decimal.format(calcInitialEscrow()) +
                "\nAppraisal Cost: " + decimal.format(appraisalCost) +
                "\nTotal Cash Out Of Pocket: " + decimal.format(cashOutPocket()) +
                "\nEstimated Monthly Appreciation (16% for Year 2022): " + decimal.format(monthlyAppreciation) +
                "\nCash Recuperation Time From Asset Appreciation (days): " + decimal.format(timeROI) + " days";

    }

//Test Bench Method//
    public static void main(String[] args) {
        SFR sfr = new SFR("101 Main St", "SFR", 100000, 3.5);
        System.out.println(sfr);
    }

}
