package codes.walid4444.lavaloon.toggl.Activities;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import codes.walid4444.lavaloon.toggl.Database.SharedPrefManger;
import codes.walid4444.lavaloon.toggl.R;
import codes.walid4444.lavaloon.toggl.RecyclerView.ExpandableSection;
import codes.walid4444.lavaloon.toggl.RecyclerView.ParentAdapter;
import codes.walid4444.lavaloon.toggl.Remote.ApiClient;
import codes.walid4444.lavaloon.toggl.Remote.ApiInterface;
import codes.walid4444.lavaloon.toggl.Remote.Models.LoginDataModel;
import codes.walid4444.lavaloon.toggl.Remote.Models.ResponseModel.LoginResponseModel;
import codes.walid4444.lavaloon.toggl.Remote.Models.ResponseModel.TimeEntriesResponseModel;
import codes.walid4444.lavaloon.toggl.Remote.Models.TimeEntryModel;
import codes.walid4444.lavaloon.toggl.SortingUtility;
import codes.walid4444.lavaloon.toggl.Utility;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public static SectionedRecyclerViewAdapter sectionAdapter = new SectionedRecyclerViewAdapter();
    public static List<ExpandableSection> expandableSections = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView timesRecyclerview =findViewById(R.id.timesRecyclerview);



        final AlertDialog alertDialog = Utility.ShowProgressDialog(this, true);
        alertDialog.show();

        SharedPrefManger sharedPrefManger = new SharedPrefManger();
        sharedPrefManger.init(this);
        ApiInterface apiService = ApiClient.getClient(sharedPrefManger.getLoginData()).create(ApiInterface.class);


        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        Calendar cal = Calendar.getInstance();

        Date date = new Date();
        String now =formatter.format(date);
        String before_month_date = Utility.getPastDate(date,-30);

        Call<List<TimeEntryModel>> timeEntriesRequest = apiService.getTimeEntriesRequest(sharedPrefManger.getToken(),before_month_date,now);
        timeEntriesRequest.enqueue(new Callback<List<TimeEntryModel>>() {
            @Override
            public void onResponse(Call<List<TimeEntryModel>> call, Response<List<TimeEntryModel>> response) {
                    if (response.code() == 200) {
                        Log.i(TAG, "Success!! " + response.body().size());

                        List<TimeEntryModel> items = SortingUtility.sortTimeEntries(response.body());

                        ParentAdapter parentAdapter =new ParentAdapter(SortingUtility.groupTimeEntriesDates(items),MainActivity.this);

                        timesRecyclerview.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        timesRecyclerview.setAdapter(parentAdapter);
                    }else
                        Log.i(TAG, "Success!!  but have error" + response.code()+" url:"+response.raw().request().url());
                alertDialog.dismiss();
                Log.i(TAG, "Success!!  but have error" + response.code()+" url:"+response.raw().request().url());


            }

            @Override
            public void onFailure(Call<List<TimeEntryModel>> call, Throwable t) {
                Log.e(TAG,"Failed!! "+t.getMessage());
                alertDialog.dismiss();

            }
        });
    }

}
