package com.interview.peloton;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*The base class contrains the driver and loads the site.
 * */
public abstract class Base {
	WebDriver driver = new FirefoxDriver();

    public Base(){
        driver.get("http://www.pelotoncycle.com/");
    }


}
