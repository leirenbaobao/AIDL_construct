package com.ctrlz.www.aidlstudy;

import android.os.RemoteException;

/**
 * Created by DAV on 15/5/8.
 */
public class MySecondStub extends ISecondInterface.Stub {
    @Override
    public int add(int a, int b) throws RemoteException {
        return a+b;
    }
}
