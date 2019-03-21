import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHelper extends HelperBase{

  public LoginHelper(WebDriver wd) {
    super(wd);
  }


  public void clickSignUpButtonLogin() {
   click(By.cssSelector("[class='Button Button--submit Button--main']"));
  }

  public void fillSignUpPopUpLogin(Login login) {
    typeEmailInSignUpPopUpLogin(By.xpath("//input[@placeholder='Your email']"), login.getEmail());
    typeNameInSignUpPopUpLogin(By.xpath("//input[@placeholder='Your name']"), login.getName());
    typePasswordInSignUpPopUpLogin(By.xpath("//input[@placeholder='Your password']"), login.getPassword());
  }

  public void typePasswordInSignUpPopUpLogin(By selector, String password) {
    type(selector, password);
  }

  public void typeNameInSignUpPopUpLogin(By selector, String name) {
    type(selector, name);
  }

  public void typeEmailInSignUpPopUpLogin(By selector, String email) {
    type(selector, email);
  }

  public void openLoginSignUpPopUp() {
    click(By.cssSelector("[class='login login__underline']"));
  }

  public void createUser(String email, String name, String password) {
    openLoginSignUpPopUp();
    fillSignUpPopUpLogin(new Login()
            .setEmail(email)
            .setName(name)
            .setPassword(password));
    clickSignUpButtonLogin();
  }
}
