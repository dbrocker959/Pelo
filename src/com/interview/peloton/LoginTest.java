package com.interview.peloton;

import org.testng.AssertJUnit.*;
import org.testng.annotations.Test;

public class LoginTest{

	  Login test = new Login();
	 /*
	    * This test that a user can succesfully login with valid credentials.
	    * 1. Loads the website
	    * 2. Opens the side nav
	    * 3. Click on Sign in
	    * 4. Pass in login credentials
	    * 5. validate that the login attempt was successful.
	    *
	    * */
	    @Test
	    public void loginSuccessfulTest(){
	        test.openSideNav();
	        test.clickSignNav();
	        test.loginWithCreds("pelotonqa@gmail.com","ILoveToRide");
	        if (test.validateLogin())
	             System.out.println("Login was Successful");
	        else System.out.println("Login Failed");
	        test.logOut();
	    }
	     /*
	     * This test that a user can succesfully login with valid credentials.
	     * 1. Loads the website
	     * 2. Opens the side nav
	     * 3. Click on Sign in
	     * 4. Pass in invalid login credentials
	     * 5. validate that the login attempt gets a warning message.
	     */
	    
	    @Test
	    public void unSuccessful() {
	        test.openSideNav();
	        test.clickSignNav();
	        test.loginWithCreds("someTest@gmail.com","tst4321");
	        if (test.validateLoginErr()){
	            System.out.println("Login with invalid credentials resulted in generic message");
	        }else System.out.println("Something went wrong. No error message was found");
	    }
}
