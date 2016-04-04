package com.cheat.notepad.atys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cheat.notepad.R;
import com.cheat.notepad.db.Mydb;
import com.cheat.notepad.db.Userdb;


/**
 * Created by Administrator on 2016/3/31 0031.
 */
public class AtyRegister extends Activity {
    private EditText name,passwd,email;
    private Mydb db;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.atyregister);

        db = new Mydb(this);
        name = (EditText) findViewById(R.id.et_name);
        passwd = (EditText) findViewById(R.id.et_passwd);
        email = (EditText) findViewById(R.id.et_email);

        findViewById(R.id.btn_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = name.getText().toString();
                String p = passwd.getText().toString();
                String e = email.getText().toString();
                if (AtyEquals.equalsNull(AtyRegister.this,n,p,e)) {
                   try {
                       db.insert(n,p,e);
                       AtyDialog.showA(AtyRegister.this,"注册成功","您的用户名是:"+ n+
                               "\n密码是:"+ p+"\nEmail:"+ e,AtyLogin.class,true);
                   }catch (Exception ef){
                       ef.printStackTrace();
                       AtyDialog.show(AtyRegister.this,"注册失败","请稍后再试");
                   }

                }

//                FinalDb db = FinalDb.create(AtyRegister.this);
//                Userdb user = new Userdb();
//                user.setName(name);
//                user.setPasswd(passwd);
//                user.setEmail(email);
//                db.save(user);
//                Log.e("", "ffffff");
//                Userdb userdb = new Userdb(name,passwd);
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("user", userdb);
//                Intent intent = getIntent();
//                intent.putExtras(bundle);
//                AtyRegister.this.setResult(1, intent);
//                AtyRegister.this.finish();

            }
        });
    }
}
