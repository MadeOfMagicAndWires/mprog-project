package nl.mprog.spek.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import nl.mprog.spek.R;

/**
 * Superclass for all fragments.
 * Unfortunately can't make it abstract because newInstance makes an instance of this class.
 */

public class SpekFragment extends Fragment {

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
        return inflater.inflate(R.layout.info_list_item, container, false);
    }


}
