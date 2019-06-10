package com.dwirandyh.workmanager;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class DemoWorker extends Worker {


    public DemoWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        try{

            for (int i = 0; i < 100000; i++){
                Log.i("MYTAG", "count is " + i);
            }


            return Result.success();
        }catch (Exception e){
            Log.e("DemoWorker", e.getMessage());
            return Result.failure();
        }
    }
}
