package com.routePerfect.tests;
import com.routePerfect.model.Login;
import org.testng.annotations.Test;


public class LoginTest extends TestBase {
  @Test
  public void loginTest() {
    fillLoginForm(new Login().setEmail("logradum+1@gmail.com").setPassword("qwerty"));}

//should extract creation of new instance from method which in helper
  public void fillLoginForm(Login Login) {
    fw.getLoginHelper().loginFromHomePage(Login.getEmail(), Login.getPassword());
  }


}
