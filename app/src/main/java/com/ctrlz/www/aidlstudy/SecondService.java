package com.ctrlz.www.aidlstudy;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by DAV on 15/5/8.
 */
public class SecondService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
