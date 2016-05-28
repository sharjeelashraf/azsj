package com.fauwad.myfirstapp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.telephony.gsm.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by system6 on 4/26/2016.
 */
public class Communication extends ActionBarActivity{
    EditText etPhoneNo;
    EditText etMsg;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.communication);

        etPhoneNo =(EditText)findViewById(R.id.editText6);
        etMsg =(EditText)findViewById(R.id.editText7);


        ///


        Button button1 = (Button) findViewById(R.id.button12);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String a = etPhoneNo.getText().toString().trim();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+a));
                startActivity(callIntent);

            }
        });


        Button button2 = (Button) findViewById(R.id.button13);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String phoneNo1 = etPhoneNo.getText().toString();
                String msg = etMsg.getText().toString();
                try {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNo1, null, msg, null, null);
                    Toast.makeText(getApplicationContext(), "Message Sent",
                            Toast.LENGTH_LONG).show();
                } catch (Exception ex) {
                    Toast.makeText(getApplicationContext(),
                            ex.getMessage().toString(),
                            Toast.LENGTH_LONG).show();
                    ex.printStackTrace();
                }
            }


        });
    }


        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
