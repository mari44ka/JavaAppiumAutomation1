package lib.ui;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Mari on 10/12/18.
 */
public class ArticlePageObject extends MainPageObject {

  private static final String
          TITLE = "org.wikipedia:id/view_page_title_text",
          FOOTER_ELEMENT = "//*[@text ='View page in browser']";

  public ArticlePageObject(AppiumDriver driver) {
    super(driver);
  }

  public WebElement waitForTitleElement() {
    return this.WaitforElementPresent(By.id(TITLE), "cannot find article title on page", 15);
  }
   public String getArticleTitle(){
    WebElement title_element = waitForTitleElement();
    return title_element.getAttribute("text");
   }

   public void swipeToFooter(){
     this.swipeUpToFindElement(By.xpath(FOOTER_ELEMENT),"cannot find the end of article",20);
   }
}
