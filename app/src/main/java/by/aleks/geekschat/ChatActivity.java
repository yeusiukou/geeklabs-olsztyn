package by.aleks.geekschat;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import io.kimo.lib.faker.Faker;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {

    ListView messageListView;
    ArrayList<Message> messageList;
    ImageButton sendButton;
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        messageListView = (ListView) findViewById(R.id.chatMessages);
        messageList = new ArrayList<>();
        final MessageAdapter adapter = new MessageAdapter(this, R.layout.item_message, messageList);
        messageListView.setAdapter(adapter);
        messageListView.setDivider(null);
        input = (EditText) findViewById(R.id.chatInput);

        final User user = new User("Alex", "mymail@mail.pl", 5, Faker.Url.avatar());

        sendButton = (ImageButton) findViewById(R.id.chatSendButton);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                messageList.add(new Message(user, input.getText().toString(), System.currentTimeMillis()));
                adapter.notifyDataSetChanged();
                input.setText("");

                //hide keyboard
                // Check if no view has focus:
                View focusedView = ChatActivity.this.getCurrentFocus();
                if (focusedView != null) {
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            }
        });
    }
}
