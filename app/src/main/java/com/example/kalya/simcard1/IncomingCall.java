package com.example.kalya.simcard1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.PhoneStateListener;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by kalya on 08-Jul-17.
 */

public class IncomingCall extends BroadcastReceiver {
    final SmsManager sms = SmsManager.getDefault();
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        SmsMessage[] msgs = null;
        try {
            if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED"))
            {
                //Toast.makeText(context,"JDSFKA",Toast.LENGTH_LONG).show();
                Object[] pdus= (Object[]) bundle.get("pdus");
                msgs = new SmsMessage[pdus.length];
                for (int i = 0; i< pdus.length;i++)
                {
                    SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdus[i]);
                    //String number = msgs[i].getOriginatingAddress();
                    String nu= smsMessage.getDisplayOriginatingAddress();
                    //Toast.makeText(context,nu,Toast.LENGTH_LONG).show();
                    if ("+918309579985".equals(nu)){
                        Intent a = new Intent(context, MyService.class);
                        context.startService(a);
                    }
                    if ("+919963919273".equals(nu)){
                        Intent a = new Intent(context, MyService.class);
                        context.startService(a);
                    }
                }
            }
        }catch (Exception e)
        {

        }
       /** if (intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(TelephonyManager.EXTRA_STATE_RINGING)){
            String incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
            Toast.makeText(context,"call from:"+incomingNumber,Toast.LENGTH_LONG).show();
            if ("+919963919273".equals(incomingNumber)){
                Intent a = new Intent(context, MyService.class);
                context.startService(a);
            }
            if ("+919963919272".equals(incomingNumber)){
                Intent a = new Intent(context, MyService.class);
                context.stopService(a);
            }
        }**/

        /**try {
            TelephonyManager tmgr =  (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
            MyPhoneStateListner PhoneListner = new MyPhoneStateListner();
            tmgr.listen(PhoneListner, PhoneStateListener.LISTEN_CALL_STATE);
        }catch (Exception e){
            Log.e("Phone Reciever Error"," "+ e);
        }**/
    }
    /**private class MyPhoneStateListner extends PhoneStateListener{
        public void OnCallStateChanged(int state,String incomingNumber){
            Log.d("MyPhoneStateListner",state+"incoming no:"+incomingNumber);
            if (state == 1){
                String msg = "New Phone call Event.incoming Number:"+incomingNumber;
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(this,msg,duration);
                toast.show();
            }
        }
    }**/
}
