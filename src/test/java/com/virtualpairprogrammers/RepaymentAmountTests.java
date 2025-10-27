package com.virtualpairprogrammers;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.*;
import org.mockito.Spy;
import java.math.BigDecimal;


public class RepaymentAmountTests {
    @Spy
    LoanApplication loanApplication;

    @Test
    public void test1YearLoanWholePounds() {
        loanApplication = spy (new LoanApplication());
        loanApplication.setPrincipal(1200);
        loanApplication.setTermInMonths(12);

        //set the interest rate to 10%
        doReturn(new BigDecimal(10)).when(loanApplication).getInterestRate();

        LoanCalculatorController controller = new LoanCalculatorController();
        controller.processNewLoanApplication(loanApplication);

        assertEquals(new BigDecimal(110), loanApplication.getRepayment());
    }
}
