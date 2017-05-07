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

import com.project.julia.ioweyou.Adapters.GroupsAdapter;
import com.project.julia.ioweyou.Model.Group;
import com.project.julia.ioweyou.R;

import java.util.ArrayList;
import java.util.List;

public class GroupsFragment extends Fragment {
    int color;
    GroupsAdapter adapter;

    public GroupsFragment() {
    }

    @SuppressLint("ValidFragment")
    public GroupsFragment(int color) {
        this.color = color;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.groups_fragment, container, false);

        final FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.groupsfrag_bg);
        frameLayout.setBackgroundColor(color);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.groupsfrag_scrollableview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        List<String> list = new ArrayList<String>();
        for (int i = 0; i < Group.data.length; i++)
        {
            list.add(Group.data[i]);
        }

        adapter = new GroupsAdapter(list);
        recyclerView.setAdapter(adapter);

        return view;
    }
}