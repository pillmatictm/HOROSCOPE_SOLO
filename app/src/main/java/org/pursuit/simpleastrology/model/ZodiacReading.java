package org.pursuit.simpleastrology.model;

import java.io.Serializable;

public class ZodiacReading implements Serializable {
    private String overview;
    private String love;
    private String wealth;

     public ZodiacReading(String overview, String love, String wealth) {
         this.overview = overview;
         this.love = love;
         this.wealth = wealth;
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
 }
