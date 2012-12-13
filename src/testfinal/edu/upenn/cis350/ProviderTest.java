package testfinal.edu.upenn.cis350;

import java.util.ArrayList;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;
import edu.upenn.cis350.*;
import edu.upenn.cis350.entities.Provider;
import edu.upenn.cis350.entities.Rating;

public class ProviderTest extends ActivityInstrumentationTestCase2<ProviderProfileActivity> {
	
	@SuppressWarnings("deprecation")
	public ProviderTest() {
		super("edu.upenn.cis350", ProviderProfileActivity.class);
	}
	
	private Activity activity;
//	private LayoutInflater factory;
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
	private View expandedView;
	private RatingBar stars;
	private TextView userName;
	private TextView date;
	private TextView reviewSummary;
	private TextView tv_pro1;
	private TextView tv_pro2;
	private TextView tv_pro3;
	private TextView tv_con1;
	private TextView tv_con2;
	private TextView tv_con3;
	private TextView review;
	
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
		buttonmap = (Button)activity.findViewById(R.id.button_providerpf_map);
		parking = (Button)activity.findViewById(R.id.provider_parking);
		creditcard = (Button)activity.findViewById(R.id.provider_creditcard);
		accepting = (Button)activity.findViewById(R.id.provider_accepting);
		appointment = (Button)activity.findViewById(R.id.provider_appointments);
		pharmacy = (Button)activity.findViewById(R.id.provider_PCP);
		
		name= (TextView)activity.findViewById(R.id.provider_name);
		address = (TextView)activity.findViewById(R.id.provider_address);
		phone = (TextView)activity.findViewById(R.id.provider_phone);
		philosophy= (TextView)activity.findViewById(R.id.provider_philosophy_of_care);
		
		rating = (TextView)activity.findViewById(R.id.providerpf_average_rating_text);
		statistics = (Button)activity.findViewById(R.id.providerpf_all_previous_reviews_button);
		rate = (Button)activity.findViewById(R.id.providerpf_rate_button);
		
		overallProsConsTable = (TableLayout)activity.findViewById(R.id.provider_overall_proscons_table);
		overallPros1 = (TextView)activity.findViewById(R.id.providerpf_overall_pro1);
		overallPros2 = (TextView)activity.findViewById(R.id.providerpf_overall_pro2);
		overallPros3 = (TextView)activity.findViewById(R.id.providerpf_overall_pro3);
		overallCons1 = (TextView)activity.findViewById(R.id.providerpf_overall_con1);
		overallCons2 = (TextView)activity.findViewById(R.id.providerpf_overall_con2);
		overallCons3 = (TextView)activity.findViewById(R.id.providerpf_overall_con3);
		
		expandableListView = (ExpandableListView) activity.findViewById(R.id.providerpf_comment_stars).getParent().getParent();
		
	}
	
	public Provider generateProvider(String name, double latitude, double longitude) {
		// initialize a dummy provider.
		return new Provider(0, name, "3400 Spruce Street", "Philadelphia",
				"PA", "19104", "(215)662-3228", "yes", "yes", "pharmacy", "yes",
				"yes", "yes", 3, 2, 2, 2, 2, 2, 2, longitude, latitude, "None", "stfu");
	}

	public ArrayList<Rating> generateRating() {
		int rating1 = 5;
		int rating2 = 3;
		int rating3 = 3;
		int rating4 = 4;
		Rating first = new Rating(3, 1, "username1",
				"2012-12-12 11:37:09",
				"one line comment", "review content", rating1, 0, 0, 0, 0, 0, 0, 1, 2, 3, -1, -2, -3);
		
		Rating second = new Rating(4, 1, "username2", 
				"2012-11-12 11:37:09",
				"", "", rating2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		
		Rating third = new Rating(5, 1, "username3",
				"2012-10-12 11:37:09", 
				"", "", rating3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		
		Rating fourth = new Rating(5, 1, "username4", 
				"2012-09-12 11:37:09", 
				"", "", rating4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		
		ArrayList<Rating> ratings = new ArrayList<Rating>();
		ratings.add(first);
		ratings.add(second);
		ratings.add(third);
		ratings.add(fourth);
		return ratings;
	}
	
	//tests to make sure everything displays correctly
	public void testButtonMap() {
		assertNotNull(buttonmap);
	}
	public void testName() {
		assertEquals("testProvider", name.getText());
	}
	public void testAddress() {
		assertEquals("3400 Spruce Street, Philadelphia, PA  19104", address.getText());
	}
	public void testPhone() {
		assertEquals("(215)662-3228", phone.getText());
	}
	public void testPhilosophy() {
		assertNotNull(philosophy);
	}
	public void testParking() {
		assertNotNull(parking);
		assertEquals("parking", parking.getText());
	}
	public void testCreditcard() {
		assertNotNull(creditcard);
		assertEquals("credit cards", creditcard.getText());
	}
	public void testAccepting() {
		assertNotNull(accepting);
		assertEquals("accepting patients", accepting.getText());
	}
	public void testAppointment() {
		assertNotNull(appointment);
		assertEquals("by appointment", appointment.getText());
	}
	public void testPharmacy() {
		assertNotNull(pharmacy);
		assertEquals("pharmacy", pharmacy.getText());
	}
	public void testRating() {
		assertEquals("3.0", rating.getText());
	}
	public void testStatistics() {
		assertNotNull(statistics);
		assertEquals("Statistics on Features", statistics.getText());
	}
	public void testRate() {
		assertNotNull(rate);
		assertEquals("Rate Your Doctor!", rate.getText());
	}
	public void testOverallProsCons() {
		assertNotNull(overallProsConsTable);
		assertNotNull(overallPros1);
		assertNotNull(overallPros2);
		assertNotNull(overallPros3);
		assertNotNull(overallCons1);
		assertNotNull(overallCons2);
		assertNotNull(overallCons3);
		//TODO	need to test the content of statistic pros and cons after the implementation
	}
	
	public void testRatings() {
		titleView = expandableListView.getChildAt(0);
		stars = (RatingBar) titleView.findViewById(R.id.providerpf_comment_stars);
		date = (TextView) titleView.findViewById(R.id.providerpf_comment_date);		
		userName = (TextView) titleView.findViewById(R.id.providerpf_user_name);
//		reviewSummary = (TextView) titleView.findViewById(R.id.providerpf_rate_review_summary);
//		tv_pro1 = (TextView) titleView.findViewById(R.id.providerpf_review_pro1);
//		tv_pro2 = (TextView) titleView.findViewById(R.id.providerpf_review_pro2);
//		tv_pro3 = (TextView) titleView.findViewById(R.id.providerpf_review_pro3);
//		tv_con1 = (TextView) titleView.findViewById(R.id.providerpf_review_con1);
//		tv_con2 = (TextView) titleView.findViewById(R.id.providerpf_review_con2);
//		tv_con3 = (TextView) titleView.findViewById(R.id.providerpf_review_con3);
//		review = (TextView) titleView.findViewById(R.id.providerpf_comment_review);
		assertEquals("By username1", userName.getText());
		assertEquals("2012-12-12 ", date.getText());
		assertEquals(5.0, stars.getRating(), 0.0);
//		assertEquals("one line comment", reviewSummary.getText());
//		assertEquals("review content", review.getText());
//		assertEquals("", tv_pro1.getText());
//		assertEquals("By username1", tv_pro2.getText());
//		assertEquals("By username1", tv_pro3.getText());
//		assertEquals("By username1", tv_con1.getText());
//		assertEquals("By username1", tv_con2.getText());
//		assertEquals("By username1", tv_con3.getText());
		
		
		titleView = expandableListView.getChildAt(1);
		stars = (RatingBar) titleView.findViewById(R.id.providerpf_comment_stars);
		date = (TextView) titleView.findViewById(R.id.providerpf_comment_date);		
		userName = (TextView) titleView.findViewById(R.id.providerpf_user_name);
		assertEquals("By username2", userName.getText());
		assertEquals("2012-11-12 ", date.getText());
		assertEquals(3.0, stars.getRating(), 0.0);
		
		titleView = expandableListView.getChildAt(2);
		stars = (RatingBar) titleView.findViewById(R.id.providerpf_comment_stars);
		date = (TextView) titleView.findViewById(R.id.providerpf_comment_date);		
		userName = (TextView) titleView.findViewById(R.id.providerpf_user_name);
		assertEquals("By username3", userName.getText());
		assertEquals("2012-10-12 ", date.getText());
		assertEquals(3.0, stars.getRating(), 0.0);
		
		titleView = expandableListView.getChildAt(3);
		stars = (RatingBar) titleView.findViewById(R.id.providerpf_comment_stars);
		date = (TextView) titleView.findViewById(R.id.providerpf_comment_date);		
		userName = (TextView) titleView.findViewById(R.id.providerpf_user_name);
		assertEquals("By username4", userName.getText());
		assertEquals("2012-09-12 ", date.getText());
		assertEquals(4.0, stars.getRating(), 0.0);

	}
	

}
