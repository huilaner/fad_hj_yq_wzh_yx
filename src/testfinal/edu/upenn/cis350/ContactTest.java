package testfinal.edu.upenn.cis350;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.TextView;
import edu.upenn.cis350.*;


public class ContactTest extends ActivityInstrumentationTestCase2<ContactActivity> {
	public ContactTest() {
		super(ContactActivity.class);
	}

	private Activity activity;
	private TextView copyright;
	private TextView more;
	private TextView info_name;
	private Button info_email;
	@SuppressWarnings("unused")
	private TextView info_number;
	private TextView info_more;
	private Button email2;
	
	
	public void setUp() throws Exception {
		super.setUp();
		activity= getActivity();
		copyright= (TextView) activity.findViewById(R.id.contact_copyright);
		more= (TextView) activity.findViewById(R.id.contact_more);
		info_name= (TextView) activity.findViewById(R.id.contact_info_name);
		info_email= (Button) activity.findViewById(R.id.contact_info_email_now);
		info_more = (TextView) activity.findViewById(R.id.contact_more);
		email2 = (Button)activity.findViewById(R.id.contact_info_email_version2);
	}
	
	
	public void testCopyright() {
		assertEquals(copyright.getText(), "Find-A-Doc is an app provided by the University of Pennsylvania School of Nursing and School of Engineering and Applied Science");
	}
	public void testMore() {
		assertEquals(more.getText(), "For more information, please contact:");
	}
	public void testinfo_name() {
		assertEquals(info_name.getText(), "Evan Wu or Hui Jia");
	}
	public void testinfo_email() {
		assertEquals(info_email.getText(), "evanswu@nursingupenn.edu");
		assertEquals(email2.getText(), "huijia@seas.upenn.edu");
	}

	public void testinfo_more() {
		assertEquals(info_more.getText(), "For more information, please contact:");
	}
	
	
}
