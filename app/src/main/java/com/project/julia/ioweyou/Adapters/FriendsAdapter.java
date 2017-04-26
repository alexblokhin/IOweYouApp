package com.project.julia.ioweyou.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.julia.ioweyou.Model.Friend;
import com.project.julia.ioweyou.R;

import java.util.ArrayList;
import java.util.List;

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.FriendVh>
{

    private List<Friend> friends = new ArrayList<>();
    private Context context;

    public FriendsAdapter(Context context) {
        this.context = context;

        friends = Friend.prepareFriends(
                context.getResources().getStringArray(R.array.friend_names),
                context.getResources().getStringArray(R.array.friend_descriptions));
    }

    @Override
    public FriendVh onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_friend, parent, false);
        return new FriendVh(view);
    }

    @Override
    public void onBindViewHolder(FriendVh holder, int position) {
        Friend friend = friends.get(position);

        holder.mName.setText(friend.getName());
        holder.mDescription.setText(friend.getDescription());
        holder.mFirstLetter.setText(String.valueOf(friend.getFirstLetter()));

    }

    @Override
    public int getItemCount() {
        return friends == null ? 0 : friends.size();
    }

    public static class FriendVh extends RecyclerView.ViewHolder {

        private TextView mName;
        private TextView mDescription;
        private TextView mFirstLetter;

        public FriendVh(View itemView) {
            super(itemView);

            mName = (TextView) itemView.findViewById(R.id.txt_name);
            mDescription = (TextView) itemView.findViewById(R.id.txt_desc);
            mFirstLetter = (TextView) itemView.findViewById(R.id.txt_firstletter);
        }
    }
}
