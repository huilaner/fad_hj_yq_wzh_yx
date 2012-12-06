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
	
	public ProviderTest() {
		super("edu.upenn.cis350", ProviderProfileActivity.class);
	}
	
	private Activity activity;
	private Button buttonmap;
	private Button parking;
	private Button creditcard;
	private Button accepting;
	private TextView name;
	private TextView address;
	private TextView phone;
	private Button rate;
	private TextView rating;
	private Provider m_provider;
	
	public void setUp() throws Exception {
		super.setUp();
		m_provider = generateProvider("testProvider", 1.300, 2.04);
		Intent addEvent = new Intent();
	    addEvent.putExtra("providers", m_provider);
	    setActivityIntent(addEvent);	    
		
		activity = getActivity();
		buttonmap = (Button)activity.findViewById(R.id.button_providerpf_map);
		parking = (Button)activity.findViewById(R.id.provider_parking);
		creditcard = (Button)activity.findViewById(R.id.provider_creditcard);
		accepting = (Button)activity.findViewById(R.id.provider_accepting);
		name= (TextView)activity.findViewById(R.id.provider_name);
		address = (TextView)activity.findViewById(R.id.provider_address);
		phone = (TextView)activity.findViewById(R.id.provider_phone);
		rating = (TextView)activity.findViewById(R.id.providerpf_average_rating_text);
		rate = (Button)activity.findViewById(R.id.providerpf_rate_button);
	}
	
	public Provider generateProvider(String name, double latitude, double longitude) {
		Rating first = new Rating(
				3,
				1,
				"",
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
				name, 5);
		Rating second = new Rating(
				4,
				1,
				"",
				" adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehend",
				name, name, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		Rating third = new Rating(5, 1, "",
				" This guy is awesome!!!!!!!!!!!!!!!!!!!!!!!", name, 3);
		Rating fourth = new Rating(5, 1, "", " I don't speak latin );", name, name, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		ArrayList<Rating> ratings = new ArrayList<Rating>();

		ratings.add(first);
		ratings.add(second);
		ratings.add(third);
		ratings.add(fourth);

		// initialize a dummy provider.
		return new Provider(1, name, "3400 Spruce Street", "Philadelphia",
				"PA", "19104", "(215)662-3228", "yes", "yes", "doctor", "yes",
				"yes", "yes", 3, 2, 2, 2, 2, 2, 2, longitude, latitude, "None", "stfu");
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
	public void testRating() {
		assertEquals("3.0", rating.getText());
	}
	public void testRate() {
		assertNotNull(rate);
		assertEquals("Rate Your Doctor!", rate.getText());
	}
	

}
