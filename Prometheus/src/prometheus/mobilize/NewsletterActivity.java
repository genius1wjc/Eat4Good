package prometheus.mobilize;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class NewsletterActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.newsletter);
	
	ImageView viewDetail = (ImageView) findViewById(R.id.imageView);
	viewDetail.setOnClickListener(new View.OnClickListener() {
	    public void onClick(View v) {
		Intent myIntent = new Intent(NewsletterActivity.this, NewsletterDetailActivity.class);
		NewsletterActivity.this.startActivity(myIntent);
	    }
	});

	final CharSequence[] items = { "Season", "Search", "MouthPrint", "Profile" };

	ImageButton listButton = (ImageButton) findViewById(R.id.listButton);
	listButton.setOnClickListener(new View.OnClickListener() {
	    public void onClick(View v) {
		new AlertDialog.Builder(NewsletterActivity.this).setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int whichButton) {
			dialog.dismiss();
			int selectedPosition = ((AlertDialog) dialog).getListView().getCheckedItemPosition();
			Intent myIntent = null;

			switch (selectedPosition) {
			case 0:
			    myIntent = new Intent(NewsletterActivity.this, SeasonActivity.class);
			    break;
			case 1:
			    myIntent = new Intent(NewsletterActivity.this, SearchRestaurantsActivity.class);
			    break;
			case 2:
			    myIntent = new Intent(NewsletterActivity.this, MouthFootprintActivity.class);
			    break;
			case 3:
			    myIntent = new Intent(NewsletterActivity.this, ProfileActivity.class);
			    break;
			}

			NewsletterActivity.this.startActivity(myIntent);
		    }
		}).show();
	    }
	});
    }
}