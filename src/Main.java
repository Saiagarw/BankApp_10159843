import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    BufferedReader buff;
    InputStreamReader isr;
    public Main() {
        if(isr == null)
            isr = new InputStreamReader(System.in);
        if(buff == null)
            buff = new BufferedReader(isr);
    }

    int selectedBank, selectedOperation;
//    static int counter = 3;
    public static void main(String[] args) {
        Main obj = new Main();
        Customer cust = new Customer();
        System.out.println("Welcome to IBS\nPlease select your bank\n1. ICICI\n2. HDFC\n3. SBI\n4. AXIS\n5. IDFC");

        try {
            obj.selectedBank = Integer.parseInt(obj.buff.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Customer Selected " + obj.selectedBank);

        System.out.println("Please Enter Your Name");
        try {
           cust.setCustomerName(obj.buff.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Please Enter Your Email");
        try {
            cust.setCustomerEmail(obj.buff.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Please Enter Your Address");
        try {
            cust.setCustomerAddress(obj.buff.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Please Enter Your Gender");
        try {
            cust.setCustomerGender(obj.buff.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Please Enter Your Aadhar");
        try {
            cust.setCustomerAadhar(obj.buff.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Please Enter Your Phone");
        try {
            cust.setCustomerPhone(obj.buff.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Please Enter Opening Balance");
        try {
            cust.balance=(Float.parseFloat(obj.buff.readLine()));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        float opening_bal=cust.getBalance();
        RBI task = new RBI(opening_bal);

        System.out.println("Select your choice\n1. Deposit\n2. Withdrawl\n3. OpenFD\n4. Apply Loan\n5. Apply CC");

        try {
            obj.selectedOperation = Integer.parseInt(obj.buff.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Customer Selected " + obj.selectedOperation);

        int customer_task_choice=obj.selectedOperation;

        if(customer_task_choice == 1)
        {
            System.out.println("Please Enter The Amount You Want to Deposit");
            try {
                task.depositMoney(Float.parseFloat(obj.buff.readLine()));
                System.out.println("Your current updated balance "+ task.getBalance());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(customer_task_choice == 2)
        {
            System.out.println("Please Enter the Amount to Withdraw");
            try {
                task.withdrawMoney(Float.parseFloat(obj.buff.readLine()));
                System.out.println("Your current updated balance "+ task.getBalance());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(customer_task_choice == 3) {
            float fd_amount=0.0f,fd_roi=0.0f;
            int fd_term=0;

            System.out.println("Please Enter The Amount You Want to openFD");
            try {
                fd_amount=Float.parseFloat(obj.buff.readLine());
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Please Enter The Term You Want to openFD");
            try {
                fd_term=Integer.parseInt(obj.buff.readLine());
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("The ROI per year will be");
            try {
                fd_roi=Float.parseFloat(obj.buff.readLine());
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            task.openFD(fd_amount,fd_roi,fd_term);
        }

        else if(customer_task_choice == 4) {
            float loan_amount=0.0f,loan_roi=0.0f;
            int loan_term=0;

            System.out.println("Please Enter The Amount You Want to openFD");
            try {
                loan_amount=Float.parseFloat(obj.buff.readLine());
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Please Enter The Term You Want to openFD");
            try {
                loan_term=Integer.parseInt(obj.buff.readLine());
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("The ROI per year will be");
            try {
                loan_roi=Float.parseFloat(obj.buff.readLine());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            String loan_type="";
            task.applyLoan(loan_type,loan_amount,loan_roi,loan_term);
        }
    }
}