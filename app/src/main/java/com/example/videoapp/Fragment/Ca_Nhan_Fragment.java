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
import com.example.videoapp.databinding.CaNhanFrangmentBinding;


public class Ca_Nhan_Fragment extends Fragment {
    CaNhanFrangmentBinding binding ;
    public static Ca_Nhan_Fragment newInstance(){
        Bundle bundle = new Bundle();
        Ca_Nhan_Fragment caNhanFragment = new Ca_Nhan_Fragment();
        caNhanFragment.setArguments(bundle);
        return caNhanFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       binding = DataBindingUtil.inflate(inflater, R.layout.ca_nhan_frangment,container,false);
        return binding.getRoot();
    }
}
