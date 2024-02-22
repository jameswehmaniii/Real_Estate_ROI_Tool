package RealEstateROI_Project;

/**
 * This program compares real estate investment parameters and return on investment based solely on appreciation of the asset.
 * Each property is classified as real estate.  The types of property have attributes differentiation in the following:
 *      1.  Rate of appreciation
 *      2.  Down payment percent and total out-of-pocket costs
 *      3.  Monthly payment
 *      4.  Credit score requirement for a mortgage loan
 *      5.  Some properties carry and addition site fee or HOA fee
 *
 * Program also prints out detailed information on ESTIMATIONS of the following:
 *      1. Expected appreciation rate for year of 2022
 *      2. Monthly appreciation in terms of dollar amounts
 *      3. Monthly costs and rate
 *      4. Initial investment details and cost amount
 *      5. Property with the fastest return on investment
 */

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Main extends Object {

    /** Method **
     *  Calculates the property with the fastest expected ROI
     * @param realEstate
     */
    public static void calcLengthROI(ArrayList<RealEstate> realEstate) {
        int fastest = 0;
        for(int i = 0; i < realEstate.size(); i++) {
            if(realEstate.get(fastest).getTimeROI() > realEstate.get(i).getTimeROI()) {
                fastest = i;
            }
        }
        System.out.println("Fastest Recuperation: " + realEstate.get(fastest).getName());
        System.out.println("At " + (int)Math.ceil(realEstate.get(fastest).calcRecuperationTime()) + " days");
    }

    public static void main(String[] args) {
        ArrayList<RealEstate> realEstate = new ArrayList<>();

        //Address, Type, Price, Rate, HOA (if applicable)//  if property not being used then comment out
        SFR sfr = new SFR("123 SingleFam Way", "Single Family Residence", 100000, 2.875);  SFR sfr2 = new SFR("1st 2nd SFR", "Single Family Residence", 300000, 2.875);
        GatedSFR gatedSFR = new GatedSFR("1105 Gated Drive", "Gated SFR", 100000, 2.875, 300);
        Townhouse townhouse = new Townhouse("88 Towny Way", "Townhouse", 90000, 2.875, 250);
        Condo condo = new Condo("555 Share Ct #4B", "Condo", 80000, 3.125, 350);
        MobileHome mobileHome = new MobileHome("24 MH C4", "Mobile Home", 50000, 3.5);


        //adds each property to array list if specific property not being used then comment out
        realEstate.add(0, sfr); // realEstate.add(1, sfr2);
        realEstate.add(1, gatedSFR);
        realEstate.add(2, townhouse);
        realEstate.add(3, condo);
        realEstate.add(4, mobileHome);

    //prints out each type of properties' full details
        System.out.println();
        System.out.println("***************************************************************************************************");
        System.out.println();
        for(int i = 0; i < realEstate.size(); i++) {
            System.out.println(realEstate.get(i));
            System.out.println("\n***************************************************************************************************");
            System.out.println();
        }
        System.out.println();

    //seperates and prints each properties' recuperation time
        for(int i = 0; i < realEstate.size(); i++) {
            System.out.println("(" + realEstate.get(i).getType() + ") Address: " + realEstate.get(i).getName() + "\nRecuperation time = " + realEstate.get(i).getTimeROI() + " days");
        }

    //obtains property with the quickest recuperation time
        System.out.println();
        calcLengthROI(realEstate);

        JTextArea textArea = new JTextArea("" + realEstate);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        scrollPane.setPreferredSize(new Dimension(500,500));
        JOptionPane.showMessageDialog(null, scrollPane, "ROI Time on Appreciation of Asset", JOptionPane.YES_NO_OPTION);

    }

}