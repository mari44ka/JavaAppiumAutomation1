package testmy;

import lib.CoreTestCase;
import lib.ui.*;
import org.junit.Test;

/**
 * Created by Mari on 10/18/18.
 */
public class MyListsTestIOS extends CoreTestCase {

  @Test
  public void testSaveTwoArticlesIOS(){
    WelcomePageObject Welcomepage = new WelcomePageObject(driver);
    Welcomepage.waitForLearnMoreLink();
    Welcomepage.clickSkipButton();



  }
}
