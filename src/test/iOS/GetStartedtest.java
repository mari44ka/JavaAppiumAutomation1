package test.iOS;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.WelcomePageObject;

/**
 * Created by Mari on 10/17/18.
 */
public class GetStartedtest extends CoreTestCase {

  public void testPassThroughWelcome(){
    if ((Platform.getInstance().isAndroid()) || (Platform.getInstance().isMW())) {
      return;
    }
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
