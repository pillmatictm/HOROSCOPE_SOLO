package org.pursuit.simpleastrology;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.pursuit.simpleastrology.fragments.FragmentInterface;
import org.pursuit.simpleastrology.fragments.ZodiacFragment;
import org.pursuit.simpleastrology.model.Astrology;
import org.pursuit.simpleastrology.model.AstrologyList;
import org.pursuit.simpleastrology.network.AstrologyService;
import org.pursuit.simpleastrology.network.RetrofitSingleton;
import org.pursuit.simpleastrology.recyclerview.AstrologyAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements FragmentInterface {
private static final String TAG = "retrofit";
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        Retrofit retrofit = RetrofitSingleton.getSingleInstance();
        retrofit.create(AstrologyService.class)
                .getAstrology()
                .enqueue(new Callback<AstrologyList>() {
                    @Override
                    public void onResponse(Call<AstrologyList> call, Response<AstrologyList> response) {
                        Log.d(TAG, "onResponse: " + response.body());

                        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setAdapter(new AstrologyAdapter(response.body()));
                    }

                    @Override
                    public void onFailure(Call<AstrologyList> call, Throwable throwable) {
                        Log.d(TAG, "onFailure: " + throwable);
                    }
                });
    }

    @Override
    public void toZodiacFrag(Astrology model) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, ZodiacFragment.newInstance())
                .addToBackStack(ZodiacFragment.KEY)
                .commit();
    }
}
