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
    private JFrame secondFrame;
    private JLabel headerLabel;
    public JTextArea ta;
    public JTextArea tb;
    public JTextArea tc;
    public JButton next;
    public JButton back;
    public JLabel label;
    private int W = 1000;
    private int H = 700;
    public String goal;


    public static void main(String[] args) {
        Main myMain = new Main();
        myMain.prepareGUI();
        myMain.showEventDemo();
//        try {
//            myMain.pull();
//        } catch (ParseException x) {
//            System.out.println("it did not work");
//        }
    }

    private void prepareGUI() {
        mainFrame = new JFrame("what's for dinner");
        mainFrame.setSize(W, H);
        mainFrame.setLayout(new BorderLayout());

        secondFrame = new JFrame("what's for dinner");
        secondFrame.setSize(W, H);
        secondFrame.setLayout(new GridLayout(1,4));
        // mainFrame.setVisible(true);

    }


    private void showEventDemo() {
        try {
            pull();
        } catch (ParseException x) {
            System.out.println("it did not work");
        }
        ta = new JTextArea();
        label = new JLabel();
        tb = new JTextArea();
        tc = new JTextArea();
        back = new JButton("something else");
        back.setActionCommand("refresh");
        next = new JButton("this one!");
        next.setActionCommand("expand");
        back.addActionListener(new ButtonClickListener());
        next.addActionListener(new ButtonClickListener());

        //mainFrame.add(headerLabel, BorderLayout.NORTH);
        mainFrame.add(ta, BorderLayout.NORTH);
        mainFrame.add(back, BorderLayout.WEST);
        mainFrame.add(next, BorderLayout.EAST);


        mainFrame.setVisible(true);


    }

    private void showEventDemo2() {
//        ta = new JTextArea();
//        tb = new JTextArea();
//        tc = new JTextArea();
        secondFrame.add(ta);
        secondFrame.add(tb);
        secondFrame.add(tc);
        secondFrame.setVisible(true);

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
       // System.out.println(jsonObject);

        try {
          //  ta.append((String) jsonObject.get("meals"));
            //ta.append(": ");
            org.json.simple.JSONArray msg = (org.json.simple.JSONArray) jsonObject.get("meals");

            int n =   msg.size();
            for (int i = 0; i < n; ++i) {
                //System.out.println(msg.get(i));
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
                String M_1 =(String) test.get("strMeasure1");
                String M_2 =(String) test.get("strMeasure2");
                String M_3 =(String) test.get("strMeasure3");
                String M_4 =(String) test.get("strMeasure4");
                String M_5 =(String) test.get("strMeasure5");
                String M_6 =(String) test.get("strMeasure6");
                String M_7 =(String) test.get("strMeasure7");
                String M_8 =(String) test.get("strMeasure8");
                String M_9 =(String) test.get("strMeasure9");
                String M_10 =(String) test.get("strMeasure10");
                String M_11 =(String) test.get("strMeasure11");
                String M_12 =(String) test.get("strMeasure12");
                String M_13 =(String) test.get("strMeasure13");
                String M_14 =(String) test.get("strMeasure14");
                String M_15 =(String) test.get("strMeasure15");
                String M_16 =(String) test.get("strMeasure16");
                String M_17 =(String) test.get("strMeasure17");
                String M_18 =(String) test.get("strMeasure18");
                String M_19 =(String) test.get("strMeasure19");
                String M_20 =(String) test.get("strMeasure20");





                String image =(String) test.get("strMealThumb");
                String path = image;
                URL url = new URL(path);
                BufferedImage image2 = ImageIO.read(url);
                JLabel label = new JLabel(new ImageIcon(image2));
                JLabel label2 = new JLabel(new ImageIcon(image2));

                 mainFrame.add(label, BorderLayout.CENTER);
                 secondFrame.add(label2);

                ta = new JTextArea();
                tb = new JTextArea();
                tc = new JTextArea();


                System.out.println("meal id: "+mealNum);
                System.out.println("dish name: "+name);
                System.out.println("type of cusine: "+cuisine);
                System.out.println("Ingredients:");
                System.out.println(I_1+": "+M_1);
                System.out.println(I_2+": "+M_2);
                System.out.println(I_3+": "+M_3);
                System.out.println(I_4+": "+M_4);
                System.out.println(I_5+": "+M_5);
                System.out.println(I_6+": "+M_6);
                System.out.println(I_7+": "+M_7);
                System.out.println(I_8+": "+M_8);
                System.out.println(I_9+": "+M_9);
                System.out.println(I_10+": "+M_10);
                System.out.println(I_11+": "+M_11);
                System.out.println(I_12+": "+M_12);
                System.out.println(I_13+": "+M_13);
                System.out.println(I_14+": "+M_14);
                System.out.println(I_15+": "+M_15);
                System.out.println(I_16+": "+M_16);
                System.out.println(I_17+": "+M_17);
                System.out.println(I_18+": "+M_18);
                System.out.println(I_19+": "+M_19);
                System.out.println(I_20+": "+M_20);
                System.out.println("instructions: "+steps);
               ta.append("Recipe number "+ mealNum+": "+name);
               tc.append("instructions:"+steps);
               tb.append(I_1+M_1);
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

             mainFrame.remove(ta);
             mainFrame.remove(back);
             mainFrame.remove(next);
             mainFrame.remove(label);

             showEventDemo();

         }
            if (command.equals("expand")) {
                ta.append(" ");
                mainFrame.setVisible(false);
                secondFrame.setVisible(true);
               showEventDemo2();
            }


    }}}

