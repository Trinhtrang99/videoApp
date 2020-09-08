package com.example.videoapp.Main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.videoapp.Fragment.Ca_Nhan_Fragment;
import com.example.videoapp.Fragment.Tai_Xuong_Frangment;
import com.example.videoapp.Fragment.Trang_Chu_Fragment;
import com.example.videoapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    static final String TAG = "MainActivity";
    Toolbar toolbar;

    BottomNavigationView btNag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btNag = findViewById(R.id.btNag);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getFragment(Trang_Chu_Fragment.newInstance());

        btNag.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.home) {
                    getFragment(Trang_Chu_Fragment.newInstance());
                    return true;
                }
                if (item.getItemId() == R.id.caNhan) {

                    getFragment(Ca_Nhan_Fragment.newInstance());
                    return true;
                }
                if (item.getItemId() == R.id.taikhoan) {

                    getFragment(Tai_Xuong_Frangment.newInstance());
                    return true;
                }
                return false;
            }
        });
    }




    public void getFragment(Fragment fragment) {
        try {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment)
                    .commit();
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "getFragment: " + e.getMessage());
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search,menu);
        return true;
    }
}