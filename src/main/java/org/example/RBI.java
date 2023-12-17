package org.example;

interface RBI{

    float depositMoney(float deposit_money);
    float withdrawMoney(float withdraw_money,float curr_money);
    void openFD(float amount,float ROI,int years);

    void applyLoan(int loanType,float amount,int years);
    void applyCreditCard(float curr_money,float min_balance);
}