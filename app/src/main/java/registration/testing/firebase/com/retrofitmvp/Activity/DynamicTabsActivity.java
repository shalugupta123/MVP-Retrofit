package registration.testing.firebase.com.retrofitmvp.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import registration.testing.firebase.com.retrofitmvp.Model.Constant;
import registration.testing.firebase.com.retrofitmvp.R;

public class DynamicTabsActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    private int noOfTabs = 1;
    String value;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_tabs);

        Bundle getBundle = null;
        getBundle = this.getIntent().getExtras();
        String name[]= getBundle.getStringArray("TABVALUE");
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),name.length);
        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addTab(tabLayout.newTab().setText(name.length));



    }

}