package com.routePerfect.tests;
import org.testng.annotations.Test;


public class LoginTest extends TestBase {
  @Test
  public void loginTest() {
    fw.getLoginHelper().loginFromHomePage("logradum+1@gmail.com", "qwerty");
  }


}
