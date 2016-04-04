package com.cheat.notepad.atys;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.cheat.notepad.R;

/**
 * Created by Administrator on 2016/4/3 0003.
 */
public class AtyAddContent extends Activity {
    private String val;
    private ImageView listimg,listv;
    private TextView listtext,listTime;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcontent);
        val = getIntent().getStringExtra("flag");
    }
}
