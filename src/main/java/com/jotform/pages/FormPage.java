package com.jotform.pages;

import com.jotform.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class FormPage extends Utility {

    public FormPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(id = "first_3")
    WebElement firstName;

    @CacheLookup
    @FindBy(id = "last_3")
    WebElement lastName;

    @CacheLookup
    @FindBy(id = "form-pagebreak-next_5")
    WebElement nextBtn1;

    @CacheLookup
    @FindBy(id = "form-pagebreak-next_4")
    WebElement nextBtn2;

    @CacheLookup
    @FindBy(id = "form-pagebreak-next_8")
    WebElement nextBtn3;

    @CacheLookup
    @FindBy(id = "form-pagebreak-next_10")
    WebElement nextBtn4;

    @CacheLookup
    @FindBy(id = "form-pagebreak-next_13")
    WebElement nextBtn5;

    @CacheLookup
    @FindBy(xpath = "//canvas[@aria-label='E-Signature Field']")
    WebElement sign;

    @CacheLookup
    @FindBy(id = "input_9_pick")
    WebElement openDatePicker;

    @CacheLookup
    @FindBy(className = "calendar-new-month")
    WebElement selectMonth;

    @CacheLookup
    @FindBy(className = "button nextMonth")
    WebElement nextMonth;

    @CacheLookup
    @FindBy(className = "calendar-new-year")
    WebElement selectYear;

    @CacheLookup
    @FindBy(xpath = "//tr[@class='days']//td")
    List<WebElement> allDates;

    @CacheLookup
    @FindBy(id = "input_11")
    WebElement securityQ;

    @CacheLookup
    @FindBy(id = "input_12")
    WebElement answerQ;

    public void answerSecurity(String ans){
        sendTextToElement(answerQ,ans);
    }

    public void selectSecurityQuestion(String question){
        selectByVisibleTextFromDropDown(securityQ,question);
    }

    public void enterFirstName(String first) throws InterruptedException {
        Thread.sleep(1000);
        sendTextToElement(firstName, first);
    }

    public void enterLastName(String last) {
        sendTextToElement(lastName, last);
    }

    public void clickOnNextBtn() {
        clickOnElement(nextBtn1);
    }

    public void clickOnNext2() {
        clickOnElement(nextBtn2);
    }

    public void clickOnNext3() {
        clickOnElement(nextBtn3);
    }

    public void clickOnNext4() {
        clickOnElement(nextBtn4);
    }

    public void clickOnNext5() {
        clickOnElement(nextBtn5);
    }

    public void signature() {
        Actions builder = new Actions(driver);
        Action signature = builder.moveToElement(sign, 100, 50)
//start points x axis and y axis.
                .clickAndHold()
                .moveByOffset(150, 55) // 2nd point (x1,y1)
                .click()
                .build();
        signature.perform();
    }

    public void selectDate(String year, String month,String day) {


        clickOnElement(openDatePicker); // Opens the date picker

        while (true) {
            String monthYear = selectMonth.getText();
            String arr[] = monthYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(nextMonth);
            }
        }
        // Date Selection
        for (WebElement dt : allDates) {
            if (dt.getText().equalsIgnoreCase(day)) {
                dt.click();
                break;
            }
        }
    }
}
