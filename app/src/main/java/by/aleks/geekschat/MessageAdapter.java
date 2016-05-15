package by.aleks.geekschat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Alex on 5/15/16.
 */
public class MessageAdapter extends ArrayAdapter<Message> {
    public MessageAdapter(Context context, int resource, List<Message> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Message message = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_message, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.messageName);
        ImageView avatar = (ImageView)convertView.findViewById(R.id.messageAvatar);
        TextView content = (TextView)convertView.findViewById(R.id.messageText);
        TextView time = (TextView)convertView.findViewById(R.id.messageTime);

        name.setText(message.getUser().getName());
        Picasso.with(getContext()).load(message.getUser().getImgSrc()).into(avatar);
        content.setText(message.getContent());
        time.setText(msToDate(message.getTimeMs()));

        return convertView;
    }

    private String msToDate(long ms){
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        return df.format(ms);
    }

}
