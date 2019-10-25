package codes.walid4444.lavaloon.toggl.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import codes.walid4444.lavaloon.toggl.BuildConfig;
import codes.walid4444.lavaloon.toggl.Database.SharedPrefManger;
import codes.walid4444.lavaloon.toggl.R;
import codes.walid4444.lavaloon.toggl.Remote.ApiClient;
import codes.walid4444.lavaloon.toggl.Remote.ApiInterface;
import codes.walid4444.lavaloon.toggl.Remote.Models.LoginDataModel;
import codes.walid4444.lavaloon.toggl.Remote.Models.ResponseModel.LoginResponseModel;
import codes.walid4444.lavaloon.toggl.Remote.Models.UserInfoModel;
import codes.walid4444.lavaloon.toggl.Utility;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginPage";
    EditText email_edt,password_edit;
    Button login_btn;
    SharedPrefManger sharedPrefManger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        password_edit =findViewById(R.id.password_edit);
        email_edt =findViewById(R.id.email_edt);
        login_btn = findViewById(R.id.login_btn);


        sharedPrefManger = new SharedPrefManger();
        sharedPrefManger.init(this);

        if (BuildConfig.DEBUG) {
            email_edt.setText("walid44443@gmail.com");
            password_edit.setText("w4a4l4i4d4");
        }
        login_btn.setOnClickListener(v->{
            final AlertDialog alertDialog = Utility.ShowProgressDialog(this, true);
            alertDialog.show();
            ApiInterface apiService = ApiClient.getClient(new LoginDataModel(email_edt.getText().toString(),password_edit.getText().toString())).create(ApiInterface.class);
            Call<LoginResponseModel> userlogincall = apiService.LoginRequest();

            userlogincall.enqueue(new Callback<LoginResponseModel>() {
                @Override
                public void onResponse(Call<LoginResponseModel> call, Response<LoginResponseModel> response) {
                    if (response.code() == 200) {
                        Log.i(TAG, "Success!! " + response.body().getData().getApi_token());
                        UserInfoModel userInfo = response.body().getData();
                        sharedPrefManger.saveLoginData(new LoginDataModel(email_edt.getText().toString(),password_edit.getText().toString(),userInfo.getApi_token()));
                        LoginActivity.this.startActivity(new Intent(LoginActivity.this,MainActivity.class));
                        LoginActivity.this.finish();
                    }else
                        Log.i(TAG, "Success!! " + response.code()+" url:"+response.raw().request().url());

                    alertDialog.dismiss();

                }

                @Override
                public void onFailure(Call<LoginResponseModel> call, Throwable t) {
                    Log.e(TAG,"Failed!! "+t.getMessage());
                    alertDialog.dismiss();
                }
            });
        });
    }

}
