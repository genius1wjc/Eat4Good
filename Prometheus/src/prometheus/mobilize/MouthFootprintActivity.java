package prometheus.mobilize;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MouthFootprintActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.mouth_footprint);

	ImageButton circleButton1 = (ImageButton) findViewById(R.id.circleButton1);
	circleButton1.setOnClickListener(new View.OnClickListener() {
	    public void onClick(View v) {
		Intent myIntent = new Intent(MouthFootprintActivity.this, FoodActivity.class);
		myIntent.putExtra("title", "Check in");
		MouthFootprintActivity.this.startActivity(myIntent);
	    }
	});

	ImageButton circleButton2 = (ImageButton) findViewById(R.id.circleButton2);
	circleButton2.setOnClickListener(new View.OnClickListener() {
	    public void onClick(View v) {
		Intent myIntent = new Intent(MouthFootprintActivity.this, FoodActivity.class);
		myIntent.putExtra("title", "Eaten food");
		MouthFootprintActivity.this.startActivity(myIntent);
	    }
	});

	ImageButton circleButton3 = (ImageButton) findViewById(R.id.circleButton3);
	circleButton3.setOnClickListener(new View.OnClickListener() {
	    public void onClick(View v) {
		Intent myIntent = new Intent(MouthFootprintActivity.this, FoodActivity.class);
		myIntent.putExtra("title", "Favorite");
		MouthFootprintActivity.this.startActivity(myIntent);
	    }
	});
    }
}