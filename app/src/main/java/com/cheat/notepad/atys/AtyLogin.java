package com.cheat.notepad.atys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cheat.notepad.R;
import com.cheat.notepad.db.Mydb;
import com.cheat.notepad.db.Userdb;


/**
 * Created by Administrator on 2016/3/31 0031.
 */
public class AtyLogin extends Activity {

    EditText etname, etpasswd;
    Button login, register;
    TextView btnpasswd;
    Mydb db;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.atylogin);
        etname = (EditText) findViewById(R.id.et_name);
        etpasswd = (EditText) findViewById(R.id.et_passwd);
        login = (Button) findViewById(R.id.btn_login);
        register = (Button) findViewById(R.id.btn_register);
        db = new Mydb(this);
        btnpasswd = (TextView) findViewById(R.id.btn_passwd);

        login.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {
                                         String name = etname.getText().toString();
                                         String passwd = etpasswd.getText().toString();
                                         if (AtyEquals.equalsNull(AtyLogin.this, name, passwd)) {
                                             try {
                                                 if (AtyEquals.equalsdb(AtyLogin.this, name, passwd)) {
                                                     startActivity(new Intent(AtyLogin.this, AtyMain.class));

                                                 }
                                             } catch (Exception e) {
                                                 AtyDialog.show(AtyLogin.this, "友情提示", "用户名或密码错误");
                                             }
                                         }
                                     }
                                 }
        );

        register.setOnClickListener(new View.OnClickListener() {
                                        public void onClick(View v) {
                                            Intent intent = new Intent(AtyLogin.this, AtyRegister.class);
                                            startActivityForResult(intent, 1);
                                        }
                                    }
        );

        btnpasswd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AtyLogin.this,AtyPasswd.class));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 1 && resultCode == 1) {
            Bundle data = intent.getExtras();
            Userdb u = (Userdb) intent.getSerializableExtra("user");
            etname.setText(u.getName());
            etpasswd.setText(u.getPasswd());
        }
    }


}


