package com.cheat.notepad.atys;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cheat.notepad.R;
import com.cheat.notepad.db.Mydb;

/**
 * Created by Administrator on 2016/4/3 0003.
 */
public class AtyPasswd extends Activity{
    EditText name,email;
    Button btnpasswd;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.atypasswd);
        name = (EditText) findViewById(R.id.et_name);
        email = (EditText) findViewById(R.id.et_email);
        btnpasswd = (Button) findViewById(R.id.btn_passwd);

        btnpasswd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = name.getText().toString();
                String e = email.getText().toString();
                Mydb db = new Mydb(AtyPasswd.this);
                if (AtyEquals.equalsNull(AtyPasswd.this,n,"null",e)){
                    String email =db.selectEmail(n);
                    if (email.equals("")){
                        AtyDialog.show(AtyPasswd.this,"友情提示","用户不存在");
                    }if (email.equals(e)){
                        Bundle bundle = new Bundle();
                        bundle.putString("names",n);
                        Intent intent =new Intent(AtyPasswd.this,AtyPassword.class);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }else {
                        AtyDialog.show(AtyPasswd.this,"友情提示","邮箱不正确");
                    }


                }

            }
        });
    }
}
