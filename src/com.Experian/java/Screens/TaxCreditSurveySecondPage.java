package Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BasePackage.BaseSelenium;
import java.util.List;


public class TaxCreditSurveySecondPage extends BaseSelenium {

    private static final By answerNo = By.xpath("//div[@class='ima-answer-item-container']//label[2]");
    private static final By answerYes = By.xpath("//div[@class='ima-answer-item-container']//label[1]");
    private static final By nextButton = By.xpath("//input[@id='SurveyControl_SurveySubmit']");

    public static void selectAll(String option)  {
        List<WebElement> allNOAnswers = driver.findElements(answerNo);
        List<WebElement> allYesAnswers = driver.findElements(answerYes);

        if(option.equalsIgnoreCase("Yes")){
            for (WebElement ele:allYesAnswers) {
                try{
                    ele.click();
                }catch(Exception e){
                    System.out.println("Unable to click on element, trying to scroll and then click on element");
                    scrollToElement(ele);
                    ele.click();
                }
            }
        }else{
            for (WebElement ele: allNOAnswers) {
                try{
                    ele.click();
                }catch(Exception e){
                    System.out.println("Unable to click on element, trying to scroll and then click on element");
                    scrollToElement(ele);
                    ele.click();
                }

            }
        }

    }

    public static void clickOnNextButton(){
        clickOnElement(nextButton);
    }
}
