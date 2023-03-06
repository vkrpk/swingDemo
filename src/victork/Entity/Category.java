package victork.Entity;


import victork.Tools.ControlString;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import victork.Exception.ExceptionEntity;


public class Category {
    //--------------------- CONSTANTS ------------------------------------------
    //--------------------- STATIC VARIABLES -----------------------------------
    //--------------------- INSTANCE VARIABLES ---------------------------------
    private int idCategory;
    private String label;
    private static AtomicInteger count = new AtomicInteger(0);
    private static ArrayList<Category> listOfCategory = new ArrayList<>();


    //--------------------- CONSTRUCTORS ---------------------------------------
    public Category(int idCategory, String label) throws Exception {
        this.setIdCategory(idCategory);
        this.setLabel(label);
        Category.getListOfCategory().add(this);
    }
    //--------------------- STATIC METHODS -------------------------------------
    //--------------------- INSTANCE METHODS -----------------------------------
    //--------------------- ABSTRACT METHODS -----------------------------------
    //--------------------- STATIC - GETTERS - SETTERS -------------------------
    public static ArrayList<Category> getListOfCategory() {
        return listOfCategory;
    }
    public static int autoIdIncremented() {
        return count.incrementAndGet();
    };
    //--------------------- GETTERS - SETTERS ----------------------------------
    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) throws ExceptionEntity {
        if (ControlString.controlString(label)) {
            this.label = label;
        } else {
            throw new ExceptionEntity("Input is not good");
        }
    }
    //--------------------- TO STRING METHOD------------------------------------
}
