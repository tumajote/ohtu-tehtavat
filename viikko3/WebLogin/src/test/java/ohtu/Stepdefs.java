package ohtu;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Stepdefs {

    //WebDriver driver = new ChromeDriver();
    WebDriver driver = new HtmlUnitDriver();
    String baseUrl = "http://localhost:4567";

    //Login
    @Given("login is selected")
    public void loginIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();
    }

    @When("correct username {string} and password {string} are given")
    public void correctUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }

    @Then("user is logged in")
    public void userIsLoggedIn() {
        pageHasContent("Ohtu Application main page");
    }

    @When("correct username {string} and incorrect password {string} are given")
    public void correctUsernameAndIncorrectPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }

    @Then("user is not logged in and error message is given")
    public void userIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }

    @When("nonexistent username {string} and password {string} are given")
    public void nonexistentUsernameAndPasswordAreGiven(String username, String password) throws Throwable {
        logInWith(username, password);
    }

    // Signup
    @Given("command new user is selected")
    public void newUserIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
    }
    @Given("user with username {string} with password {string} is successfully created")
    public void newUSerIsCreated(String username, String password)throws Throwable {
        newUserIsSelected();
        validusernamePasswordandPasswordConfirmationAreGiven(username, password);
        WebElement element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        element = driver.findElement(By.linkText("logout"));
        element.click();    
    }
    
    @Given("user with username {string} and password {string} is tried to be created")
    public void newUSerIsNotCreated(String username, String password)throws Throwable {
        newUserIsSelected();
        notValidUsernameAndNotValidsswordandPasswordConfirmationAreGiven(username, password);
        WebElement element = driver.findElement(By.linkText("back to home"));
        element.click();        
    }
    
    @When("a valid username {string} and password {string} and matching password confirmation are entered")
    public void validusernamePasswordandPasswordConfirmationAreGiven(String username, String password) throws Throwable {
        signInWith(username, password);
    }

    @Then("a new user is created")
    public void aNewUserisCreated() throws Throwable {
        assertTrue(driver.getPageSource().contains("Welcome to Ohtu Application!"));
    }

    @When("too short username {string} and password {string} and matching password confirmation are entered")
    public void tooShortusernameValidPasswordandPasswordConfirmationAreGiven(String username, String password) throws Throwable {
        signInWith(username, password);
    }

    @When("a valid username {string} and too short password {string} and matching password confirmation are entered")
    public void validUsernameTooShortPasswordandPasswordConfirmationAreGiven(String username, String password) throws Throwable {
        signInWith(username, password);
    }
    
    @When("a not valid username {string} and too short password {string} and matching password confirmation are entered")
    public void notValidUsernameAndNotValidsswordandPasswordConfirmationAreGiven(String username, String password) throws Throwable {
        signInWith(username, password);
    }

    @Then("user is not created and error {string} is reported")
    public void userIsNotCreatedAndErrorMessageIsGiven(String error) {
        pageHasContent(error);
        pageHasContent("Create username and give password");
    }

    @When("a valid username {string} and password {string} and not matching password confirmation are entered")
    public void validusernamePasswordandNotMatchingPasswordConfirmationAreGiven(String username, String password) throws Throwable {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);

        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(password + "jotain");

        element = driver.findElement(By.name("signup"));
        element.submit();
    }
    

    @After
    public void tearDown() {
        driver.quit();
    }

    /* helper methods */
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }

    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();
    }

    private void signInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);

        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(password);

        element = driver.findElement(By.name("signup"));
        element.submit();
    }
}
