package com.solvd.carina.tests.gui.yahoo.enums;

public enum WeatherForecast {
    THURSDAY(1, "Thursday", "", "75%", "75°F",
            "24°C", "40°F", "4°C"),
    FRIDAY(2, "Friday", "", "0%", "56°F", "13°C",
            "40°F", "4°C"),
    SATURDAY(3, "Saturday", "", "40%", "59°F",
            "15°C", "32°F", "0°C"),
    SUNDAY(4, "Sunday", "", "11%", "51°F",
            "10°C", "41°F", "5°C"),
    MONDAY(5, "Monday", "", "66%", "57°F",
            "14°C", "43°F", "6°C"),
    TUESDAY(6, "Tuesday", "", "66%", "54°F",
            "12°C", "40°F", "4°C"),
    WEDNESDAY(7, "Wednesday", "", "25%", "51°F",
            "10°C", "36°F", "2°C"),
    NEXT_THURSDAY(8, "Thursday", "", "0%", "49°F",
            "9°C", "37°F", "3°C"),
    NEXT_FRIDAY(9, "Friday", "S", "60%", "50°F",
            "10°C", "38°F", "3°C"),
    NEXT_SATURDAY(10, "Saturday", "", "0%", "51°F",
            "10°C", "38°F", "3°C"),
    NEXT_SUNDAY(11, "Sunday", "", "58%", "48°F",
            "9°C", "37°F", "3°C");

    private final Integer index;
    private final String day;
    private final String weatherCondition;
    private final String precipitation;
    private final String fahrenheitHighTemp;
    private final String celsiusHighTemp;
    private final String fahrenheitLowTemp;
    private final String celsiusLowTemp;

    private WeatherForecast(Integer index, String day, String weatherCondition, String precipitation,
            String fahrenheitHighTemp, String celsiusHighTemp,
            String fahrenheitLowTemp, String celsiusLowTemp) {
        this.index = index;
        this.day = day;
        this.weatherCondition = weatherCondition;
        this.precipitation = precipitation;
        this.fahrenheitHighTemp = fahrenheitHighTemp;
        this.celsiusHighTemp = celsiusHighTemp;
        this.fahrenheitLowTemp = fahrenheitLowTemp;
        this.celsiusLowTemp = celsiusLowTemp;
    }

    public String getDay() {
        return day;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }

    public String getPrecipitation() {
        return precipitation;
    }

    public String getFahrenheitHighTemp() {
        return fahrenheitHighTemp;
    }

    public String getCelsiusHighTemp() {
        return celsiusHighTemp;
    }

    public String getFahrenheitLowTemp() {
        return fahrenheitLowTemp;
    }

    public String getCelsiusLowTemp() {
        return celsiusLowTemp;
    }

    public Integer getIndex(){
        return index;
    }

    public static WeatherForecast getByDay(String day) {
        for (WeatherForecast forecast : values()) {
            if (forecast.getDay().equalsIgnoreCase(day)) {
                return forecast;
            }
        }
        throw new IllegalArgumentException("Invalid day: " + day);
    }
}
