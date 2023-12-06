public class RBI {
    float balance;
    int counter;

    public RBI() {
    }

    public RBI(float balance) {
        this.balance = balance;
        this.counter=3;
    }

    public void depositMoney(float deposit_money) {
        this.balance += deposit_money;
    }
    public void withdrawMoney(float withdraw_money){
        float penalty_money=0.0f,total_withdraw_money;

        if(counter==0) {
            penalty_money= (float)(0.01*withdraw_money);
        }

        total_withdraw_money=penalty_money+withdraw_money;

        if((this.balance-total_withdraw_money)<1000) {
            System.out.println("You don't have sufficient balance to withdraw");
        }
        else {
            this.balance-=total_withdraw_money;
        }
        if(this.counter>0)
            this.counter--;
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
    public void applyLoan(String loanType, float amount, float ROI, int years) {

        float curr=amount;
        if(ROI>1.0){
            ROI=ROI/100;
        }
        for(int i=0;i<years;i++)
        {
            curr=(ROI*curr);
        }

        System.out.println("Total Loan Value "+curr);
    }
    public void applyCreditCard() {}
    public float getBalance() {
        return this.balance;
    }
}
