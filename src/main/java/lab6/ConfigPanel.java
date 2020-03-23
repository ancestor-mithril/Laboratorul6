package lab6;


import javax.swing.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label; // we’re drawing regular polygons
    JLabel sizeLabel;
    JSpinner sizeField;
    JSpinner sidesField; // number of sides
    JComboBox colorCombo; // the color of the shape
    JLabel sidesLabel;
    JLabel colorLabel;
    JLabel shapeLabel;
    JComboBox shapeCombo;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //create the label and the spinner
        sizeLabel=new JLabel("Size: ");
        sizeField=new JSpinner(new SpinnerNumberModel(5,  0, 20, 1));
        add(sizeLabel);
        add(sizeField);

        sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(3, 3, 100, 1));
        sidesField.setValue(6); //default number of sides
        add(sidesLabel); //JPanel uses FlowLayout by default
        add(sidesField);

        //create the colorCombo, containing the values: Random and Black
        colorLabel=new JLabel("Choose color:");
        colorCombo=new JComboBox(new String[]{"Random", "Black","Red","Blue","Yellow"});
        add(colorLabel);
        add(colorCombo);

        shapeLabel = new JLabel("Choose shape:");
        shapeCombo= new JComboBox(new String[]{"Random", "Circle", "Polygon", "Square", "Snowflake"});

        add(shapeLabel);
        add(shapeCombo);
    }
}