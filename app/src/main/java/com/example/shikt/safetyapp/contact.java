package com.example.shikt.safetyapp;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;
import java.util.Vector;

/**
 * Created by shikt on 30-07-2016.
 */
public class contact extends AppCompatActivity implements View.OnClickListener {
    String name[] = new String[1000];
    int m = 0, h = 0;
    ListView con;
    String choosenCon[] = new String[1000];
    CheckBox mbox;
    ArrayAdapter conlist;
    Button done;
    int g = 0;
    SparseBooleanArray choo;
    List choosen;

    @Override
    public void onCreate(Bundle savedInstancestate) {
        super.onCreate(savedInstancestate);
        setContentView(R.layout.cantact);
        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        while (cursor.moveToNext()) {
            if (cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)) != null) {
                name[h] = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                h++;
            } else
                break;
        }
        con = (ListView) findViewById(R.id.conlist);
        conlist = new ArrayAdapter<String>(this, R.layout.conlayout, R.id.checkedTextView, name);
        con.setAdapter(conlist);

        mbox = (CheckBox) findViewById(R.id.child);
        done = (Button) findViewById(R.id.done);
        done.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.done) {
            choo = con.getCheckedItemPositions();
            for (int k = 0; k <= choo.size(); k++) {
                if (choo.valueAt(k)) {
                    //choo.keyAt(k)
                }


            }
        }


    }
}












