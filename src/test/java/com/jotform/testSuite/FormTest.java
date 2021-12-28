package com.jotform.testSuite;

import com.jotform.customlisteners.CustomListeners;
import com.jotform.pages.FormPage;
import com.jotform.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class FormTest extends TestBase {

    FormPage formPage;

    @BeforeMethod(alwaysRun=true)
    public void inIt() {
        formPage = new FormPage();
    }

    @Test
    public void verifyTheFormsFunctionalities() throws InterruptedException {
        formPage.enterFirstName("John");
        formPage.enterLastName("Dillinger");
        formPage.clickOnNextBtn();
        formPage.clickOnNext2();
        formPage.signature();
        formPage.clickOnNext3();
        formPage.selectDate("2022","June","26");
        formPage.clickOnNext4();
        formPage.selectSecurityQuestion(" Favourite colour ");
        formPage.answerSecurity("Red");
        formPage.clickOnNext5();

    }
}
