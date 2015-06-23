package com.ctrlz.www.aidlstudy;

import android.os.IBinder;
import android.os.RemoteException;

/**
 * Created by DAV on 15/5/11.
 */
public class MyMainStub extends IMainInterface.Stub{

    @Override
    public IBinder getFirstService() throws RemoteException {
        return new MyFirstStub();
    }

    @Override
    public IBinder getSecodService() throws RemoteException {
        return new MySecondStub();
    }
}
