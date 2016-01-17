/**
 * Template Fragment class to base other Fragments off of.
 * Too lazy to add it into Android Studio's actual templates.
 *
 * @author Joost Bremmer
 * @since  2016
 */

package nl.mprog.spek.fragment;

import nl.mprog.spek.interfaces.HardwareInfoInterface;

public class TemplateFragment extends SpekFragment implements HardwareInfoInterface {
    public TemplateFragment() {
        // Required empty public constructor
    }


    public static TemplateFragment newInstance(String param1, String param2) {
        return (TemplateFragment) SpekFragment.newInstance(param1, param2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMapData() {
        super.setMapData();
    }

}
