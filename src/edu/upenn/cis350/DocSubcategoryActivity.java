package edu.upenn.cis350;

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
	private Button doc_submit;
	int[] checkBoxRecord = new int[10];

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
		doc_submit=(Button)this.findViewById(R.id.doc_submit);

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


		//set the listeners for each button
		setListeners();
	}

	private void setListeners() {
		// TODO Auto-generated method stub
		doc_submit.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(m_context, SearchActivity.class);
				intent.putExtra("providerType", "pharmacy");
				// TODO check which check box is checked by checking the checkBoxRecord, then send corresponding intents
				startActivityForResult(intent, 0);

			}

		});
	}


	public void onCheckboxClicked(View view, int index) {
		// Is the view now checked?
		boolean checked = ((CheckBox) view).isChecked();

		if (checked) {

			((CheckBox) view).setChecked(true);

			checkBoxRecord[index-1]=checked?1:0;

		} else{
			checkBoxRecord[index-1] = 0;
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
