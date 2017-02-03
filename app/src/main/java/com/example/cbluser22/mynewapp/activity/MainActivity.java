package com.example.cbluser22.mynewapp.activity;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.cbluser22.mynewapp.R;
import com.example.cbluser22.mynewapp.adapter.RecyclerAdapter;
import com.example.cbluser22.mynewapp.models.MyModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    DrawerLayout dl;
    ArrayList<MyModel> mList;
    Toolbar tb;
    RecyclerView rv;
    RecyclerAdapter recyclerAdapter;
    ActionBarDrawerToggle mDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init() ;
        setToolBar();
        getData();
        adapterSetting();
        actionBarSetup();
    }

    private void actionBarSetup() {
        mDrawerToggle=new ActionBarDrawerToggle(this,dl,0,0)
        {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        dl.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

    }

    private void adapterSetting() {
        recyclerAdapter=new RecyclerAdapter(this,mList);
        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rv.setAdapter(recyclerAdapter);

    }

    private void getData() {

        mList.add(new MyModel("Jack",R.drawable.logo_adidas));
        mList.add(new MyModel("Jack",R.drawable.logo_adidas));
        mList.add(new MyModel("Jack",R.drawable.logo_adidas));
        mList.add(new MyModel("Jack",R.drawable.logo_adidas));
        mList.add(new MyModel("Jack",R.drawable.logo_adidas));
        mList.add(new MyModel("Jack",R.drawable.logo_adidas));
        mList.add(new MyModel("Jack",R.drawable.logo_adidas));
        mList.add(new MyModel("Jack",R.drawable.logo_adidas));
        mList.add(new MyModel("Jack",R.drawable.logo_adidas));
        mList.add(new MyModel("Jack",R.drawable.logo_adidas));
        mList.add(new MyModel("Jack",R.drawable.logo_adidas));


    }

    private void setToolBar() {

        setSupportActionBar(tb);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void init() {
        rv=(RecyclerView)findViewById(R.id.rv_layout);
        dl=(DrawerLayout)findViewById(R.id.dl_main);
        tb=(Toolbar)findViewById(R.id.tb_layout);
        mList=new ArrayList<>();

    }

    @Override
    public void onBackPressed() {
        if(dl.isDrawerOpen(rv))
        {
            dl.closeDrawer(Gravity.LEFT);
        }
        else
        {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menu:
                dl.openDrawer(Gravity.RIGHT);
                break;
            case android.R.id.home:
                dl.openDrawer(Gravity.LEFT);
                break;
        }

        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.clear();
        getMenuInflater().inflate(R.menu.newmenu,menu);
        return super.onPrepareOptionsMenu(menu);
    }
}
