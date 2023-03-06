package victork.View;

import victork.Entity.Category;
import victork.Entity.Medication;
import victork.Exception.ExceptionEntity;
import victork.Tools.EnumPlaster;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class CRUDMedication extends MainFrame {
    //--------------------- CONSTANTS ------------------------------------------
    //--------------------- STATIC VARIABLES -----------------------------------
    //--------------------- INSTANCE VARIABLES ---------------------------------
    private Medication medication;
    private Boolean isEditable;
    private EnumPlaster enumCRUD;
    private JPanel panDetailMedication = new JPanel();
    private JPanel subpanel;
    private JButton btnSave;
    private JComboBox<String> inputCategory;
    private JTextField inputIdMedication, inputName, inputPrice, inputCommissioningDate, inputInventoryQuantity;
    private JLabel labelIdMedication, labelName, labelPrice, labelCommissioningDate, labelInventoryQuantity,
            labelCategory;
    //--------------------- CONSTRUCTORS ---------------------------------------
    public CRUDMedication(String title, Medication medication, EnumPlaster enumCRUD) {
        super(title);
        this.medication = medication;
        this.enumCRUD = enumCRUD;
        initMenuDropdownCategory();
        designFrame();
        chooseMethodOfCRUD();
    }
    //--------------------- STATIC METHODS -------------------------------------
    //--------------------- INSTANCE METHODS -----------------------------------
    public void chooseMethodOfCRUD()  {
        switch (enumCRUD) {
            case CREATE:
                create();
                break;
            case UPDATE:
                update();
                break;
            case DELETE:
                delete();
                break;
            default:
                System.out.println("Method did not receive parameters");
        }
    }
    private void designFrame(){
        panDetailMedication.setLayout(new BoxLayout(panDetailMedication, BoxLayout.X_AXIS));
        initInput();
        super.contentPaneCenter.add(panDetailMedication);
    }
    private void create(){
        btnSave = new JButton("Create");
        panDetailMedication.add(btnSave);
        btnSave.addActionListener(e -> {
            LocalDate dateEntered = LocalDate.parse(inputCommissioningDate.getText());
            int selectedIndexCategory = inputCategory.getSelectedIndex();
            Category selectedItem = Category.getListOfCategory().get(selectedIndexCategory);
            try {
                Medication newMedication = new Medication(
                        10,
                        inputName.getText(),
                        Integer.parseInt(inputPrice.getText()),
                        dateEntered,
                        Integer.parseInt(inputInventoryQuantity.getText()),
                        selectedItem
                );
            for (Medication medicationItem: Medication.getListOfMedication()
                 ) {
                System.out.println(medicationItem.getName());
            }
            } catch (ExceptionEntity ex) {
                throw new RuntimeException(ex);
            }
        });
    }
    private void delete(){}
    private void update(){}
    private void initInput(){
        switch (enumCRUD) {
            case CREATE:
                inputIdMedication = new JTextField( 25);
                inputName = new JTextField(25);
                inputPrice = new JTextField( 25);
                inputCommissioningDate = new JTextField( 25);
                inputInventoryQuantity = new JTextField( 25);
                break;
            case UPDATE:
                preFilledTheFields(true);
                break;
            case READ:
            case DELETE:
                preFilledTheFields(false);
                break;
        }
        labelIdMedication = new JLabel("Id");
        labelName = new JLabel("Name");
        labelPrice = new JLabel("Price");
        labelCommissioningDate = new JLabel("Date");
        labelInventoryQuantity = new JLabel("Quantity");
        labelCategory = new JLabel("Category");

        fillPanel();
    }

    private void preFilledTheFields(Boolean isEditable){
        inputIdMedication = new JTextField(String.valueOf(medication.getIdMedication()), 25);
        inputName = new JTextField(medication.getName(), 25);
        inputPrice = new JTextField(String.valueOf(medication.getPrice()), 25);
        inputCommissioningDate = new JTextField(String.valueOf(medication.getCommissioningDate()), 25);
        inputInventoryQuantity = new JTextField(String.valueOf(medication.getInventoryQuantity()), 25);

        if(!isEditable){
            inputIdMedication.setEditable(false);
            inputName.setEditable(false);
            inputPrice.setEditable(false);
            inputCommissioningDate.setEditable(false);
            inputInventoryQuantity.setEditable(false);
            inputCategory.setEditable(false);
        }
    }

    private void initMenuDropdownCategory(){
        inputCategory = new JComboBox<String>();
        for (Category category: Category.getListOfCategory()
        ) {
            this.inputCategory.addItem(category.getLabel());
        }
    }

    private void fillPanel(){
        subpanel = new JPanel();
        subpanel.setLayout(new BoxLayout(subpanel, BoxLayout.Y_AXIS));

        subpanel.add(labelIdMedication);
        subpanel.add(inputIdMedication);
        panDetailMedication.add(subpanel);

        subpanel.add(labelName);
        subpanel.add(inputName);
        panDetailMedication.add(subpanel);

        subpanel.add(labelPrice);
        subpanel.add(inputPrice);
        panDetailMedication.add(subpanel);

        subpanel.add(labelCommissioningDate);
        subpanel.add(inputCommissioningDate);
        panDetailMedication.add(subpanel);

        subpanel.add(labelInventoryQuantity);
        subpanel.add(inputInventoryQuantity);
        panDetailMedication.add(subpanel);

        subpanel.add(labelCategory);
        subpanel.add(inputCategory);
        panDetailMedication.add(subpanel);
    }
    //--------------------- ABSTRACT METHODS -----------------------------------
    //--------------------- STATIC - GETTERS - SETTERS -------------------------
    //--------------------- GETTERS - SETTERS ----------------------------------
    //--------------------- TO STRING METHOD------------------------------------
}
