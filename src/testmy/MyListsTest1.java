package testmy;

import lib.CoreTestCase;
import lib.ui.*;
import org.junit.Test;


/**
 * Created by Mari on 10/13/18.
 */
public class MyListsTest1 extends CoreTestCase {

  @Test
  public void testSaveTwoArticles()
  {
    SearchPageObject SearchPageObject = new SearchPageObject(driver);
    SearchPageObject.initSearchInput();
    SearchPageObject.typeSearchLine("Java");
    SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

    ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
    String article_title = ArticlePageObject.getArticleTitle();
    String name_of_folder = "Learning programming";
    ArticlePageObject.waitForTitleElement();
    ArticlePageObject.addArticleToMyList(name_of_folder);
    ArticlePageObject.closeArticle();

    SearchPageObject.initSearchInput();
    SearchPageObject.typeSearchLine("Java");
    SearchPageObject.clickByArticleWithSubstring("Java version history");

    ArticlePageObject.waitForTitleElement();
    ArticlePageObject.addanotherArticleToMyList(name_of_folder);
    ArticlePageObject.closeArticle();
    NavigationUI NavigationUI = new NavigationUI(driver);
    NavigationUI.clickMyLists();

    MyLIstPageObject MyLIstPageObject = new MyLIstPageObject(driver);
    MyLIstPageObject.openFolderByName(name_of_folder);
    MyLIstPageObject.swipeArticleToDelete(article_title);
    ArticlePageObject.openArticle("Java version history");

    String article_title1 = ArticlePageObject.getArticleTitle();
    String title ="Java version history";
    assertEquals(
            "we cannot see expected title"+ title,
            title,
            article_title1);

  }
}
