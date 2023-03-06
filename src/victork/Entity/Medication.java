package victork.Entity;

import victork.Exception.ExceptionEntity;
import victork.Tools.ControlString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Medication {
    //--------------------- CONSTANTS ------------------------------------------
    //--------------------- STATIC VARIABLES -----------------------------------
    //--------------------- INSTANCE VARIABLES ---------------------------------
    private int idMedication;
    private String name;
    private int price;
    private LocalDate commissioningDate;
    private int inventoryQuantity;
    private Category category;
    private static ArrayList<Medication> listOfMedication = new ArrayList<>();
    //--------------------- CONSTRUCTORS ---------------------------------------
    public Medication(int idMedication, String name, int price, LocalDate commissioningDate, int inventoryQuantity,
                      Category category) throws ExceptionEntity {
        this.setIdMedication(idMedication);
        this.setName(name);
        this.setPrice(price);
        this.setCommissioningDate(commissioningDate);
        this.setInventoryQuantity(inventoryQuantity);
        this.setCategory(category);
        Medication.getListOfMedication().add(this);
    }

    //--------------------- STATIC METHODS -------------------------------------
    //--------------------- INSTANCE METHODS -----------------------------------
    //--------------------- ABSTRACT METHODS -----------------------------------
    //--------------------- STATIC - GETTERS - SETTERS -------------------------
    public static List<Medication> getListOfMedication() {
        return listOfMedication;
    }

    public static void setListOfMedication(ArrayList<Medication> listOfMedication) {
        Medication.listOfMedication = listOfMedication;
    }
    //--------------------- GETTERS - SETTERS ----------------------------------

    public int getIdMedication() {
        return idMedication;
    }

    public void setIdMedication(int idMedication) {
        this.idMedication = idMedication;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws ExceptionEntity {
        if (ControlString.controlString(name)) {
            this.name = name;
        } else {
            throw new ExceptionEntity("Input is not good");
        }
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) throws ExceptionEntity {
        if (price > 0) {
            this.price = price;
        } else {
            throw new ExceptionEntity("The price must be greater than 0 €");
        }
    }

    public LocalDate getCommissioningDate() {
        return commissioningDate;
    }

    public void setCommissioningDate(LocalDate commissioningDate) {
        this.commissioningDate = commissioningDate;
    }

    public int getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void setInventoryQuantity(int inventoryQuantity) throws ExceptionEntity {
        if (inventoryQuantity >= 0) {
            this.inventoryQuantity = inventoryQuantity;
        } else {
            throw new ExceptionEntity("Stock cannot be negative");
        }
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    //--------------------- TO STRING METHOD------------------------------------
    @Override
    public String toString() {
        return "Medication{" +
                "idMedication=" + idMedication +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", commissioningDate=" + commissioningDate +
                ", inventoryQuantity=" + inventoryQuantity +
                ", category=" + category +
                '}';
    }
}
