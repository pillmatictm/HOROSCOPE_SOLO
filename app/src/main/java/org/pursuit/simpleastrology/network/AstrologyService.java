package org.pursuit.simpleastrology.network;

import org.pursuit.simpleastrology.model.AstrologyList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AstrologyService {
    @GET("59250e4e28cfcf1bc28a57f67e3fcc00/raw/abcdadee813e96b958c25ff268570cfe4844eca3/Pilin's%2520Horoscope%2520API")
    Call<AstrologyList> getAstrology();
}