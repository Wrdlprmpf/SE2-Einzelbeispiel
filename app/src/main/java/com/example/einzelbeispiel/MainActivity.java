package com.example.einzelbeispiel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText mEdit;
    ImageView aau;
    String result;
    TextView resultText;

    Thread thread  = new Thread(new Runnable() {
        @Override
        public void run(){
            try{
                tcpConnection();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.button = findViewById(R.id.button_id1);
        this.aau = findViewById(R.id.image1);
        this.mEdit = (EditText)findViewById(R.id.InputText_1);
        this.resultText = (TextView)findViewById(R.id.textView3);

        startUpAnimation();

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Log.i("MyApp","OnCLick Works");
                Log.i("MyApp", mEdit.getText().toString());
                startUpAnimation();

                thread.start();
            }
        });

        mEdit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Log.v("EditText", mEdit.getText().toString());
                thread.start();
            }
        });
    }

    private void startUpAnimation(){
        Animation fadeInAnimation = AnimationUtils.loadAnimation(this,R.anim.fadein);
        aau.startAnimation(fadeInAnimation);
    }

    private void textAppearanceAnimation(){
        Animation fadeInAnimation = AnimationUtils.loadAnimation(this,R.anim.fadein);
        resultText.startAnimation(fadeInAnimation);
    }

    private void tcpConnection(){
        TCPClient tcp = new TCPClient("se2-isys.aau.at", 53212);
        tcp.writeLine(mEdit.getText().toString());
        result = tcp.readLine();
        Log.d("Debug",result);
        resultText.setText(result);
    }
}