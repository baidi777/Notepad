package com.cheat.notepad.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.cheat.notepad.atys.AtyDialog;

/**
 * Created by Administrator on 2016/3/31 0031.
 */
public class Mydb extends SQLiteOpenHelper {
    SQLiteDatabase db;
    private final static String DATABASE_NAME = "db2016";
    private final static int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "userdb";
    private static final String FILED_1 = "name";
    private static final String FILED_2 = "password";
    private static final String FILED_3 = "email";


    public Mydb(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        "create table db (_id integer primary key,money decimal,time varchar(10),"
//                + "type varchar(10),address varchar(100),mark varchar(200))"
//        "create table db ("
//                + "id integer primary key autoincrement, "
//                + "name text, "
//                + "passwd text, "
//                + "email text)";
        String sql = "CREATE TABLE " + TABLE_NAME + " ( "
                + FILED_1 + " TEXT, " + FILED_2 + " TEXT, " + FILED_3 + " TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insert(String name, String password, String email) {
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("password", password);
        cv.put("email", email);
        this.getWritableDatabase().insert("userdb", null, cv);
        this.getWritableDatabase().close();//关闭数据库对象"
        Log.e("插入成功", ",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
    }

    /**
     * 删除表中的若干条数据
     *
     * @param name 一个包含所有要删除数据的"name"字段的数组
     */
    public void delete(String[] name) {
        String where = FILED_1 + " = ?";
        String[] whereValues = name;
        this.getWritableDatabase().delete(TABLE_NAME, where, whereValues);
        this.getWritableDatabase().close();
    }

    /**
     * 更新表中的数据(修改字段二"password")
     *
     * @param name        要更新的数据"name"字段值
     * @param newPassword 新的"password"字段
     */
    public void updatePasswd(String name, String newPassword) {
        ContentValues cv = new ContentValues();
        cv.put(FILED_2, newPassword);
        String where = FILED_1 + " = ?";
        String[] whereValues = {name};
        this.getWritableDatabase().update(TABLE_NAME, cv, where, whereValues);
        this.getWritableDatabase().close();
    }

    /**
     * //参数1：表名
     * //参数2：要想显示的列 new String[]{"name","password","email"}
     * //参数3：where子句"name=?"
     * //参数4：where子句对应的条件值
     * //参数5：分组方式
     * //参数6：having条件
     * //参数7：排序方式
     *
     * @param name 查询表数据"name"字段值
     * @return 表数据"password"字段值
     */
    public String select(String name) {
        Cursor cursor = this.getReadableDatabase().query("userdb", new String[]{"name", "password", "email"}, "name=?", new String[]{name}, null, null, null);
        if (cursor.getCount()==0){return "";}
        cursor.moveToNext();
        String n = cursor.getString(cursor.getColumnIndex("name"));
        String p = cursor.getString(cursor.getColumnIndex("password"));
        String e = cursor.getString(cursor.getColumnIndex("email"));
        return p;
    }
    public String selectEmail(String name) {
        Cursor cursor = this.getReadableDatabase().query("userdb", new String[]{"name", "password", "email"}, "name=?", new String[]{name}, null, null, null);
        if (cursor.getCount()==0){return "";}
        cursor.moveToNext();
        String e = cursor.getString(cursor.getColumnIndex("email"));
        return e;
    }

    /**
     * 查询表中所有的数据
     *
     * @return
     */
    public Cursor select() {
        return this.getReadableDatabase()
                .query(TABLE_NAME, null, null, null, null, null, null);
    }

    /**
     * 清空表中的数据
     */
    public void clean() {
        this.getWritableDatabase().execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        System.out.println("clean删除表");
        this.onCreate(this.getWritableDatabase());
        this.getWritableDatabase().close();
    }

//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        db = SQLiteDatabase.openOrCreateDatabase(this.getFilesDir().toString()
//                +"my.db",null);
//    }


}
