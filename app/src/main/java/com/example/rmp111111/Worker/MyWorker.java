package com.example.rmp111111.Worker;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.example.rmp111111.UI.Layer.view.Name;
import com.example.rmp111111.UI.Layer.viewmodel.MyViewModel2;

public class MyWorker extends Worker {
    public MyWorker(
            @NonNull Context appContext,
            @NonNull WorkerParameters workerParams) {
        super(appContext, workerParams);
    }
    @NonNull
    @Override
    public Result doWork() {
        try {
            MyViewModel2 viewModel2 = new MyViewModel2(getApplicationContext(), Name.APP);
            String example="Пример содержимого файла";
            viewModel2.writeApp(example);
            viewModel2.readAPP();

            Log.i("doWork", "Завершение работы");
            return Result.success();
        } catch (Throwable throwable) {
            Log.i("doWork", "Ошибка", throwable);
            return Result.failure();
        }
    }
}