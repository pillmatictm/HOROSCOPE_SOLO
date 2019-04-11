package org.pursuit.simpleastrology.model;

import java.util.List;

public class Astrology {
    private String zodiacName;
    private String zodiacDate;
    private String zodiacSymbol;
    private String rulingPlanet;
    private String element;
    private String modality;
    private List<String> zodiacReadings;
    private String overview;
    private String love;
    private String wealth;
    private String[] keywords;
    private String[] famousFigures;

    public Astrology(String zodiacName, String zodiacDate, String zodiacSymbol, String rulingPlanet, String element, String modality, List<String> zodiacReadings, String overview, String love, String wealth, String[] keywords, String[] famousFigures) {
        this.zodiacName = zodiacName;
        this.zodiacDate = zodiacDate;
        this.zodiacSymbol = zodiacSymbol;
        this.rulingPlanet = rulingPlanet;
        this.element = element;
        this.modality = modality;
        this.zodiacReadings = zodiacReadings;
        this.overview = overview;
        this.love = love;
        this.wealth = wealth;
        this.keywords = keywords;
        this.famousFigures = famousFigures;
    }

    public String getZodiacName() {
        return zodiacName;
    }

    public String getZodiacDate() {
        return zodiacDate;
    }

    public String getZodiacSymbol() {
        return zodiacSymbol;
    }

    public String getRulingPlanet() {
        return rulingPlanet;
    }

    public String getElement() {
        return element;
    }

    public String getModality() {
        return modality;
    }

    public List<String> getZodiacReadings() {
        return zodiacReadings;
    }

    public String getOverview() {
        return overview;
    }

    public String getLove() {
        return love;
    }

    public String getWealth() {
        return wealth;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public String[] getFamousFigures() {
        return famousFigures;
    }
}

