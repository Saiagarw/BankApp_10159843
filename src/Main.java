import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    BufferedReader buff;
    InputStreamReader isr;

    float min_bal=1000;
    public Main() {
        if(isr == null)
            isr = new InputStreamReader(System.in);
        if(buff == null)
            buff = new BufferedReader(isr);
    }

    public int integer_reader(){

        int a=0;
        try {
            a=Integer.parseInt(this.buff.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return a;
    }

    public float float_reader(){

        float a=0;
        try {
            a=Float.parseFloat(this.buff.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return a;
    }

    public String string_reader(){

        String a="";
        try {
            a=this.buff.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return a;
    }

    int selectedBank, selectedOperation;

    public static void main(String[] args) {
        Main obj = new Main();
        Customer cust = new Customer();
        System.out.println("Welcome to IBS\nPlease select your bank\n1. ICICI\n2. HDFC\n3. SBI\n4. AXIS\n5. IDFC");


        obj.selectedBank = obj.integer_reader();
        System.out.println("Customer Selected " + obj.selectedBank);

        System.out.println("Please Enter Your Name");
        cust.setCustomerName(obj.string_reader());

        System.out.println("Please Enter Your Email");
        cust.setCustomerEmail(obj.string_reader());

        System.out.println("Please Enter Your Address");
        cust.setCustomerAddress(obj.string_reader());

        System.out.println("Please Enter Your Gender");
        cust.setCustomerGender(obj.string_reader());

        System.out.println("Please Enter Your Aadhaar");
        cust.setCustomerAadhar(obj.string_reader());

        System.out.println("Please Enter Your Phone");
        cust.setCustomerPhone(obj.string_reader());

        System.out.println("Please Enter Opening Balance");
        cust.balance=(Float.parseFloat(obj.string_reader()));

        RBI bank=null;

        switch(obj.selectedBank){

            case 1:
                bank=new ICICI();
                break;
            case 2:
                bank=new HDFC();
                break;
            case 3:
                bank=new SBI();
                break;
            case 4:
                bank=new AXIS();
                break;
            case 5:
                bank=new IDFC();
                break;
            default:
                bank=null;
        }

        while(true){

            System.out.println("Select your choice\n1. Deposit\n2. Withdrawl\n3. OpenFD\n4. Apply Loan\n5. Apply CC");

            obj.selectedOperation = obj.integer_reader();
            System.out.println("Customer Selected " + obj.selectedOperation);

            int customer_task_choice=obj.selectedOperation;
            float curr_money=cust.balance;

            if(customer_task_choice == 1)
            {
                System.out.println("Please Enter The Amount You Want to Deposit");
                cust.balance+=bank.depositMoney(obj.float_reader());
                System.out.println("Your current updated balance "+ cust.balance);
            }
            else if(customer_task_choice == 2)
            {
                System.out.println("Please Enter the Amount to Withdraw");
                cust.balance-=bank.withdrawMoney(obj.float_reader(),cust.balance);
                System.out.println("Your current updated balance "+ cust.balance);
            }
            else if(customer_task_choice == 3) {
                float fd_amount=0.0f,fd_roi=0.0f;
                int fd_term=0;

                System.out.println("Please Enter The Amount You Want to openFD");
                fd_amount=obj.float_reader();

                System.out.println("Please Enter The Term You Want to openFD");
                fd_term=obj.integer_reader();

                System.out.println("The ROI per year will be");
                fd_roi=obj.float_reader();

                bank.openFD(fd_amount,fd_roi,fd_term);
            }

            else if(customer_task_choice == 4) {
                float loan_amount=0.0f;
                int loan_term=0,loan_type=0;

                System.out.println("Enter the type of Loan you want to take.\n 1.Home\n 2.Education\n 3.Personal\n 4.Car");
                loan_type=obj.integer_reader();

                System.out.println("Please Enter The Amount You Want to openLoan");
                loan_amount=obj.float_reader();

                System.out.println("Please Enter The Term You Want to openLoan");
                loan_term=obj.integer_reader();

                bank.applyLoan(loan_type,loan_amount,loan_term);
            }
            else if(customer_task_choice == 5) {
                bank.applyCreditCard(curr_money, obj.min_bal);
            }

            System.out.println("Do You want to Continue.\n 1.Press to Continue\n 2.Press to discontinue");
            int continue_choice= obj.integer_reader();

            if(continue_choice==2)
                break;
        }
    }
}