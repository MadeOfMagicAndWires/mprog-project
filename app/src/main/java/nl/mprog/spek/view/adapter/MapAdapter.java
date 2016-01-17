/**
 * Map Adapter class to relay a Map of key-value entries to a ViewGroup
 *
 * @author Joost Bremmer
 * @since  2016
 *
 */

package nl.mprog.spek.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Map;
import nl.mprog.spek.R;

public class MapAdapter extends BaseAdapter {

    private final Map mData;
    private final ArrayList mKeys;

    //TODO: documentation.
    private static class ViewHolder{
        TextView key;
        TextView value;
    }

    /**
     * Constructor
     * @param map map you want to turn into views.
     */
    public MapAdapter(Map map) {
        super();
        mData = map;
        mKeys = new ArrayList<>(mData.keySet());
    }

    /**
     * return amount of key-value entries.
     */
    @Override
    public int getCount() {
        return mKeys.size();

    }

    /**
     * Gets the value pertaining to a key
     * @param position position of key
     * @return value of key.
     */
    @Override
    public Object getItem(int position) {
        return mData.get(mKeys.get(position));
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        final View view;
        final ViewHolder holder = new ViewHolder();

        String keyString  = mKeys.get(position).toString();
        String valueString = getItem(position).toString();

        if(convertView != null) {
            view = convertView;
        }
        else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.info_list_item,
                    parent, false);
        }

        initHolder(view, holder);
        holder.key.setText(keyString);
        holder.value.setText(valueString);


        return view;

    }

    ViewHolder initHolder(View view, ViewHolder holder){

        holder.key = (TextView) view.findViewById(R.id.key);
        holder.value = (TextView) view.findViewById(R.id.value);
        view.setTag(holder);

        return holder;
    }
}
