package com.team.intentservice;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by aed1443 on 10/06/2015.
 */
public class MyIntentService extends IntentService {

    public static final String ACTION_MyIntentService = "com.team.intentService.RESPONSE";
    public static final String ACTION_MyUpdate = "com.team.intentService.UPDATE";
    public static final String EXTRA_KEY_IN = "EXTRA_IN";
    public static final String EXTRA_KEY_OUT = "EXTRA_OUT";
    public static final String EXTRA_KEY_UPDATE = "EXTRA_UPDATE";
    String msgFromActivity;
    String extraOut;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     */
    public MyIntentService() {
        super("com.team.intentService.MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        //get input
        msgFromActivity = intent.getStringExtra(EXTRA_KEY_IN);
        extraOut = "Hello: " +  msgFromActivity;

        for(int i = 0; i <=10; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            //send update
            Intent intentUpdate = new Intent();
            intentUpdate.setAction(ACTION_MyUpdate);
            intentUpdate.addCategory(Intent.CATEGORY_DEFAULT);
            intentUpdate.putExtra(EXTRA_KEY_UPDATE, i);
            sendBroadcast(intentUpdate);
        }

        //return result
        Intent intentResponse = new Intent();
        intentResponse.setAction(ACTION_MyIntentService);
        intentResponse.addCategory(Intent.CATEGORY_DEFAULT);
        intentResponse.putExtra(EXTRA_KEY_OUT, extraOut);
        sendBroadcast(intentResponse);
    }


}
