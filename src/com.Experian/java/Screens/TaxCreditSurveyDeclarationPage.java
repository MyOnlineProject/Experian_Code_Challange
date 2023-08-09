package Screens;

import org.openqa.selenium.By;
import BasePackage.BaseSelenium;

public class TaxCreditSurveyDeclarationPage extends BaseSelenium {

    private static final By submitFormButton = By.xpath("//input[@id='SurveyControl_SurveySubmit']");

    public static void submitForm(){
        clickOnElement(submitFormButton);
    }
}
