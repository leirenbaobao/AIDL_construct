package com.ctrlz.www.aidlstudy;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MainService extends Service {

    MyMainStub myMainStub = new MyMainStub();

    @Override
    public IBinder onBind(Intent intent) {
        return myMainStub;
    }
}
