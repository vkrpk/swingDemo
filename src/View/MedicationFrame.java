package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MedicationFrame extends MainFrame{
    //--------------------- CONSTANTS ------------------------------------------
    //--------------------- STATIC VARIABLES -----------------------------------
    private final JComboBox<String> medicationDropDownMenu = new JComboBox<String>();
    private final JButton btnCreateMedication = new JButton("Create");
    private final JButton btnEditMedication = new JButton("Edit");
    private final JButton deleteMedication = new JButton("Delete");
    private final JButton readMedication = new JButton("Read");
    Object selectedItem;

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
        panBtn.add(btnEditMedication);
        panBtn.add(deleteMedication);
        panBtn.add(readMedication);
        panListMoreButtons.add(panBtn);
        super.contentPaneCenter.add(panListMoreButtons);

        medicationDropDownMenu.addActionListener(this::medicationDropDownMenuListener);
    }

    private void medicationDropDownMenuListener(ActionEvent actionEvent) {
        // récupérer l'index, pas l'objet
        selectedItem = medicationDropDownMenu.getSelectedIndex();

        System.out.println("test");
    }

    //--------------------- STATIC METHODS -------------------------------------
    //--------------------- INSTANCE METHODS -----------------------------------
    private void initMedicationDropDownMenu(){
        medicationDropDownMenu.addItem("Aspirin");
        medicationDropDownMenu.addItem("Doliprane");
    }
    //--------------------- ABSTRACT METHODS -----------------------------------
    //--------------------- STATIC - GETTERS - SETTERS -------------------------
    //--------------------- GETTERS - SETTERS ----------------------------------
    //--------------------- TO STRING METHOD------------------------------------
}
