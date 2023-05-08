import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main  {
    //^add "implements ActionListener"
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JTextArea ta;
    private JTextArea tb;
    private JPanel info;
    private JTextArea tc;
    private JTextArea td;
    private JPanel abilities;
    private JTextArea description;
    private int W=1000;
    private int H=700;


    public static void main(String[] args) {
        Main myMain=new Main();
        myMain.prepareGUI();
        myMain.showEventDemo();
    }
    private void prepareGUI(){
        mainFrame=new JFrame("pokedex");
        mainFrame.setSize(W,H);
        mainFrame.setLayout(new GridLayout(4,1));
       // mainFrame.setVisible(true);
    }
    private void showEventDemo(){
    headerLabel = new JLabel("name");
    ta = new JTextArea();
    tb = new JTextArea();
    info = new JPanel(new GridLayout(1,2));
    info.add(ta);
    info.add(tb);
    tc = new JTextArea();
    td = new JTextArea();
    abilities = new JPanel(new GridLayout(1,2));
    abilities.add(tc);
    abilities.add(td);
    description= new JTextArea();

    mainFrame.add(headerLabel);
    mainFrame.add(info);
    mainFrame.add(abilities);
    mainFrame.add(description);
    mainFrame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

//            if (command.equals("OK")) {
//                statusLabel.setText("Ok Button clicked.");
//            } else if (command.equals("Submit")) {
//                statusLabel.setText("Submit Button clicked.");
//            } else {
//                statusLabel.setText("Cancel Button clicked.");
//            }
        }
    }
}
