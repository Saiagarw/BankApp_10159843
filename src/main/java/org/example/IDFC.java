package org.example;

import java.util.HashMap;

public class IDFC implements RBI{

    int counter=3;
    float rbi_loan_charge=0.02f,rbi_cc_charge=0.01f;
    HashMap<Integer,Float> loan_roi=new HashMap<>();
    public IDFC() {
        loan_roi.put(1,0.07f);
        loan_roi.put(2,0.06f);
        loan_roi.put(3,0.11f);
        loan_roi.put(4,0.10f);
    }

    public IDFC(float balance) {
    }

    public float depositMoney(float deposit_money) {
        return deposit_money;
    }
    public float withdrawMoney(float withdraw_money,float curr_money){

        float penalty_money=0.0f,total_withdraw_money;

        if(counter==0) {
            penalty_money= (float)(0.01*withdraw_money);
        }

        total_withdraw_money=penalty_money+withdraw_money;

        if((curr_money-total_withdraw_money)<1000) {
            System.out.println("You don't have sufficient balance to withdraw");
        }
        else {
            curr_money-=total_withdraw_money;
        }
        if(this.counter>0)
            this.counter--;

        return total_withdraw_money;
    }

    public void openFD(float amount, float ROI, int years) {

        float curr=amount;

        if(ROI>1.0){
            ROI=ROI/100;
        }

        for(int i=0;i<years;i++)
        {
            curr+=(ROI*curr);
        }

        System.out.println("Total Maturity Value "+curr);
    }

    public void applyLoan(int loanType, float amount, int years) {

        float curr=amount;
        float ROI=loan_roi.get(loanType);
        if(ROI>1.0){
            ROI=ROI/100;
        }
        for(int i=0;i<years;i++)
        {
            curr=(ROI*curr);
        }

        System.out.println("Total Loan Value "+curr);
    }

    public void applyCreditCard(float curr_balance,float min_balance) {

        if(curr_balance<(2*min_balance))
            System.out.println("You are not eligible for Credit Card");
        else
            System.out.println("You are eligible for Credit Card");
    }
}
