package com.example.videoapp.Main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
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

public class GameShow extends AppCompatActivity {
    AdapterFragment adapter, adapter4;
    AdapterFragment2 adapter2, adapter3;
    RecyclerView rc1, rc2, rc3, rc4;
    GetData getDataq;
    ProgressBar pro;
    Toolbar toolbar;
    List<Contect> list1, list3;
    List<Contect> list2, list4;
    ViewFlipper viewFlipper;
    String url2 = "http://demo8640072.mockable.io/gameshow";
    String url1 = "http://demo8640072.mockable.io/music";
    String url3 = "http://demo8640072.mockable.io/tnone";
    String url4 = "http://demo8640072.mockable.io/tnforn";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_show);
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
        return true;
    }
    private void getData() {

        ArrayList<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://i.ytimg.com/vi/IFX4HZz9CNg/maxresdefault.jpg");
        mangquangcao.add("https://kenh14cdn.com/thumb_w/640/2020/8/5/srfacebook-avatar-copy-13-1596598923683920182617-crop-15965990204012095762594.jpg");
        mangquangcao.add("https://www.brandsvietnam.com/upload/forum2/2019/06/16876_3_1561718632.jpeg");
        mangquangcao.add("https://media.laodong.vn/Storage/NewsPortal/Uploaded/nguyenthinhatle/2015_12_07/v%20o%204_TNYR.jpg");
        mangquangcao.add("https://top.trangdangtin.com/htdocs/images/news/2019/12/10/800/nhanhnhuchop.jpg");


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