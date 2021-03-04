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

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText mEdit;
    ImageView aau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.button = findViewById(R.id.button_id1);
        this.aau = findViewById(R.id.image1);
        startUpAnimation();

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Log.i("MyApp","OnCLick Works");
                Log.i("MyApp", mEdit.getText().toString());
                startUpAnimation();
            }
        });

        this.mEdit = (EditText)findViewById(R.id.InputText_1);

        mEdit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Log.v("EditText", mEdit.getText().toString());
            }
        });
    }

    private void startUpAnimation(){
        Animation fadeInAnimation = AnimationUtils.loadAnimation(this,R.anim.fadein);
        aau.startAnimation(fadeInAnimation);
    }
}