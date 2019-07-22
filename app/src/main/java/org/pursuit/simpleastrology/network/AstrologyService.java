package org.pursuit.simpleastrology.network;

import org.pursuit.simpleastrology.model.AstrologyList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AstrologyService {
    @GET("59250e4e28cfcf1bc28a57f67e3fcc00/raw/09aa0177de0314b173818cc564daba249ca1b086/Pilin's%2520Horoscope%2520API")
    Call<AstrologyList> getAstrology();
}