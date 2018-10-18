package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.time.Duration;

/**
 * Created by Mari on 10/11/18.
 */
public class CoreTestCase extends TestCase {
  private static final String
  PLATFORM_IOS ="ios",
  PLATFORM_ANDROID ="android";


  protected AppiumDriver driver;
  private static String AppiumURL = "http://127.0.0.1:4723/wd/hub";



  @Override
  protected void setUp() throws Exception {

    super.setUp();



    DesiredCapabilities capabilities = this.getCapabilitiesByPlatformEnv();

    driver = new AndroidDriver(new URL(AppiumURL), capabilities);


    this.rotateScreenPortrait();

  }

  @Override
  protected void tearDown() throws Exception {

    driver.quit();
    super.tearDown();

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

  private DesiredCapabilities getCapabilitiesByPlatformEnv() throws Exception
  {
    String platform = System.getenv("PLATFORM");

    DesiredCapabilities capabilities = new DesiredCapabilities();

    if (platform.equals(PLATFORM_ANDROID)) {
      capabilities.setCapability("platformName", "Android");
      capabilities.setCapability("deviceName", "AndroidTestDevice");
      capabilities.setCapability("platformVersion", "5.1");
      capabilities.setCapability("automationName", "Appium");
      capabilities.setCapability("appPackage", "org.wikipedia");
      capabilities.setCapability("appActivity", ".main.MainActivity");
      capabilities.setCapability("app", "/Users/Mari/Desktop/JavaAppiumAutomation1/apks/org.wikipedia.apk");
    } else if (platform.equals(PLATFORM_IOS)) {
      capabilities.setCapability("platformName", "iOS");
      capabilities.setCapability("deviceName", "iPhone SE");
      capabilities.setCapability("platformVersion", "11.1");
      capabilities.setCapability("app", "/Users/Mari/Desktop/JavaAppiumAutomation1/apks/Wikipedia.app");
    } else {
      throw new Exception("cannot get run platform from env variable.Platform value" + platform);
    }
    return capabilities;
  }

}



