package victork.View;

import victork.Entity.Category;
import victork.Entity.Medication;
import victork.Tools.EnumPlaster;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MedicationFrame extends MainFrame{
    //--------------------- CONSTANTS ------------------------------------------
    //--------------------- STATIC VARIABLES -----------------------------------
    private final JComboBox<String> medicationDropDownMenu = new JComboBox<String>();
    private final JButton btnCreateMedication = new JButton("Create");
    private final JButton btnUpdateMedication = new JButton("Update");
    private final JButton btnDeleteMedication = new JButton("Delete");
    private final JButton btnReadMedication = new JButton("Read");
    Medication selectedItem;

    //--------------------- INSTANCE VARIABLES ---------------------------------
    //--------------------- CONSTRUCTORS ---------------------------------------
    public MedicationFrame(String title)  {
        super(title);
        initMedicationDropDownMenu();
        JPanel panListMoreButtons = new JPanel();
        panListMoreButtons.setLayout(new BoxLayout(panListMoreButtons, BoxLayout.Y_AXIS));
        panListMoreButtons.add(medicationDropDownMenu);

        JPanel panBtn = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panBtn.add(btnCreateMedication);
        panBtn.add(btnUpdateMedication);
        panBtn.add(btnDeleteMedication);
        panBtn.add(btnReadMedication);
        panListMoreButtons.add(panBtn);
        super.contentPaneCenter.add(panListMoreButtons);
        selectMedication();
        medicationDropDownMenu.addActionListener(e -> {
            selectMedication();
        });
        btnCreateMedication.addActionListener(this::btnCreateMedicationListener);
        btnUpdateMedication.addActionListener(this::btnUpdateMedicationListener);
        btnDeleteMedication.addActionListener(this::btnDeleteMedicationListener);
        btnReadMedication.addActionListener(this::btnReadMedicationListener);
    }
    private void selectMedication() {
        int selectedIndex  = medicationDropDownMenu.getSelectedIndex();
        selectedItem = Medication.getListOfMedication().get(selectedIndex);
    }

    //--------------------- STATIC METHODS -------------------------------------
    //--------------------- INSTANCE METHODS -----------------------------------
    private void initMedicationDropDownMenu(){
        medicationDropDownMenu.addItem("Aspirin");
        medicationDropDownMenu.addItem("Propranolol");
    }
    private void btnCreateMedicationListener(ActionEvent actionEvent) {
        new CRUDMedication("CRUD", selectedItem, EnumPlaster.CREATE);
    }
    private void btnUpdateMedicationListener(ActionEvent actionEvent) {
        new CRUDMedication("CRUD", selectedItem, EnumPlaster.UPDATE);
    }
    private void btnDeleteMedicationListener(ActionEvent actionEvent) {
        new CRUDMedication("CRUD", selectedItem, EnumPlaster.DELETE);
    }
    private void btnReadMedicationListener(ActionEvent actionEvent) {
        new CRUDMedication("CRUD", selectedItem, EnumPlaster.READ);
    }

    //--------------------- ABSTRACT METHODS -----------------------------------
    //--------------------- STATIC - GETTERS - SETTERS -------------------------
    //--------------------- GETTERS - SETTERS ----------------------------------
    //--------------------- TO STRING METHOD------------------------------------
}
