package testfinal.edu.upenn.cis350;
import edu.upenn.cis350.*;

import android.app.Activity;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ListView;


/**
 * Populating the history of a user's interactions with the application requires many simulations and hence is not very testable
 * @author DXU
 *
 */
public class TestHistory extends ActivityInstrumentationTestCase2<HistoryActivity> {
	

	public TestHistory() {
		super(HistoryActivity.class);
		// TODO Auto-generated constructor stub
	}

	private Activity activity;
	private ListView lv;
	
	
	
	
	public void setUp() throws Exception {
		super.setUp();
		Intent addEvent = new Intent();
		addEvent.putExtra("id", (long)0);
		setActivityIntent(addEvent);
		activity = getActivity();
		lv = (ListView)activity.findViewById(R.id.history_res);
		
	}
	
	public void testHistory() {
		activity.runOnUiThread(new Runnable() {
			public void run() {
				
			}
		});
		//wait for UI Thread to finish
		getInstrumentation().waitForIdleSync();

		assertNotNull(lv);

		

		
	}
	
}
