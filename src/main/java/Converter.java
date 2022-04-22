import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Converter extends JPanel implements ActionListener, KeyListener {

    private JLabel lblDistanceUnit, lblDistanceAnswer, lblWeightUnit, lblWeightAnswer, lblVolumeUnit, lblVolumeAnswer, lblTemperatureUnit, lblTemperatureAnswer;
    private JTextField txtDistanceUnit, txtWeightUnit, txtVolumeUnit, txtTemperatureUnit;
    private JComboBox cboxDistanceSource, cboxDistanceDes, cboxWeightSource, cboxWeightDes, cboxVolumeSource, cboxVolumeDes, cboxTemperatureSource, cboxTemperatureDes;
    private JButton cmdDistanceConvert, cmdWeightConvert, cmdVolumeConvert, cmdTemperatureConvert;
    private objConvert convertObject;

    private JTabbedPane tabPane;
    private JPanel panDistanceRoot, panDistanceSource, panDistanceDes, panDistanceSourceUnit, panDistanceDesAnswer, panDistanceButton;
    private JPanel panWeightRoot, panWeightSource, panWeightDes, panWeightSourceUnit, panWeightDesAnswer, panWeightButton;
    private JPanel panVolumeRoot, panVolumeSource, panVolumeDes, panVolumeSourceUnit, panVolumeDesAnswer, panVolumeButton;
    private JPanel panTemperatureRoot, panTemperatureSource, panTemperatureDes, panTemperatureSourceUnit, panTemperatureDesAnswer, panTemperatureButton;
    private Color clrBackgrounds, clrForegrounds;

    private final Dimension convertArea = new Dimension(200, 100);
    private final TitledBorder borderConvertFrom = new TitledBorder(BorderFactory.createLineBorder(Color.black, 1), "Convert from", TitledBorder.CENTER, TitledBorder.CENTER);
    private final TitledBorder borderConvertTo = new TitledBorder(BorderFactory.createLineBorder(Color.black, 1), "Convert To", TitledBorder.CENTER, TitledBorder.CENTER);


    public static void main(String[] args) {

        JFrame.setDefaultLookAndFeelDecorated(true);

        JFrame frame = new JFrame("Metric Imperial Converter"); //Title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComponent paneMain = new Converter();
        paneMain.setOpaque(true);
        paneMain.setPreferredSize(new Dimension(440, 180));
        frame.setContentPane(paneMain);

        frame.pack();
        frame.setVisible(true);

    }

    public Converter() {

        super.setLayout(new BorderLayout());
        convertObject = new objConvert();

        cboxDistanceSource = new JComboBox(convertObject.getDistanceMenu()); //Gets the string array from objConvert to use as menu items
        cboxDistanceDes = new JComboBox(convertObject.getDistanceMenu());
        cboxWeightSource = new JComboBox(convertObject.getWeightMenu());
        cboxWeightDes = new JComboBox(convertObject.getWeightMenu());
        cboxVolumeSource = new JComboBox(convertObject.getVolumeMenu());
        cboxVolumeDes = new JComboBox(convertObject.getVolumeMenu());
        cboxTemperatureSource = new JComboBox(convertObject.getTemperatureMenu());
        cboxTemperatureDes = new JComboBox(convertObject.getTemperatureMenu());

        lblDistanceUnit = new JLabel("Unit: ");
        lblDistanceAnswer = new JLabel("Answer: ");
        lblWeightUnit = new JLabel("Unit: ");
        lblWeightAnswer = new JLabel("Answer: ");
        lblVolumeUnit = new JLabel("Unit: ");
        lblVolumeAnswer = new JLabel("Answer: ");
        lblTemperatureUnit = new JLabel("Unit: ");
        lblTemperatureAnswer = new JLabel("Answer: ");

        txtDistanceUnit = new JTextField("1.0", 4); //(caption, columns long);
        txtWeightUnit = new JTextField("1.0", 4);
        txtVolumeUnit = new JTextField("1.0", 4);
        txtTemperatureUnit = new JTextField("1.0", 4);

        txtDistanceUnit.addKeyListener(this);
        txtWeightUnit.addKeyListener(this);
        txtVolumeUnit.addKeyListener(this);
        txtTemperatureUnit.addKeyListener(this);

        cmdDistanceConvert = new JButton("Convert");
        cmdWeightConvert = new JButton("Convert");
        cmdVolumeConvert = new JButton("Convert");
        cmdTemperatureConvert = new JButton("Convert");

        cmdDistanceConvert.addActionListener(this);
        cmdWeightConvert.addActionListener(this);
        cmdVolumeConvert.addActionListener(this);
        cmdTemperatureConvert.addActionListener(this);

        tabPane = new JTabbedPane();

        panDistanceRoot = new JPanel(new BorderLayout());
        panDistanceSource = new JPanel(new BorderLayout());
        panDistanceDes = new JPanel(new BorderLayout());
        panDistanceSourceUnit = new JPanel();
        panDistanceDesAnswer = new JPanel();
        panDistanceButton = new JPanel();

        panWeightRoot = new JPanel(new BorderLayout());
        panWeightSource = new JPanel(new BorderLayout());
        panWeightDes = new JPanel(new BorderLayout());
        panWeightSourceUnit = new JPanel();
        panWeightDesAnswer = new JPanel();
        panWeightButton = new JPanel();

        panVolumeRoot = new JPanel(new BorderLayout());
        panVolumeSource = new JPanel(new BorderLayout());
        panVolumeDes = new JPanel(new BorderLayout());
        panVolumeSourceUnit = new JPanel();
        panVolumeDesAnswer = new JPanel();
        panVolumeButton = new JPanel();

        panTemperatureRoot = new JPanel(new BorderLayout());
        panTemperatureSource = new JPanel(new BorderLayout());
        panTemperatureDes = new JPanel(new BorderLayout());
        panTemperatureSourceUnit = new JPanel();
        panTemperatureDesAnswer = new JPanel();
        panTemperatureButton = new JPanel();


        add(tabPane);
        tabPane.addTab("Distance", panDistanceRoot);
        tabPane.addTab("Weight", panWeightRoot);
        tabPane.addTab("Volume", panVolumeRoot);
        tabPane.addTab("Temperature", panTemperatureRoot);

        //Start arranging panels
        panDistanceRoot.add(panDistanceSource, BorderLayout.WEST);
        panDistanceSource.add(cboxDistanceSource, BorderLayout.NORTH);
        panDistanceSource.add(panDistanceSourceUnit, BorderLayout.SOUTH);
        panDistanceSourceUnit.add(lblDistanceUnit);
        panDistanceSourceUnit.add(txtDistanceUnit);
        panDistanceRoot.add(panDistanceDes, BorderLayout.EAST);
        panDistanceDes.add(cboxDistanceDes, BorderLayout.NORTH);
        panDistanceDes.add(panDistanceDesAnswer, BorderLayout.SOUTH);
        panDistanceDesAnswer.add(lblDistanceAnswer);
        panDistanceRoot.add(panDistanceButton, BorderLayout.SOUTH);
        panDistanceButton.add(cmdDistanceConvert);

        panWeightRoot.add(panWeightSource, BorderLayout.WEST);
        panWeightSource.add(cboxWeightSource, BorderLayout.NORTH);
        panWeightSource.add(panWeightSourceUnit, BorderLayout.SOUTH);
        panWeightSourceUnit.add(lblWeightUnit);
        panWeightSourceUnit.add(txtWeightUnit);
        panWeightRoot.add(panWeightDes, BorderLayout.EAST);
        panWeightDes.add(cboxWeightDes, BorderLayout.NORTH);
        panWeightDes.add(panWeightDesAnswer, BorderLayout.SOUTH);
        panWeightDesAnswer.add(lblWeightAnswer);
        panWeightRoot.add(panWeightButton, BorderLayout.SOUTH);
        panWeightButton.add(cmdWeightConvert);

        panVolumeRoot.add(panVolumeSource, BorderLayout.WEST);
        panVolumeSource.add(cboxVolumeSource, BorderLayout.NORTH);
        panVolumeSource.add(panVolumeSourceUnit, BorderLayout.SOUTH);
        panVolumeSourceUnit.add(lblVolumeUnit);
        panVolumeSourceUnit.add(txtVolumeUnit);
        panVolumeRoot.add(panVolumeDes, BorderLayout.EAST);
        panVolumeDes.add(cboxVolumeDes, BorderLayout.NORTH);
        panVolumeDes.add(panVolumeDesAnswer, BorderLayout.SOUTH);
        panVolumeDesAnswer.add(lblVolumeAnswer);
        panVolumeRoot.add(panVolumeButton, BorderLayout.SOUTH);
        panVolumeButton.add(cmdVolumeConvert);

        panTemperatureRoot.add(panTemperatureSource, BorderLayout.WEST);
        panTemperatureSource.add(cboxTemperatureSource, BorderLayout.NORTH);
        panTemperatureSource.add(panTemperatureSourceUnit, BorderLayout.SOUTH);
        panTemperatureSourceUnit.add(lblTemperatureUnit);
        panTemperatureSourceUnit.add(txtTemperatureUnit);
        panTemperatureRoot.add(panTemperatureDes, BorderLayout.EAST);
        panTemperatureDes.add(cboxTemperatureDes, BorderLayout.NORTH);
        panTemperatureDes.add(panTemperatureDesAnswer, BorderLayout.SOUTH);
        panTemperatureDesAnswer.add(lblTemperatureAnswer);
        panTemperatureRoot.add(panTemperatureButton, BorderLayout.SOUTH);
        panTemperatureButton.add(cmdTemperatureConvert);
        //End arranging panels

        //Sets the preffered size of the convert boxes
        panDistanceSource.setPreferredSize(convertArea);
        panWeightSource.setPreferredSize(convertArea);
        panVolumeSource.setPreferredSize(convertArea);
        panTemperatureSource.setPreferredSize(convertArea);
        panDistanceDes.setPreferredSize(convertArea);
        panWeightDes.setPreferredSize(convertArea);
        panVolumeDes.setPreferredSize(convertArea);
        panTemperatureDes.setPreferredSize(convertArea);

        //Sets up the convert boxes
        panDistanceSource.setBorder(borderConvertFrom);
        panWeightSource.setBorder(borderConvertFrom);
        panVolumeSource.setBorder(borderConvertFrom);
        panTemperatureSource.setBorder(borderConvertFrom);
        panDistanceDes.setBorder(borderConvertTo);
        panWeightDes.setBorder(borderConvertTo);
        panVolumeDes.setBorder(borderConvertTo);
        panTemperatureDes.setBorder(borderConvertTo);

        //Creates empty space so components don't look clustered together
        panDistanceRoot.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        cboxDistanceSource.setBorder(BorderFactory.createEmptyBorder(1, 5, 1, 5));
        cboxDistanceDes.setBorder(BorderFactory.createEmptyBorder(1, 5, 1, 5));

        panWeightRoot.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        cboxWeightSource.setBorder(BorderFactory.createEmptyBorder(1, 5, 1, 5));
        cboxWeightDes.setBorder(BorderFactory.createEmptyBorder(1, 5, 1, 5));

        panVolumeRoot.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        cboxVolumeSource.setBorder(BorderFactory.createEmptyBorder(1, 5, 1, 5));
        cboxVolumeDes.setBorder(BorderFactory.createEmptyBorder(1, 5, 1, 5));

        panTemperatureRoot.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        cboxTemperatureSource.setBorder(BorderFactory.createEmptyBorder(1, 5, 1, 5));
        cboxTemperatureDes.setBorder(BorderFactory.createEmptyBorder(1, 5, 1, 5));

        clrBackgrounds = new Color(75, 141, 221); //Light blue
        setBackground(clrBackgrounds);

        clrBackgrounds = new Color(154, 156, 154); //Grey
        tabPane.setBackground(clrBackgrounds);

        clrBackgrounds = new Color(37, 103, 238); //Dark blue
        panDistanceRoot.setBackground(clrBackgrounds);
        panDistanceSource.setBackground(clrBackgrounds);
        panDistanceDes.setBackground(clrBackgrounds);
        panDistanceSourceUnit.setBackground(clrBackgrounds);
        panDistanceDesAnswer.setBackground(clrBackgrounds);
        panDistanceButton.setBackground(clrBackgrounds);
        lblDistanceUnit.setBackground(clrBackgrounds);
        lblDistanceAnswer.setBackground(clrBackgrounds);
        cboxDistanceSource.setBackground(clrBackgrounds);
        cboxDistanceDes.setBackground(clrBackgrounds);

        clrBackgrounds = new Color(37, 103, 238);
        panWeightRoot.setBackground(clrBackgrounds);
        panWeightSource.setBackground(clrBackgrounds);
        panWeightDes.setBackground(clrBackgrounds);
        panWeightSourceUnit.setBackground(clrBackgrounds);
        panWeightDesAnswer.setBackground(clrBackgrounds);
        panWeightButton.setBackground(clrBackgrounds);
        lblWeightUnit.setBackground(clrBackgrounds);
        lblWeightAnswer.setBackground(clrBackgrounds);
        cboxWeightSource.setBackground(clrBackgrounds);
        cboxWeightDes.setBackground(clrBackgrounds);

        clrBackgrounds = new Color(37, 103, 238);
        panVolumeRoot.setBackground(clrBackgrounds);
        panVolumeSource.setBackground(clrBackgrounds);
        panVolumeDes.setBackground(clrBackgrounds);
        panVolumeSourceUnit.setBackground(clrBackgrounds);
        panVolumeDesAnswer.setBackground(clrBackgrounds);
        panVolumeButton.setBackground(clrBackgrounds);
        lblVolumeUnit.setBackground(clrBackgrounds);
        lblVolumeAnswer.setBackground(clrBackgrounds);
        cboxVolumeSource.setBackground(clrBackgrounds);
        cboxVolumeDes.setBackground(clrBackgrounds);

        clrBackgrounds = new Color(37, 103, 238); //Dark blue
        panTemperatureRoot.setBackground(clrBackgrounds);
        panTemperatureSource.setBackground(clrBackgrounds);
        panTemperatureDes.setBackground(clrBackgrounds);
        panTemperatureSourceUnit.setBackground(clrBackgrounds);
        panTemperatureDesAnswer.setBackground(clrBackgrounds);
        panTemperatureButton.setBackground(clrBackgrounds);
        lblTemperatureUnit.setBackground(clrBackgrounds);
        lblTemperatureAnswer.setBackground(clrBackgrounds);
        cboxTemperatureSource.setBackground(clrBackgrounds);
        cboxTemperatureDes.setBackground(clrBackgrounds);

        clrForegrounds = new Color(255, 255, 255);
        lblDistanceUnit.setForeground(clrForegrounds);
        lblDistanceAnswer.setForeground(clrForegrounds);
        cboxDistanceSource.setForeground(clrForegrounds);
        cboxDistanceDes.setForeground(clrForegrounds);

        lblWeightUnit.setForeground(clrForegrounds);
        lblWeightAnswer.setForeground(clrForegrounds);
        cboxWeightSource.setForeground(clrForegrounds);
        cboxWeightDes.setForeground(clrForegrounds);

        lblVolumeUnit.setForeground(clrForegrounds);
        lblVolumeAnswer.setForeground(clrForegrounds);
        cboxVolumeSource.setForeground(clrForegrounds);
        cboxVolumeDes.setForeground(clrForegrounds);

        lblTemperatureUnit.setForeground(clrForegrounds);
        lblTemperatureAnswer.setForeground(clrForegrounds);
        cboxTemperatureSource.setForeground(clrForegrounds);
        cboxTemperatureDes.setForeground(clrForegrounds);

    }

    public void actionPerformed(ActionEvent e) {

        int sourceIndex = 0, desIndex = 0;
        double unit = 0.0;

        if (e.getSource() == cmdDistanceConvert) {

            sourceIndex = cboxDistanceSource.getSelectedIndex();
            desIndex = cboxDistanceDes.getSelectedIndex();
            unit = Double.parseDouble(txtDistanceUnit.getText());

            lblDistanceAnswer.setText(convertObject.convertDistance(sourceIndex, desIndex, unit));

        } else if (e.getSource() == cmdWeightConvert) {

            sourceIndex = cboxWeightSource.getSelectedIndex();
            desIndex = cboxWeightDes.getSelectedIndex();
            unit = Double.parseDouble(txtWeightUnit.getText());

            lblWeightAnswer.setText(convertObject.convertWeight(sourceIndex, desIndex, unit));

        } else if (e.getSource() == cmdVolumeConvert) {

            sourceIndex = cboxVolumeSource.getSelectedIndex();
            desIndex = cboxVolumeDes.getSelectedIndex();
            unit = Double.parseDouble(txtVolumeUnit.getText());

            lblVolumeAnswer.setText(convertObject.convertVolume(sourceIndex, desIndex, unit));

        } else if (e.getSource() == cmdTemperatureConvert) {

            sourceIndex = cboxTemperatureSource.getSelectedIndex();
            desIndex = cboxTemperatureDes.getSelectedIndex();
            unit = Double.parseDouble(txtTemperatureUnit.getText());

            lblTemperatureAnswer.setText(convertObject.convertTemperature(sourceIndex, desIndex, unit));

        }

    }

    public void keyTyped(KeyEvent e) {

        char c = e.getKeyChar();
        boolean removeKey = false;
        String strBuffer = "";

        if (e.getSource() == txtDistanceUnit) {
            strBuffer = txtDistanceUnit.getText();
        } else if (e.getSource() == txtWeightUnit) {
            strBuffer = txtWeightUnit.getText();
        } else if (e.getSource() == txtVolumeUnit) {
            strBuffer = txtVolumeUnit.getText();
        } else if (e.getSource() == txtTemperatureUnit) {
            strBuffer = txtTemperatureUnit.getText();
        }

        if (c == ' ') {
            removeKey = true;
        } else if (strBuffer.indexOf('.') != -1 && c == '.') {
            removeKey = true;
        } else if (!((Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == '.'))) {
            removeKey = true;
        }

        if (removeKey) {
            e.consume();
        }

    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

}
