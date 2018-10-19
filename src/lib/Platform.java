package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

/**
 * Created by Mari on 10/19/18.
 */
public class Platform {
  private static final String PLATFORM_IOS ="ios";
  private static final String PLATFORM_ANDROID ="android";
  private static String AppiumURL = "http://127.0.0.1:4723/wd/hub";

  public AppiumDriver getDriver() throws Exception{
    URL URL = new URL(AppiumURL);
    if (this.isAndroid()){
      return new AndroidDriver(URL,getAndroidDesiredCapabilities());
    }
    else if (this.isIOS()){
      return new IOSDriver(URL,getIOSDesiredCapabilities());
    }
    else {
      throw new Exception("cannot detect of the driver platform value");
    }
  }

  public boolean isAndroid(){
    return isPlatform(PLATFORM_ANDROID);

  }
  public boolean isIOS(){
    return isPlatform(PLATFORM_IOS);
  }


  private DesiredCapabilities getAndroidDesiredCapabilities(){
  DesiredCapabilities capabilities = new DesiredCapabilities();
  capabilities.setCapability("platformName", "Android");
  capabilities.setCapability("deviceName", "AndroidTestDevice");
  capabilities.setCapability("platformVersion", "5.1");
  capabilities.setCapability("automationName", "Appium");
  capabilities.setCapability("appPackage", "org.wikipedia");
  capabilities.setCapability("appActivity", ".main.MainActivity");
  capabilities.setCapability("app", "/Users/Mari/Desktop/JavaAppiumAutomation1/apks/org.wikipedia.apk");
  return capabilities;
}
  private DesiredCapabilities getIOSDesiredCapabilities(){
  DesiredCapabilities capabilities = new DesiredCapabilities();
  capabilities.setCapability("platformName", "iOS");
  capabilities.setCapability("deviceName", "iPhone SE");
  capabilities.setCapability("platformVersion", "11.1");
  capabilities.setCapability("app", "/Users/Mari/Desktop/JavaAppiumAutomation1/apks/Wikipedia.app");
  return capabilities;

}
  private boolean isPlatform(String my_platform){
  String platform =this.getPlatformVar();
  return my_platform.equals(platform);
}

  private String getPlatformVar(){
  return System.getenv("PLATFORM");
}



}