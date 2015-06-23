package com.ctrlz.www.aidlstudy;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by DAV on 15/5/5.
 */
public class FirstService extends Service{

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
