package org.pursuit.simpleastrology.model;

public class Astrology {
    public final String zodiacName;
    public final String zodiacDate;
    public final String zodiacSymbol;
    public final String rulingPlanet;
    public String element;
    public final String modality;
    public final ZodiacReading zodiacReading;
    public final String[] keywords;
    public final String[] famousFigures;

    public Astrology(String zodiacName, String zodiacDate, String zodiacSymbol, String rulingPlanet, String element, String modality, ZodiacReading zodiacReading, String[] keywords, String[] famousFigures) {
        this.zodiacName = zodiacName;
        this.zodiacDate = zodiacDate;
        this.zodiacSymbol = zodiacSymbol;
        this.rulingPlanet = rulingPlanet;
        this.element = element;
        this.modality = modality;
        this.zodiacReading = zodiacReading;
        this.keywords = keywords;
        this.famousFigures = famousFigures;

}

    public class ZodiacReading {
        public final String overview;
        public final String love;
        public final String wealth;

        private ZodiacReading(String overview, String love, String wealth) {
            this.overview = overview;
            this.love = love;
            this.wealth = wealth;
        }
    }
}

