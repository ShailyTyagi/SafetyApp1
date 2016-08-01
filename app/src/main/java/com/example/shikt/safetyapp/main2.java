package com.example.shikt.safetyapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class main2 extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private String[] mylist;
    private DrawerLayout myDrawer;
    private ListView myDrawerList;
    public ArrayAdapter<String> myadap;
    TextView fname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("SafetyApp");
        mylist= new String[]{"  ","  ","Compose Default Message","Add People","Health Specifications","Settings"};
        myDrawer=(DrawerLayout)findViewById(R.id.drawer_layout);
        myDrawerList=(ListView)findViewById(R.id.left_drawer);
        myadap=new ArrayAdapter<String>(this,R.layout.navigate,mylist);
        myDrawerList.setAdapter(myadap);
        fname=(TextView)findViewById(R.id.name);
        Intent in=getIntent();
        String name=in.getStringExtra(MainActivity.EX);
        fname.setText(name);
        myDrawerList.setOnItemClickListener(this);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case R.id.nav:
                myDrawer.openDrawer(myDrawerList);

            default:
                return super.onOptionsItemSelected(item);}
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        switch(position){
            case(3):
                myDrawer.closeDrawer(myDrawerList);
                Intent intent=new Intent(this,ScrollingActivity.class);
                startActivity(intent);

        }



    }


}




