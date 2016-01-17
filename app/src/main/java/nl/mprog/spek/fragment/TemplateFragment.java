package nl.mprog.spek.fragment;

import nl.mprog.spek.interfaces.HardwareInfoInterface;

/**
 *
 * CPUFragment class.
 *
 */
public class TemplateFragment extends SpekFragment implements HardwareInfoInterface {
    public TemplateFragment() {
        // Required empty public constructor
    }


    public static TemplateFragment newInstance(String param1, String param2) {
        return (TemplateFragment) SpekFragment.newInstance(param1, param2);
    }

    @Override
    public void setMapData() {
        super.setMapData();
    }

}
