package testfinal.edu.upenn.cis350;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import edu.upenn.cis350.*;


public class SubCategoryTest extends ActivityInstrumentationTestCase2<DocSubcategoryActivity> {
	public SubCategoryTest() {
		super(DocSubcategoryActivity.class);
	}
	


	private Activity activity;
	private CheckBox internalMedicine, familyPractice, obGyn, mentalHealth, otherSpecialist, immunology, radiology, cardiology, pediatric, dental;

	
	
	public void setUp() throws Exception {
		super.setUp();
		activity= getActivity();
		internalMedicine = (CheckBox)activity.findViewById(R.id.doc_internal_medicine);
		familyPractice = (CheckBox)activity.findViewById(R.id.doc_family_practice);
		obGyn = (CheckBox)activity.findViewById(R.id.doc_ob_gyn);
		mentalHealth = (CheckBox)activity.findViewById(R.id.doc_mental_health);
		otherSpecialist = (CheckBox)activity.findViewById(R.id.doc_other_specialist);
		immunology = (CheckBox)activity.findViewById(R.id.doc_immunology);
		radiology = (CheckBox)activity.findViewById(R.id.doc_radiology);
		cardiology = (CheckBox)activity.findViewById(R.id.doc_cardiology);
		pediatric = (CheckBox)activity.findViewById(R.id.doc_pediatric);
		dental = (CheckBox)activity.findViewById(R.id.doc_dental);

	}
	
	public void testCheckBoxes(){
		assertEquals(internalMedicine.getText(),"Internal Medicine");
	
		assertEquals(familyPractice.getText(),"Family Practice");

		assertEquals(obGyn.getText(), "Ob-Gyn");

		assertEquals(mentalHealth.getText(), "Mental Health");

		assertEquals(otherSpecialist.getText(), "Other Specialist");

		assertEquals(immunology.getText(), "Immunology");

		assertEquals(radiology.getText(), "Radiology");

		assertEquals(cardiology.getText(), "Cardiology");

		assertEquals(pediatric.getText(), "Pediatric");

		assertEquals(dental.getText(), "Dental Hygiene");
	}
	
}
