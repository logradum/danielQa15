package Manager;

import Model.ContactMessage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactMessageHelper extends HelperBase{

  public ContactMessageHelper(WebDriver wd) {
    this.wd = wd;
  }


  public void fillAddressForm(ContactMessage message) throws InterruptedException {

    type(By.xpath("//input[@id='email']"), message.getEmail());
    Thread.sleep(500);
    type(By.xpath("//input[@id='id_order']"), message.getOrderReferance());
    Thread.sleep(500);
    type(By.xpath("//textarea[@id='message']"), message.getMessage());

  }

  public void fillContactMessageForm() throws InterruptedException {
    click(By.xpath("//a[@title='Contact Us']"));

    select(By.xpath("//select[@id='id_contact']"), "Webmaster");

    fillAddressForm(new ContactMessage()
            .setEmail("testMail@mail.ua")
            .setOrderReferance(String.valueOf(211546))
            .setMessage("Help me please with my order, they sent me wrong jeans"));

    attachContactMessageFile();

    click(By.xpath("//button[@id='submitMessage']"));
  }

  public void attachContactMessageFile() {
    attachFile(By.xpath("//input[@id='fileUpload']"), "/Users/logradum/Desktop/cat.png");
  }


}
