package com.stackroute;

import java.io.*;
import java.util.*;

/*Main class to remove duplicate lines from file to another file*/
public class RemoveDuplicateLines {

    public static void main(String[] args) {
        removeDuplicateLines();
    }

    /*Main method to removeeDuplicateLines from the file and copy to another file*/
    public static void removeDuplicateLines() {
        Set<String> sortedset = new HashSet<>();
        FileInputStream fileinp = null;
        BufferedReader reader = null;
        try {
            fileinp = new FileInputStream("input.txt");
            reader = new BufferedReader(new InputStreamReader(fileinp));
            PrintWriter writer = new PrintWriter(new FileOutputStream("output.txt"));
            /*Adding each line to Hashset for sorting*/
            System.out.println("Input.txt:");
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                sortedset.add(line);
                line = reader.readLine();
            }
            /*Convert HashSet to ArryaList then add to file*/
            List<String> list = new ArrayList<>(sortedset);
            System.out.println("\noutput.txt:");
            for (String set : list) {
                System.out.println(set);
                writer.println(set);
            }
            writer.close();
            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Input file not found!");
        } catch (IOException e) {
            System.out.println("IO Exception!");
        }
    }
}
