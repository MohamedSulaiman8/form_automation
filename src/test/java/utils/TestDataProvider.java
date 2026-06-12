package utils;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "bookingData")
    public Object[][] getFormData() {

        return new Object[][] {

                {
                        new BookingData(
                                "Mohamed",
                                "Sulaiman",
                                "test@example.com",
                                "Family Room (1 to 4 People)",
                                "2",
                                "04-17-2026",
                                "April",
                                "17",
                                "2026",
                                "05:20",
                                "AM",
                                "April",
                                "20",
                                "2026",
                                "AI-202",
                                "Late check-in"
                        )
                },

                {
                        new BookingData(
                                "John",
                                "Doe",
                                "john@example.com",
                                "Standard Room (1 to 2 People)",
                                "1",
                                "05-10-2026",
                                "May",
                                "10",
                                "2026",
                                "08:30",
                                "PM",
                                "May",
                                "15",
                                "2026",
                                "BA-101",
                                "Near elevator"
                        )
                }
        };
    }
}