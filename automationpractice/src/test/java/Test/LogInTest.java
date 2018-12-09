package Test;

import org.testng.annotations.Test;

public class LogInTest extends TestBase {

  @Test
  public void testRegisterUser(){

    app.getRegistrationHelper().clickLogInButton();

    app.getRegistrationHelper().typeLoginMail();

    app.getRegistrationHelper().clickLoginSubmit();

  }



}
