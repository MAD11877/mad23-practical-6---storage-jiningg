package sg.edu.np.mad.madpractical2;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    ArrayList<User> userData;

    public UserAdapter(ArrayList<User> input){
        this.userData = input;
    }

    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View item;
        if (viewType == 1) {
            item = inflater.inflate(R.layout.recycler_view_item2, parent, false);
        } else {
            item = inflater.inflate(R.layout.recycler_view_item, parent, false);
        }
        return new UserViewHolder(item, userData, viewType);
    }

    public void onBindViewHolder(UserViewHolder holder, int position){
        User user_details = userData.get(position);
        holder.txt.setText(user_details.getUserName());
        holder.desc.setText(user_details.getUserDescription());
    }

    public int getItemCount(){
        return userData.size();
    }

    @Override
    public int getItemViewType(int position) {
        String name = userData.get(position).getUserName();
        // Get the last digit of the name
        int lastDigit = Integer.parseInt(name.substring(name.length() - 1));

        // Check if the last digit is 7
        if (lastDigit == 7) {
            return 1;
        } else {
            return 0;
        }
    }
}