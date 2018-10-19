package lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import java.time.Duration;

/**
 * Created by Mari on 10/11/18.
 */
public class CoreTestCase extends TestCase {

  protected AppiumDriver driver;
  protected Platform Platform;

  @Override
  protected void setUp() throws Exception {

    super.setUp();
    this.Platform = new Platform();
    driver = this.Platform.getDriver();

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



}



