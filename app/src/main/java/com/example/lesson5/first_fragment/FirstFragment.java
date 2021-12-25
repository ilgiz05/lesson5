package com.example.lesson5.first_fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.lesson5.R;
import com.example.lesson5.second_fragment.SecondFragment;

public class FirstFragment extends Fragment {
    Button btnOpen;
    TextView tvText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnOpen = view.findViewById(R.id.btn_open);
        tvText = view.findViewById(R.id.tv_text);
        listeners();
        getData();
    }

    private void listeners() {
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondFragment secondFragment = new SecondFragment();
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container_fragment, secondFragment).commit();
            }
        });
    }

    private void getData() {
        if (getArguments() != null) {
            String s = getArguments().getString("key");
            tvText.setText(s);

        }
        tvText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = tvText.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("key1", string);
                SecondFragment secondFragment = new SecondFragment();
                secondFragment.setArguments(bundle);
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.container_fragment, secondFragment).commit();
            }
        });
    }
}