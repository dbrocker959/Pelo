package com.interview.peloton;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;

public class AddBikeToCartTest {
  
  @Test
  public void addToCart() {
	  Peloton test = new Peloton();

	  System.out.println("Running add to cart test");

	  //Goes to the bike tab
	  test.navigateToBike();
	  //Goes to the buy section of the bike
	  test.clickBuyBike();
	  //Adds the bike to the cart
	  test.clickAddToCart();
	  //close schedule test ride sign up
	  test.closeScheduleRideDialog();
	  //verify quality in fly out
	  AssertJUnit.assertEquals( test.getQtyInFlyOut().getText().split(" ")[1],"1");
	  //closes the fly out that appears when an item is added.
	  test.closeFlyOut();

	  //validated that cart icon has 1 item.
	  AssertJUnit.assertEquals(test.getCartWebElement().getText(), "2");
  }
}
