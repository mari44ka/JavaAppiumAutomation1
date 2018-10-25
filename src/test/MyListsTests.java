package test;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.MyLIstPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListPageObjectFactory;
import lib.ui.factories.NavigatioUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

/**
 * Created by Mari on 10/12/18.
 */
public class MyListsTests extends CoreTestCase {

  private static final String name_of_folder = "Learning programming";

  @Test
  public void testsaveFirstArticleToMyList() {

    SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
    SearchPageObject.initSearchInput();
    SearchPageObject.typeSearchLine("Java");
    SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

    ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);

    String article_title = ArticlePageObject.getArticleTitle();
    if(Platform.getInstance().isAndroid()){
    ArticlePageObject.waitForTitleElement();
    ArticlePageObject.addArticleToMyList(name_of_folder);}
    else{
      ArticlePageObject.addArticleToMySaved();
      ArticlePageObject.closeSyncSavedArticle();}

    ArticlePageObject.closeArticle();

    NavigationUI NavigationUI = NavigatioUIFactory.get(driver);
    NavigationUI.clickMyLists();

    MyLIstPageObject MyLIstPageObject = MyListPageObjectFactory.get(driver);
    if(Platform.getInstance().isAndroid()) {
      MyLIstPageObject.openFolderByName(name_of_folder);
    }
    MyLIstPageObject.swipeArticleToDelete(article_title);


  }
}
