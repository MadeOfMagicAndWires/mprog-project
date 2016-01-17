/**
 * Graphics Fragment class used to display Graphics information from Hardware on screen.
 *
 * @author Joost Bremmer
 * @since  2016
 */

package nl.mprog.spek.fragment;

import nl.mprog.spek.interfaces.HardwareInfoInterface;


public class GraphicsFragment extends SpekFragment implements HardwareInfoInterface {
    public GraphicsFragment() {
        // Required empty public constructor
    }


    public static GraphicsFragment newInstance(String param1, String param2) {
        return (GraphicsFragment) SpekFragment.newInstance(param1, param2);
    }

    @Override
    public void setMapData() {
        super.setMapData();
    }

}
