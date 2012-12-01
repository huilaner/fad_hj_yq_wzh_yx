package edu.upenn.cis350;

import java.util.ArrayList;

import edu.upenn.cis350.entities.User;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.SharedPreferences;
/**
 * Medium Screen activity which leads to the Search activities
 * 
 *
 */
public class CategoryActivity extends Activity {
	/** Called when the activity is first created. */
	private Button button_category_doctor;
	private Button button_category_clinic;
	private Button button_category_pharmacy;

	private final Context m_context = this;




	/**
	 * Set up the view upon creation
	 */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_category);
	}

	/**
	 * Set up the activity when the main screen is brought up
	 */
	public void onResume(){
		super.onResume();
		button_category_doctor = (Button)this.findViewById(R.id.category_doctor);
		button_category_clinic = (Button)this.findViewById(R.id.category_clinic);
		button_category_pharmacy = (Button)this.findViewById(R.id.category_pharmacy);

		//set the listeners for each button
		setListeners();
	}

	public void setListeners() {
		final ArrayList<String> typeList = new ArrayList<String>();
		button_category_doctor.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				Intent intent = new Intent(m_context, DocSubcategoryActivity.class);
				startActivity(intent);
			}
		});
		button_category_clinic.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				Intent intent = new Intent(m_context, SearchActivity.class);
				typeList.add("clinic");
				intent.putStringArrayListExtra("typeList", typeList);
				startActivityForResult(intent, 0);
			}
		});
		button_category_pharmacy.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				Intent intent = new Intent(m_context, SearchActivity.class);
				typeList.add("pharmacy");
				intent.putStringArrayListExtra("typeList", typeList);
				startActivityForResult(intent, 0);
			}
		});
	}
}