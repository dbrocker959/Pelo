package com.interview.peloton;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

public class Login extends Base {

	public Login(){
		super();
	}
	
    //starts the browsers and goes to the website.
    public void loadPage(String s){
        driver.get(s);
    }

    //finds top hamburger icon and opens side navigation panel.
    public void openSideNav(){ driver.findElement(By.cssSelector("*[data-test-id=\"panelNavIcon\"]")).click(); }

    //clicks the sign in link with in the side nav menu.
    public void clickSignNav() {
        driver.findElement(By.cssSelector("*[data-test-id=\"navLogIn\"]")).click();
    }

    //Finds the username and password fields and passes in the credentials.
    public void loginWithCreds(String un,String pwd) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("*[data-test-id=\"username\"]")));
        WebElement tmp = driver.findElement(By.cssSelector("*[data-test-id=\"username\"]"));
        tmp.click();
        tmp.sendKeys(un);
        tmp = driver.findElement(By.cssSelector("*[data-test-id=\"password\"]"));
        tmp.click();
        tmp.sendKeys(pwd);
        tmp.sendKeys(Keys.ENTER);
    }

    //Once logged in, this validates the user has successfully logged in if their username is present.
    public boolean validateLogin(){
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("*[data-test-id=\"userInfo\"]")));
        WebElement user = driver.findElement(By.cssSelector("*[data-test-id=\"userInfo\"]"));
        AssertJUnit.assertEquals(user.getText(),"qachallenge");
        if (user.getText().equals("qachallenge")) return true;
        else return false;
    }

    //This validates that the generic error message appears on login attempts.
    public boolean validateLoginErr() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("*[data-test-id=\"loginFormGenericError\"]")));
        return driver.findElement(By.cssSelector("[data-test-id=\"loginFormGenericError\"]")).isEnabled();
    }

    //This logs out a signed in user.
    public void logOut(){
        driver.findElement(By.cssSelector("*[data-test-id=\"moreNavLink\"]")).click();
        driver.findElement(By.cssSelector("*[data-test-id=\"logoutButton\"]")).click();
    }
}
