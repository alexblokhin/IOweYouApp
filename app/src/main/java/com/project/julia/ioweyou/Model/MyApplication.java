package com.project.julia.ioweyou.Model;

import android.app.Application;

import java.util.ArrayList;

/**
 * This class holds all of the global data that can be accessed anywhere in the application.
 * <p>
 * Members:
 *   payers - an ArrayList of stored Payer objects, representing the user's party
 *   tax - the user-specified local sales tax percentage, converted to a multiplier
 */
public class MyApplication extends Application {
    
    private ArrayList<Payer> payers;
    private double tax;

    public MyApplication() {
        super();
        payers = new ArrayList<>();
        tax = 0d;
    }



    /**
     * Get the stored Payer object at the given index
     *
     * @param idx The index of the stored Payer object
     * @return The stored Payer object at the given index, or null if not found
     */
    public Payer getPayer(int idx) {
        try {
            return payers.get(idx);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    // Get methods
    public ArrayList<Payer> getPayers() { return payers; }
    public double getTax() { return tax; }
    public int getNumPayers() { return payers.size(); }

    // Set method
    public void setTax(double new_tax) { tax = new_tax; }

    // Clear methods
    public void clearAmtsOwed() { for (Payer payer : payers) payer.clearAmtOwed(); }

    /**
     * Check if the ArrayList of stored Payer objects is empty
     *
     * @return `true` if the ArrayList is empty, else `false`
     */
    public boolean payersIsEmpty() { return payers.isEmpty(); }

}
