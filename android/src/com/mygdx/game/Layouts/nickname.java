package com.mygdx.game.Layouts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.mygdx.game.Spiel.GameActivity;
import com.mygdx.game.R;

public class nickname extends Activity {
    private EditText editTextNickname;
    private TextView textViewNick;
    private RadioButton radioButtonGruen;
    private RadioButton radioButtonBlau;
    private RadioButton radioButtonRot;
    private RadioButton radioButtonGelb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);
        textViewNick = (TextView) findViewById(R.id.textViewNick);
        editTextNickname = (EditText) findViewById(R.id.editTextNickname);
        radioButtonGruen = (RadioButton) findViewById(R.id.radioButtonGruen);
        radioButtonGelb = (RadioButton) findViewById(R.id.radioButtonGelb);
        radioButtonBlau = (RadioButton) findViewById(R.id.radioButtonBlau);
        radioButtonRot = (RadioButton) findViewById(R.id.radioButtonRot);

    }

    public void onButtonClickNickZurück(View v) {
        Intent intent = new Intent(getApplicationContext(), startscreen.class);
        startActivity(intent);
    }


    public void onButtonClickOk(View v) {


        if (editTextNickname.getText().toString().equals("")) {
            editTextNickname.setHint("Nicknamen auswählen!!");


        //if (radioButtonBlau.equals(false) && radioButtonGelb.equals(false) && radioButtonGruen.equals(false) && radioButtonRot.equals(false)) {

        //     textViewNick.setText("Farbe Auswahälen");
        //  }



            } else { Intent intent = new Intent(getApplicationContext(), GameActivity.class);
            startActivity(intent);}

        }
    }


