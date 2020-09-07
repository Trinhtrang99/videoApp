package com.example.videoapp.GetData;


import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.videoapp.Context.Contect;
import com.example.videoapp.Context.Video;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class GetData {


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






//    public void getJsonData2(String url, List<Video> list, Context context,ProgressBar progressBar) {
//        //  String URL = "https://raw.githubusercontent.com/bikashthapa01/myvideos-android-app/master/data.json";
//        RequestQueue requestQueue = Volley.newRequestQueue(context);
//
//        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                //Log.d(TAG, "onResponse: "+ response);
//                try {
//                    JSONArray categories = response.getJSONArray("categories");
//                    JSONObject categoriesData = categories.getJSONObject(0);
//                    JSONArray videos = categoriesData.getJSONArray("videos");
//
//                    //Log.d(TAG, "onResponse: "+ videos);
//
//                    for (int i = 0; i< videos.length();i++){
//                        JSONObject video = videos.getJSONObject(i);
//
//                        Video v = new Video();
//
//                        v.setTitle(video.getString("title"));
//                        v.setDescription(video.getString("description"));
//                        v.setAuthor(video.getString("subtitle"));
//                        v.setImageUrl(video.getString("thumb"));
//                        JSONArray videoUrl = video.getJSONArray("sources");
//                        v.setVideoUrl(videoUrl.getString(0));
//
//                        list.add(v);
//
//                    }
//                    if(list.size()>0){
//                        progressBar.setVisibility(View.GONE);
//                    }
//                    else {
//                        progressBar.setVisibility(View.VISIBLE);
//                    }
//
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//
//        requestQueue.add(objectRequest);
//    }
}
