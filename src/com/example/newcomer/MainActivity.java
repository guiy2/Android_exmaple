package com.example.newcomer;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {
	public static final String TAG = "MainActivity";
	private String mstring;
	private EditText mEditText;
	//private LinearLayout mainLayout;
	//private static final String[] strs = new String[]{"first","second","third","fourth","fifth"};
	private ListView lv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mEditText = (EditText)findViewById(R.id.editText1);
		LayoutInflater layoutInflater = LayoutInflater.from(this);
		View buttonLayout = layoutInflater.inflate(R.layout.button_layout, null);
		
		lv = (ListView) findViewById(R.id.lv);
		
		//lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_checked,strs));
		//lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		
		//Use a Array of HashMap
		ArrayList<HashMap<String,Object>> listItem = new ArrayList<HashMap<String,Object>>();
		for(int i=0;i<10;i++){
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("ItemImage", R.drawable.ic_launcher);
			map.put("ItemTitle", "The "+i + " line");
			map.put("ItemText", "This is the " + i + " line");
			listItem.add(map);
		}
		
		SimpleAdapter mSimpleAdapter = new SimpleAdapter(this,listItem,R.layout.item,
						new String[]{"ItemImage","ItemTitle","ItemText"}, 
						new int[]{R.id.ItemImage,R.id.ItemTitle,R.id.ItemText});
		
		lv.setAdapter(mSimpleAdapter);
		
		lv.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> arg0,View arg1,int arg2,long arg3){
				setTitle("you select the " + arg2 + "lines ");
			}
		});
		
		Log.e(TAG,"Start onCreate");
	}
	@Override
	protected void onStart(){
		super.onStart();
		Log.e(TAG,"Start onStart~~~~~~~~");
	}
	@Override 
	protected void onPause(){
		super.onPause();
		mstring = mEditText.getText().toString();
		Log.e(TAG, "start on Pause");
	}
	@Override
	protected void onRestart(){
		super.onRestart();
		mEditText.setText(mstring);
		Log.e(TAG,"start onRestart~~~~");
	}
	@Override
	protected void onResume(){
		super.onResume();
		Log.e(TAG,"start onResume~~~~~~");
	}
	@Override
	protected void onStop(){
		super.onStop();
		Log.e(TAG,"start onStop~~~~");
	}
	@Override
	protected void onDestroy(){
		super.onDestroy();
		Log.e(TAG,"start onDestroy~~~~~~");
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
