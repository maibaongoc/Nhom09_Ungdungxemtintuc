package com.example.nhom09_ungdungxemtintuc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText txtTitle, txtImage,txtUrl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        InitView();
    }

    public void InitView(){
        txtTitle = findViewById(R.id.txtInputTitle);
        txtTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()==0){
                    txtTitle.setError("Please enter your information");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        txtImage = findViewById(R.id.txtInputImage);
        txtImage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()==0){
                    txtTitle.setError("Please enter your information");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        txtUrl = findViewById(R.id.txtInputURL);
        txtUrl.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()==0){
                    txtTitle.setError("Please enter your information");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    public void showInput (View view)
    {
        if(txtTitle.length()!=0)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(AddActivity.this);
            builder.setTitle("Notification");
            String a =txtTitle.getText().toString();
            String b = txtImage.getText().toString();
            String c = txtUrl.getText().toString();
            builder.setMessage(a+" " + b+" "+c+" ");
            AlertDialog dialog = builder.create();
            dialog.show();
            Intent intent = new Intent(AddActivity.this, MainActivity.class);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    dialog.dismiss(); // Đóng AlertDialog nếu nó vẫn đang hiển thị
                    intent.putExtra("textTitle", a);
                    intent.putExtra("textImage", b);
                    intent.putExtra("textUrl",c);
                    startActivity(intent);

                }
            },100);

        }
        else {
            AlertDialog.Builder builder = new AlertDialog.Builder(AddActivity.this);
            builder.setTitle("notification");
            builder.setMessage("Enter information");
            AlertDialog dialog = builder.create();
            dialog.show();

        }
    }
}