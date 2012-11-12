package prometheus.mobilize;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

public class EatenFoodActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.eaten_food);

	final CharSequence[] items = { "Newsletter", "Season", "Search", "MouthPrint", "Profile" };

	ImageButton listButton = (ImageButton) findViewById(R.id.listButton);
	listButton.setOnClickListener(new View.OnClickListener() {
	    public void onClick(View v) {
		new AlertDialog.Builder(EatenFoodActivity.this).setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int whichButton) {
			dialog.dismiss();
			int selectedPosition = ((AlertDialog) dialog).getListView().getCheckedItemPosition();
			Intent myIntent = null;

			switch (selectedPosition) {
			case 0:
			    myIntent = new Intent(EatenFoodActivity.this, NewsletterActivity.class);
			    break;
			case 1:
			    myIntent = new Intent(EatenFoodActivity.this, SeasonActivity.class);
			    break;
			case 2:
			    myIntent = new Intent(EatenFoodActivity.this, SearchRestaurantsActivity.class);
			    break;
			case 3:
			    myIntent = new Intent(EatenFoodActivity.this, MouthFootprintActivity.class);
			    break;
			case 4:
			    myIntent = new Intent(EatenFoodActivity.this, ProfileActivity.class);
			    break;
			}

			EatenFoodActivity.this.startActivity(myIntent);
		    }
		}).show();
	    }
	});
    }
}