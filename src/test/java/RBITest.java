import org.example.RBI_Test_methods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RBITest {

    RBI_Test_methods rbi;
    public RBITest(){
        rbi=new RBI_Test_methods();
    }

    @Test
    public void depositMoney(){
        Assertions.assertEquals(3000F, rbi.depositMoney(1000F,2000F));
        Assertions.assertEquals(8000F,rbi.depositMoney(3000F,5000F));
    }

    @Test
    public void withrawMoney(){
        Assertions.assertEquals(2000F,rbi.withdrawMoney(1000F,3000F,1,2,1000));
        Assertions.assertEquals(3970F,rbi.withdrawMoney(3000F,7000f,4,3,3000));
    }

    @Test
    public void openFD(){
        Assertions.assertEquals("Total maturity value is 1210.0",rbi.openFD(1000,2,0.1f));
        Assertions.assertEquals("Total maturity value is 2205.0",rbi.openFD(2000,2,0.05f));
    }

    @Test
    public void applyLoan(){
        Assertions.assertEquals("Total loan value is 1210.0",rbi.applyLoan(1000,2,0.1f));
        Assertions.assertEquals("Total loan value is 2205.0",rbi.applyLoan(2000,2,0.05f));
    }

    @Test
    public void applyCreditCard(){
        Assertions.assertEquals("You are eligible for credit card",rbi.applyCredit(2000,800));
        Assertions.assertEquals("You are not eligible for credit card",rbi.applyCredit(1500,1000));
    }
}
