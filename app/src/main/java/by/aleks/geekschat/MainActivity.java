package by.aleks.geekschat;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import io.kimo.lib.faker.Faker;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView friendsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(getString(R.string.my_friends));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent usersIntent = new Intent(MainActivity.this, UsersActivity.class);
                startActivity(usersIntent);
            }
        });
        friendsListView = (ListView)findViewById(R.id.mainList);
        UsersAdapter usersAdapter = new UsersAdapter(this, R.layout.item_user, getFriends());
        friendsListView.setAdapter(usersAdapter);
    }

    private ArrayList<User> getFriends(){

        ArrayList<User> users = new ArrayList<>();
        for(int i=0; i<5; i++){
            users.add(new User(Faker.with(this).Name.fullName(), Faker.Internet.email(), 5, Faker.Url.avatar()));
        }

        return users;
    }

}
