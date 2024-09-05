package de.exxcellent.challenge.data;

public class WeatherData implements Data {
    private int day;
    private int maxTemp;
    private int minTemp;

    public WeatherData(int day, int maxTemp, int minTemp) {
        this.day = day;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
    }

    public int getDay() {
        return day;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public int getMinTemp() {
        return minTemp;
    }

    @Override
    public int getSpread() {
        return (maxTemp - minTemp);
    }

    @Override
    public String getId() {
        return String.valueOf(day);
    }
}
