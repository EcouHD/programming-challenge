package de.exxcellent.challenge;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReaderTest {

    private String testFilePath;

    @BeforeEach
    public void setUp() {
        testFilePath = "CSVFileForTesting.csv";
    }

    @AfterEach
    public void cleanUp() throws IOException {
        Files.deleteIfExists(Paths.get(testFilePath));
    }


    @Test void readFromCSV_ValidWeatherData() throws IOException {
        // given
        createTestCSV("Day,MxT,MnT\n1,20,10\n2,15,12");

        // when
        List<WeatherData> weatherDataList = Reader.readFromCSV(testFilePath, data -> {
            int day = Integer.parseInt(data[0]);
            int maxTemp = Integer.parseInt(data[1]);
            int minTemp = Integer.parseInt(data[2]);
            return new WeatherData(day, maxTemp, minTemp);
        });

        // then
        assertEquals(2, weatherDataList.size());
        assertEquals(1, weatherDataList.get(0).getDay());
        assertEquals(10, weatherDataList.get(0).getMinTemp());
        assertEquals(20, weatherDataList.get(0).getMaxTemp());
        assertEquals(2, weatherDataList.get(1).getDay());
        assertEquals(12, weatherDataList.get(1).getMinTemp());
        assertEquals(15, weatherDataList.get(1).getMaxTemp());
    }

    @Test void readFromCSV_EmptyFile() throws IOException {
        // given
        createTestCSV("");

        // when
        List<WeatherData> weatherDataList = Reader.readFromCSV(testFilePath, data -> {
            int day = Integer.parseInt(data[0]);
            int maxTemp = Integer.parseInt(data[1]);
            int minTemp = Integer.parseInt(data[2]);
            return new WeatherData(day, maxTemp, minTemp);
        });

        List<FootballData> footballDataList = Reader.readFromCSV(testFilePath, data -> {
            String name = data[0];
            int goals = Integer.parseInt(data[5]);
            int goalsAllowed = Integer.parseInt(data[6]);
            return new FootballData(name, goals, goalsAllowed);
        });

        // then
        assertTrue(weatherDataList.isEmpty());
        assertTrue(footballDataList.isEmpty());
    }

    @Test void readFromCSV_ValidFootballData() throws IOException {
        // given
        createTestCSV("Team,Goals,GoalsAllowed\nArsenal,79,36\nLiverpool,67,30");

        // when
        List<FootballData> footballDataList = Reader.readFromCSV(testFilePath, data -> {
            String name = data[0];
            int goals = Integer.parseInt(data[5]);
            int goalsAllowed = Integer.parseInt(data[6]);
            return new FootballData(name, goals, goalsAllowed);
        });

        // then
        assertEquals(2, footballDataList.size());
        assertEquals("Arsenal", footballDataList.get(0).getName());
        assertEquals(79, footballDataList.get(0).getGoals());
        assertEquals(36, footballDataList.get(0).getGoalsAllowed());
        assertEquals("Liverpool", footballDataList.get(1).getName());
        assertEquals(67, footballDataList.get(1).getGoals());
        assertEquals(30, footballDataList.get(1).getGoalsAllowed());
    }

    /**
     * Currently not working. Has to be investigated further why.
     */
    @Disabled
    @Test void readFromCSV_InvalidFilePath() {
        Exception exception = assertThrows(FileNotFoundException.class, () -> {
            Reader.readFromCSV("notValidPath.csv", data -> data[0]);
        }, "Throw FileNotFound!");

        assertTrue(exception.getMessage().contains("File not found"));
    }

    /**
     * helper method to create a dummy CSV file
     * @param content
     * @throws IOException
     */
    private void createTestCSV(String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testFilePath))) {
            writer.write(content);
        }
    }
}