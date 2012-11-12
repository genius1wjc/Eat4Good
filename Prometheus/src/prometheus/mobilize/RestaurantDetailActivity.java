package prometheus.mobilize;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;

public class RestaurantDetailActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.restaurant_detail);

	EditText editText1 = (EditText) findViewById(R.id.editText1);
	editText1.setKeyListener(null);

	final CharSequence[] items = { "Newsletter", "Season", "Search", "MouthPrint", "Profile" };

	ImageButton listButton = (ImageButton) findViewById(R.id.listButton);
	listButton.setOnClickListener(new View.OnClickListener() {
	    public void onClick(View v) {
		new AlertDialog.Builder(RestaurantDetailActivity.this).setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int whichButton) {
			dialog.dismiss();
			int selectedPosition = ((AlertDialog) dialog).getListView().getCheckedItemPosition();
			Intent myIntent = null;

			switch (selectedPosition) {
			case 0:
			    myIntent = new Intent(RestaurantDetailActivity.this, NewsletterActivity.class);
			    break;
			case 1:
			    myIntent = new Intent(RestaurantDetailActivity.this, SeasonActivity.class);
			    break;
			case 2:
			    myIntent = new Intent(RestaurantDetailActivity.this, SearchRestaurantsActivity.class);
			    break;
			case 3:
			    myIntent = new Intent(RestaurantDetailActivity.this, MouthFootprintActivity.class);
			    break;
			case 4:
			    myIntent = new Intent(RestaurantDetailActivity.this, ProfileActivity.class);
			    break;
			}

			RestaurantDetailActivity.this.startActivity(myIntent);
		    }
		}).show();
	    }
	});
    }
}