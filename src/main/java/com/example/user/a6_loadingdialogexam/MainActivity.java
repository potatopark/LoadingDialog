package com.example.user.a6_loadingdialogexam;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener{
    Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                showLoadingDialog();
                break;
            case R.id.button2:
                showTransLoadingDialog();
                break;
        }
    }

    public  void showLoadingDialog(){
        ProgressDialog dialog1 = new ProgressDialog(this);
        dialog1.setMessage("잠시만 기다려주세요...");
        dialog1.setOnCancelListener(new DialogInterface.OnCancelListener(){
            @Override
            public void onCancel(DialogInterface dialog) {
                Toast.makeText(getApplication(),"로딩 취소됨",Toast.LENGTH_LONG).show();
            }
        });

        dialog1.show();
    }

    public void showTransLoadingDialog(){
        Dialog dialog2 = new Dialog(this,R.style.TransDialog);
        ProgressBar pb = new ProgressBar(this);
        dialog2.addContentView(pb,new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));


        dialog2.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                Toast.makeText(getApplication(),"로딩 취소됨",Toast.LENGTH_LONG).show();
            }
        });
        dialog2.show();
    }


}
