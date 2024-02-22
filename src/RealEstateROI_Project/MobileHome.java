package RealEstateROI_Project;

public class MobileHome extends RealEstate {
    private double yearAppreciation = 0.03;
    private double downPaymentPercent = 0.10;
    private double monthIns = price * (0.003 / 12);
    private double siteFee = (price * 0.01) / 12;
    private double appraisalMH = 350.00;
    private int creditScore = 700;

    public MobileHome(String name, String type, double price, double monthRate) {
        super(name, type, price, monthRate);
        this.monthSiteFee = siteFee;
        this.downPayment = price * downPaymentPercent;
        this.loanAmount = price - downPayment;
        this.monthlyAppreciation = (price * yearAppreciation) / 12;
        this.payment = calcPayment();
        this.taxTitleFL = calcTitleTaxFL();
        this.monthlyTax = getMonthTax();
        this.appraisalCost = appraisalMH;
        this.timeROI = (int)(Math.ceil(calcRecuperationTime()));
    }

    public String toString() {
        return "**************************************************************************************" +
                "\n" + "\n" + name +
                "\nType: " + type +
                "\nCredit Score Required: " + creditScore +
                "\nDown Payment Required: 3.5%" +
                "\nAppraisal Cost: " + decimal.format(appraisalCost) +
                "\nTraditionally a low cost, low maintenance option" +

                "\n\nPrice: " + decimal.format(price) +
                "\nDown Payment (3.5%): " + decimal.format(downPayment) +
                "\nLoan Amount: " + decimal.format(loanAmount) +
                "\nPayment Rate: " + monthRate +
                "\nMortgage Payment : " + decimal.format(payment) +
                "\nMonthly Taxes, Insurance, Site Fee: " + decimal.format(monthlyTax + monthIns + monthSiteFee) +
                "\nOverall Payment: " + decimal.format(payment + monthlyTax + monthIns + siteFee) +

                "\n\n*Investment Details*" +
                "\nDown Payment: " + decimal.format(downPayment) +
                "\nTitle and Sales Tax: " + decimal.format(calcTitleTaxFL()) +
                "\nInitial Escrow: " + decimal.format(calcInitialEscrow()) +
                "\nAppraisal Cost: " + decimal.format(appraisalCost) +
                "\nTotal Cash Out Of Pocket: " + decimal.format(cashOutPocket()) +
                "\nEstimated Monthly Appreciation (3% for Year 2022): " + decimal.format(monthlyAppreciation) +
                "\nCash Recuperation Time From Asset Appreciation (days): " + decimal.format(timeROI) + " days";
    }

    public static void main(String[] args) {
        MobileHome mobileHome = new MobileHome("522 River Ave", "Mobile Home", 100000, 3.5);
        System.out.println(mobileHome);
    }



}
