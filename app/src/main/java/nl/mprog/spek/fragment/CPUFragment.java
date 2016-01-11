package nl.mprog.spek.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nl.mprog.spek.interfaces.HardwareInfoInterface;
import nl.mprog.spek.model.Hardware;

/**
 *
 * CPUFragment class.
 *
 */
public class CPUFragment extends SpekFragment implements HardwareInfoInterface {
    public CPUFragment() {
        // Required empty public constructor
    }


    public static CPUFragment newInstance(String param1, String param2) {
        return (CPUFragment) SpekFragment.newInstance(param1, param2);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void setMapData() {
        //TODO: Get CPU INFORMATION.
    }

}
