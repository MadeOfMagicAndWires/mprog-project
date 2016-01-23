/**
 * Memory Fragment class used to display Memory information from Hardware on screen.
 *
 * @author Joost Bremmer
 * @since  2016
 */

package nl.mprog.spek.fragment;

import nl.mprog.spek.interfaces.HardwareInfoInterface;
import nl.mprog.spek.model.Hardware;

public class MemoryFragment extends SpekFragment implements HardwareInfoInterface {
    public MemoryFragment() {
        // Required empty public constructor
    }


    public static MemoryFragment newInstance(String param1, String param2) {
        return (MemoryFragment) SpekFragment.newInstance(param1, param2);
    }

    @Override
    public void setMapData() {
        super.setMapData();

        info.put("Total RAM", formatFileSize(Hardware.Memory.getTotalRam(getActivity())));
        info.put("Virtual Memory Size", formatFileSize(Hardware.Memory.V_MEM));
        info.put("Free Memory", formatFileSize(Hardware.Memory.FREE_MEM));
    }

}
