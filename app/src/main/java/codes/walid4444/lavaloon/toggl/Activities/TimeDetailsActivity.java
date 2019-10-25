package codes.walid4444.lavaloon.toggl.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import codes.walid4444.lavaloon.toggl.Database.SharedPrefManger;
import codes.walid4444.lavaloon.toggl.R;
import codes.walid4444.lavaloon.toggl.RecyclerView.ParentAdapter;
import codes.walid4444.lavaloon.toggl.Remote.ApiClient;
import codes.walid4444.lavaloon.toggl.Remote.ApiInterface;
import codes.walid4444.lavaloon.toggl.Remote.Models.ResponseModel.DetailsItemResponse;
import codes.walid4444.lavaloon.toggl.Remote.Models.TimeEntryModel;
import codes.walid4444.lavaloon.toggl.SortingUtility;
import codes.walid4444.lavaloon.toggl.Utility;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TimeDetailsActivity extends AppCompatActivity {
    private static final String TAG = "TimeDetails";
    TextView title,start_date,end_date,project_id,duration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_details);
        title=findViewById(R.id.title_txt);
        start_date=findViewById(R.id.start_date_txt);
        end_date=findViewById(R.id.end_date_txt);
        project_id=findViewById(R.id.project_id_txt);
        duration=findViewById(R.id.duration_time_txt);


        final AlertDialog alertDialog = Utility.ShowProgressDialog(this, true);
        alertDialog.show();

        int id = getIntent().getIntExtra("ID",0);
        SharedPrefManger sharedPrefManger = new SharedPrefManger();
        sharedPrefManger.init(this);
        ApiInterface apiService = ApiClient.getClient(sharedPrefManger.getLoginData()).create(ApiInterface.class);
        Call<DetailsItemResponse> timeDetailsRequest = apiService.getTimeDetailsRequest(sharedPrefManger.getToken(),id);
        timeDetailsRequest.enqueue(new Callback<DetailsItemResponse>() {
            @Override
            public void onResponse(Call<DetailsItemResponse> call, Response<DetailsItemResponse> response) {
                if (response.code() == 200) {
                    title.setText(response.body().getData().getDescription());
//                    Log.i("start",response.body().getStart());
                    start_date.setText(SortingUtility.ConverttoSimpleDate(response.body().getData().getStart()));
                    end_date.setText(SortingUtility.ConverttoSimpleDate(response.body().getData().getStop()));
                    duration.setText(Utility.getDurationString(response.body().getData().getDuration()));
                    project_id.setText("Workspace ID"+response.body().getData().getWid()+"");

                }else
                    Log.i(TAG, "Success!!  but have error" + response.code()+" url:"+response.raw().request().url());
                alertDialog.dismiss();
                Log.i(TAG, "Success!!  but have error" + response.code()+" url:"+response.raw().request().url());


            }

            @Override
            public void onFailure(Call<DetailsItemResponse> call, Throwable t) {
                Log.e(TAG,"Failed!! "+t.getMessage());
                alertDialog.dismiss();

            }
        });
    }
}
