package homework2;

import org.testng.Assert;
import org.testng.annotations.Test;


public class FindJavaWikiChrome extends TestBase{

  @Test
  public void testFindJavaWordWiki(){
    findJavaWiki();
    String currentUrl=wd.getCurrentUrl();
    Assert.assertEquals(currentUrl,"https://en.wikipedia.org/wiki/Java");
  }

}
