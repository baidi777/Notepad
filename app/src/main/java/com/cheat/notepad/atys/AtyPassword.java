package com.cheat.notepad.atys;

import android.app.Activity;
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
public class AtyPassword extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.atypassword);
        final EditText passwd = (EditText) findViewById(R.id.et_passwd);
        Button btn_passwd = (Button) findViewById(R.id.btn_passwd);

        btn_passwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String n = intent.getStringExtra("names");
               String p = passwd.getText().toString();
                if (AtyEquals.equalsNull(AtyPassword.this,"n",p)){
                    Mydb db = new Mydb(AtyPassword.this);
                    db.updatePasswd(n,p);
                    AtyDialog.showA(AtyPassword.this,"提示","修改成功",AtyLogin.class,true);
                }
            }
        });
    }
}
