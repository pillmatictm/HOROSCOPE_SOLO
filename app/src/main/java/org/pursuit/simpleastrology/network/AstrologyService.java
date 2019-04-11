package org.pursuit.simpleastrology.network;

import org.pursuit.simpleastrology.model.AstrologyList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AstrologyService {
    @GET("pillmatictm/59250e4e28cfcf1bc28a57f67e3fcc00")
    Call<AstrologyList> getAstrology();
}
