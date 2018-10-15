package testmy;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;

/**
 * Created by Mari on 10/14/18.
 */
public class ArticleTests1 extends CoreTestCase {
  @Test
  public void testCheckTitlePresent()
  {
    SearchPageObject SearchPageObject = new SearchPageObject(driver);
    SearchPageObject.initSearchInput();
    SearchPageObject.typeSearchLine("Appium");
    SearchPageObject.clickByArticleWithSubstring("Appium");
    ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
    ArticlePageObject.assertThereIsResultOfSearch();

  }
}
