package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngine {
    public static void main(String[] args) {

        boolean running = false;

        Scanner myObj = new Scanner(System.in);

        try {
            FileWriter fileWriter = new FileWriter("logs.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            LocalDateTime dayTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-dd-MMM HH:mm:ss ");
            String formatted = dayTime.format(formatter);

            bufferedWriter.write(formatted + " launch\n");

            while(!running) {

                System.out.print("\nEnter a search term (x to exit): ");
                String userInput = myObj.nextLine();

                if (userInput.equalsIgnoreCase("x")) {
                    bufferedWriter.write(formatted + " exit" );
                    running = true;
                    bufferedWriter.flush();

                    System.exit(0);
                }

                bufferedWriter.write(formatted + " search :" + userInput);
                bufferedWriter.newLine();
                bufferedWriter.flush();

            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
