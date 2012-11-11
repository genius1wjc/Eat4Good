package prometheus.mobilize;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TestActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.test);

	Button button1 = (Button) findViewById(R.id.button1);
	button1.setOnClickListener(new View.OnClickListener() {
	    public void onClick(View v) {
		Intent myIntent = new Intent(TestActivity.this, LoginActivity.class);
		TestActivity.this.startActivity(myIntent);
	    }
	});

	Button button2 = (Button) findViewById(R.id.button2);
	button2.setOnClickListener(new View.OnClickListener() {
	    public void onClick(View v) {
		Intent myIntent = new Intent(TestActivity.this, NewsletterActivity.class);
		TestActivity.this.startActivity(myIntent);
	    }
	});

	Button button3 = (Button) findViewById(R.id.button3);
	button3.setOnClickListener(new View.OnClickListener() {
	    public void onClick(View v) {
		Intent myIntent = new Intent(TestActivity.this, ProfileActivity.class);
		TestActivity.this.startActivity(myIntent);
	    }
	});

	Button button4 = (Button) findViewById(R.id.button4);
	button4.setOnClickListener(new View.OnClickListener() {
	    public void onClick(View v) {
		Intent myIntent = new Intent(TestActivity.this, SeasonActivity.class);
		TestActivity.this.startActivity(myIntent);
	    }
	});

	Button button5 = (Button) findViewById(R.id.button5);
	button5.setOnClickListener(new View.OnClickListener() {
	    public void onClick(View v) {
		Intent myIntent = new Intent(TestActivity.this, MouthFootprintActivity.class);
		TestActivity.this.startActivity(myIntent);
	    }
	});

	Button button6 = (Button) findViewById(R.id.button6);
	button6.setOnClickListener(new View.OnClickListener() {
	    public void onClick(View v) {
		Intent myIntent = new Intent(TestActivity.this, RestaurantDetailActivity.class);
		TestActivity.this.startActivity(myIntent);
	    }
	});
	
	Button button7 = (Button) findViewById(R.id.button7);
	button7.setOnClickListener(new View.OnClickListener() {
	    public void onClick(View v) {
		Intent myIntent = new Intent(TestActivity.this, NewsletterDetailActivity.class);
		TestActivity.this.startActivity(myIntent);
	    }
	});
    }
}