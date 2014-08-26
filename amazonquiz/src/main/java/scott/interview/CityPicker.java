package scott.interview;

import java.util.ArrayList;
import java.util.List;

public class CityPicker {

    // Assuming "For the following data: [“Seattle:60”, “Spokane:21”, “Olympia:5”]" means a string array.
    // I also could have assumed it was a json string and would have processed it that way.
    //
    public static City randomWeighted(String[] cityStrings) {
        List<City> cities = new ArrayList<City>();
        for (String c : cityStrings) {
            String[] cParts = c.split(":");
            if (cParts.length == 2) {
                City city = new City();
                city.setName(cParts[0]);
                city.setPopulation(Integer.parseInt(cParts[1]));
                cities.add(city);
            }
        }
        return randomWeighted(cities);
    }

    public static City randomWeighted(List<City> cities) {

        if (cities == null || cities.size() == 0) {
            return null;
        }

        // Calculate how large the search space is.
        //
        long totalWeight = 0;
        for (City city : cities) {
            totalWeight += city.getPopulation();
        }

        // Now Pick a random number from [0 to TotalWeight)
        //
        long randomWeight = (long) (totalWeight * Math.random());

        // Search back through the cities and find the city for randomWeight
        //
        City randomCity = null;
        for (City city : cities) {
            randomCity = city;
            randomWeight -= city.getPopulation();
            if (randomWeight <= 0) {
                break;
            }
        }

        // Here is your random city, based on weight.
        //
        return randomCity;
    }

}
