package it.jaschke.alexandria;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by ibrahimhassan on 8/26/15.
 */
public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();


    }

    /**
     * Checks if the device has Internet connection.
     *
     * @return <code>true</code> if the phone is connected to the Internet.
     */

    public static boolean getNetworkState(Context pContext) {
        ConnectivityManager connect = null;
        connect = (ConnectivityManager) pContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connect != null) {
            NetworkInfo resultM = connect
                    .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            NetworkInfo resultW = connect
                    .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            if (resultM != null && resultM.isConnectedOrConnecting()) {
                return true;
            } else if (resultW != null && resultW.isConnectedOrConnecting()) {
                return true;
            } else {
                return false;
            }
        } else
            return false;
    }
}
