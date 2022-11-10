package qa.annenko.models;

import java.util.List;

public class Flights {

    public String flightNumber;
    public String destination;
    public String departureTime;
    public List<String> cabinCrew;
    public Meal meal;

    public static class Meal {
        public int hotMeal;
        public int water;
        public int juice;
    }
}