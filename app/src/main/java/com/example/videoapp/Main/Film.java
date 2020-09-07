package com.example.videoapp.Main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ViewFlipper;

import com.example.videoapp.Adapter.AdapterFragment;
import com.example.videoapp.Adapter.AdapterFragment2;
import com.example.videoapp.Context.Contect;
import com.example.videoapp.GetData.GetData;
import com.example.videoapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Film extends AppCompatActivity {

    AdapterFragment adapter, adapter4;
    AdapterFragment2 adapter2, adapter3;
    RecyclerView rc1, rc2, rc3, rc4;
    GetData getDataq;
    ProgressBar pro;
    List<Contect> list1, list3;
    List<Contect> list2, list4;
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    String url2 = "http://demo1913415.mockable.io/GetItemCategoryOne";
    String url1 = "http://demo1913415.mockable.io/getVideoHot";
    String url3 = "http://demo8640072.mockable.io/move";
    String url4 = "http://demo8640072.mockable.io/romantic";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewFlipper = findViewById(R.id.Viewflipper);
        rc1 = findViewById(R.id.rc1);
        rc2 = findViewById(R.id.rc2);
        rc3 = findViewById(R.id.rc3);
        rc4 = findViewById(R.id.rc4);
        pro = findViewById(R.id.pro);
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        list3 = new ArrayList<>();
        list4 = new ArrayList<>();
        getDataq = new GetData();


        getDataq.getDataJSON1(url2, list1, getBaseContext(), pro);
        getDataq.getDataJSON1(url3, list3, getBaseContext(), pro);
        getDataq.getDataJSON1(url1, list2, getBaseContext(), pro);
        getDataq.getDataJSON1(url4, list4, getBaseContext(), pro);

        adapter = new AdapterFragment(list1, getBaseContext());
        adapter2 = new AdapterFragment2(list4, getBaseContext());
        adapter3 = new AdapterFragment2(list2, getBaseContext());
        adapter4 = new AdapterFragment(list3, getBaseContext());


        rc1.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager1 = new GridLayoutManager(getBaseContext(), 1, RecyclerView.HORIZONTAL, false);
        rc1.setLayoutManager(layoutManager1);

        rc3.setAdapter(adapter4);
        RecyclerView.LayoutManager layoutManager3 = new GridLayoutManager(getBaseContext(), 1, RecyclerView.HORIZONTAL, false);
        rc3.setLayoutManager(layoutManager3);

        rc2.setAdapter(adapter3);
        RecyclerView.LayoutManager layoutManager2 = new GridLayoutManager(getBaseContext(), 1, RecyclerView.HORIZONTAL, false);
        rc2.setLayoutManager(layoutManager2);

        rc4.setAdapter(adapter2);
        RecyclerView.LayoutManager layoutManager4 = new GridLayoutManager(getBaseContext(), 2, RecyclerView.HORIZONTAL, false);
        rc4.setLayoutManager(layoutManager4);


        getData();


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search,menu);
        MenuItem menuItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
    private void getData() {

        ArrayList<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://media.ngoisao.vn/resize_580/news/2011/6/17/20/Chan-dai-9X-Mi-Lan-dao-nguyen-hinh-anh-phim-Priest--0.jpg");
        mangquangcao.add("https://d69c23af-a-62cb3a1a-s-sites.googlegroups.com/site/conghungstore/home/dich-vu-1/dch-v-phim-nh/Untitled-2.jpg");
        mangquangcao.add("https://static2.yan.vn/YanNews/2167221/201903/anh-1-1027d370.jpg");
        mangquangcao.add("https://netmode.com.vn/wp-content/uploads/2019/11/xem-phim-hanh-dong-my-hay-nhat-co-thuyet-minh-tieng-viet-2.jpg");
        mangquangcao.add("https://sohanews.sohacdn.com/2020/5/26/anh-1-15904595256101028474846-15904596473971514545073.png");


        for (int i = 0; i < mangquangcao.size(); i++) {

            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.with(getApplicationContext()).load(mangquangcao.get(i)).into(imageView);

            //cho image tu can full
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        // cho tu chay trong 5s
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_right);
        Animation animation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_right);
        viewFlipper.setInAnimation(animation_slide_in);
        viewFlipper.setOutAnimation(animation_slide_out);
    }
}