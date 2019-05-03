package com.example.chatapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.chatapplication.adapter.TabAdapter;
import com.example.chatapplication.fragment.ChatsFragment;
import com.example.chatapplication.fragment.ContactsFragment;
import com.example.chatapplication.fragment.GroupsFragment;
import com.example.chatapplication.fragment.RequestsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        toolbar.setTitle("Chat");
        toolbar.setTitleTextColor(Color.WHITE);

        AddTab(viewpager);
        tablayout.setupWithViewPager(viewpager);
        tablayout.setSelectedTabIndicatorColor(Color.parseColor("#ffffff"));
        tablayout.setSelectedTabIndicatorHeight((int) (2 * getResources().getDisplayMetrics().density));
        tablayout.setTabTextColors(Color.parseColor("#E1E1E1"), Color.parseColor("#ffffff"));
    }


    private void AddTab(ViewPager viewPager) {
        TabAdapter adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new ChatsFragment(), "Chat");
        adapter.addFragment(new GroupsFragment(), "Group");
        adapter.addFragment(new ContactsFragment(), "Contact");
        adapter.addFragment(new RequestsFragment(), "Request");
        viewPager.setAdapter(adapter);
    }
}
