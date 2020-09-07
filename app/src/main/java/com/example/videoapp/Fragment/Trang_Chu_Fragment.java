package com.example.videoapp.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.videoapp.Action.OnClickItem;
import com.example.videoapp.Adapter.AdapterFragment;
import com.example.videoapp.Adapter.AdapterFragment2;
import com.example.videoapp.Context.Contect;
import com.example.videoapp.GetData.GetData;

import com.example.videoapp.Main.Film;
import com.example.videoapp.Main.GameShow;
import com.example.videoapp.Main.HoatHinh;
import com.example.videoapp.Main.PlayVideo;
import com.example.videoapp.R;
import com.example.videoapp.databinding.TrangChuFrangmentBinding;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class Trang_Chu_Fragment extends Fragment {

    TrangChuFrangmentBinding binding;
    AdapterFragment adapter, adapter4;
    AdapterFragment2 adapter2, adapter3;
    TextView tvPhim, tvHoatHinh, tvGame;
    String url = "http://demo1913415.mockable.io/GetItemCategoryOne";
    String url2 = "http://demo8640072.mockable.io/abc";
    String url3 = "http://demo1913415.mockable.io/GetItemCategoryTwo";
    String url4 ="http://demo8640072.mockable.io/thieunhi";
    public static final String TAG = "TAG";
    GetData getDataq;
    List<Contect> list, list3;
    List<Contect> list2, list4;


    public static Trang_Chu_Fragment newInstance() {
        Bundle bundle = new Bundle();
        Trang_Chu_Fragment trangChuFragment = new Trang_Chu_Fragment();
        trangChuFragment.setArguments(bundle);
        return trangChuFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.trang_chu_frangment, container, false);

        binding.phim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Film.class);
                startActivity(intent);

            }
        });
        binding.game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), GameShow.class);
                startActivity(intent);
            }
        });
        binding.hoathinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), HoatHinh.class);
                startActivity(intent);
            }
        });

        getData();
        list = new ArrayList<>();
        list2 = new ArrayList<>();
        list3 = new ArrayList<>();
        list4 = new ArrayList<>();
        getDataq = new GetData();


        getDataq.getDataJSON1(url, list, getContext(), binding.pro);
        getDataq.getDataJSON1(url2, list2, getContext(), binding.pro);
        getDataq.getDataJSON1(url3, list3, getContext(), binding.pro);
        getDataq.getDataJSON1(url4,list4,getContext(),binding.pro);

        adapter = new AdapterFragment(list, getContext());
        adapter2 = new AdapterFragment2(list3, getContext());
        adapter3 = new AdapterFragment2(list2, getContext());
        adapter4= new AdapterFragment(list4,getContext());


        binding.rc1.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager1 = new GridLayoutManager(getContext(), 1, RecyclerView.HORIZONTAL, false);
        binding.rc1.setLayoutManager(layoutManager1);

        binding.rc3.setAdapter(adapter4);
        RecyclerView.LayoutManager layoutManager3 = new GridLayoutManager(getContext(), 1, RecyclerView.HORIZONTAL, false);
        binding.rc3.setLayoutManager(layoutManager3);

        binding.rc2.setAdapter(adapter3);
        RecyclerView.LayoutManager layoutManager2 = new GridLayoutManager(getContext(), 1, RecyclerView.HORIZONTAL, false);
        binding.rc2.setLayoutManager(layoutManager2);

        binding.rc4.setAdapter(adapter2);
        RecyclerView.LayoutManager layoutManager4 = new GridLayoutManager(getContext(), 2, RecyclerView.HORIZONTAL, false);
        binding.rc4.setLayoutManager(layoutManager4);

        adapter.setOnClickItem(new OnClickItem() {
            @Override
            public void onClickLayoutItem(Contect contect) {
                Intent intent = new Intent(getContext(), PlayVideo.class);
                intent.putExtra("object", contect);
                startActivity(intent);
            }
        });

        adapter2.setOnClickItem(new OnClickItem() {
            @Override
            public void onClickLayoutItem(Contect contect) {
                Intent intent = new Intent(getContext(), PlayVideo.class);
                intent.putExtra("object", contect);
                startActivity(intent);
            }
        });
        adapter3.setOnClickItem(new OnClickItem() {
            @Override
            public void onClickLayoutItem(Contect contect) {
                Intent intent = new Intent(getContext(), PlayVideo.class);
                intent.putExtra("object", contect);
                startActivity(intent);
            }
        });


        return binding.getRoot();

    }


    private void getData() {

        ArrayList<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://i.ytimg.com/vi/a5tD7OeRxnQ/maxresdefault.jpg");
        mangquangcao.add("https://phunuvatiepthi.net/wp-content/uploads/2019/10/4LI5OLQ.jpg");
        mangquangcao.add("https://t.a4vn.com/2019/11/7/doan-van-hau-banh-trai-xuat-hien-huan-luyen-cho-dan-cau-thu-nhi-9c1.jpg");
        mangquangcao.add("https://i.ytimg.com/vi/GwkP1dDszpI/maxresdefault.jpg");


        for (int i = 0; i < mangquangcao.size(); i++) {

            ImageView imageView = new ImageView(getActivity());
            Picasso.with(getActivity()).load(mangquangcao.get(i)).into(imageView);

            //cho image tu can full
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            binding.Viewflipper.addView(imageView);
        }
        // cho tu chay trong 5s
        binding.Viewflipper.setFlipInterval(5000);
        binding.Viewflipper.setAutoStart(true);
        Animation animation_slide_in = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_in_right);
        Animation animation_slide_out = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_out_right);
        binding.Viewflipper.setInAnimation(animation_slide_in);
        binding.Viewflipper.setOutAnimation(animation_slide_out);
    }


    public void getDataJSON1(String url, final List<Contect> list, Context context, final ProgressBar progressBar) {



        RequestQueue requestQueue = Volley.newRequestQueue(context);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("json: ",response.toString());

                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                String title = jsonObject.getString("title");
                                String avatar = jsonObject.getString("avatar");
                                int user_created = jsonObject.getInt("user_created");
                                int user_modified = jsonObject.getInt("user_modified");
                                String date_created = jsonObject.getString("date_created");
                                String date_modified = jsonObject.getString("date_modified");
                                String mp4 = jsonObject.getString("file_mp4");
                                int size = jsonObject.getInt("file_mp4_size");
                                String linkUtbe = jsonObject.getString("youtube_url");
                                Contect contect1 = new Contect(title, avatar, date_created, date_modified, mp4, size, linkUtbe);
                                list.add(contect1);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                        if(list.size()>0){
                            progressBar.setVisibility(View.GONE);
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        requestQueue.add(jsonArrayRequest);
    }

}



