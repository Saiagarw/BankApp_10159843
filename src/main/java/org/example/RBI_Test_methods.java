package org.example;

public class RBI_Test_methods {

    public float depositMoney(float deposit,float balanace){
        return balanace+deposit;
    }

    public float withdrawMoney(float withdraw,float balance,int times,int times_limit,float min_balance){

        float total_withdraw=withdraw;
        if(times>times_limit){
            total_withdraw+=(0.01f*withdraw);
        }

        if((balance-total_withdraw)<min_balance){
            return balance;
        }
        return balance-total_withdraw;
    }

    public String openFD(float amt,int years,float roi){

        float mat_val=amt;

        for(int i=0;i<years;i++){
            mat_val+=(mat_val*roi);
        }

        return "Total maturity value is "+mat_val;
    }

    public String applyLoan(float amt,int years,float roi){

        float mat_val=amt;

        for(int i=0;i<years;i++){
            mat_val+=(mat_val*roi);
        }

        return "Total loan value is "+mat_val;
    }

    public String applyCredit(float bal,float min_bal){

        if(bal>=(2*min_bal)){
            return "You are eligible for credit card";
        }
        else
            return "You are not eligible for credit card";
    }
}
