package com.example.peek;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.FriendViewHolder> {

    private List<Friend> friendsList;
    private Context context;

    public FriendAdapter(Context context, List<Friend> friendsList) {
        this.context = context;
        this.friendsList = friendsList;
    }

    public static class FriendViewHolder extends RecyclerView.ViewHolder {
        TextView name, username;
        ImageView imageView;
        ImageButton starButton;

        public FriendViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textViewName);
            username = itemView.findViewById(R.id.textViewUsername);
            imageView = itemView.findViewById(R.id.imageView2);
            starButton = itemView.findViewById(R.id.starButton);
        }
    }

    @Override
    public FriendViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.friend_card_items, parent, false);
        return new FriendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FriendViewHolder holder, int position) {
        Friend friend = friendsList.get(position);

        holder.name.setText(friend.getName());
        holder.username.setText(friend.getUsername());
        holder.imageView.setImageResource(friend.getImageResId());

        // Set star icon based on state
        if (friend.isStarred()) {
            holder.starButton.setImageResource(R.drawable.filled);
        } else {
            holder.starButton.setImageResource(R.drawable.unfilled);
        }

        holder.starButton.setOnClickListener(v -> {
            boolean newState = !friend.isStarred();
            friend.setStarred(newState);
            notifyItemChanged(position);
        });
    }

    @Override
    public int getItemCount() {
        return friendsList.size();
    }
}
