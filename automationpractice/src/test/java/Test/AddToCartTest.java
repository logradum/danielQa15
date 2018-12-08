package Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends TestBase {

  @Test
  public void testAdditionToCard() throws InterruptedException {

    int cartIntBefore = getNumberProductInCart();


    chooseProductFromMainPage("(//ul[@id='homefeatured']//div[@class='product-image-container'])");

    clickContinueButtonFromAddingToCardForm(By.xpath("//span[@title='Continue shopping']//span"));

    int cartIntAfter = getNumberProductInCart();

    Assert.assertEquals(cartIntAfter, cartIntBefore + 1);
  }

  public int getNumberProductInCart() throws InterruptedException {
    int number = 0;
    goToShoppingCardFromMain();
    Thread.sleep(2000);
    try {
      WebElement productInCart = app.wd.findElement(By.xpath("//span[@id='summary_products_quantity']"));
      String cartString = productInCart.getText();
      System.out.println(productInCart.getText());
      number = Integer.parseInt(cartString.replaceAll("[\\D]", ""));
    } catch (Exception e) {
      System.out.println(e);
    }
    goToMainByLogo();
    return number;
  }

  public void goToMainByLogo() {
    app.getContactMessageHelper().click(By.xpath("//img[@class='logo img-responsive']"));
  }

  public void goToShoppingCardFromMain() {
    app.getContactMessageHelper().click(By.xpath("//a[@title='View my shopping cart']"));
  }

  public void clickContinueButtonFromAddingToCardForm(By locator) {
    app.getContactMessageHelper().click(locator);
  }


  public void chooseProductFromMainPage(String locator) {
    Integer i = getCountOfProduct(locator);
    Integer r = (getRandomNumber(i));

    Actions mouse = new Actions(app.wd);
    WebElement product = app.wd.findElement(By.xpath(getRandomProduct(locator, r)));
    WebElement addToCardButton = app.wd
            .findElement(By.xpath(getRandomAddToCardButton(r)));

    mouse.moveToElement(product).pause(500).moveToElement(addToCardButton).click().release().perform();
  }

  public String getRandomAddToCardButton(int r) {
    return "(//span[contains(text(),'Add to cart')])" + "[" + r + "]";
  }

  public int getCountOfProduct(String locator) {
    return app.wd.findElements(By.xpath(locator)).size();
  }

  public String getRandomProduct(String locator, int r) {
    return locator + "[" + r + "]";
  }

  public int getRandomNumber(int i) {
    return (int) (Math.random() * i - 1);
  }
}
