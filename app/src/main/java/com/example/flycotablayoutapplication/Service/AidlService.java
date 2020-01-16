package com.example.flycotablayoutapplication.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.flycotablayoutapplication.IMyAidlInterface;
import com.example.flycotablayoutapplication.model.User;

/**
 * @Author: david.lvfujiang
 * @Date: 2019/11/28
 * @Describe:
 */
public class AidlService extends Service {
    Binder binder;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        Log.e("服务端",intent.getStringExtra("name"));
        binder = new IMyAidlInterface.Stub() {
            @Override
            public String getMessage() throws RemoteException {
                return "消息";
            }
            @Override
            public User getUser() throws RemoteException {
                User user = new User("二白", "23");
                return user;
            }
        };
        return binder;
    }
}
