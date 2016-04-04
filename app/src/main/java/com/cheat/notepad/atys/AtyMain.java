package com.cheat.notepad.atys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.cheat.notepad.R;

/**
 * Created by Administrator on 2016/4/3 0003.
 */
public class AtyMain extends Activity implements View.OnClickListener{
    private Button btntext,btnimg,btnvideo;
    private ListView listView;
    private Intent i;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.atymain);
        initview();
    }

    private void initview() {
        btntext = (Button) findViewById(R.id.btn_text);
        btnimg = (Button) findViewById(R.id.btn_img);
        btnvideo = (Button) findViewById(R.id.btn_video);
        listView = (ListView) findViewById(R.id.list);
        btntext.setOnClickListener(this);
        btnimg.setOnClickListener(this);
        btnvideo.setOnClickListener(this);
    }

    @Override

    public void onClick(View v) {
        i = new Intent(this,AtyAddContent.class);
        switch (v.getId()){
            case R.id.btn_text:
                i.putExtra("flag","1");
                startActivity(i);
                break;
            case R.id.btn_img:
                i.putExtra("flag","2");
                startActivity(i);
                break;
            case R.id.btn_video:
                i.putExtra("flag","3");
                startActivity(i);
                break;



        }

    }
}
