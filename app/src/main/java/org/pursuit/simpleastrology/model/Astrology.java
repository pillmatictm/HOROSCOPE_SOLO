package org.pursuit.simpleastrology.model;

import java.io.Serializable;

public class Astrology implements Serializable {
    private String zodiacSymbol;
    private String zodiacName;
    private String zodiacDate;
    private String rulingPlanet;
    private String modality;
    private String element;
    private String[] keywords;
    private String[] famousFigures;

    public Astrology(String zodiacSymbol, String zodiacName, String zodiacDate, String rulingPlanet, String modality, String element, String[] keywords, String[] famousFigures) {
        this.zodiacSymbol = zodiacSymbol;
        this.zodiacName = zodiacName;
        this.zodiacDate = zodiacDate;
        this.rulingPlanet = rulingPlanet;
        this.modality = modality;
        this.element = element;
        this.keywords = keywords;
        this.famousFigures = famousFigures;
    }

    public String getZodiacSymbol() {
        return zodiacSymbol;
    }

    public String getZodiacName() {
        return zodiacName;
    }

    public String getZodiacDate() {
        return zodiacDate;
    }

    public String getRulingPlanet() {
        return rulingPlanet;
    }

    public String getModality() {
        return modality;
    }

    public String getElement() {
        return element;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public String[] getFamousFigures() {
        return famousFigures;
    }
}
