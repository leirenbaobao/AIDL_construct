package com.ctrlz.www.aidlstudy;

import android.os.RemoteException;

/**
 * Created by DAV on 15/4/29.
 */
public class MyFirstStub extends IFirstInterface.Stub{

    @Override
    public String getString(String s) throws RemoteException {
        return s.toUpperCase();
    }

}
