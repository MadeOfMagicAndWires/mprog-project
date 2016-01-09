package nl.mprog.spek.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import nl.mprog.spek.R;
import nl.mprog.spek.model.Hardware;

/**
 *
 * DeviceFragment class.
 *
 */
public class DeviceFragment extends SpekFragment {
    public DeviceFragment() {
        // Required empty public constructor
    }


    public static DeviceFragment newInstance(String param1, String param2) {
        return (DeviceFragment) SpekFragment.newInstance(param1, param2);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.info_list_item, container, false);
        TextView label = (TextView) layout.findViewById(R.id.label);
        label.setText("Model");
        TextView value = (TextView) layout.findViewById(R.id.value);
        value.setText(Hardware.Device.MODEL);



        return layout;
    }

}
