package victork;

import victork.Entity.Category;
import victork.Entity.Medication;
import victork.Exception.ExceptionEntity;
import victork.View.HomeFrame;

import javax.swing.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {
        Category antiInflammatory = new Category(2, "Anti inflammatory");
        Category antibiotic = new Category(2, "Antibiotic");
        Medication aspirin = new Medication(1,"Aspirin", 3,
                LocalDate.of(1957, 7, 25), 10, antiInflammatory );
        Medication propranolol = new Medication(2,"Propranolol", 5,
                LocalDate.of(1957, 7, 25), 15, antibiotic);
        new HomeFrame("Home Frame");
    }
}