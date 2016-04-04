package com.cheat.notepad.atys;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;

/**
 * Created by Administrator on 2016/4/1 0001.
 */
public class AtyDialog {

    public static void show(Context context, String title, String msg) {
        new AlertDialog.Builder(context).setTitle(title)
                .setMessage(msg).setPositiveButton("确定", null).show();
    }
    public static void showA(final Context ctx, String title, String msg, final Class<?> cls, boolean f) {
        AlertDialog.Builder bud = new AlertDialog.Builder(ctx).setTitle(title).setMessage(msg).setCancelable(false);
        if (f) {bud.setPositiveButton("确定",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface d, int i) {
                Intent intent = new Intent(ctx,cls);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                ctx.startActivity(intent);
            }
        });
        }else {bud.setPositiveButton("确定",null);}bud.create().show();
    }
    public static void showB(Context ctx, View view){
        new AlertDialog.Builder(ctx)
                .setView(view).setCancelable(false)
                .setPositiveButton("确定", null).create().show();
    }
}
