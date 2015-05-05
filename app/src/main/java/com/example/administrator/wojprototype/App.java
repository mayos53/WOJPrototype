package com.example.administrator.wojprototype;

import android.app.Application;
import android.content.SharedPreferences;

import com.example.administrator.wojprototype.model.Spam;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yossef on 4/27/15.
 */
public class App extends Application {

    public final static String APP_PREFS="APP_PREFS";
    public final static String SPAM_LIST="SPAM_LIST";

    private SharedPreferences mPrefs;

    @Override
    public void onCreate() {
        super.onCreate();
        mPrefs = getSharedPreferences(APP_PREFS,0);

        if(getList().length == 0) {
            Spam spam = new Spam();
            spam.id = 1;
            spam.title = "משכנתא ישיר";
            spam.content = "זכות לדירה בהוד השרון במתחם שביל התפוזים עכשיו ב 299,000 http://i4u.me/lNv";
           updateList(spam);

            spam = new Spam();
            spam.id = 2;
            spam.title = "07898766676";
            spam.content = "מהיום כל המשפחה בדיאטה, חייגו כוכבית 6193 ,להסרה http://smsim.rmov.me/";
            updateList(spam);
        }
    }

    public void updateList(Spam spam){
        Spam [] spams = getList();
        List<Spam> list = new ArrayList<Spam>();
        for(Spam sp:spams){
            list.add(sp);
        }
        list.add(spam);
        spams = list.toArray(new Spam[0]);
        Gson gson = new Gson();
        String s = gson.toJson(spams);

        mPrefs.edit().putString(SPAM_LIST,s).commit();




    }

    public Spam [] removeSpam(int id){
        Spam [] spams = getList();

        List<Spam> list = new ArrayList<Spam>();
        for(Spam sp:spams){
            list.add(sp);
        }
        int index = -1;
        for(int i=0;i<list.size();i++){
            if(list.get(i).id == id){
                index = i;
                break;
            }
        }
        if(index >= 0){
            list.remove(index);
        }
        spams = list.toArray(new Spam[0]);
        Gson gson = new Gson();
        String s = gson.toJson(spams);

        mPrefs.edit().putString(SPAM_LIST,s).commit();


        return spams;

    }

    public Spam [] getList(){

        String s = mPrefs.getString(SPAM_LIST,null);
        if(s != null){
            Gson gson = new Gson();
            return gson.fromJson(s, Spam [].class);
        }else{
            return new Spam[0];
        }



    }

}
