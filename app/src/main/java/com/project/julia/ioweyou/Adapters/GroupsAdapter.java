package com.project.julia.ioweyou.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.julia.ioweyou.R;

import java.util.List;

public class GroupsAdapter extends RecyclerView.Adapter<GroupsAdapter.GroupsViewHolder> {
    List<String> versionModels;

    Context context;
    OnItemClickListener clickListener;

    public GroupsAdapter(Context context)
    {
        this.context = context;
    }

    public GroupsAdapter(List<String> versionModels)
    {
        this.versionModels = versionModels;
    }

    @Override
    public GroupsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerlist_item, viewGroup, false);
        return new GroupsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GroupsViewHolder versionViewHolder, int i)
    {
        versionViewHolder.title.setText(versionModels.get(i));
    }

    @Override
    public int getItemCount()
    {
        return versionModels == null ? 0 : versionModels.size();
    }

    class GroupsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        CardView cardItemLayout;
        TextView title;
        TextView subTitle;

        public GroupsViewHolder(View itemView)
        {
            super(itemView);

            cardItemLayout = (CardView) itemView.findViewById(R.id.cardlist_item);
            title = (TextView) itemView.findViewById(R.id.listitem_name);
            subTitle = (TextView) itemView.findViewById(R.id.listitem_subname);
        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(v, getPosition());
        }
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public void SetOnItemClickListener(final OnItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

}
