package test;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

/**
 * Created by Mari on 10/12/18.
 */
public class ChangeAppConditionTests extends CoreTestCase {
  @Test

  public void testChangeScreenOrientationOnSearchResult()
  {
    if(Platform.getInstance().isMW()){
      return;
    }
    SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

    SearchPageObject.initSearchInput();
    SearchPageObject.typeSearchLine("Java");
    SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

    ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
    String title_before_rotation = ArticlePageObject.getArticleTitle();

    this.rotateScreenlandscape();

    String title_after_rotation = ArticlePageObject.getArticleTitle();

    this.rotateScreenPortrait();
    String title_after_second_rotation =ArticlePageObject.getArticleTitle();


    assertEquals("Article title have benn changed after screen rotation",
            title_before_rotation,
            title_after_second_rotation);


  }

  @Test
  public void testCheckSearchArticleInBackground()
  {
    if(Platform.getInstance().isMW()){
      return;
    }
    SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

    SearchPageObject.initSearchInput();
    String search_line = "Java";
    SearchPageObject.typeSearchLine(search_line);
    SearchPageObject.waitForSearchResult("Object-oriented programming language");
    this.backgroundApp(8);
    SearchPageObject.waitForSearchResult("Object-oriented programming language");

  }


}
