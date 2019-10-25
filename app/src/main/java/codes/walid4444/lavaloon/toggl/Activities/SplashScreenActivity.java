package codes.walid4444.lavaloon.toggl.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import codes.walid4444.lavaloon.toggl.CONST;
import codes.walid4444.lavaloon.toggl.Database.SharedPrefManger;
import codes.walid4444.lavaloon.toggl.R;

public class SplashScreenActivity extends AppCompatActivity {

    private static final String TAG = "SplashScreenActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final SharedPrefManger sharedPrefManger = new SharedPrefManger();
        sharedPrefManger.init(this);


            /* New Handler to start the Menu-Activity
             * and close this Splash-Screen after some seconds.*/
            new Handler().postDelayed(new Runnable(){
                @Override
                public void run() {
                    Log.i(TAG,"User isn't loggedin");

                    if (!isUserLoggedIn(sharedPrefManger)) {
                        /* Create an Intent that will start the Main-Activity. */
                        Intent mainIntent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                        SplashScreenActivity.this.startActivity(mainIntent);
                        SplashScreenActivity.this.finish();
                    }
                    else {
                        SplashScreenActivity.this.startActivity(new Intent(SplashScreenActivity.this,MainActivity.class));
                        SplashScreenActivity.this.finish();
                        Log.i(TAG,"User is Loggedin");
                    }
                }
            }, CONST.SPLASH_DISPLAY_MIN_LENGTH);

    }

    private boolean isUserLoggedIn(SharedPrefManger sharedPrefManger){
        if ((sharedPrefManger.getEmail().isEmpty() && sharedPrefManger.getPassword().isEmpty()) || sharedPrefManger.getToken().isEmpty())
            return false;
        else
            return true;
    }


}
