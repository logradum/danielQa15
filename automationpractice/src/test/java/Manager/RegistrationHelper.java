package Manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationHelper extends HelperBase {

  public RegistrationHelper(WebDriver wd) {
    this.wd = wd;
  }

  public void clickLogInButton() {
    click(By.xpath("//a[@title='Log in to your customer account']"));
  }
  public void typeLoginMail() {
    type(By.xpath("//input[@id='email_create']"), "daniel.osypenko.il@gmail.com");
  }
  public void clickLoginSubmit() {
    click(By.xpath("//button[@id='SubmitCreate']"));
  }

}
