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
        ArrayAdapter<String> usersAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getUsers());
        usersListView.setAdapter(usersAdapter);
    }


    private ArrayList<String> getUsers(){

        ArrayList<String> users = new ArrayList<>();
        for(int i=0; i<20; i++){
            users.add("User "+i);
        }

        return users;
    }
}
