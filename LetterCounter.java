
//Letter Frequency Calculator
//Credit: Ryder Selikow, Max Reed

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;


public class LetterCounter {

    public static void main(String[] args) {
        StdDraw.setTitle("Letter Counter");
        StdDraw.setPenRadius(0.01);
        String[] filenames = {"src/book"}; //Input File
        double pos = -1;
        //Todo Rename variables to something that makes more logical sense
        int i;
        int j;

        ArrayList<String> lines = new ArrayList<String>();
        ArrayList<Double> freq_list = new ArrayList<Double>(); //Create array to store frequency values (allows us to find highest frequency later down the line)
        int k = 0;

        //Read File
        double count = 0;
        char ch;
        try {
            File TextObj = new File("src/book");
            Scanner myReader = new Scanner(TextObj);
            while (myReader.hasNextLine()) { //Iterate through each line of text
                lines.add(myReader.nextLine()); //Adds each line to Lines arraylist

            }
            myReader.close();
        } catch (FileNotFoundException error) {
            System.out.println("ERROR!!!"); //Error Handling

        }



            String input_text = lines.toString();

            //Format input_text / remove unwanted characters
            //TODO Find more efficient way to do this
            input_text = input_text.replace(" ", "");
            input_text = input_text.replace(".", "");
            input_text = input_text.replace(",", "");
            input_text = input_text.replace(";", "");
            input_text = input_text.replace("-", "");
            input_text = input_text.replace("'", "");
            input_text = input_text.replace("]", "");
            input_text = input_text.replace("[", "");
            input_text = input_text.toLowerCase();

           // System.out.println(input_text);

            char charArray[] = input_text.toCharArray(); //convert to CharArray to sort alphabetically
            Arrays.sort(charArray);
            System.out.println(charArray);



            input_text = new String(charArray);
            System.out.println(input_text);



            double length = input_text.length();
            System.out.println("length:" + length);
            double length_scaled = length/1000;
            //System.out.println(length_scaled);
            // System.out.println(input_text.length());
            // System.out.println(input_text);

        //Scaler
        double scaler = 1.1*length_scaled;
        double x1 = -5;
        double y1 = 27;
        double x2 = -0.1;
        double y2 = 1.1;
        StdDraw.setXscale(x1, y1);
        StdDraw.setYscale(x2*scaler, y2*scaler);





        //Count frequency of letters

            for (i = 0; i < length; i++) {
                    ch = input_text.charAt(i);
                    if (input_text.indexOf(ch) < i)
                        continue;
                    for (j = 0; j < length; j++) {
                        if (input_text.charAt(j) == ch)
                            count++;
                    }
                    System.out.println(ch + " freq: " + count);
                    freq_list.add(count);


                    //Draw Graph in loop
                    StdDraw.setPenColor(StdDraw.RED);
                    //StdDraw.line(pos, 0.05, pos, count / 100);
                    double count_scaled  = (count/100);
                    StdDraw.filledRectangle(pos, count_scaled/2, 0.2, count_scaled/2);
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.setPenColor();
                    StdDraw.setPenRadius(0.003);
                    StdDraw.rectangle(pos, count_scaled/2, 0.23, count_scaled/2);
                    Integer count_int = ((int)count);    //Convert Count from Double to Integer to get rid of decimal (save space on graph)
                    String count_str = Integer.toString(count_int);
                    //StdDraw.text(pos, count/100 + 0.1, count_str);
                    System.out.println(count / 100);
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.text(pos, -0.05, Character.toString(ch)); //Draw Y axis labels (letters)


                pos = pos + 1; //Space out each Graph line evenly
                    count = 0; //Reset count (3 hrs of troubleshooting for this simple line to be the solution)




                }  //End of Loop
        Collections.sort(freq_list);
        double largest_num = freq_list.get(freq_list.size() - 1);
        int largest_num_int = (int)largest_num;
        //Box
        StdDraw.line(-2.9,0,24,0);
        StdDraw.line(-2.9,0,-2.9,largest_num/100);
        StdDraw.line(-2.9,largest_num/100,24,largest_num/100);
        StdDraw.line(24,0,24,largest_num/100);
        StdOut.println(largest_num);
        StdDraw.text(10,largest_num/100 - 0.03, "Letter Distribution");
        StdDraw.text(-3.5, largest_num/100, Double.toString(largest_num_int));
        StdDraw.text(-3.5, 0, "0");
        }
    }







