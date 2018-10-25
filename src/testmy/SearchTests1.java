package testmy;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;


/**
 * Created by Mari on 10/12/18.
 */
public class SearchTests1 extends CoreTestCase {
  @Test
  public void testSearchAndAssertText() {
    SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
    SearchPageObject.initSearchInput();
    String search_test =SearchPageObject.textAtribute();

    assertEquals("we cannot find 'Search...'",
            "Search…",
            search_test);

  }

  @Test
  public void testSearchCancel() {
    SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
    SearchPageObject.initSearchInput();
    SearchPageObject.typeSearchLine("Google");
    SearchPageObject.clickCanselSearch();
    SearchPageObject.waitForSearchResultNotPresent("Web browser developed by Google");


  }
}
