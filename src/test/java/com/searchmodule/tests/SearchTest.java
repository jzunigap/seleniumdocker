package com.searchmodule.tests;

import com.tests.BaseTest;
import org.testng.Assert;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.Optional;
import searchmodule.pages.SearchPage;

public class SearchTest extends BaseTest {


    @Test
    @Parameters({"keyword"})
    public void search(String keyword){
        SearchPage searchPage=new SearchPage(driver);
        searchPage.goTo();
        searchPage.doSearch(keyword);
        searchPage.goToVideos();
        int size=searchPage.getResult();
        Assert.assertTrue(size>0);
    }


}
