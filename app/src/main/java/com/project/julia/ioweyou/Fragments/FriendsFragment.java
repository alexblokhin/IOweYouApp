package com.project.julia.ioweyou.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.project.julia.ioweyou.Adapters.FriendsAdapter;
import com.project.julia.ioweyou.Adapters.GroupsAdapter;
import com.project.julia.ioweyou.R;

/**
 * Created by Alex on 4/21/2017.
 */

public class FriendsFragment extends Fragment {
    int color;
    GroupsAdapter adapter;

    public FriendsFragment() {
    }

    @SuppressLint("ValidFragment")
    public FriendsFragment(int color) {
        this.color = color;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.friends_fragment, container, false);

        final FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.friendsfrag_bg);
        frameLayout.setBackgroundColor(color);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.friendsfrag_scrollableview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        FriendsAdapter adapter = new FriendsAdapter(getContext());
        recyclerView.setAdapter(adapter);

        return view;
    }
}