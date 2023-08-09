package Tests;

import ExtentReporter.ExtentFactory;
import Screens.TaxCreditSurveyDeclarationPage;
import Screens.TaxCreditSurveyFirstPage;
import Screens.TaxCreditSurveySecondPage;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TaxCreditSurveyDeclarationPageTest extends TaxCreditSurveyDeclarationPage {

    @Parameters({"First Name", "Last Name", "Email Address", "Street Address", "City", "Zip Code"})
    @Test
    public static void VerifyThatUserNavigatesToEmployerServices(String firstName, String lastName, String emailAddress, String streetAddress, String city, String zipCode) throws InterruptedException {
        TaxCreditSurveyFirstPage.enterFirstName(firstName);
        TaxCreditSurveyFirstPage.enterLastName(lastName);
        TaxCreditSurveyFirstPage.enterEmailAddress(emailAddress);
        TaxCreditSurveyFirstPage.enterStreetAddress(streetAddress);
        TaxCreditSurveyFirstPage.enterCityName(city);
        TaxCreditSurveyFirstPage.enterZipcode(zipCode);
        TaxCreditSurveyFirstPage.clickOnSubmitButton();

        TaxCreditSurveySecondPage.selectAll("No");
        TaxCreditSurveySecondPage.clickOnNextButton();

        TaxCreditSurveyDeclarationPage.submitForm();

        String url = driver.getCurrentUrl().split("/\\?")[0];
        System.out.println("Final URL is "+url);

        //ExtentFactory.getInstance().getExtent().log(Status.INFO,"Asserting URL after submitting the form");
        Assert.assertEquals(url,"https://www.experian.com/employer-services");





    }

}
