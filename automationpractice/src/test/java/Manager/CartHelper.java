package Manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CartHelper extends HelperBase{


  public CartHelper(WebDriver wd) {
    this.wd = wd;
  }

  public int getNumberProductInCart() throws InterruptedException {
    int number = 0;
    goToShoppingCardFromMain();
    Thread.sleep(2000);
    try {
      WebElement productInCart = wd.findElement(By.xpath("//span[@id='summary_products_quantity']"));
      String cartString = productInCart.getText();
      System.out.println(productInCart.getText());
      number = Integer.parseInt(cartString.replaceAll("[\\D]", ""));
    } catch (Exception e) {
      System.out.println(e);
    }
    goToMainByLogo();
    return number;
  }

  public void clickContinueButtonFromAddingToCardForm(By locator) {
    click(locator);
  }


  public void chooseProductFromMainPage(String locator) {
    Integer i = getCountOfProduct(locator);
    Integer r = (getRandomNumber(i));

    Actions mouse = new Actions(wd);
    WebElement product = wd.findElement(By.xpath(getRandomProduct(locator, r)));
    WebElement addToCardButton = wd
            .findElement(By.xpath(getRandomAddToCardButton(r)));

    mouse.moveToElement(product).pause(500).moveToElement(addToCardButton).click().release().perform();
  }

  public String getRandomAddToCardButton(int r) {
    return "(//span[contains(text(),'Add to cart')])" + "[" + r + "]";
  }

  public int getCountOfProduct(String locator) {
    return wd.findElements(By.xpath(locator)).size();
  }

  public String getRandomProduct(String locator, int r) {
    return locator + "[" + r + "]";
  }

}
