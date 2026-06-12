package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class CalendarUtils {

    private WebDriver driver;

    public CalendarUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void selectDate(String targetMonth, String targetYear, String day) {

        //driver.findElement(By.id("input_22_pick")).click();
        WebElement calendarBtn =
                driver.findElement(By.id("input_22_pick"));

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        calendarBtn);

        calendarBtn.click();

        By monthText = By.className("calendar-new-month-text");
        By yearText  = By.className("calendar-new-year-text");

        By nextMonth = By.className("nextMonth");
        By prevMonth = By.className("previousMonth");

        By nextYear = By.className("nextYear");
        By prevYear = By.className("previousYear");

        while (true) {

            String currentMonth = driver.findElement(monthText).getText();
            String currentYear  = driver.findElement(yearText).getText();

            if (currentMonth.equalsIgnoreCase(targetMonth)
                    && currentYear.equals(targetYear)) {
                break;
            }

            if (!currentYear.equals(targetYear)) {

                int curr = Integer.parseInt(currentYear);
                int target = Integer.parseInt(targetYear);

                if (curr < target) {
                    driver.findElement(nextYear).click();
                } else {
                    driver.findElement(prevYear).click();
                }
            } else {
                driver.findElement(nextMonth).click();
            }
        }

        String xpath =
                "//button[@data-date and contains(@aria-label,'" +
                        targetMonth + " " + day + "')]/ancestor::td";

        driver.findElement(By.xpath(xpath)).click();
    }
}