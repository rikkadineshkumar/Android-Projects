package com.nist.sankalp2k18;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Dinesh on 08/02/18.
 */
public class PrefManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "introduction-welcome-sankalp";

    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    private static final String IS_USER_REGISTERED = "IsUserRegistered";

    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public void setIsUserRegistered(boolean isRegistered){
        editor.putBoolean(IS_USER_REGISTERED, isRegistered);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    public boolean isUserRegistered(){
        return pref.getBoolean(IS_USER_REGISTERED, false);
    }

}
