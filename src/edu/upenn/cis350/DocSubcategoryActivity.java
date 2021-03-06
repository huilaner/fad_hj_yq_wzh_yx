package edu.upenn.cis350;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class DocSubcategoryActivity extends Activity{
	private CheckBox doc_immunology;
	private CheckBox doc_radiology;
	private CheckBox doc_cardiology;
	private CheckBox doc_pediatric;
	private CheckBox doc_dental;
	private CheckBox doc_internalMedicine, doc_familyPractice, doc_obGyn, doc_mentalHealth, doc_otherSpecialist;
	private Button doc_submit;
	private int countCheck = 0;
	int[] checkBoxRecord = new int[20];
	String[] docTypeList = new String[20];

	private final Context m_context = this;


	/**
	 * Set up the view upon creation
	 */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.subcategory_doctor);
	}

	/**
	 * Set up the activity when the main screen is brought up
	 */
	public void onResume(){
		super.onResume();
		doc_immunology = (CheckBox)this.findViewById(R.id.doc_immunology);
		doc_radiology = (CheckBox)this.findViewById(R.id.doc_radiology);
		doc_cardiology = (CheckBox)this.findViewById(R.id.doc_cardiology);
		doc_pediatric=(CheckBox)this.findViewById(R.id.doc_pediatric);
		doc_dental=(CheckBox)this.findViewById(R.id.doc_dental);
		doc_internalMedicine = (CheckBox)this.findViewById(R.id.doc_internal_medicine);
		doc_familyPractice = (CheckBox)this.findViewById(R.id.doc_family_practice);
		doc_obGyn = (CheckBox)this.findViewById(R.id.doc_ob_gyn);
		doc_mentalHealth = (CheckBox)this.findViewById(R.id.doc_mental_health);
		doc_otherSpecialist = (CheckBox)this.findViewById(R.id.doc_other_specialist);
		doc_submit=(Button)this.findViewById(R.id.doc_submit);
		docTypeList[0] = "immunology";
		docTypeList[1] = "radiology";
		docTypeList[2] = "cardiology";
		docTypeList[3] = "pediatric";
		docTypeList[4] = "dental";
		docTypeList[5] = "internalMedicine";
		docTypeList[6] = "familyPractice";
		docTypeList[7] = "obGyn";
		docTypeList[8] = "mentalHealth";
		docTypeList[9] = "otherSpecialist";
		doc_immunology.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				onCheckboxClicked(doc_immunology,1);
			}  
		});

		doc_radiology.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				onCheckboxClicked(doc_radiology,2);
			}  
		});

		doc_cardiology.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				onCheckboxClicked(doc_cardiology,3);
			}  
		});

		doc_pediatric.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				onCheckboxClicked(doc_pediatric,4);
			}  
		});

		doc_dental.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				onCheckboxClicked(doc_dental,5);
			}  
		});
		
		doc_internalMedicine.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				onCheckboxClicked(doc_internalMedicine,6);
			}  
		});
		
		doc_familyPractice.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				onCheckboxClicked(doc_familyPractice,7);
			}  
		});
		
		doc_obGyn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				onCheckboxClicked(doc_obGyn,8);
			}  
		});
		
		doc_mentalHealth.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				onCheckboxClicked(doc_mentalHealth,9);
			}  
		});
		
		doc_otherSpecialist.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				onCheckboxClicked(doc_otherSpecialist,10);
			}  
		});

		//set the listeners for each button
		setListeners();
	}

	private void setListeners() {
		// TODO Auto-generated method stub
		doc_submit.setOnClickListener(new OnClickListener(){
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(countCheck <= 0) Toast.makeText(m_context,
						"Please at least check one of the specialties!",
						Toast.LENGTH_LONG).show();
				else{
					ArrayList<String> typeList = new ArrayList<String>();
					for(int i = 0; i < checkBoxRecord.length; i++) {
						if(checkBoxRecord[i] != 0)
							typeList.add(docTypeList[i]);
					}
					Intent intent = new Intent(m_context, SearchActivity.class);
					intent.putStringArrayListExtra("typeList", typeList);
					// TODO check which check box is checked by checking the checkBoxRecord, then send corresponding intents
					startActivityForResult(intent, 0);
				}

			}

		});
	}


	public void onCheckboxClicked(View view, int index) {
		// Is the view now checked?
		boolean checked = ((CheckBox) view).isChecked();

		if (checked) {

			((CheckBox) view).setChecked(true);

			checkBoxRecord[index-1]=checked?1:0;
			countCheck++;

		} else{
			checkBoxRecord[index-1] = 0;
			countCheck--;
		}

		// Check which checkbox was clicked
		// switch(view.getId()) {
		// case R.id.pros_checkbox1:
		// // if (checked) countCheck++;
		// break;
		// case R.id.pros_checkbox2:
		// // if (checked) countCheck++;
		// break;
		// // TODO: Veggie sandwich
		// }
	}


}