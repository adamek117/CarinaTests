package com.solvd.carina.tests.gui.ebay.enums;

public enum Product {
    GPUS(
            new String[] { "NVIDIA GeForce GTX TITAN XP Star Wars 12GB GDDR5X GPU" },
            new String[] { "US $184.99" },
            new String[] {}),

    LAPTOP_REPLACEMENT_PARTS(
            new String[] { "OEM Genuine Macbook Pro 15\" A1707 2016 2017 LCD Display Assembly Space Gray",
                    "OEM A2141 Apple MacBook Pro 16\" LCD Screen Display Assembly 2019 Silver Gray" },
            new String[] { "US $219.99", "US $184.99" },
            new String[] {
                    "OEM Genuine Parts! Please Read Description and See Photos for Condition Guide. Tested to be 100%",
                    "OEM Genuine Parts! Various Conditions! Please read description for full details. Tested to be 100%" }),

    THERMAL_COMPOUNDS(
            new String[] { "Arctic Silver 5 CPU Thermal Compound Paste 3.5 Grams AS5-3.5G",
                    "Arctic MX-4 Thermal Compound Paste Heatsink Paste - 4 Grams (4.0 g)" },
            new String[] { "US $9.99", "US $10.99" },
            new String[] { "High-performance thermal paste for efficient heat transfer.",
                    "Premium thermal paste for improved cooling." });

    private final String[] titles;
    private final String[] prices;
    private final String[] descriptions;

    Product(String[] titles, String[] prices, String[] descriptions) {
        this.titles = titles;
        this.prices = prices;
        this.descriptions = descriptions;
    }

    public String[] getProductNames() {
        return titles;
    }

    public String[] getProductPrices() {
        return prices;
    }

    public String[] getProductDescriptions() {
        return descriptions;
    }
}
