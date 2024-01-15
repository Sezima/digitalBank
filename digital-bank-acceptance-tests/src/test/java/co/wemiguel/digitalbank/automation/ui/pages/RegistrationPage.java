package co.wemiguel.digitalbank.automation.ui.pages;

import co.wemiguel.digitalbank.automation.ui.utils.MockData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class RegistrationPage {

    private WebDriver driver;

    public RegistrationPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    MockData mockData = new MockData();


    @FindBy(id = "title")
    private WebElement titleDropDown;

    @FindBy(id = "firstName")
    private WebElement firstNameTxt;

    @FindBy(id = "lastName")
    private WebElement lastNameTxt;

    @FindBy(xpath = "//label[@for='male]//input")
    private WebElement genderMRadio;

    @FindBy(xpath = "//label[@for='female']//input")
    private WebElement genderFRadio;

    @FindBy(id="dob")
    private  WebElement dobTxt;

    @FindBy(id="ssn")
    private WebElement ssnTxt;

    @FindBy(id="emailAddress")
    private WebElement emailAddressTxt;

    @FindBy(id = "password")
    private WebElement passwordTxt;

    @FindBy(id = "confirmPassword")
    private WebElement passwordConfirmTxt;

    @FindBy(id="//button[@class='btn btn-primary btn-flat m-b-30 m-t-30']")
    private WebElement registrationButton;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement nextButton;

    @FindBy (id = "address")
    private WebElement addressTxt;

    @FindBy(id = "locality")
    private WebElement localityTxt;

    @FindBy(id = "region")
    private WebElement regionTxt;

    @FindBy(id = "postalCode")
    private WebElement postalCodeTxt;

    @FindBy(id= "country")
    private WebElement countryTxt ;

    @FindBy(id = "homePhone")
    private WebElement homePhoneTxt;

    @FindBy (id = "mobilePhone")
    private WebElement mobilePhoneTxt;

    @FindBy(id = "workPhone")
    private WebElement workPhoneTxt;

    @FindBy(id = "agree-terms")
    private WebElement agreeTermsCheckbox;

    //      | title | firstName | lastName | gender | dateOfBirth | ssn         | email          | password    | confirmPassword | address    | locality | region | postalCode | country | mobilePhone  |
    public void fillOutRegistrationForm(List<Map<String, String>> registrationPageTestDataListOfMap) {

        Select titleSelect = new Select(titleDropDown);
        Map<String, String> firstRow = registrationPageTestDataListOfMap.get(0);
        titleSelect.selectByVisibleText(firstRow.get("title"));

        firstNameTxt.sendKeys(firstRow.get("firstName"));
        lastNameTxt.sendKeys(firstRow.get("lastName"));

        if (firstRow.get("gender").equalsIgnoreCase("M")) {
            genderMRadio.click();

        } else if(firstRow.get("gender").equalsIgnoreCase(firstRow.get("F"))){
            genderFRadio.click();

        } else {
            System.out.println("Wrong Gender");

        }

        dobTxt.sendKeys(firstRow.get("dob"));

        ssnTxt.sendKeys(mockData.generateRandomSsn());


        Map<String, String> mockNameAndEmail = mockData.generateRandomNameAndEmail();

        emailAddressTxt.sendKeys(mockNameAndEmail.get("email"));


        passwordTxt.sendKeys(firstRow.get("firstName"));
        passwordConfirmTxt.sendKeys(firstRow.get("password"));

        nextButton.click();

        addressTxt.sendKeys(firstRow.get("address"));
        localityTxt.sendKeys(firstRow.get("locality"));
        regionTxt.sendKeys(firstRow.get("region"));
        postalCodeTxt.sendKeys(firstRow.get("postalCode"));
        countryTxt.sendKeys(firstRow.get("country"));
        homePhoneTxt.sendKeys(firstRow.get("HomePhone"));
        mobilePhoneTxt.sendKeys(firstRow.get("mobilePhone"));
        workPhoneTxt.sendKeys(firstRow.get("workPhone"));

        agreeTermsCheckbox.click();
        registrationButton.click();


    }

}
