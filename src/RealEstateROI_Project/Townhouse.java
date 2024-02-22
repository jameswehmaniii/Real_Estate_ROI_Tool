package RealEstateROI_Project;

public class Townhouse extends RealEstate {
    private double yearAppreciation = 0.14;
    private double downPaymentPercent = 0.035;
    private double monthIns = price * (0.002 / 12);
    private double appraisalTownhouse = 700.00;
    private int creditScore = 680;

    Townhouse(String name, String type, double price, double monthRate, double HOA) {
        super(name, type, price, monthRate);
        this.monthHOA = HOA;
        this.downPayment = price * downPaymentPercent;
        this.loanAmount = price - downPayment;
        this.monthlyAppreciation = (price * yearAppreciation) / 12;
        this.payment = calcPayment();
        this.taxTitleFL = calcTitleTaxFL();
        this.monthlyTax = getMonthTax();
        this.appraisalCost = appraisalTownhouse;
        this.timeROI = (int)(Math.ceil(calcRecuperationTime()));
    }

    public String toString() {
        return "**************************************************************************************" +
                "\n" + "\n" + name +
                "\nType: " + type +
                "\nCredit Score Required: " + creditScore +
                "\nDown Payment Required: 3.5%" +
                "\nAppraisal Cost: " + decimal.format(appraisalCost) +
                "\nSingle Family Residence that is attached to another residence and shares a plot of land." +

                "\n\nPrice: " + decimal.format(price) +
                "\nDown Payment (3.5%): " + decimal.format(downPayment) +
                "\nLoan Amount: " + decimal.format(loanAmount) +
                "\nPayment Rate: " + monthRate +
                "\nMortgage Payment : " + decimal.format(payment) +
                "\nMonthly Taxes, Insurance, HOA Dues: " + decimal.format(monthlyTax + monthIns + monthHOA) +
                "\nOverall Payment: " + decimal.format(payment + monthlyTax + monthIns + monthHOA) +

                "\n\n*Investment Details*" +
                "\nDown Payment: " + decimal.format(downPayment) +
                "\nTitle and Sales Tax: " + decimal.format(taxTitleFL) +
                "\nInitial Escrow: " + decimal.format(calcInitialEscrow()) +
                "\nAppraisal Cost: " + decimal.format(appraisalCost) +
                "\nTotal Cash Out Of Pocket: " + decimal.format(cashOutPocket()) +
                "\nEstimated Monthly Appreciation (14% for Year 2022): " + decimal.format(monthlyAppreciation) +
                "\nCash Recuperation Time From Asset Appreciation (days): " + decimal.format(timeROI) + " days";
    }

//Test Bench Method//
    public static void main(String[] args) {
        Townhouse townhouse = new Townhouse("522 River Ave", "Townhouse", 100000, 3.5, 300);
        System.out.println(townhouse);
    }

}
