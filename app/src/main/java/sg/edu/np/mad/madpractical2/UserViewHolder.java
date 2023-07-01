package sg.edu.np.mad.madpractical2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserViewHolder extends RecyclerView.ViewHolder {
    TextView txt;
    TextView desc;
    ImageView image;

    ArrayList<User> userData;

    public UserViewHolder(View itemView, ArrayList<User> user_list, int viewType){
        super(itemView);
        this.userData = user_list;
        txt = itemView.findViewById(R.id.textView5);
        desc = itemView.findViewById(R.id.textView6);
        image = itemView.findViewById(R.id.imageView2);

        // Set additional properties for the special layout
        if (viewType == 1) {
            ImageView specialImageView = itemView.findViewById(R.id.imageView4);

            specialImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showAlertDialog(userData);
                }
            });
        }

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showAlertDialog(userData);
                showAlertDialog(userData);
            }
        });

    }
    private void showAlertDialog(ArrayList<User> userData) {
        AlertDialog.Builder builder = new AlertDialog.Builder(itemView.getContext());
        User selectedUser = userData.get(getAdapterPosition());
        builder.setTitle("Profile");
        builder.setMessage(selectedUser.getUserName());
        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    User selectedUser = userData.get(getAdapterPosition());
                    Intent profileIntent = new Intent(itemView.getContext(), MainActivity.class);
                    profileIntent.putExtra("selected_user", selectedUser);
                    itemView.getContext().startActivity(profileIntent);

                }
            }
        });

        builder.setNegativeButton("Close", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
