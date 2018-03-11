package com.example.jay.chatapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jay.chatapp.R;
import com.example.jay.chatapp.model.Message;

import java.util.List;

/**
 * Created by Jay on 11-03-2018.
 */
public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {


    private List<Message> chats;

    public ChatAdapter(List<Message> items) {
        this.chats = items;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        switch (viewType) {
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user1, parent, false);
                break;
            case 2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user2, parent, false);
                break;
            case 3:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user1_again, parent, false);
                break;
            case 4:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user2_again, parent, false);
                break;
        }
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.userMessage.setText(chats.get(position).getBody() != null ? chats.get(position).getBody() : "");
    }

    @Override
    public int getItemCount() {
        return chats != null ? chats.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView userMessage;

        public ViewHolder(View view) {
            super(view);
            userMessage = (TextView) view.findViewById(R.id.tv1);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (chats != null) {
            String to = chats.get(position).getTo();
            //String from = chats.get(position).getFrom();
            if (to != null) {
                if (to.equals("user1")) {
                    //check for previous
                    if (position > 0) {
                        if (to.equals("user1") && chats.get(position - 1).getTo().equals("user1"))
                            return 3;
                        else
                            return 1;
                    } else
                        return 1;
                } else //if (to.equals("user2"))
                {
                    //check for previous
                    if (position > 0) {
                        if (to.equals("user2") && chats.get(position - 1).getTo().equals("user2"))
                            return 4;
                        else
                            return 2;
                    } else
                        return 2;
                }
            }
        }
        return 0;
    }
}