package it.jaschke.alexandria;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class Utility {
    private static final String LOG_TAG = Utility.class.getSimpleName();

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isAvailable = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        Log.v(LOG_TAG, "isNetworkAvailable(): isAvailable = " + isAvailable);

        return isAvailable;
    }

}
