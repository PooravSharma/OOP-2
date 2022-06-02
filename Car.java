package Vehicle;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author 30045900
 */
public class Car implements Comparable<Car>, Serializable {

    private String make;
    private String model;
    private String year;
    private int odometer;

    public Car(String make) {
        this.make = make;
    }

    public Car(String make, String model, String year, int odometer) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.odometer = odometer;
    }

    

    @Override
    public int compareTo(Car cars) {
        int compareMake = Integer.parseInt(cars.getMake());
        int thMake = Integer.parseInt(this.make); 
        return thMake - compareMake;

        
    }

    public String getMake() {
        return make;
    }

    /**
     * @param make the make to set
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * @return the odometer
     */
    public int getOdometer() {
        return odometer;
    }

    /**
     * @param odometer the odometer to set
     */
    public void setOdometer(int odometer) {
        Random rn = new Random();
        this.odometer = rn.nextInt(9999999);
    }
}
