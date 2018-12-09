package Test;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends TestBase{


  @Test
  public void testAdditionToCard() throws InterruptedException {

    int cartIntBefore = app.getCartHelper().getNumberProductInCart();

    app.getCartHelper().chooseProductFromMainPage("(//ul[@id='homefeatured']//div[@class='product-image-container'])");

    app.getCartHelper().clickContinueButtonFromAddingToCardForm(By.xpath("//span[@title='Continue shopping']//span"));

    int cartIntAfter = app.getCartHelper().getNumberProductInCart();

    Assert.assertEquals(cartIntAfter, cartIntBefore + 1);
  }




}
