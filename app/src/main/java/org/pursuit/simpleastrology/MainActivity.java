package org.pursuit.simpleastrology;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

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
    private ProgressBar progressSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final FragmentInterface callback = this;

        progressSpinner = findViewById(R.id.progress_circular);
        progressSpinner.setVisibility(View.VISIBLE);

        recyclerView = findViewById(R.id.recyclerView);
        Retrofit retrofit = RetrofitSingleton.getSingleInstance();
        retrofit.create(AstrologyService.class)
                .getAstrology()
                .enqueue(new Callback<AstrologyList>() {
                    @Override
                    public void onResponse(Call<AstrologyList> call, Response<AstrologyList> response) {
                        Log.d(TAG, "onResponse: " + response.body());


                        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));
                        recyclerView.setAdapter(new AstrologyAdapter(response.body().getMessage(), callback));
                        recyclerView.setHasFixedSize(true);
                        progressSpinner.setVisibility(View.GONE);
                    }

                    @Override
                    public void onFailure(Call<AstrologyList> call, Throwable throwable) {
                        Log.d(TAG, "onFailure: " + throwable);

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                progressSpinner.setVisibility(View.GONE);

                                AlertDialog.Builder noInternetDialog = new AlertDialog.Builder(MainActivity.this)
                                        .setIcon(R.drawable.no_network_icon)
                                        .setTitle("No Network Connection")
                                        .setMessage("Sorry, no internet connectivity detected. Make sure that your Wifi or cellular mobile data is turned on and try again.")
                                        .setPositiveButton("Refresh", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                MainActivity.this.recreate();
                                            }
                                        });
                                noInternetDialog.create().show();
                            }
                        }, 3000);
                    }
                });
    }

    @Override
    public void toZodiacFrag(Astrology model) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, ZodiacFragment.newInstance(model))
                .addToBackStack(ZodiacFragment.KEY)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.pop_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent browserIntent;
        String toastMsg_linkedIn = "You will be taken to LinkedIn";
        String toastMsg_gitHub = "You will be taken to GitHub";
        switch (item.getItemId()) {
            case R.id.pilin_linkedIn:
                Toast.makeText(this, toastMsg_linkedIn, Toast.LENGTH_SHORT).show();
                browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/pillmatic/"));
                startActivity(browserIntent);
                return true;
            case R.id.pilin_gitHub:
                Toast.makeText(this, toastMsg_gitHub, Toast.LENGTH_SHORT).show();
                browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/pillmatictm"));
                startActivity(browserIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
