package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Reader {

    public static <T> List<T> readFromCSV(String filePath, Function<String[], T> mapper) {
        List<T> dataList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                T dataObject = mapper.apply(data);
                dataList.add(dataObject);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataList;
    }
}
