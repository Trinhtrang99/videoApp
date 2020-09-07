package com.example.videoapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.videoapp.R;
import com.example.videoapp.databinding.TaiXuongFrangmentBinding;


public class Tai_Xuong_Frangment extends Fragment {
    TaiXuongFrangmentBinding binding ;
    public static Tai_Xuong_Frangment newInstance(){
        Bundle bundle = new Bundle();
        Tai_Xuong_Frangment caNhanFragment = new Tai_Xuong_Frangment();
        caNhanFragment.setArguments(bundle);
        return caNhanFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       binding = DataBindingUtil.inflate(inflater, R.layout.tai_xuong_frangment,container,false);
        return binding.getRoot();
    }
}
