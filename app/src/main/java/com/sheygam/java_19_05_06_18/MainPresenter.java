package com.sheygam.java_19_05_06_18;

import android.os.AsyncTask;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

@InjectViewState
public class MainPresenter extends MvpPresenter<IMainView>{


    public void onStart() {
        new AsyncTask<Void,String,String>(){

            @Override
            protected void onPreExecute() {
                getViewState().disableBtn();
            }

            @Override
            protected void onProgressUpdate(String... values) {
                getViewState().changeText(values[0]);
            }

            @Override
            protected String doInBackground(Void... voids) {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    publishProgress(""+i);
                }
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                getViewState().enableBtn();
            }
        }.execute();
    }
}
