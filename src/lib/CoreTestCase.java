package lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import lib.ui.WelcomePageObject;
import org.openqa.selenium.ScreenOrientation;
import java.time.Duration;

/**
 * Created by Mari on 10/11/18.
 */
public class CoreTestCase extends TestCase {

  protected AppiumDriver driver;


  @Override
  protected void setUp() throws Exception {

    super.setUp();

    driver = Platform.getInstance().getDriver();

    this.rotateScreenPortrait();
    this.skipWelcomePageIOS();

  }

  @Override
  protected void tearDown() throws Exception {

    driver.quit();
    super.tearDown();

  }
  private void skipWelcomePageIOS(){
    if(Platform.getInstance().isIOS()){
      WelcomePageObject WelcomePage = new WelcomePageObject(driver);
      WelcomePage.clickSkipButton();
    }
  }

  protected void rotateScreenPortrait() {
    driver.rotate(ScreenOrientation.PORTRAIT);
  }

  protected void rotateScreenlandscape() {
    driver.rotate(ScreenOrientation.LANDSCAPE);
  }

  protected void backgroundApp(int seconds) {
    driver.runAppInBackground(Duration.ofMillis(seconds));
  }



}



