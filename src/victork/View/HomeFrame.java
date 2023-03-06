package victork.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class HomeFrame extends MainFrame {
    //--------------------- CONSTANTS ------------------------------------------
    //--------------------- STATIC VARIABLES -----------------------------------
    //--------------------- INSTANCE VARIABLES ---------------------------------
    JButton btnToMedicationFrame = new JButton("Medication frame");
    //--------------------- CONSTRUCTORS ---------------------------------------
    public HomeFrame(String title)  {
        super(title);
        super.contentPaneCenter.setLayout(new FlowLayout(FlowLayout.CENTER));
        super.contentPaneCenter.add(btnToMedicationFrame);
        btnToMedicationFrame.addActionListener(this::btnMedicationListener);
        super.pack();
    }
    private void btnMedicationListener(ActionEvent actionEvent)  {
        closeFrame();
        new MedicationFrame("Medication frame");
    }
    private void closeFrame() {
        this.dispose();
    }
    //--------------------- STATIC METHODS -------------------------------------
    //--------------------- INSTANCE METHODS -----------------------------------

    //--------------------- ABSTRACT METHODS -----------------------------------
    //--------------------- STATIC - GETTERS - SETTERS -------------------------
    //--------------------- GETTERS - SETTERS ----------------------------------
    //--------------------- TO STRING METHOD------------------------------------
}
