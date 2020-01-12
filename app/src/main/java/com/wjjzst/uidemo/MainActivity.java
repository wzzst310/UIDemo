package com.wjjzst.uidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView display;
    private Button buttonLeft, buttonRight, button3;
    private Switch aSwitch;
    private ProgressBar progressBar;
    private EditText editText;
    private RadioGroup radioGroup;
    private ImageView imageView;
    private SeekBar seekBar;
    private CheckBox checkBoxChinese, checkBoxMath, checkBoxEnglish;
    private RatingBar ratingBar;
    private String chinese = "";
    private String math = "";
    private String english = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.textView);
        buttonLeft = findViewById(R.id.button1);
        buttonRight = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        aSwitch = findViewById(R.id.switch1);
        progressBar = findViewById(R.id.progressBar3);
        editText = findViewById(R.id.editText);
        radioGroup = findViewById(R.id.radioGroup);
        imageView = findViewById(R.id.imageView);
        seekBar = findViewById(R.id.seekBar);
        checkBoxChinese = findViewById(R.id.checkBox1);
        checkBoxMath = findViewById(R.id.checkBox2);
        checkBoxEnglish = findViewById(R.id.checkBox3);
        ratingBar = findViewById(R.id.ratingBar);
        buttonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(R.string.button1);
            }
        });


        buttonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(R.string.button2);
            }
        });

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    display.setText(R.string.open);
                } else {
                    display.setText(R.string.close);
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = editText.getText().toString();
                if (TextUtils.isEmpty(s)) {
                    s = "0";
                }
                progressBar.setProgress(Integer.parseInt(s));  //第二个参数是否有过渡动画  //android 24以上才支持
                display.setText(s);

            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton1) {
                    imageView.setImageResource(R.drawable.androidlogo);
                } else {
                    imageView.setImageResource(R.drawable.applelogo);
                }
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                display.setText(progress + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        checkBoxChinese.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    chinese = getString(R.string.checkbox1);
                } else {
                    chinese = "";
                }
                display.setText(chinese + math + english);
            }
        });

        checkBoxMath.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    math = getString(R.string.checkbox2);
                } else {
                    math = "";
                }
                display.setText(chinese + math + english);
            }
        });

        checkBoxEnglish.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    english = getString(R.string.checkbox3);
                } else {
                    english = "";
                }
                display.setText(chinese + math + english);
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(getApplicationContext(), String.valueOf(rating) + "星评价！", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
