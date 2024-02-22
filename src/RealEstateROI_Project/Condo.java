package RealEstateROI_Project;


public class Condo extends RealEstate {
    private double yearAppreciation = 0.10;
    private double downPaymentPercent = 0.05;
    private double monthIns = price * (0.002 / 12);
    private double appraisalCondo = 900.00;
    private int creditScore = 700;

    public Condo(String name, String type, double price, double monthRate, double HOA) {
        super(name, type, price, monthRate);
        this.monthHOA = HOA;
        this.downPayment = price * downPaymentPercent;
        this.loanAmount = price - downPayment;
        this.monthlyAppreciation = (price * yearAppreciation) / 12;
        this.payment = calcPayment();
        this.taxTitleFL = calcTitleTaxFL() + 400;
        this.monthlyTax = getMonthTax();
        this.appraisalCost = appraisalCondo;
        this.timeROI = (int)(Math.ceil(calcRecuperationTime()));
    }

    @Override
    public double calcTitleTaxFL() {
        double tax = 0.0094 * price;
        double title = 0.0110 * price;
        return tax + title + 400; //400 extra due to condo
    }

    public String toString() {
        return "**************************************************************************************" +
                "\n" + "\n" + name +
                "\nType: " + type +
                "\nCredit Score Required: " + creditScore +
                "\nDown Payment Required: 3.5%" +
                "\nAppraisal Cost: " + decimal.format(appraisalCost) +
                "\nProperty attached to other properties, each living quarter called units.  Residents share and own shares in the land and community." +

                "\n\nPrice: " + decimal.format(price) +
                "\nDown Payment (3.5%): " + decimal.format(downPayment) +
                "\nLoan Amount: " + decimal.format(loanAmount) +
                "\nPayment Rate: " + monthRate +
                "\nMortgage Payment : " + decimal.format(payment) +
                "\nMonthly Taxes, Insurance, HOA Dues: " + decimal.format(monthlyTax + monthIns + monthHOA) +
                "\nOverall Payment: " + decimal.format(payment + monthlyTax + monthIns + monthHOA) +

                "\n\n*Investment Details*" +
                "\nDown Payment: " + decimal.format(downPayment) +
                "\nTitle and Sales Tax: " + decimal.format(calcTitleTaxFL()) +
                "\nInitial Escrow: " + decimal.format(calcInitialEscrow()) +
                "\nAppraisal Cost: " + decimal.format(appraisalCost) +
                "\nTotal Cash Out Of Pocket: " + decimal.format(cashOutPocket()) +
                "\nEstimated Monthly Appreciation (10% for Year 2022): " + decimal.format(monthlyAppreciation) +
                "\nCash Recuperation Time From Asset Appreciation (days): " + decimal.format(timeROI) + " days";
    }

//Test Bench Method//
    public static void main(String[] args) {
        Condo condo = new Condo("522 River Ave", "Condo", 100000, 3.5, 350);
        System.out.println(condo);
    }


}
