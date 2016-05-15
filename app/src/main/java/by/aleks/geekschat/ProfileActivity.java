package by.aleks.geekschat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;

public class ProfileActivity extends AppCompatActivity {

    private TextView name;
    private TextView email;
    private ImageView avatar;
    private Button addButton;
    private TextView friendNum;

    private int friends = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setTitle(getIntent().getStringExtra("name"));

        name = (TextView) findViewById(R.id.profileName);
        email = (TextView) findViewById(R.id.profileEmail);
        friendNum = (TextView) findViewById(R.id.profileFriendsNum);
        avatar = (ImageView) findViewById(R.id.profileAvatar);
        addButton = (Button) findViewById((R.id.profileAddButton));

        name.setText(getIntent().getStringExtra("name"));
        email.setText(getIntent().getStringExtra("email"));
        friendNum.setText(String.valueOf(getIntent().getIntExtra("friendsNum", 0)));
        Picasso.with(this).load(getIntent().getStringExtra("imgSrc")).into(avatar);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProfileActivity.this, getString(R.string.friend_added), Toast.LENGTH_SHORT).show();
                friendNum.setText(String.valueOf(++friends));
            }
        });
    }

}
