package by.aleks.geekschat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import io.kimo.lib.faker.Faker;

import java.util.ArrayList;

public class UsersActivity extends AppCompatActivity {

    private ListView usersListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        usersListView = (ListView)findViewById(R.id.usersListView);
        final UsersAdapter usersAdapter = new UsersAdapter(this, R.layout.item_user, getUsers());
        usersListView.setAdapter(usersAdapter);
        usersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                User user = usersAdapter.getItem(i);
                Intent profileIntent = new Intent(UsersActivity.this, ProfileActivity.class);
                profileIntent.putExtra("name", user.getName());
                profileIntent.putExtra("friendsNum", user.getFriendsNum());
                profileIntent.putExtra("email", user.getEmail());
                profileIntent.putExtra("imgSrc", user.getImgSrc());
                startActivity(profileIntent);
            }
        });
    }


    private ArrayList<User> getUsers(){

        ArrayList<User> users = new ArrayList<>();
        for(int i=0; i<20; i++){
            users.add(new User(Faker.with(this).Name.fullName(), Faker.Internet.email(), 5, Faker.Url.avatar()));
        }

        return users;
    }
}
