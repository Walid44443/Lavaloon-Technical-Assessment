package codes.walid4444.lavaloon.toggl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AlertDialog;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import codes.walid4444.lavaloon.toggl.Activities.LoginActivity;
import codes.walid4444.lavaloon.toggl.Activities.SplashScreenActivity;

public class Utility {
    public static AlertDialog ShowProgressDialog(Context mContext, boolean isVisible) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(mContext);
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(R.layout.loading_dialoge_layout, null);
        dialogBuilder.setView(dialogView);
        dialogBuilder.setCancelable(false);
        AlertDialog b = dialogBuilder.create();
        if (isVisible)
            b.show();
        else
            b.dismiss();
        return b;
    }

    public static AlertDialog noConnection(Context mContext, boolean isVisible) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);

        builder.setTitle(mContext.getResources().getString(R.string.no_internet));
        builder.setMessage(mContext.getResources().getString(R.string.no_internet_connection));

        builder.setPositiveButton(mContext.getResources().getString(R.string.no_connection_try_again), new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                mContext.startActivity(new Intent(mContext, SplashScreenActivity.class));
                dialog.dismiss();
            }
        });

        builder.setNegativeButton(mContext.getResources().getString(R.string.no_internet_continue), new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                mContext.startActivity(new Intent(mContext, LoginActivity.class));
                dialog.dismiss();
            }
        });

        AlertDialog alert = builder.create();
        if (!((Activity) mContext).isFinishing())
            alert.show();
        return alert;
    }


    public static String  getDurationString(int seconds) {

        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        seconds = seconds % 60;

        return twoDigitString(hours) + " : " + twoDigitString(minutes) + " : " + twoDigitString(seconds);
    }

    private static String twoDigitString(int number) {

        if (number == 0) {
            return "00";
        }

        if (number / 10 == 0) {
            return "0" + number;
        }

        return String.valueOf(number);
    }

    public static String getPastDate(Date day, int interval)
    {
        try{

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

            Calendar c = Calendar.getInstance();
            c.setTime(day);

            c.add(Calendar.DATE,interval);  //not sure

            return dateFormat.format(c.getTime());


        }catch (Exception exp)
        {
            return null;
        }
    }

}
