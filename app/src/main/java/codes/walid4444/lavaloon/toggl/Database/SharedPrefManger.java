package codes.walid4444.lavaloon.toggl.Database;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

import codes.walid4444.lavaloon.toggl.Remote.Models.LoginDataModel;

public class SharedPrefManger {

    private static SharedPreferences mSharedPref;



    public void init(Context mContext) {
        if (mSharedPref == null) {
            mSharedPref = PreferenceManager.getDefaultSharedPreferences(mContext);
        }
    }

    public String getEmail() {
        return mSharedPref.getString("email", "");
    }

    public void setEmail(String value) {
        mSharedPref.edit().putString("email", value).apply();
    }

    public String getPassword() {
        return mSharedPref.getString("password", "");
    }

    public void setPassword(String value) {
        mSharedPref.edit().putString("password", value).apply();
    }

    public boolean isIsUsingToken() {
        return mSharedPref.getBoolean("isUsingToken", false);
    }

    public void setIsUsingToken(boolean value) {
        mSharedPref.edit().putBoolean("isUsingToken", value).apply();
    }

    public String getToken() {
        return mSharedPref.getString("Token", "");
    }

    public void setToken(String value) {
        mSharedPref.edit().putString("Token", value).apply();
    }

    public void saveLoginData(LoginDataModel loginDataModel){
        setEmail(loginDataModel.getUser());
        setPassword(loginDataModel.getPassword());
        setToken(loginDataModel.getToken());
    }

    public LoginDataModel getLoginData(){
        return new LoginDataModel(getEmail(),getPassword(),getToken());
    }
}
