package org.pursuit.simpleastrology.network;

import org.pursuit.simpleastrology.model.AstrologyList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AstrologyService {
    @GET("559250e4e28cfcf1bc28a57f67e3fcc00/raw/1efd9e9b0a6158908b9b7af7bba3f52f2f13f9f5/Pilin's%2520Horoscope%2520API")
    Call<AstrologyList> getAstrology();
}
