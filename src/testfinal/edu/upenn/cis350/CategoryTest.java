package testfinal.edu.upenn.cis350;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.TextView;
import edu.upenn.cis350.*;


public class CategoryTest extends ActivityInstrumentationTestCase2<CategoryActivity> {
	public CategoryTest() {
		super(CategoryActivity.class);
	}
	


	private Activity activity;
	private Button button_doctor, button_clinic, button_pharmacy;

	
	
	public void setUp() throws Exception {
		super.setUp();
		activity= getActivity();
		button_doctor = (Button)activity.findViewById(R.id.category_doctor);
		button_clinic = (Button)activity.findViewById(R.id.category_clinic);
		button_pharmacy = (Button)activity.findViewById(R.id.category_pharmacy);
//		copyright= (TextView) activity.findViewById(R.id.contact_copyright);
//		more= (TextView) activity.findViewById(R.id.contact_more);
//		info_name= (TextView) activity.findViewById(R.id.contact_info_name);
//		info_email= (Button) activity.findViewById(R.id.contact_info_email_now);
//		info_more = (TextView) activity.findViewById(R.id.contact_more);
	}
	
	
//	public void testCopyright() {
//		assertEquals(copyright.getText(), "Find-A-Doc is an app provided by the University of Pennsylvania School of Nursing");
//	}
//	public void testMore() {
//		assertEquals(more.getText(), "For more information, please contact:");
//	}
//	public void testinfo_name() {
//		assertEquals(info_name.getText(), "Evan Wu");
//	}
//	public void testinfo_email() {
//		assertEquals(info_email.getText(), "evanswu@nursingupenn.edu");
//	}
	
	public void testDoctor(){
		assertEquals(button_doctor.getText(),"Doctor's Office");
	}
	
	public void testClinic(){
		assertEquals(button_clinic.getText(),"Clinic - Urgent Care");
	}
	
	public void testPharmacy(){
		assertEquals(button_pharmacy.getText(), "Pharmacy");
	}

//	public void testinfo_more() {
//		assertEquals(info_more.getText(), "For more information, please contact:");
//	}
	
	
}
