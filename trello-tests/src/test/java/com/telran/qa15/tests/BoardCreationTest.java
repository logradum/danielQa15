package com.telran.qa15.tests;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BoardCreationTest extends TestBase{


  @BeforeTest
  public void preconditions() throws InterruptedException {
    if(!app.getBoardHelper()
            .isElementPresent(By
                    .xpath("(//*[@class='icon-organization icon-sm tab__tabIconSpan__jlnEo'])[1]"))){
      app.getTeamHelper().createTeam();
    }
  }

  @Test
  public void testBoardCreation() throws InterruptedException {
    Thread.sleep(3000);
    int beforeBoardCreationCount = app.getBoardHelper().getBoardCount();
    app.getTeamHelper().openTeam();
    app.getBoardHelper().waitElementUntilPresent(By.xpath("//span[contains(text(),'Create new board…')]"));

    //create new board click
    Thread.sleep(2000);

    try {
      app.getBoardHelper().clickPresentElement(By.xpath("//a[@class='board-tile mod-add']"));
    } catch (Exception e) {
      app.getBoardHelper().clickPresentElement(By.xpath("//a[@class='board-tile mod-add']"));
    }

    //type board name
    Thread.sleep(2000);

    app.getBoardHelper().type(By.xpath("//input[@placeholder='Add board title']"), "TestBoard");

    //click submit button
    Thread.sleep(2000);

    app.getBoardHelper().clickPresentElement(By.xpath("//span[contains(text(),'Create Board')]"));


    Thread.sleep(2000);

    app.getTeamHelper().openTeam();
    int afterBoardCreationCount = app.getBoardHelper().getBoardCount();
    Assert.assertEquals(beforeBoardCreationCount, afterBoardCreationCount-1);
  }


}
