package utils;

public class BookingData {

    private String firstName;
    private String lastName;
    private String email;
    private String room;
    private String people;

    private String arrivalDate;

    private String arrivalMonth;
    private String arrivalDay;
    private String arrivalYear;

    private String arrivalTime;
    private String ampm;

    private String depMonth;
    private String depDay;
    private String depYear;

    private String flight;
    private String requests;

    public BookingData(
            String firstName,
            String lastName,
            String email,
            String room,
            String people,
            String arrivalDate,
            String arrivalMonth,
            String arrivalDay,
            String arrivalYear,
            String arrivalTime,
            String ampm,
            String depMonth,
            String depDay,
            String depYear,
            String flight,
            String requests) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.room = room;
        this.people = people;
        this.arrivalDate= arrivalDate;
        this.arrivalMonth = arrivalMonth;
        this.arrivalDay = arrivalDay;
        this.arrivalYear = arrivalYear;
        this.arrivalTime = arrivalTime;
        this.ampm = ampm;
        this.depMonth = depMonth;
        this.depDay = depDay;
        this.depYear = depYear;
        this.flight = flight;
        this.requests = requests;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getRoom() { return room; }
    public String getPeople() { return people; }
    public String getArrivalDate(){return arrivalDate;}
    public String getArrivalMonth() { return arrivalMonth; }
    public String getArrivalDay() { return arrivalDay; }
    public String getArrivalYear() { return arrivalYear; }

    public String getArrivalTime() { return arrivalTime; }
    public String getAmpm() { return ampm; }

    public String getDepMonth() { return depMonth; }
    public String getDepDay() { return depDay; }
    public String getDepYear() { return depYear; }

    public String getFlight() { return flight; }
    public String getRequests() { return requests; }
}