package com.solvd.carina.tests.gui.ebay.enums;

public enum ShipData {
    SHIPDATA1("United States", "John", "Doe", "123 Main St", "Apt 4B", 
            "New York", "New York", "10307",
            "john.doe@gmail.com", "john.doe@gmail.com", "StanyZjednoczone+1", "1234567890"),
    SHIPDATA2("Canada", "Jane", "Smith", "456 Maple Ave", "Suite 210", 
            "Toronto", "Ontario", "M5H 2N2",
            "jane.smith@gmail.com", "jane.smith@gmail.com", "Kanada+1", "0987654321"),
    SHIPDATA3("United Kingdom", "Alice", "Brown", "78 King Street", "Flat 12", 
        "London", "London", "SW1A 1AA",
            "alice.brown@gmail.com", "alice.brown@gmail.com", "WielkaBrytania+44", "9876543210");

    private final String country;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String optionalAddress;
    private final String city;
    private final String state;
    private final String zipCode;
    private final String email;
    private final String emailConfirm;
    private final String countryCode;
    private final String phoneNumber;

    private ShipData(String country, String firstName, String lastName, String address, String optionalAddress, String city,
            String state,
            String zipCode, String email, String emailConfirm, String countryCode, String phoneNumber) {
        this.country = country;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.optionalAddress = optionalAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.email = email;
        this.emailConfirm = emailConfirm;
        this.countryCode = countryCode;
        this.phoneNumber = phoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getOptionalAddress() {
        return optionalAddress;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getEmail() {
        return email;
    }

    public String getEmailConfirm() {
        return emailConfirm;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
