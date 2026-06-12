package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormPage;
import utils.BookingData;
import utils.TestDataProvider;

public class FormTest extends BaseTest {

    @Test(
            dataProvider = "bookingData",
            dataProviderClass = TestDataProvider.class
    )
    public void fillFormDirectMethod(BookingData data) {

        FormPage form = new FormPage(driver);

        form.enterFirstName(data.getFirstName());
        form.enterLastName(data.getLastName());
        form.enterEmail(data.getEmail());

        form.selectRoom(data.getRoom());
        form.enterPeopleCount(data.getPeople());

        // Direct sendKeys approach
        form.enterArrivalDate(data.getArrivalDate());

        form.enterArrivalTime(data.getArrivalTime());
        form.selectAMPM(data.getAmpm());

        form.selectDepartureDate(
                data.getDepMonth(),
                data.getDepDay(),
                data.getDepYear()
        );

        form.enterFlightNumber(data.getFlight());
        form.enterSpecialRequests(data.getRequests());

        form.selectPickupYes();

        form.clickSubmit();

        boolean success = form.isSuccessPageLoaded();

        Assert.assertTrue(success, "Form submission failed");
    }

    @Test(
            dataProvider = "bookingData",
            dataProviderClass = TestDataProvider.class
    )
    public void fillFormUsingCalendar(BookingData data) {

        FormPage form = new FormPage(driver);

        form.enterFirstName(data.getFirstName());
        form.enterLastName(data.getLastName());
        form.enterEmail(data.getEmail());

        form.selectRoom(data.getRoom());
        form.enterPeopleCount(data.getPeople());

        // Calendar-based date selection
        form.selectArrivalDateUsingCalendar(
                data.getArrivalMonth(),
                data.getArrivalYear(),
                data.getArrivalDay()
        );

        form.enterArrivalTime(data.getArrivalTime());
        form.selectAMPM(data.getAmpm());

        form.selectDepartureDate(
                data.getDepMonth(),
                data.getDepDay(),
                data.getDepYear()
        );

        form.enterFlightNumber(data.getFlight());
        form.enterSpecialRequests(data.getRequests());

        form.selectPickupYes();

        form.clickSubmit();

        boolean success = form.isSuccessPageLoaded();

        Assert.assertTrue(success, "Form submission failed");
    }
}