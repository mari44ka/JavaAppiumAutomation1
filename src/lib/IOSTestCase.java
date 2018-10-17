package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

/**
 * Created by Mari on 10/16/18.
 */
public class IOSTestCase extends TestCase{
  protected AppiumDriver driver;
  private static String AppiumURL = "http://127.0.0.1:4723/wd/hub";


  @Override
  protected void setUp() throws Exception {

    super.setUp();

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("platformName", "iOS");
    capabilities.setCapability("deviceName", "iPhone SE");
    capabilities.setCapability("platformVersion", "11.1");
    capabilities.setCapability("app", "/Users/Mari/Desktop/JavaAppiumAutomation1/apks/Wikipedia.app");
    driver = new IOSDriver(new URL(AppiumURL), capabilities);
    this.rotateScreenPortrait();
  }

  @Override
  protected void tearDown() throws Exception {

    driver.quit();
    super.tearDown();

  }
  protected void rotateScreenPortrait(){
    driver.rotate(ScreenOrientation.PORTRAIT);
  }
  protected void rotateScreenlandscape(){
    driver.rotate(ScreenOrientation.LANDSCAPE);
  }
  protected void backgroundApp(int sec){
    driver.runAppInBackground(sec);
  }

}


