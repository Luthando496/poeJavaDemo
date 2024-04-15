import org.testng.annotations.Test;

import static org.junit.Assert.*;

public class LoginTest {

    @Test
    @org.junit.Test
    public void checkUserName() throws Exception {
        Register user = new Register();
        boolean checkUser = user.checkUserName("Didi_");
        assertTrue(checkUser);
    }

    @org.junit.Test
    public void checkPassword() throws Exception {
        Register userPassword = new Register();
        boolean checkPass = userPassword.checkPasswordComplexity("Luthando@1");
        assertTrue(checkPass);
    }

    @org.junit.Test
    public void registerUser() {
    }

    @org.junit.Test
    public void loginUser() {
    }

    @org.junit.Test
    public void returnLoginStatus() {
    }

    @org.junit.Test
    public void checkSumAdd(){
        Register sum = new Register();
        assertEquals(8,sum.addSum(2,2));
    }

}