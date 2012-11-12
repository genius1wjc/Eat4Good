package prometheus.mobilize;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ViewSwitcher;

public class SeasonActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.season);

	final CharSequence[] items = { "Newsletter", "Search", "MouthPrint", "Profile" };

	ImageButton listButton = (ImageButton) findViewById(R.id.listButton);
	listButton.setOnClickListener(new View.OnClickListener() {
	    public void onClick(View v) {
		new AlertDialog.Builder(SeasonActivity.this).setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int whichButton) {
			dialog.dismiss();
			int selectedPosition = ((AlertDialog) dialog).getListView().getCheckedItemPosition();
			Intent myIntent = null;

			switch (selectedPosition) {
			case 0:
			    myIntent = new Intent(SeasonActivity.this, NewsletterActivity.class);
			    break;
			case 1:
			    myIntent = new Intent(SeasonActivity.this, SearchRestaurantsActivity.class);
			    break;
			case 2:
			    myIntent = new Intent(SeasonActivity.this, MouthFootprintActivity.class);
			    break;
			case 3:
			    myIntent = new Intent(SeasonActivity.this, ProfileActivity.class);
			    break;
			}

			SeasonActivity.this.startActivity(myIntent);
		    }
		}).show();
	    }
	});

	final ViewSwitcher switcher = (ViewSwitcher) findViewById(R.id.SeasonSwitcher);

	Button button1 = (Button) findViewById(R.id.button1);
	button1.setOnClickListener(new View.OnClickListener() {
	    public void onClick(View v) {
		switcher.showNext();
	    }
	});

	ImageButton metroButton = (ImageButton) findViewById(R.id.metroButton);
	metroButton.setOnClickListener(new View.OnClickListener() {
	    public void onClick(View v) {
		switcher.showPrevious();
	    }
	});
    }
}