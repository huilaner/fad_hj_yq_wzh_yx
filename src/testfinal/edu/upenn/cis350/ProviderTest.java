package testfinal.edu.upenn.cis350;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
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
	
	private TextView reviewSummary;
	
	private Provider m_provider;
	private ArrayList<Rating> m_ratings;
	
	public void setUp() throws Exception {
		super.setUp();
		m_provider = generateProvider("testProvider", 1.300, 2.04);
		m_ratings = generateRating("testRating");
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
		
		reviewSummary = (TextView)activity.findViewById(R.id.providerpf_rate_review_summary);
	}
	
	public Provider generateProvider(String name, double latitude, double longitude) {
		// initialize a dummy provider.
		return new Provider(16, name, "3400 Spruce Street", "Philadelphia",
				"PA", "19104", "(215)662-3228", "yes", "yes", "pharmacy", "yes",
				"yes", "yes", 3, 2, 2, 2, 2, 2, 2, longitude, latitude, "None", "stfu");
	}

	public ArrayList<Rating> generateRating(String name) {
		int rating1 = 5;
		int rating2 = 3;
		int rating3 = 3;
		int rating4 = 4;
		Rating first = new Rating(3, 1, "",
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
				name, name, rating1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		
		Rating second = new Rating(4, 1, "",
				" adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehend",
				name, name, rating2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		
		Rating third = new Rating(5, 1, "",
				" This guy is awesome!!!!!!!!!!!!!!!!!!!!!!!", 
				name, name, rating3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		
		Rating fourth = new Rating(5, 1, "", 
				" I don't speak latin );", 
				name, name, rating4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		
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
	
//	public void testRatings() {
//		assertEquals("", reviewSummary.getText());
//	}
	

}
