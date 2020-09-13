package com.stackroute;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/*Main class to append the text to the file*/
public class fileEdition {

    public static void main(String[] args) throws IOException {
        String fileName, input, value;
        Scanner scan = new Scanner(System.in);
        /*Get user input for filename and text*/
        System.out.println("Enter the file and input separated by comma:");
        input = scan.nextLine();
        /*Add exception if file or value is not entered*/
        try {
            fileName = input.substring(0, input.indexOf(","));
            value = input.substring(input.indexOf(",") + 1, input.length());

            String finalValu = fileEditor(fileName, value);
            if (finalValu != null) {
                System.out.println(finalValu);
            }


        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Enter file name and value properly!");
        }

    }

    /*Method to check if the file exist and append the value if found*/
    public static String fileEditor(String fileName, String value) {
        File file = new File(fileName);
        FileOutputStream fileOut = null;
        FileInputStream inputFile;
        String output = null;

        try {
            inputFile = new FileInputStream(file);
            int c = inputFile.read();
            fileOut = new FileOutputStream(file, true);

            /*Append the value to the file*/
            fileOut.write(value.getBytes());

            /*Convert the content file to string*/
            output = new String(Files.readAllBytes(Paths.get(fileName)));

            inputFile.close();
            fileOut.close();

        } catch (FileNotFoundException e) {
            System.out.println("File '" + fileName + "' not found");
        } catch (IOException e) {
            System.out.println("IO exception ");
        }

        return output;
    }
}
