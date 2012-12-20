package testfinal.edu.upenn.cis350;

import java.util.ArrayList;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.*;
import edu.upenn.cis350.*;
import edu.upenn.cis350.entities.Provider;
import edu.upenn.cis350.entities.Rating;

public class ProviderTest extends
		ActivityInstrumentationTestCase2<ProviderProfileActivity> {

	@SuppressWarnings("deprecation")
	public ProviderTest() {
		super("edu.upenn.cis350", ProviderProfileActivity.class);
	}

	private ProviderProfileActivity activity;
	// private LayoutInflater factory;
	private Button buttonmap;
	private Button parking;
	private Button creditcard;
	private Button appointment;
	private Button accepting;
	private Button pharmacy;
	private TextView name;
	private TextView address;
	private TextView phone;
	private TextView philosophy;
	private TextView tv_provider_summary;
	private TextView tv_pro1;
	private TextView tv_pro2;
	private TextView tv_pro3;
	private TextView tv_con1;
	private TextView tv_con2;
	private TextView tv_con3;
	private TextView tv_provider_desc;

	private Button statistics;
	private Button rate;
	private TextView rating;

	private TableLayout overallProsConsTable;
	private TextView overallPros1;
	private TextView overallPros2;
	private TextView overallPros3;
	private TextView overallCons1;
	private TextView overallCons2;
	private TextView overallCons3;

	private ExpandableListView expandableListView;
	private View titleView;
	private View listView;
	private ExpandableListAdapter listAdapter;
	private RatingBar stars;
	private TextView userName;
	private TextView date;

	private Provider m_provider;
	private ArrayList<Rating> m_ratings;

	public void setUp() throws Exception {
		super.setUp();
		m_provider = generateProvider("testProvider", 1.300, 2.04);
		m_ratings = generateRating();
		Intent addEvent = new Intent();
		addEvent.putExtra("providers", m_provider);
		addEvent.putExtra("ratings", m_ratings);
		setActivityIntent(addEvent);
		activity = getActivity();
		buttonmap = (Button) activity.findViewById(R.id.button_providerpf_map);
		parking = (Button) activity.findViewById(R.id.provider_parking);
		creditcard = (Button) activity.findViewById(R.id.provider_creditcard);
		accepting = (Button) activity.findViewById(R.id.provider_accepting);
		appointment = (Button) activity
				.findViewById(R.id.provider_appointments);
		pharmacy = (Button) activity.findViewById(R.id.provider_PCP);

		name = (TextView) activity.findViewById(R.id.provider_name);
		address = (TextView) activity.findViewById(R.id.provider_address);
		phone = (TextView) activity.findViewById(R.id.provider_phone);
		philosophy = (TextView) activity
				.findViewById(R.id.provider_philosophy_of_care);

		rating = (TextView) activity
				.findViewById(R.id.providerpf_average_rating_text);
		statistics = (Button) activity
				.findViewById(R.id.providerpf_all_previous_reviews_button);
		rate = (Button) activity.findViewById(R.id.providerpf_rate_button);

		overallProsConsTable = (TableLayout) activity
				.findViewById(R.id.provider_overall_proscons_table);
		overallPros1 = (TextView) activity
				.findViewById(R.id.providerpf_overall_pro1);
		overallPros2 = (TextView) activity
				.findViewById(R.id.providerpf_overall_pro2);
		overallPros3 = (TextView) activity
				.findViewById(R.id.providerpf_overall_pro3);
		overallCons1 = (TextView) activity
				.findViewById(R.id.providerpf_overall_con1);
		overallCons2 = (TextView) activity
				.findViewById(R.id.providerpf_overall_con2);
		overallCons3 = (TextView) activity
				.findViewById(R.id.providerpf_overall_con3);

		expandableListView = (ExpandableListView) activity
				.findViewById(R.id.providerpf_comments);

	}

	public Provider generateProvider(String name, double latitude,
			double longitude) {
		// initialize a dummy provider.
		return new Provider(0, name, "3400 Spruce Street", "Philadelphia",
				"PA", "19104", "(215)662-3228", "yes", "yes", "pharmacy",
				"yes", "yes", "yes", 3, 2, 2, 2, 2, 2, 2, longitude, latitude,
				"None", "stfu");
	}

	public ArrayList<Rating> generateRating() {
		Rating first = new Rating(3, 1, "username1", "2012-12-12 11:37:09",
				"Very Good", "A good doctor!", 5, 0, 0, 0, 0, 0, 0, 1, 2, 3,
				-1, -2, -3);

		Rating second = new Rating(4, 1, "username2", "2012-11-12 11:37:09",
				"", "", 3, 0, 0, 0, 0, 0, 0, 1, 2, 0, -1, 0, 0);

		Rating third = new Rating(5, 1, "username3", "2012-10-12 11:37:09",
				"Fair", "Hard to say - just so so", 3, 0, 0, 0, 0, 0, 0, 6, 7,
				8, 0, 0, 0);

		Rating fourth = new Rating(5, 1, "username4", "2012-09-12 11:37:09",
				"Good", "He is so handsome:)", 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0);

		ArrayList<Rating> ratings = new ArrayList<Rating>();
		ratings.add(first);
		ratings.add(second);
		ratings.add(third);
		ratings.add(fourth);
		return ratings;
	}

	// tests to make sure everything displays correctly
	public void testButtonMap() {
		assertNotNull(buttonmap);
	}

	public void testName() {
		assertEquals("testProvider", name.getText());
	}

	public void testAddress() {
		assertEquals("3400 Spruce Street, Philadelphia, PA  19104",
				address.getText());
	}

	public void testPhone() {
		assertEquals("(215)662-3228", phone.getText());
	}

	public void testPhilosophy() {
		assertNotNull(philosophy);
	}

	public void testParking() {
		assertEquals("parking", parking.getText());
	}

	public void testCreditcard() {
		assertEquals("credit cards", creditcard.getText());
	}

	public void testAccepting() {
		assertEquals("accepting patients", accepting.getText());
	}

	public void testAppointment() {
		assertEquals("by appointment", appointment.getText());
	}

	public void testPharmacy() {
		assertEquals("pharmacy", pharmacy.getText());
	}

	public void testRating() {
		assertEquals("3.0", rating.getText());
	}

	public void testStatistics() {
		assertEquals("Statistics on Features", statistics.getText());
	}

	public void testRate() {
		assertEquals("Rate the Provider!", rate.getText());
	}

	public void testOverallProsCons() {
		assertNotNull(overallProsConsTable);
		assertEquals("care about patient", overallPros1.getText());
		assertEquals("quick diagnosis", overallPros2.getText());
		assertEquals("easy for parking", overallPros3.getText());
		assertEquals("don't care about patient", overallCons1.getText());
		assertEquals("slow diagnosis", overallCons2.getText());
		assertEquals("hard for parking", overallCons3.getText());
	}

	public void testRatings() {
		titleView = expandableListView.getChildAt(0);
		stars = (RatingBar) titleView
				.findViewById(R.id.providerpf_comment_stars);
		date = (TextView) titleView.findViewById(R.id.providerpf_comment_date);
		userName = (TextView) titleView.findViewById(R.id.providerpf_user_name);
		assertEquals("By username1", userName.getText());
		assertEquals("2012-12-12 ", date.getText());
		assertEquals(5.0, stars.getRating(), 0.0);

		titleView = expandableListView.getChildAt(1);
		stars = (RatingBar) titleView
				.findViewById(R.id.providerpf_comment_stars);
		date = (TextView) titleView.findViewById(R.id.providerpf_comment_date);
		userName = (TextView) titleView.findViewById(R.id.providerpf_user_name);
		assertEquals("By username2", userName.getText());
		assertEquals("2012-11-12 ", date.getText());
		assertEquals(3.0, stars.getRating(), 0.0);

		titleView = expandableListView.getChildAt(2);
		stars = (RatingBar) titleView
				.findViewById(R.id.providerpf_comment_stars);
		date = (TextView) titleView.findViewById(R.id.providerpf_comment_date);
		userName = (TextView) titleView.findViewById(R.id.providerpf_user_name);
		assertEquals("By username3", userName.getText());
		assertEquals("2012-10-12 ", date.getText());
		assertEquals(3.0, stars.getRating(), 0.0);

		titleView = expandableListView.getChildAt(3);
		stars = (RatingBar) titleView
				.findViewById(R.id.providerpf_comment_stars);
		date = (TextView) titleView.findViewById(R.id.providerpf_comment_date);
		userName = (TextView) titleView.findViewById(R.id.providerpf_user_name);
		assertEquals("By username4", userName.getText());
		assertEquals("2012-09-12 ", date.getText());
		assertEquals(4.0, stars.getRating(), 0.0);

		listAdapter = expandableListView.getExpandableListAdapter();
		listView = listAdapter.getChildView(0, 0, true, null, null);
		tv_provider_summary = (TextView) listView
				.findViewById(R.id.providerpf_rate_review_summary);
		assertEquals(tv_provider_summary.getText(), "Very Good");
		tv_pro1 = (TextView) listView.findViewById(R.id.providerpf_review_pro1);
		assertEquals(tv_pro1.getText(), "care about patient");
		tv_pro2 = (TextView) listView.findViewById(R.id.providerpf_review_pro2);
		assertEquals(tv_pro2.getText(), "quick diagnosis");
		tv_pro3 = (TextView) listView.findViewById(R.id.providerpf_review_pro3);
		assertEquals(tv_pro3.getText(), "easy for parking");
		tv_con1 = (TextView) listView.findViewById(R.id.providerpf_review_con1);
		assertEquals(tv_con1.getText(), "don't care about patient");
		tv_con2 = (TextView) listView.findViewById(R.id.providerpf_review_con2);
		assertEquals(tv_con2.getText(), "slow diagnosis");
		tv_con3 = (TextView) listView.findViewById(R.id.providerpf_review_con3);
		assertEquals(tv_con3.getText(), "hard for parking");
		tv_provider_desc = (TextView) listView
				.findViewById(R.id.providerpf_comment_review);
		assertEquals(tv_provider_desc.getText(), "A good doctor!");
		listView = listAdapter.getChildView(1, 0, true, null, null);
		tv_provider_summary = (TextView) listView
				.findViewById(R.id.providerpf_rate_review_summary);
		assertEquals(tv_provider_summary.getText(), "");
		tv_pro1 = (TextView) listView.findViewById(R.id.providerpf_review_pro1);
		assertEquals(tv_pro1.getText(), "care about patient");
		tv_pro2 = (TextView) listView.findViewById(R.id.providerpf_review_pro2);
		assertEquals(tv_pro2.getText(), "quick diagnosis");
		tv_pro3 = (TextView) listView.findViewById(R.id.providerpf_review_pro3);
		assertEquals(tv_pro3.getText(), "");
		tv_con1 = (TextView) listView.findViewById(R.id.providerpf_review_con1);
		assertEquals(tv_con1.getText(), "don't care about patient");
		tv_con2 = (TextView) listView.findViewById(R.id.providerpf_review_con2);
		assertEquals(tv_con2.getText(), "");
		tv_con3 = (TextView) listView.findViewById(R.id.providerpf_review_con3);
		assertEquals(tv_con3.getText(), "");
		tv_provider_desc = (TextView) listView
				.findViewById(R.id.providerpf_comment_review);
		assertEquals(tv_provider_desc.getText(), "");
		listView = listAdapter.getChildView(2, 0, true, null, null);
		tv_provider_summary = (TextView) listView
				.findViewById(R.id.providerpf_rate_review_summary);
		assertEquals(tv_provider_summary.getText(), "Fair");
		tv_pro1 = (TextView) listView.findViewById(R.id.providerpf_review_pro1);
		assertEquals(tv_pro1.getText(), "adequate parking");
		tv_pro2 = (TextView) listView.findViewById(R.id.providerpf_review_pro2);
		assertEquals(tv_pro2.getText(), "availability of appointments");
		tv_pro3 = (TextView) listView.findViewById(R.id.providerpf_review_pro3);
		assertEquals(tv_pro3.getText(), "cleanliness/attractiveness of office");
		tv_con1 = (TextView) listView.findViewById(R.id.providerpf_review_con1);
		assertEquals(tv_con1.getText(), "");
		tv_con2 = (TextView) listView.findViewById(R.id.providerpf_review_con2);
		assertEquals(tv_con2.getText(), "");
		tv_con3 = (TextView) listView.findViewById(R.id.providerpf_review_con3);
		assertEquals(tv_con3.getText(), "");
		tv_provider_desc = (TextView) listView
				.findViewById(R.id.providerpf_comment_review);
		assertEquals(tv_provider_desc.getText(), "Hard to say - just so so");
		listView = listAdapter.getChildView(3, 0, true, null, null);
		tv_provider_summary = (TextView) listView
				.findViewById(R.id.providerpf_rate_review_summary);
		assertEquals(tv_provider_summary.getText(), "Good");
		tv_pro1 = (TextView) listView.findViewById(R.id.providerpf_review_pro1);
		assertEquals(tv_pro1.getText(), "");
		tv_pro2 = (TextView) listView.findViewById(R.id.providerpf_review_pro2);
		assertEquals(tv_pro2.getText(), "");
		tv_pro3 = (TextView) listView.findViewById(R.id.providerpf_review_pro3);
		assertEquals(tv_pro3.getText(), "");
		tv_con1 = (TextView) listView.findViewById(R.id.providerpf_review_con1);
		assertEquals(tv_con1.getText(), "");
		tv_con2 = (TextView) listView.findViewById(R.id.providerpf_review_con2);
		assertEquals(tv_con2.getText(), "");
		tv_con3 = (TextView) listView.findViewById(R.id.providerpf_review_con3);
		assertEquals(tv_con3.getText(), "");
		tv_provider_desc = (TextView) listView
				.findViewById(R.id.providerpf_comment_review);
		assertEquals(tv_provider_desc.getText(), "He is so handsome:)");
	}

	public void testGetSortedIndices() {
		int[] array1 = { 1, 3, 2, 2, 4 };
		int[] result1 = activity.getSortedIndices(array1, 5, 3);
		assertEquals(result1[0], 5);
		assertEquals(result1[1], 2);
		assertEquals(result1[2], 3);

		int[] array2 = { 1, 1, 2 };
		int[] result2 = activity.getSortedIndices(array2, 3, 3);
		assertEquals(result2[0], 3);
		assertEquals(result2[1], 1);
		assertEquals(result2[2], 2);
	}

	public void testGetProAndConString() {
		assertEquals("care about patient", activity.getProAndConString(1));
		assertEquals("easy to make appointment",
				activity.getProAndConString(5));
		assertEquals("continuity of care", activity.getProAndConString(10));
		assertEquals("don't care about patient",
				activity.getProAndConString(-1));
		assertEquals("hard to make appointment",
				activity.getProAndConString(-5));
		assertEquals("bad in continuity of care",
				activity.getProAndConString(-10));
	}

	public void testCheckMultipleReviewer() {
		activity.checkMultipleReviewer("2012-12-12 12:12:12", null,
				"tester");
		assertFalse(activity.isMultipleReviewer);
		activity.isMultipleReviewer = false;
		activity.checkMultipleReviewer("2012-12-12 12:12:12", "tester",
				"tester");
		assertTrue(activity.isMultipleReviewer);
		activity.isMultipleReviewer = false;
		activity.checkMultipleReviewer("2011-12-12 12:12:12", "tester",
				"tester");
		assertFalse(activity.isMultipleReviewer);
		activity.checkMultipleReviewer("2012-12-12 12:12:12", "tester",
				"admin");
		assertFalse(activity.isMultipleReviewer);
	}

	public void testWithinSixMonth() {
		assertTrue(activity.withinSixMonth("2012-12-12 12:12:12"));
		assertFalse(activity.withinSixMonth("2011-12-12 12:12:12"));
	}
}