package com.example.bikesafety;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.util.Linkify;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;


	public class Tabs extends Activity {
		
		
		public static void addLink(TextView textView, String patternToMatch,
		        final String link) {
		    Linkify.TransformFilter filter = new Linkify.TransformFilter() {
		        @Override public String transformUrl(Matcher match, String url) {
		            return link;
		        }
		    };
		    Linkify.addLinks(textView, Pattern.compile(patternToMatch), null, null,
		            filter);
		}
		
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.tabs);
			
			
			
			TextView noteView = (TextView) findViewById(R.id.textView2);
			noteView.setText(" 1) Use a flAT key U-Lock to secure the frame and rear wheel to the rack or other fixed object. \n http://www.bicyclecoalition.org/resources/presentations/bikevideos/dvrpc_safety");
			//Linkify.addLinks(noteView, Linkify.WEB_URLS);
			Pattern wikiWordMatcher = Pattern.compile("\\b[A-Z]+[a-z0-9]+[A-Z][A-Za-z0-9]+\\b");
			String wikiViewURL =    "content://com.google.android.wikinotes.db.wikinotes/wikinotes/";
			Linkify.addLinks(noteView, wikiWordMatcher, wikiViewURL);
			//addLink(text, "^Android", "http://www.android.com");

			
			
			
			TabHost th = (TabHost)findViewById(R.id.tabhost);
			th.setup();
			
			TabSpec specs = th.newTabSpec("tag1");
			specs.setContent(R.id.map);
			//specs.setContent(R.layout.activity_main);
			specs.setIndicator("Map");
			th.addTab(specs);
	        //Intent intent = new Intent().setClass(this, MainActivity.class);
			//specs.setContent(intent);
			
			
			specs = th.newTabSpec("tag2");
			specs.setContent(R.id.tab2);
			specs.setIndicator("Safety Tips");
			
			th.addTab(specs);
			

		}

	}


