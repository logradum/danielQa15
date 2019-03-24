package com.routePerfect.tests;
import com.routePerfect.model.Login;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends TestBase {
  @Test
  public void loginTest() throws InterruptedException {
    fillLoginForm(new Login().setEmail("test+1@test.test").setPassword("test"));
    Assert.assertTrue(fw.getLoginHelper().isElementPresent(By.xpath("//span[@class='site-menu__user__menu__name'][contains(.,'Hi test')]")));
    //fw.getLoginHelper().waitUntilPresent(By.cssSelector("#startIn"));
    //Thread.sleep(2000);
  }


//should extract creation of new instance from method which in helper
  public void fillLoginForm(Login Login) {
    fw.getLoginHelper().loginFromHomePage(Login.getEmail(), Login.getPassword());
  }
}
