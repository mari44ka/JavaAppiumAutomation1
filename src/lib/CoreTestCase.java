package lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import lib.ui.WelcomePageObject;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

/**
 * Created by Mari on 10/11/18.
 */
public class CoreTestCase extends TestCase {

  protected RemoteWebDriver driver;


  @Override
  protected void setUp() throws Exception {

    super.setUp();

    driver = Platform.getInstance().getDriver();

    this.rotateScreenPortrait();
    this.skipWelcomePageIOS();
    this.openWikiWebPageForMobileWeb();

  }

  @Override
  protected void tearDown() throws Exception {

    driver.quit();
    super.tearDown();

  }
  private void skipWelcomePageIOS(){
    if(driver instanceof AppiumDriver){
    if(Platform.getInstance().isIOS()){
      WelcomePageObject WelcomePage = new WelcomePageObject((AppiumDriver)driver);
      WelcomePage.clickSkipButton();
    }
    else { System.out.println("Method rotateScreenPortrait does nothing for platform" + Platform.getInstance().getPlatformVar());}
    }
  }
  private void openWikiWebPageForMobileWeb() {
    if (Platform.getInstance().isMW()) {
      driver.get("https://en.m.wikipedia.org");
    } else {
      {
        System.out.println("Method rotateScreenPortrait does nothing for platform" + Platform.getInstance().getPlatformVar());
      }
    }
  }

  protected void rotateScreenPortrait() {

    if (driver instanceof AppiumDriver) {
      AppiumDriver driver = (AppiumDriver) this.driver;
      driver.rotate(ScreenOrientation.PORTRAIT);
    }
    else { System.out.println("Method rotateScreenPortrait does nothing for platform" + Platform.getInstance().getPlatformVar());}
  }

  protected void rotateScreenlandscape() {
    if (driver instanceof AppiumDriver){
      AppiumDriver driver = (AppiumDriver) this.driver;
      driver.rotate(ScreenOrientation.LANDSCAPE);}
    else { System.out.println("Method rotateScreenPortrait does nothing for platform" + Platform.getInstance().getPlatformVar());}
  }


  protected void backgroundApp(int seconds) {
    if (driver instanceof AppiumDriver){
      AppiumDriver driver = (AppiumDriver) this.driver;
      driver.runAppInBackground(Duration.ofMillis(seconds));
    }
    else { System.out.println("Method rotateScreenPortrait does nothing for platform" + Platform.getInstance().getPlatformVar());}
  }
  }





