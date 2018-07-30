package com.interview.peloton;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Peloton extends Base{

    public Peloton(){
        super();
    }

    //This finds the bike tab and goes to the bike profile age from the home page.
    public void navigateToBike(){
        driver.findElement(By.cssSelector("*[data-test-id='bike']")).click();
    }
    
    //Navigates thru all the informational pages and getos the right package to add
    public void clickBuyBike() {
        driver.findElement(By.cssSelector("*[href=\"/shop/bike\"")).click();
        driver.findElement(By.cssSelector("*[data-test-id=\"selectPackage\"]")).click();
    }

    //This adds the bike to the shopping cart
    public void clickAddToCart(){
        driver.findElement(By.cssSelector("*[data-test-id=\"addToCart\"]")).click();
    }

    //This closes the the shopping cart fly out after it opens.
    public void closeFlyOut(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("*[data-test-id=\"flyoutCloseIcon\"]")));
        driver.findElement(By.cssSelector("*[data-test-id=\"flyoutCloseIcon\"]")).click();
    }

    //This validates the cart count has something in it and it isn't null.
    public WebElement getCartWebElement(){
    	WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sc-eNNmBn")));
    	WebElement cartDiv = driver.findElement(By.className("sc-eNNmBn"));
        return cartDiv;
    }
    
    //This finds and clicks the pay button
    public void clickPayNow(){
        driver.findElement(By.cssSelector("*[data-test-id=\"creditButton\"]")).click();
    }

    //This handles the sign in on the checkout page
    public void signInOnPay(String un,String pwd){
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("*[data-test-id=\"checkoutEmail\"]")));
        WebElement tmp = driver.findElement(By.cssSelector("*[data-test-id=\"checkoutEmail\"]"));
        tmp.click();
        tmp.sendKeys(un);
        tmp.sendKeys(Keys.TAB);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("*[data-test-id=\"loginModalPassword\"]")));
        tmp = driver.findElement(By.cssSelector("*[data-test-id=\"loginModalPassword\"]"));
        tmp.sendKeys(pwd);
        tmp.sendKeys(Keys.ENTER);

    }

    //This clicks the final checkout button before signing in and providing user details.
    public void clickCheckOut()  {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("*[data-test-id=\"checkoutLink\"]")));
        driver.findElement(By.cssSelector("*[data-test-id=\"checkoutLink\"]")).click();
    }

    //This complete the checkout process. Its never called at the moment.
    public void completeCheckoutExistingUser(String un,String pw) {
        clickCheckOut();
        clickPayNow();
        signInOnPay(un,pw);
    }
    
    //Returns the element that has the quaity value of the bike entry
    public WebElement getQtyInFlyOut() {
    	  WebDriverWait wait = new WebDriverWait(driver,10);
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("*[data-test-id=\"orderItemQty\"]")));
        WebElement flyOutDiv = driver.findElement(By.cssSelector("*[data-test-id=\"orderItemQty\"]"));
        return flyOutDiv;
    }
    
    //Closes that schedule a ride lightbox that appears. 
    public void closeScheduleRideDialog() {
    	WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#bx-close-inside-799458")));
    	driver.findElement(By.cssSelector("#bx-close-inside-799458")).click();
    }
}
