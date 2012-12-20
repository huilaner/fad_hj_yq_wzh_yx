package testfinal.edu.upenn.cis350;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
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
	}

	public void testDoctor(){
		assertEquals(button_doctor.getText(),"Doctor's Office");
	}

	public void testClinic(){
		assertEquals(button_clinic.getText(),"Clinic - Urgent Care");
	}

	public void testPharmacy(){
		assertEquals(button_pharmacy.getText(), "Pharmacy");
	}

}