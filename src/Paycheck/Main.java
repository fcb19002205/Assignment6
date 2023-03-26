package Paycheck;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    public static void main(String[] args) {

        Logger LOGGER = Logger.getLogger(Main.class.getName());
        try {
            FileHandler fileHandler = new FileHandler("log.txt");
            LOGGER.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
        } catch (IOException e) {
            LOGGER.warning("Log datoteka se nije uspjela kreirati: " + e.getMessage());
        }


        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Marko", "Maric", -15.0, 40.0));
        employees.add(new Employee("Zdenka", "Vragek", 18.0, 40.0));
        employees.add(new Employee("Vlatka", "Vragovic", 12.0, 20.0));
        employees.add(new Employee("Pero", "Peric", 10.0, 35.0));
        employees.add(new Employee("Pavao", "Cigaric", 20.0, 40.0));
        employees.add(new Employee("Josipa", "Lijanovic", 20.0, 35.5));

        for (Employee employee : employees) {
            try {
                double pay = employee.calculatePay();
                if (pay < 0) {
                    throw new Exception("Plaća ne može biti negativna");
                }


            } catch (Exception e) {
                System.out.println();
                LOGGER.warning("Greška: " + e.getMessage() + "kod obračuna plaće za " + employee.getFullName());

            }
        }
    }

}
