package by.aleks.geekschat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class UsersActivity extends AppCompatActivity {

    private ListView usersListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        usersListView = (ListView)findViewById(R.id.usersListView);
        UsersAdapter usersAdapter = new UsersAdapter(this, R.layout.item_user, getUsers());
        usersListView.setAdapter(usersAdapter);
    }


    private ArrayList<User> getUsers(){

        ArrayList<User> users = new ArrayList<>();
        for(int i=0; i<20; i++){
            users.add(new User("user "+i, "some@mail.com", 5, "http://"));
        }

        return users;
    }
}
