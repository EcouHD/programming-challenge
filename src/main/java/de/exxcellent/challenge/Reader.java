package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public static void readFromCSV(String filePath) {

       try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
           String line;
           int minSpread = Integer.MAX_VALUE;
           int minSpreadDay = -1;
           br.readLine();

           while((line = br.readLine()) != null)  {
               String[] weatherData = line.split(",");
               int day = Integer.parseInt(weatherData[0]);
               int spread = Integer.parseInt(weatherData[1]) - Integer.parseInt(weatherData[2]);

               if (minSpread > spread) {
                   minSpread = spread;
                   minSpreadDay = day;
               }
           }
           System.out.printf("Day with smallest temperature spread : %d%n", minSpreadDay);

       } catch (IOException e) {
           e.printStackTrace();
       }
    }
}
