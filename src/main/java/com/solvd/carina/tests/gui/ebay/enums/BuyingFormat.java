package com.solvd.carina.tests.gui.ebay.enums;

public enum BuyingFormat {
    BUY_IT_NOW("Buy It Now"),
    ALL_LISTINGS("All listings"),
    AUCTION("Auction"),
    ACCEPTS_OFFERS("Accepts Offers");

    private final String formatName;

    private BuyingFormat(String formatName) {
        this.formatName = formatName;
    }

    public String getFormatName(){
        return formatName;
    }

}
