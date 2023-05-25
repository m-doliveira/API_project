import java.awt.*;
import java.awt.event.*;
import java.awt.image.BaseMultiResolutionImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main  {
    //^add "implements ActionListener"
    private JFrame mainFrame;
    private JLabel headerLabel;
    public JTextArea ta;
    public JButton next;
    public JButton back;
    public JLabel pic;
    private int W=1000;
    private int H=700;
    public String goal;
    Main run=new Main();



    public static void main(String[] args) {
        Main myMain = new Main();
        myMain.prepareGUI();
        myMain.showEventDemo();
        try {
            myMain.pull();
        } catch (ParseException x) {
            System.out.println("it did not work");
        }
    }
    private void prepareGUI(){
        mainFrame=new JFrame("pokedex");
        mainFrame.setSize(W,H);
        mainFrame.setLayout(new BorderLayout());
       // mainFrame.setVisible(true);

    }


    private void showEventDemo(){
        goal="/ditto";
    ta = new JTextArea();
    back = new JButton("back");
    back.setActionCommand("to charmander");
    next = new JButton("next");
    next.setActionCommand("to pikachu");
    pic = new JLabel(new ImageIcon("ditto.jpeg"));

    //mainFrame.add(headerLabel, BorderLayout.NORTH);
    mainFrame.add(ta, BorderLayout.CENTER);
    mainFrame.add(back, BorderLayout.WEST);
    mainFrame.add(next, BorderLayout.EAST);
    mainFrame.add(pic, BorderLayout.NORTH);
    mainFrame.setVisible(true);

    }
    private void showEventDemo2(){
        goal="/pikachu";
        ta = new JTextArea();
        back = new JButton("back");
        back.setActionCommand("to ditto");
        next = new JButton("next");
        next.setActionCommand("to squirtle");
        pic = new JLabel(new ImageIcon("pikachu.jpeg"));

        //mainFrame.add(headerLabel, BorderLayout.NORTH);
        mainFrame.add(ta, BorderLayout.CENTER);
        mainFrame.add(back, BorderLayout.WEST);
        mainFrame.add(next, BorderLayout.EAST);
        mainFrame.add(pic, BorderLayout.NORTH);
        mainFrame.setVisible(true);

    }
    private void showEventDemo3(){
        goal="/squirtle";
        ta = new JTextArea();
        back = new JButton("back");
        back.setActionCommand("to pikachu");
        next = new JButton("next");
        next.setActionCommand("to charmander");
        pic = new JLabel(new ImageIcon("squirtle.jpeg"));

        //mainFrame.add(headerLabel, BorderLayout.NORTH);
        mainFrame.add(ta, BorderLayout.CENTER);
        mainFrame.add(back, BorderLayout.WEST);
        mainFrame.add(next, BorderLayout.EAST);
        mainFrame.add(pic, BorderLayout.NORTH);
        mainFrame.setVisible(true);

    }
    private void showEventDemo4(){
        goal="/charmander";
        ta = new JTextArea();
        back = new JButton("back");
        back.setActionCommand("to squirtle");
        next = new JButton("next");
        next.setActionCommand("to ditto");
        pic = new JLabel(new ImageIcon("charmander.jpeg"));

        //mainFrame.add(headerLabel, BorderLayout.NORTH);
        mainFrame.add(ta, BorderLayout.CENTER);
        mainFrame.add(back, BorderLayout.WEST);
        mainFrame.add(next, BorderLayout.EAST);
        mainFrame.add(pic, BorderLayout.NORTH);
        mainFrame.setVisible(true);

    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

         if (command.equals("to ditto")) {
             run.showEventDemo();
        }
            if (command.equals("to pikachu")) {
               // run.showEventDemo2();
            }
            if (command.equals("to squirtle")) {
              //  run.showEventDemo3();
            }
            if (command.equals("to charmander")) {
                //  run.showEventDemo4();
            }
    }


        public  void pull() throws ParseException {
            String output = "abc";
            String totalJson="";
            try {

                URL url = new URL("https://pokeapi.co/api/v2/pokemon"+ goal);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/json");


                if (conn.getResponseCode() != 200) {

                    throw new RuntimeException("Failed : HTTP error code : "
                            + conn.getResponseCode());
                }

                BufferedReader br = new BufferedReader(new InputStreamReader(
                        (conn.getInputStream())));


                System.out.println("Output from Server .... \n");
                while ((output = br.readLine()) != null) {
                    System.out.println(output);
                    totalJson+=output;
                }

                conn.disconnect();

            } catch (MalformedURLException e) {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            }

            JSONParser parser = new JSONParser();
            //System.out.println(str);
            org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) parser.parse(totalJson);
            System.out.println("hey"+jsonObject);

            try {
                ta.append((String) jsonObject.get("name"));
                ta.append(": ");
                org.json.simple.JSONArray msg = (org.json.simple.JSONArray) jsonObject.get("abilities");
                int n =   msg.size(); //(msg).length();
                for (int i = 0; i < n; ++i) {
                    org.json.simple.JSONObject test =(org.json.simple.JSONObject) msg.get(i);
                    org.json.simple.JSONObject test2 =(org.json.simple.JSONObject) test.get("ability");
                    String abilityName = (String) test2.get("name");
                    System.out.println(abilityName);
                    ta.append( abilityName +", ");
                    //System.out.println(test);
                    //tb.append(String.valueOf(test));
                    // System.out.println(person.getInt("key"));
                }
                long height= (long)jsonObject.get("height");
                System.out.println("height: "+height);
                ta.append(" height= "+ height);
            }

            catch (Exception e) {
                e.printStackTrace();
            }




        }
    }}

