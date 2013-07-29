package com.exemple.internationalization;

import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	private Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mContext = this;
		
		Button changeLanguagePT = (Button) findViewById(R.id.change_language_pt);
		Button changeLanguageEN = (Button) findViewById(R.id.change_language_en);
		Button changeLanguageES = (Button) findViewById(R.id.change_language_es);
		Button changeLanguageJA = (Button) findViewById(R.id.change_language_ja);
		
		final Configuration configuration = new Configuration();
		
		changeLanguagePT.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				configuration.locale = Locale.getDefault();
				getBaseContext().getResources().updateConfiguration(configuration, null);
				
				restartApplication();
			}
		});
		
		changeLanguageEN.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				configuration.locale = Locale.ENGLISH;
				
				getBaseContext().getResources().updateConfiguration(configuration, null);
				
				restartApplication();
			}
		});
		
		changeLanguageES.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				configuration.locale = new Locale("es", "ES");
				
				getBaseContext().getResources().updateConfiguration(configuration, null);
				
				restartApplication();
			}
		});
		
		changeLanguageJA.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				configuration.locale = new Locale("ja", "JA");
				
				getBaseContext().getResources().updateConfiguration(configuration, null);
				
				restartApplication();
			}
		});
	}
	
	void restartApplication(){
	    Intent i = new Intent(mContext, MainActivity.class);
	    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	    mContext.startActivity(i);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
