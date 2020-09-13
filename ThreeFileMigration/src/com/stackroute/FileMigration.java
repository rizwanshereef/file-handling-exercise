package com.stackroute;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileMigration {
    /*FileMigration class which migrates the content of 1 file to another*/
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the source and destination file");
        String inp = scan.nextLine();

        /*Splitting the string to source and destination*/
        String source = inp.substring(0, inp.indexOf(","));
        String destination = inp.substring(inp.indexOf(",") + 2, inp.length());
        String comp = "null";

        /*Handle exception if destination is null or empty space*/
        if (!destination.equals(comp) && !destination.equals(" ")) {

            String out = fileContentDuplicator(source, destination);
            if (out != null) {
                System.out.println(out);
            }

        } else {
            throw new NullPointerException("Given fileName to read or write is empty, null or blank space");
        }

    }

    /*Method to copy contents of one string to another using Buffer reader and writer*/
    public static String fileContentDuplicator(String source, String destination) throws IOException {
        String out = null;
        try {
            BufferedReader bufferRead = new BufferedReader(new FileReader(source));
            BufferedWriter bufferWrite = new BufferedWriter(new FileWriter(destination));
            int i;
            do {
                i = bufferRead.read();
                if (i != -1) {
                    bufferWrite.write((char) i);
                }
            } while (i != -1);
            bufferRead.close();
            bufferWrite.close();

            /*Contents of file to string*/
            out = new String(Files.readAllBytes(Paths.get(source)));

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (NoSuchFileException e) {
            System.out.println("File not found!");
        }

        return out;
    }

}

/*User-defined exception to handle null or empty space*/
class NullHandler extends Exception {
    public NullHandler(String msg) {
        super(msg);
    }
}