package scott.interview;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CityPickerTest {

    @Test
    public void testRandomWeighted() throws Exception {
        String[] cities = {"Seattle:60", "Spokane:21", "Olympia:5"};
        for (int i = 0; i < 10; i++) {
            System.out.println("Picked " + CityPicker.randomWeighted(cities));
        }
    }

    @Test
    public void testRandomWeighted_null() throws Exception {
        String[] cities = {};
        for (int i = 0; i < 10; i++) {
            System.out.println("Picked " + CityPicker.randomWeighted(cities));
        }
    }

    @Test
    public void testRandomWeighted_null2() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println("Picked " + CityPicker.randomWeighted((List<City>)null));
        }
    }
}