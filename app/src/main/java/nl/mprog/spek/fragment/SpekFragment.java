/**
 * Superclass for all fragments.
 * Not to be meddled or trifled with! Certainly not to be initialized.
 * Unfortunately can't make it abstract because newInstance makes an instance of this class.
 *
 * @author Joost Bremmer
 * @since 2016
 */

package nl.mprog.spek.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;


import nl.mprog.spek.R;
import nl.mprog.spek.model.Hardware;
import nl.mprog.spek.view.adapter.MapAdapter;


public class SpekFragment extends Fragment {

    static final protected LinkedHashMap<String, String> info = new LinkedHashMap<>();
    static public MapAdapter infoAdapter;

    public SpekFragment() {
        // Required empty public constructor
    }


    public static SpekFragment newInstance(String param1, String param2) {
        SpekFragment fragment = new SpekFragment();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragment = inflater.inflate(R.layout.fragment_spek, container, false);

        //set the data to be shown and adapt it.
        setMapData();
        setAdapter(fragment);
        infoAdapter.notifyDataSetChanged();

        return fragment;
    }

    /**
     * The "meat" of every Fragment.
     * This is where the various Hardware information will be set in key-value entries,
     * the key being a label and the value the actual data you want shown.
     */
    public void setMapData(){
        info.clear();
    }


    /**
     * Creates a new adapter to process Map entries, and links it to Listview.
     * @param view View containing a ListView with the id info_list.
     */
    public void setAdapter(View view){
        //init Adapter and bind it to the Listview
        infoAdapter = new MapAdapter(info);
        ListView infoList = (ListView) view.findViewById(R.id.info_list);
        infoList.setAdapter(infoAdapter);
    }

    /**
     * Creates a new adapter to process Map entries, and links it to Listview.
     * @param view ListView you want to display the Map entries in.
     */
    public void setAdapter(ListView view){
        //init Adapter and bind it to the Listview
        infoAdapter = new MapAdapter(info);
        view.setAdapter(infoAdapter);
    }

    /**
     * Returns a number of bytes as a more human readable string.
     * @param n long, the amount of bytes you need formatted.
     * @return String "n (bytes,kB,MB, and so on)"
     */
    public String formatFileSize(long n){
        return android.text.format.Formatter.formatFileSize(getActivity(), n);
    }

}
