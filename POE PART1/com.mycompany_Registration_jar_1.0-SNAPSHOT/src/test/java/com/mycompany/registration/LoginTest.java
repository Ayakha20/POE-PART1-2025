package com.mycompany.registration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

@Test
    public void testCheckUserName_Success() {
        Login login = new Login("Ava", "Moyo", "ky1_1","Ch&&sec@ke99","+27838968976");
        assertTrue(login.checkUserName());    
    }
    @Test
    public void testCheckUserName_Failure() {
        Login login = new Login("Ava", "Moyo", "kyle!!!!!!!","Ch&&sec@ke99","+27838968976");
        assertFalse(login.checkUserName());
    }
    @Test
    public void testCheckPasswordComplexity_Success() {
        Login login = new Login("Ava", "Moyo", "ky1_1","Ch&&sec@ke99","+27838968976");
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99"));
    }
    @Test
    public void testCheckPasswordComplexity_Failure() {
        Login login = new Login("Ava", "Moyo", "ky1_1","password","+27838968976");
        assertFalse(login.checkPasswordComplexity("Ch&&sec@ke99!"));   
    }
    @Test
    public void testCheckPhoneNumber_Success() {
        Login login = new Login("Ava", "Moyo", "ky1_1","Ch&&sec@ke99!","+27838968976");
        assertTrue(login.checkPhoneNumber());
    }
    @Test
    public void testCheckPhoneNumber_Failure() {
        Login login = new Login("Ava", "Moyo", "ky1_1","Ch&&sec@ke99!","08966553");
        assertFalse(login.checkPhoneNumber());
    }
    @Test
    public void testCheckRegisterUser_Success() {
        Login login = new Login("Ava", "Moyo", "ky1_1","Ch&&sec@ke99!","+278389688976");
        assertEquals("User registered successfully!", login.registerUser());   
    }
    @Test
    public void testCheckRegisterUser_Failure() {
        Login login = new Login("Ava", "ky1_1", "A20","weakpass","123");
        assertEquals("Registeration failed. Please check inputs", login.registerUser());  
    }
    @Test
    public void testCheckLoginUser_Success() {
        Login login = new Login("Ava", "Moyo", "ky1_1","Ch&&sec@ke99!","+278389688976");
        login.registerUser();
        assertTrue( login.loginUser("ky1_1","Ch&&sec@ke99!"));   
    }
    @Test
    public void testCheckLoginUser_Failure() {
        Login login = new Login("Ava", "Moyo", "ky1_1","Ch&&sec@ke99!","+278389688976");
        login.registerUser();
        assertFalse( login.loginUser("ky1_1","wrongPass")); 
    }
    @Test
    public void testCheckReturnLoginStatus_Success() {
        Login login = new Login("Ava", "Moyo", "ky1_1","Ch&&sec@ke99","0848786218");
        login.registerUser();
        login.loginUser("ky1_1", "Ch&&sec@ke99!");
        assertEquals("Welcome Ava Moyo it is great to see you again.",login.returnLoginStatus("ky1_1","Ch&&sec@ke99"));
    }
     @Test
    public void testCheckReturnLoginStatus_Failure() {
        Login login = new Login("Ava", "Moyo", "ky1_1","Ch&&sec@ke99!","+27838968976");
        login.registerUser();
        login.loginUser("ky1_1", "wrongPass");
        assertEquals("Username or password incorrect, please try again", login.returnLoginStatus("ky1_1","Ch&&sec@ke99"));
    } 
}