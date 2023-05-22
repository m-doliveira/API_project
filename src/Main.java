import java.awt.*;
import java.awt.event.*;
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
    private JTextArea tb;
    private JPanel info;
    private JTextArea tc;
    private JTextArea td;
    private JPanel abilities;
    private JTextArea description;
    private int W=1000;
    private int H=700;
    public String goal;
    public JButton toD;


    public static void main(String[] args) {
        Main myMain=new Main();
        myMain.prepareGUI();
        myMain.showEventDemo();
        try {
            myMain.pull();
        }catch(ParseException x ){
            System.out.println("it did not work");
        }
    }
    private void prepareGUI(){
        mainFrame=new JFrame("pokedex");
        mainFrame.setSize(W,H);
        mainFrame.setLayout(new GridLayout(4,1));
       // mainFrame.setVisible(true);

    }


    private void showEventDemo(){
    headerLabel = new JLabel(" enter name");
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
    toD = new JButton("back");
    toD.setActionCommand("to ditto");


    mainFrame.add(headerLabel);
    mainFrame.add(info);
    mainFrame.add(abilities);
    mainFrame.add(description);
    mainFrame.setVisible(true);
    goal = ta.toString();
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

         if (command.equals("to ditto")) {
            // URL url = new URL("https://pokeapi.co/api/v2/pokemon/ditto");
             //myMain.showEventDemo();
             }
//            } else if (command.equals("to pika")) {
//                statusLabel.setText("Submit Button clicked.");
//            } else {
//                statusLabel.setText("Cancel Button clicked.");
//            }
        }
    }

        public  void pull() throws ParseException {
            String output = "abc";
            String totalJson="";
            String goal ="/ditto";
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
                System.out.println(jsonObject.get("name"));

                org.json.simple.JSONArray msg = (org.json.simple.JSONArray) jsonObject.get("abilities");
                int n =   msg.size(); //(msg).length();
                for (int i = 0; i < n; ++i) {
                    org.json.simple.JSONObject test =(org.json.simple.JSONObject) msg.get(i);
                    org.json.simple.JSONObject test2 =(org.json.simple.JSONObject) test.get("ability");
                    String abilityName = (String) test2.get("name");
                    System.out.println(abilityName);
                    ta.append(abilityName +", ");
                    //System.out.println(test);
                    //tb.append(String.valueOf(test));
                    // System.out.println(person.getInt("key"));
                }
                long height= (long)jsonObject.get("height");
                System.out.println("height: "+height);
                tc.append("height: "+ height);
            }

            catch (Exception e) {
                e.printStackTrace();
            }




        }
    }

