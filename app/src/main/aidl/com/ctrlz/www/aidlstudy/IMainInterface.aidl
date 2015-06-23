// MyInterface.aidl
package com.ctrlz.www.aidlstudy;

// Declare any non-default types here with import statements

interface IMainInterface{
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    IBinder getFirstService();
    IBinder getSecodService();

}
