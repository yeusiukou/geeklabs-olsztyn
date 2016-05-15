package by.aleks.geekschat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Alex on 5/14/16.
 */
public class UsersAdapter extends ArrayAdapter<User> {

    public UsersAdapter(Context context, int resource, List<User> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        User user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.itemUsersName);
        ImageView avatar = (ImageView)convertView.findViewById(R.id.itemUserAvatar);

        name.setText(user.getName());
        Picasso.with(getContext()).load(user.getImgSrc()).into(avatar);

        return convertView;
    }
}
