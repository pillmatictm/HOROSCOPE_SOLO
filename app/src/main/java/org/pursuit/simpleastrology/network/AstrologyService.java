package org.pursuit.simpleastrology.network;

import org.pursuit.simpleastrology.model.AstrologyList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AstrologyService {
    @GET("59250e4e28cfcf1bc28a57f67e3fcc00/raw/4995c84b1780904a2d6df3d8dfa6ddc9a3b7c1c5/Pilin's%2520Horoscope%2520API")
    Call<AstrologyList> getAstrology();
}