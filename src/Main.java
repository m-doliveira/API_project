import java.awt.*;
import java.awt.event.*;
import java.awt.image.BaseMultiResolutionImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.awt.image.BufferedImage;

import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import javax.imageio.ImageIO;


public class Main {
    //^add "implements ActionListener"
    private JFrame mainFrame;
    private JLabel headerLabel;
    public JTextArea ta;
    public JTextArea tb;
    public JTextArea tc;
    public JButton next;
    public JButton back;
    public JLabel pic;
    private int W = 1000;
    private int H = 700;
    public String goal;


    public static void main(String[] args) {
        Main myMain = new Main();
        myMain.prepareGUI();
        // myMain.showEventDemo();
        try {
            myMain.pull();
        } catch (ParseException x) {
            System.out.println("it did not work");
        }
    }

    private void prepareGUI() {
        mainFrame = new JFrame("pokedex");
        mainFrame.setSize(W, H);
        mainFrame.setLayout(new BorderLayout());
        // mainFrame.setVisible(true);

    }


    private void showEventDemo() {
        goal = "/ditto";
        try {
            pull();
        } catch (ParseException x) {
            System.out.println("it did not work");
        }
        ta = new JTextArea();
        tb = new JTextArea();
        tc = new JTextArea();
        back = new JButton("back");
        back.setActionCommand("to charmander");
        next = new JButton("next");
        next.setActionCommand("to pikachu");
        back.addActionListener(new ButtonClickListener());
        next.addActionListener(new ButtonClickListener());
        pic = new JLabel(new ImageIcon("ditto.jpeg"));

        //mainFrame.add(headerLabel, BorderLayout.NORTH);
        mainFrame.add(ta, BorderLayout.CENTER);
        mainFrame.add(back, BorderLayout.WEST);
        mainFrame.add(next, BorderLayout.EAST);
        mainFrame.add(pic, BorderLayout.NORTH);
        mainFrame.setVisible(true);


    }

    private void showEventDemo2() {
        goal = "/pikachu";
        try {
            pull();
        } catch (ParseException x) {
            System.out.println("it did not work");
        }
        ta = new JTextArea();
        back = new JButton("back");
        back.setActionCommand("to ditto");
        next = new JButton("next");
        next.setActionCommand("to squirtle");
        pic = new JLabel(new ImageIcon("pikachu.jpeg"));
        back.addActionListener(new ButtonClickListener());
        next.addActionListener(new ButtonClickListener());

        //mainFrame.add(headerLabel, BorderLayout.NORTH);
        mainFrame.add(ta, BorderLayout.CENTER);
        mainFrame.add(back, BorderLayout.WEST);
        mainFrame.add(next, BorderLayout.EAST);
        mainFrame.add(pic, BorderLayout.NORTH);
        mainFrame.setVisible(true);

    }

    public  void pull() throws ParseException {
        String output = "abc";
        String totalJson="";
        try {

            URL url = new URL("https://themealdb.com/api/json/v1/1/random.php/images/media/meals/llcbn01574260722.jpg/preview");
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
        System.out.println(jsonObject);

        try {
          //  ta.append((String) jsonObject.get("meals"));
            //ta.append(": ");
            org.json.simple.JSONArray msg = (org.json.simple.JSONArray) jsonObject.get("meals");

            int n =   msg.size();
            for (int i = 0; i < n; ++i) {
                System.out.println(msg.get(i));
                org.json.simple.JSONObject test =(org.json.simple.JSONObject) msg.get(i);
                String mealNum = (String) test.get("idMeal");
                String name = (String) test.get("strMeal");
                String cuisine =(String) test.get("strArea");
                String steps =(String) test.get("strInstructions");
                String I_1 =(String) test.get("strIngredient1");
                String I_2 =(String) test.get("strIngredient2");
                String I_3 =(String) test.get("strIngredient3");
                String I_4 =(String) test.get("strIngredient4");
                String I_5 =(String) test.get("strIngredient5");
                String I_6 =(String) test.get("strIngredient6");
                String I_7 =(String) test.get("strIngredient7");
                String I_8 =(String) test.get("strIngredient8");
                String I_9 =(String) test.get("strIngredient9");
                String I_10 =(String) test.get("strIngredient10");
                String I_11 =(String) test.get("strIngredient11");
                String I_12 =(String) test.get("strIngredient12");
                String I_13 =(String) test.get("strIngredient13");
                String I_14 =(String) test.get("strIngredient14");
                String I_15 =(String) test.get("strIngredient15");
                String I_16 =(String) test.get("strIngredient16");
                String I_17 =(String) test.get("strIngredient17");
                String I_18 =(String) test.get("strIngredient18");
                String I_19 =(String) test.get("strIngredient19");
                String I_20 =(String) test.get("strIngredient20");
                String M_20 =(String) test.get("strMeasure1");//20 of these and they correspond with ingredients by number




                String image =(String) test.get("strMealThumb");
                String path = image;
                URL url = new URL(path);
                BufferedImage image2 = ImageIO.read(url);
                JLabel label = new JLabel(new ImageIcon(image2));

                mainFrame.add(label);
                mainFrame.setVisible(true);

                System.out.println(mealNum);
                System.out.println(name);
                System.out.println(cuisine);
                System.out.println(steps);
                System.out.println(I_1);
               // ta.append( mealNum+", ");
                //System.out.println(test);
                //tb.append(String.valueOf(test));
                // System.out.println(person.getInt("key"));

            }

        }

        catch (Exception e) {
            e.printStackTrace();
        }




    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

         if (command.equals("refresh")) {

             ta.append(" ");
             try {
                 pull();
                 showEventDemo();
             } catch (ParseException parseException) {
                 parseException.printStackTrace();
             }
         }
            if (command.equals("expand")) {
                ta.append(" ");
               showEventDemo2();
            }


    }}}

