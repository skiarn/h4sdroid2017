package com.example.h4s.hubdroid;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.h4s.hubdroid.dummy.DummyContent;

public class MainActivity extends AppCompatActivity  implements LockFragment.OnListFragmentInteractionListener {

    private TextView mTextMessage;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    closeContainerFragment();
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    closeContainerFragment();
                    mTextMessage.setText(R.string.title_map);
                    return true;
                case R.id.navigation_notifications:
                    closeContainerFragment();
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.navigation_lock:
                        getSupportFragmentManager().beginTransaction()
                                .add(R.id.container,new LockFragment())
                              .commit();
                    mTextMessage.setText(R.string.title_lock);
                    return true;
            }
            return false;
        }

    };

    private void closeContainerFragment() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.container);
        if(fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .remove(fragment).commit();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onListFragmentInteraction(DummyContent.LockItem item) {
        Toast.makeText(this, item.details,
                Toast.LENGTH_LONG).show();
    }
}
