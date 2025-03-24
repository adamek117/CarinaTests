package com.solvd.carina.tests.gui.ebay.enums;

public enum Country {

    ARGENTINA("AR", "Argentina"),
    AUSTRALIA("AU", "Australia"),
    AUSTRIA("AT", "Austria"),
    BELARUS("BY", "Belarus"),
    BELGIUM("BE", "Belgium"),
    BOLIVIA("BO", "Bolivia"),
    BRAZIL("BR", "Brazil"),
    CANADA("CA", "Canada"),
    CHILE("CL", "Chile"),
    CHINA("CN", "China"),
    COLOMBIA("CO", "Colombia"),
    COSTA_RICA("CR", "Costa Rica"),
    DOMINICAN_REPUBLIC("DO", "Dominican Republic"),
    ECUADOR("EC", "Ecuador"),
    EL_SALVADOR("SV", "El Salvador"),
    FRANCE("FR", "France"),
    GERMANY("DE", "Germany"),
    GUATEMALA("GT", "Guatemala"),
    HONDURAS("HN", "Honduras"),
    HONG_KONG("HK", "Hong Kong"),
    INDIA("IN", "India"),
    IRELAND("IE", "Ireland"),
    ISRAEL("IL", "Israel"),
    ITALY("IT", "Italy"),
    JAPAN("JP", "Japan"),
    KAZAKHSTAN("KZ", "Kazakhstan"),
    KOREA("KR", "Korea"),
    MALAYSIA("MY", "Malaysia"),
    MEXICO("MX", "Mexico"),
    NETHERLANDS("NL", "Netherlands"),
    NEW_ZEALAND("NZ", "New Zealand"),
    NICARAGUA("NI", "Nicaragua"),
    PANAMA("PA", "Panama"),
    PARAGUAY("PY", "Paraguay"),
    PERU("PE", "Peru"),
    PHILIPPINES("PH", "Philippines"),
    POLAND("PL", "Poland"),
    PORTUGAL("PT", "Portugal"),
    PUERTO_RICO("PR", "Puerto Rico"),
    SINGAPORE("SG", "Singapore"),
    SPAIN("ES", "Spain"),
    SWITZERLAND("CH", "Switzerland"),
    TAIWAN("TW", "Taiwan"),
    TURKEY("TR", "Turkey"),
    UNITED_KINGDOM("GB", "United Kingdom"),
    URUGUAY("UY", "Uruguay"),
    VENEZUELA("VE", "Venezuela");

    private final String code;
    private final String fullName;

    private Country(String code, String fullName) {
        this.code = code;
        this.fullName = fullName;
    }

    public String getCode() {
        return code;
    }

    public String getFullName() {
        return fullName;
    }

    public static String getCountryNameByCode(String code) {
        for (Country country : Country.values()) {
            if (country.getCode().equalsIgnoreCase(code)) {
                return country.getFullName();
            }
        }
        return "Unknown Country Code";
    }

    public static String getCountryCodeByName(String name) {
        for (Country country : Country.values()) {
            if (country.getFullName().equalsIgnoreCase(name)) {
                return country.getCode();
            }
        }
        return "Unknown Country Name";
    }
}
