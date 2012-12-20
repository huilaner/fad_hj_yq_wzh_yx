package testfinal.edu.upenn.cis350;

import android.test.ActivityInstrumentationTestCase2;
import edu.upenn.cis350.*;

import android.app.Activity;

import android.widget.ScrollView;

/**
 * SearchResultActivity cannot be tested effectively, as it is populated by an array of search results, which depends on user interactions and
 * the database
 * @author DXU
 *
 */
public class SearchResultTest extends ActivityInstrumentationTestCase2<SearchResultActivity> {

	
	public SearchResultTest() {
		super(SearchResultActivity.class);
	}

	private Activity activity;
	private ScrollView scroll;

	protected void setUp() throws Exception {
		super.setUp();
		activity= getActivity();
		scroll= (ScrollView)activity.findViewById(R.id.scrollView1);
	}
	
	public void testResults() {
		assertNotNull(scroll);
	}

}
