package com.example.rmp111111.UI.Layer.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<Boolean> isStarted=new MutableLiveData<Boolean>(false);
    private MutableLiveData<Integer>value;
    public LiveData<Integer>getValue(){
        if(value==null){
            value=new MutableLiveData<Integer>(0);
        }
        return value;
    }
    public void execute(){
        if(!isStarted.getValue()){
            isStarted.postValue(true);
            Runnable runnable=new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<=100;i++){
                        try{
                            value.postValue(i);
                            Thread.sleep(25);
                        }
                        catch(InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    isStarted.postValue(false);
                    value.postValue(0);
                }
            };
            Thread thread=new Thread(runnable);
            thread.start();
        }
    }
}
