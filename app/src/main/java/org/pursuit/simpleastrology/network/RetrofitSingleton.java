package org.pursuit.simpleastrology.network;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitSingleton {
    private static final String BASE_URL = "https://gist.githubusercontent.com/pillmatictm/";
    private static Retrofit singleInstance;

    public static Retrofit getSingleInstance() {
        if (singleInstance != null) {
            return singleInstance;
        }

        singleInstance = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return singleInstance;
    }

    private RetrofitSingleton() {
    }
}

