package org.pursuit.simpleastrology.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.simpleastrology.R;

public class ZodiacFragment extends Fragment {
    public static final String KEY = "zodiac_Frag";
    private FragmentInterface fragmentInterface;


    public ZodiacFragment() {
        // Required empty public constructor
    }

    public static ZodiacFragment newInstance(){
        ZodiacFragment zodiacFragment = new ZodiacFragment();
        Bundle args = new Bundle();
        zodiacFragment.setArguments(args);
        return zodiacFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentInterface) {
            fragmentInterface = (FragmentInterface) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentInterface");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            // string = getArgs().getString(KEY)
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_zodiac, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
