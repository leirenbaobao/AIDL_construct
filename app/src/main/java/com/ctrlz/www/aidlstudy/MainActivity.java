package com.ctrlz.www.aidlstudy;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//演示了和MainService绑定后，通过MainService的interface获取与其同一进程的其他Service的方法
public class MainActivity extends ActionBarActivity {

    private Button mButton;

    private ServiceConnection serviceConnection;

    private TextView mTextView;

    private IMainInterface mService;

    private ISecondInterface sService;

    private IFirstInterface fService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView)findViewById(R.id.txt);

        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                mService = IMainInterface.Stub.asInterface(service);

                /*try {
                    IBinder iBinder = mService.getFirstService();
                    fService  = IFirstInterface.Stub.asInterface(iBinder);
                    mTextView.setText(fService.getString("helloword"));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }*/

                try {
                    IBinder iBinder = mService.getSecodService();
                    sService = ISecondInterface.Stub.asInterface(iBinder);
                    mTextView.setText(sService.add(5, 5) + "");
                } catch (RemoteException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };


        mButton = (Button)findViewById(R.id.btn);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bindIntent = new Intent(MainActivity.this, MainService.class);
                bindService(bindIntent, serviceConnection, BIND_AUTO_CREATE);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
