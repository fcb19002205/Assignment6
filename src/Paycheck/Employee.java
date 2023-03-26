package Paycheck;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Employee {

    private String name;
    private String lastName;
    private Double hourlyRate;
    private Double hoursWorked;
    private static final Logger LOGGER = Logger.getLogger(Employee.class.getName());

    public Employee(String name, String lastName, Double hourlyRate, Double hoursWorked) {
        this.name = name;
        this.lastName = lastName;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public String getFullName() {
        return name + " " + lastName;
    }

    public Double getHourlyRate() {
        return hourlyRate;
    }

    public Double getHoursWorked() {
        return hoursWorked;
    }

    public double calculatePay() throws Exception{
        try {
            if (hourlyRate <= 0 || hoursWorked <= 0) {
                throw new IllegalArgumentException("Satnica i/ili radni sati moraju biti veći od 0 ");
            }
            double pay = hourlyRate * hoursWorked;
            LOGGER.info(getFullName() + ", " + pay);
            return pay;

        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

}
