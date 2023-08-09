package Screens;


import org.openqa.selenium.By;
import BasePackage.BaseSelenium;

public class TaxCreditSurveyFirstPage extends BaseSelenium {

    private static final By firstNameTextBox = By.xpath("//input[starts-with(@id,'SurveyControl_Question943')]");
    private static final By lastNameTextBox = By.xpath("//input[starts-with(@id,'SurveyControl_Question946')]");
    private static final By emailAddressTextBox = By.xpath("//input[starts-with(@id,'SurveyControl_Question949')]");
    private static final By streetAddressTextBox = By.xpath("//input[starts-with(@id,'SurveyControl_Question950')]");
    private static final By cityTextBox = By.xpath("//input[starts-with(@id,'SurveyControl_Question951')]");
    private static final By zipcodeTextBox = By.xpath("//input[starts-with(@id,'SurveyControl_Question952')]");
    private static final By submitButton = By.xpath("//input[@id='SurveyControl_SurveySubmit']");


    public static void enterDataIntoEachField(String labelName, String data){
        System.out.println("Entering data into each field");
        if(labelName.equalsIgnoreCase("First Name")){
            enterTextInTextBox(firstNameTextBox, data);
        }else if(labelName.equalsIgnoreCase("Last Name")){
            enterTextInTextBox(lastNameTextBox, data);
        }else if(labelName.equalsIgnoreCase("Email Address")){
            enterTextInTextBox(emailAddressTextBox, data);
        }else if(labelName.equalsIgnoreCase("Street Address")){
            enterTextInTextBox(streetAddressTextBox, data);
        }else if(labelName.equalsIgnoreCase("City")){
            enterTextInTextBox(cityTextBox, data);
        }else if(labelName.equalsIgnoreCase("Zip Code")){
            enterTextInTextBox(zipcodeTextBox, data);
        }
    }

    public static void enterFirstName(String firstName){
        System.out.println("In method enterFirstName");
        enterTextInTextBox(firstNameTextBox, firstName);
    }

    public static void enterLastName(String lastName){
        System.out.println("In method enterLastName");
        enterTextInTextBox(lastNameTextBox, lastName);
    }

    public static void enterEmailAddress(String emailAddress){
        System.out.println("In method enterEmailAddress");
        enterTextInTextBox(emailAddressTextBox, emailAddress);
    }

    public static void enterStreetAddress(String streetAddress){
        enterTextInTextBox(streetAddressTextBox, streetAddress);
    }

    public static void enterCityName(String cityName){
        enterTextInTextBox(cityTextBox, cityName);
    }

    public static void enterZipcode(String zipcode){
        enterTextInTextBox(zipcodeTextBox, zipcode);
    }

    public static void clickOnSubmitButton(){
        clickOnElement(submitButton);
    }


}
