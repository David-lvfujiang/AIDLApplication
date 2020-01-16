package com.example.flycotablayoutapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aidlapplication.R;
import com.example.flycotablayoutapplication.Service.AidlService;
import com.example.flycotablayoutapplication.model.User;

public class MainActivity extends AppCompatActivity {
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IMyAidlInterface aidlInterface = IMyAidlInterface.Stub.asInterface(iBinder);
            try {
                String message = aidlInterface.getMessage();
                User user = aidlInterface.getUser();
                Log.e("客户端",message);
                Log.e("客户端",user.toString());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, AidlService.class);
        intent.putExtra("name","name");
     //   Intent intent = new Intent();
//        intent.setAction("android.intent.action.AIDLService");
//        //android5.0以上版本规定显示启动必须设置Package（Package是AndroidManifest.xml中的Package路径，不是你要启动的service的包路径）
//        intent.setPackage("com.example.flycotablayoutapplication");
        //Context.BIND_AUTO_CREATE代表总是启动服务
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }
}
