package com.example.student.anew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private static final String TAG="MaActivity";
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

}
    public void OnClick1(View view) {
        if(view.getId()==R.id.id1){
            ThreadCounter tc=new ThreadCounter();
            tc.start();
        }
    }

    public synchronized void print(){
        while(count<1){
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        Log.e(TAG, "counter="+count);
    }

    class ThreadCounter extends Thread{
        @Override
        public void run() {
            super.run();
            print();
        }
    }

    public synchronized void OnClick2(View view) {
        if(view.getId()==R.id.id2){
            count++;
            notifyAll();
        }
    }
}