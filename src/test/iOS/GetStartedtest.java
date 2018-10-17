package test.iOS;

import lib.IOSTestCase;
import lib.ui.WelcomePageObject;

/**
 * Created by Mari on 10/17/18.
 */
public class GetStartedtest extends IOSTestCase {

  public void testPassThroughWelcome(){
    WelcomePageObject Welcomepage = new WelcomePageObject(driver);

    Welcomepage.waitForLearnMoreLink();
    Welcomepage.clickNextButton();

    Welcomepage.waitForNewWayToExploreText();
    Welcomepage.clickNextButton();

    Welcomepage.waitForAddOrEditPrefirredLangText();
    Welcomepage.clickNextButton();

    Welcomepage.waitForLearnMoreAboutDataCollectedText();
    Welcomepage.clickgetStartedButton();



  }
}
