package nl.mprog.spek.fragment;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.File;

import nl.mprog.spek.interfaces.HardwareInfoInterface;
import nl.mprog.spek.model.Hardware;

/**
 *
 * DeviceFragment class.
 *
 */
public class DeviceFragment extends SpekFragment implements HardwareInfoInterface {
    public DeviceFragment() {
        // Required empty public constructor
    }


    public static DeviceFragment newInstance(String param1, String param2) {
        return (DeviceFragment) SpekFragment.newInstance(param1, param2);
    }


    @Override
    @TargetApi(Build.VERSION_CODES.M)
    public void setMapData() {
        super.setMapData();

        assert(info != null);
        assert(infoAdapter != null);

        info.put("Model", Hardware.Device.MODEL);
        info.put("Brand", Hardware.Device.BRAND);
        info.put("Manufacturer", Hardware.Device.MANUFACTURER);
        info.put("Codename", Hardware.Device.PRODUCT);

        info.put("OS", Hardware.Device.VERSION);
        info.put("Broadband version", Hardware.Device.RADIO);
        info.put("Kernel", Hardware.Device.KERNEL);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            info.put("Security Patch Version", Hardware.Device.getSecurityPatch());
        }
    }

}
