package com.example.nidaapp2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CameraDBHelper extends SQLiteOpenHelper {
    byte[] byteImage;
    ByteArrayOutputStream outputStream;
    Context context;

    public CameraDBHelper(@Nullable Context context){
        super(context,"gallery.db", null, 1);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table galleryTable(galleryId Integer primary key autoincrement, galleryName TEXT, galleryType String, galleryDescr TEXT, galleryImage BLOB)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists galleryTable");


    }
    public void insertProduct(Gallery gallery){
        try {
            SQLiteDatabase myDB = getWritableDatabase();
            Bitmap bitmap=gallery.getBitmapImage();
            //change the bitmap to byte[]
            outputStream=new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,outputStream);
            byteImage=outputStream.toByteArray();

            ContentValues values = new ContentValues();
            values.put("galleryName",gallery.getGalleryName());
            values.put("galleryType",gallery.getGalleryType());
            values.put("galleryDescr",gallery.getGalleryDescr());
            values.put("galleryImage",byteImage);
            long result=myDB.insert("GalleryTable",null,values);
            if (result!=-1){
                Toast.makeText(context, "Data entry successful", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(context, "Data entry failed", Toast.LENGTH_SHORT).show();
            }

        } catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        // myDB.
    }
    public List<Gallery> getData(){
        try {
            SQLiteDatabase db = getReadableDatabase();
            List<Gallery> galleryList =new ArrayList<>();
            Cursor cursor =db.rawQuery("select * from galleryTable",null);
            if (cursor.getCount()>0){
                while (cursor.moveToNext()){
                    String name=cursor.getString(1);
                    String Type =cursor.getString(2);
                    String desc =cursor.getString(3);
                    byte[] imageByte=cursor.getBlob(4);
                    Bitmap bitmap= BitmapFactory.decodeByteArray(imageByte,0,imageByte.length);
                    galleryList.add(new Gallery(name,Type,desc,bitmap));
                }
                return galleryList;
            }
            Toast.makeText(context, "Database is empty", Toast.LENGTH_SHORT).show();
            return null;


        } catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
            return null;
        }

    }
}

