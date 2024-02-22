package RealEstateROI_Project;

public class GatedSFR extends SFR {
//Same characteristics of a Single Family Residence except has a different appraisal value
    private double appraisalGatedSFR = 750.00;

//Addition of a monthly HOA argument
    GatedSFR(String name, String type, double price, double monthRate, double monthHOA) {
        super(name, type, price, monthRate);
        this.monthHOA = monthHOA;
        this.appraisalCost = appraisalGatedSFR;
        this.timeROI = (int)(Math.ceil(calcRecuperationTime()));
    }

    @Override
    public String toString() {
        return "**************************************************************************************" +
                "\n" + "\n" + name +
                "\nType: " + type +
                "\nCredit Score Required: " + creditScore +
                "\nDown Payment Required: 3.5%" +
                "\nAppraisal Cost: " + decimal.format(appraisalCost) +
                "\nShares attributes of a Single Family Residence within a gated community (has HOA fee)" +

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
                "\nEstimated Monthly Appreciation (16% for Year 2022): " + decimal.format(monthlyAppreciation) +
                "\nCash Recuperation Time From Asset Appreciation (days): " + decimal.format(timeROI) + " days";
    }


//Test Bench Method//
    public static void main(String[] args) {
        GatedSFR GatedSFR = new GatedSFR("522 River Ave", "GatedSFR", 100000, 3.5, 45);
        System.out.println(GatedSFR);
    }

}
