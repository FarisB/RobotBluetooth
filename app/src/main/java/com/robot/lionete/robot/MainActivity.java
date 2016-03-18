package com.robot.lionete.robot;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import com.robot.lionete.robot.exceptions.BTHandlingException;

public class MainActivity extends ActionBarActivity {
    private BTConnectionHandler bt ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.bt = new BTConnectionHandler(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void homeActivityClickListener(View view) throws BTHandlingException, IOException {

        EditText editText = (EditText) findViewById(R.id.editText2);
        EditText editText2 = (EditText) findViewById(R.id.editText);

        switch(view.getId()){

            case R.id.button: bt.sendData(editText2.getText().toString());
                break;

            case R.id.button4: bt.sendData("A");
                break;

            case R.id.button5: bt.sendData("S");
                break;

            case R.id.button8: bt.sendData("R");
                break;

            case R.id.button7: bt.sendData("G");
                break;

            case R.id.button6: bt.sendData("D");
                break;

            case R.id.button2: bt.connectToBTDevice(editText.getText().toString());
                Context context = this;
                CharSequence text = "Connexion !";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                break;

            case R.id.button3: bt.closeConnection();
                break;
            default : break;
        }

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
