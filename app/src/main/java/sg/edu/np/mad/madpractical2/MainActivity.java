package sg.edu.np.mad.madpractical2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final String title = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(title, "Create!");

        TextView UserName= findViewById(R.id.textView2);
        TextView UserDesc = findViewById(R.id.textView);

        Intent intent= getIntent();
        User user = (User) intent.getSerializableExtra("selected_user");

        // create a new db handler to reference
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        if (user != null) {
            UserName.setText(user.getUserName());
            UserDesc.setText(user.getUserDescription());
            Log.v("User ID", String.valueOf(user.getUserId()));

            Button follow = findViewById(R.id.followBtn);
            if(!user.userFollowed){
                follow.setText("Follow");
            }
            else{
                follow.setText("Unfollow");
            }
            follow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(user.userFollowed == false){
                        follow.setText("Unfollow");
                        user.userFollowed = true;
                        dbHandler.updateUser(user);
                        Toast.makeText(MainActivity.this, "Followed", Toast.LENGTH_SHORT).show();
                    } else {
                        user.userFollowed = false;
                        follow.setText("Follow");
                        dbHandler.updateUser(user);
                        Toast.makeText(MainActivity.this, "Unfollowed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}