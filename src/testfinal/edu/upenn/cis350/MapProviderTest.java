package testfinal.edu.upenn.cis350;
import com.google.android.maps.MapView;

import android.test.ActivityInstrumentationTestCase2;
import edu.upenn.cis350.*;

import android.app.Activity;

/**
 * This class effectively cannot be tested as it relies almost exclusively on the Maps framework and interactions with the user's inputs
 * @author DXU
 *
 */
public class MapProviderTest extends ActivityInstrumentationTestCase2<MapProviderActivity> {
	


	
	public MapProviderTest() {
		super(MapProviderActivity.class);
	}
	private Activity activity;
	private MapView mapview;

	protected void setUp() throws Exception {
		super.setUp();
		activity= getActivity();
		mapview= (MapView)activity.findViewById(R.id.mapview);
	}
	
	public void testMaps() {
		assertNotNull(mapview);
	}

}
