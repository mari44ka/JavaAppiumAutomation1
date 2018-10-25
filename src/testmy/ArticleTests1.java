package testmy;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

/**
 * Created by Mari on 10/14/18.
 */
public class ArticleTests1 extends CoreTestCase {
  @Test
  public void testCheckTitlePresent()
  {
    SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
    SearchPageObject.initSearchInput();
    SearchPageObject.typeSearchLine("Appium");
    SearchPageObject.clickByArticleWithSubstring("Appium");
    ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
    ArticlePageObject.assertThereIsResultOfSearch();

  }
}
