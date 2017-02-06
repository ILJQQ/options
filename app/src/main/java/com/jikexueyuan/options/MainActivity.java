package com.jikexueyuan.options;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /*初始化变量*/
    private Button btnSubmit;
    private RadioButton rbMale;
    private RadioButton rbFemale;
    private TextView tvResult;
    private CheckBox cbA;
    private CheckBox cbB;
    private CheckBox cbC;
    private CheckBox cbD;
    private CheckBox cbE;
    private CheckBox cbF;
    private String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*将变量与控件连接起来并为其赋值*/
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        rbMale = (RadioButton) findViewById(R.id.rbMale);
        rbFemale = (RadioButton) findViewById(R.id.rbFemale);
        cbA = (CheckBox) findViewById(R.id.cbA);
        cbB = (CheckBox) findViewById(R.id.cbB);
        cbC = (CheckBox) findViewById(R.id.cbC);
        cbD = (CheckBox) findViewById(R.id.cbD);
        cbE = (CheckBox) findViewById(R.id.cbE);
        cbF = (CheckBox) findViewById(R.id.cbF);

        /*链接输出语句与显示控件*/
        tvResult = (TextView) findViewById(R.id.tvResult);

        /*在提交按钮触发后对输入内容进行if/else判断为tvResult赋对应的值并在textview中打印*/
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*单选题判断*/
                if (rbMale.isChecked()) {
                    result = "您的性别是: 男, ";
                } else if (rbFemale.isChecked()) {
                    result = "您的性别是: 女, ";
                } else if (!(rbMale.isChecked() && rbFemale.isChecked())) {
                    result = "您还未选择性别！";
                }

                /*多选题判断*/
                if (cbB.isChecked() || cbE.isChecked()) {
                    result += "No！您选中了错误答案";
                } else if (cbA.isChecked() && cbC.isChecked() && cbD.isChecked() && cbF.isChecked()) {
                    result += "您的多选题答案是正确的";
                } else {
                    result += "您还未完成多选题! 请从选项中找出四个正确答案";
                }

                /*将赋好值后的result打印出来*/
                tvResult.setText(result);
            }
        });
    }
}
