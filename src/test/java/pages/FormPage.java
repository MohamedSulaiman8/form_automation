package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CalendarUtils;

import java.time.Duration;

public class FormPage extends BasePage {

    public FormPage(WebDriver driver) {
        super(driver);
        this.calendar = new CalendarUtils(driver);
    }
    private CalendarUtils calendar;


    // LOCATORS
    By firstName = By.id("first_16");
    By lastName = By.id("last_16");
    By email = By.id("input_17");
    By roomType = By.id("input_6");
    By peopleCount = By.id("input_18");

    By arrivalDate = By.id("lite_mode_22");
    By arrivalTime = By.id("input_22_timeInput");
    By ampm = By.id("input_22_ampm");

    By depMonth = By.id("input_20_month");
    By depDay = By.id("input_20_day");
    By depYear = By.id("input_20_year");

    By flightNumber = By.id("input_28");
    By specialRequests = By.id("input_30");

    By pickupYes = By.id("label_input_10_0");
    By submit = By.id("input_2");

    // ACTION METHODS
    public void enterFirstName(String fname) {
        type(firstName, fname);
    }

    public void enterLastName(String lname) {
        type(lastName, lname);
    }

    public void enterEmail(String mail) {
        type(email, mail);
    }

    public void selectRoom(String room) {
        selectByVisibleText(roomType, room);
    }

    public void enterPeopleCount(String count) {
        type(peopleCount, count);
    }

    public void enterArrivalDate(String date) {
        type(arrivalDate, date);
    }

    public void enterArrivalTime(String time) {
        type(arrivalTime, time);
    }

    public void selectAMPM(String value) {
        selectByVisibleText(ampm, value);
    }

    public void selectArrivalDateUsingCalendar(String month, String year, String day) {
        calendar.selectDate(month, year, day);
    }

    public void selectDepartureDate(String month, String day, String year) {
        selectByVisibleText(depMonth, month);
        selectByVisibleText(depDay, day);
        selectByVisibleText(depYear, year);
    }

    public void enterFlightNumber(String flight) {
        type(flightNumber, flight);
    }

    public void enterSpecialRequests(String text) {
        type(specialRequests, text);
    }

    public void selectPickupYes() {
        click(By.id("label_input_10_0"));
    }

    public void clickSubmit() {click(submit); }

    public boolean isSuccessPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            wait.until(ExpectedConditions.titleContains("Thank"));

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//h1[contains(text(),'Thank You')]")
            ));

            return true;

        } catch (Exception e) {
            return false;
        }
    }

}