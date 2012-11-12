package prometheus.mobilize;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

public class MouthFootprintActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.mouth_footprint);

	ImageButton circleButton1 = (ImageButton) findViewById(R.id.circleButton1);
	circleButton1.setOnClickListener(new View.OnClickListener() {
	    public void onClick(View v) {
		Intent myIntent = new Intent(MouthFootprintActivity.this, CheckedInActivity.class);
		MouthFootprintActivity.this.startActivity(myIntent);
	    }
	});

	ImageButton circleButton2 = (ImageButton) findViewById(R.id.circleButton2);
	circleButton2.setOnClickListener(new View.OnClickListener() {
	    public void onClick(View v) {
		Intent myIntent = new Intent(MouthFootprintActivity.this, EatenFoodActivity.class);
		myIntent.putExtra("title", "Eaten food");
		MouthFootprintActivity.this.startActivity(myIntent);
	    }
	});

	ImageButton circleButton3 = (ImageButton) findViewById(R.id.circleButton3);
	circleButton3.setOnClickListener(new View.OnClickListener() {
	    public void onClick(View v) {
		Intent myIntent = new Intent(MouthFootprintActivity.this, FavoriteActivity.class);
		MouthFootprintActivity.this.startActivity(myIntent);
	    }
	});

	final CharSequence[] items = { "Newsletter", "Season", "Search", "Profile" };

	ImageButton listButton = (ImageButton) findViewById(R.id.listButton);
	listButton.setOnClickListener(new View.OnClickListener() {
	    public void onClick(View v) {
		new AlertDialog.Builder(MouthFootprintActivity.this).setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int whichButton) {
			dialog.dismiss();
			int selectedPosition = ((AlertDialog) dialog).getListView().getCheckedItemPosition();
			Intent myIntent = null;

			switch (selectedPosition) {
			case 0:
			    myIntent = new Intent(MouthFootprintActivity.this, NewsletterActivity.class);
			    break;
			case 1:
			    myIntent = new Intent(MouthFootprintActivity.this, SeasonActivity.class);
			    break;
			case 2:
			    myIntent = new Intent(MouthFootprintActivity.this, SearchRestaurantsActivity.class);
			    break;
			case 3:
			    myIntent = new Intent(MouthFootprintActivity.this, ProfileActivity.class);
			    break;
			}

			MouthFootprintActivity.this.startActivity(myIntent);
		    }
		}).show();
	    }
	});
    }
}