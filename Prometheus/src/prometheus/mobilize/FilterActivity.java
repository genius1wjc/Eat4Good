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
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class FilterActivity extends Activity implements SeekBar.OnSeekBarChangeListener {
    /** Called when the activity is first created. */
    SeekBar mSeekBar;
    TextView mProgressText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.filter);
	
	Button viewDetail = (Button) findViewById(R.id.GoBackButton);
	viewDetail.setOnClickListener(new View.OnClickListener() {
	    public void onClick(View v) {
		Intent myIntent = new Intent(FilterActivity.this, SearchRestaurantsActivity.class);
		FilterActivity.this.startActivity(myIntent);
	    }
	});

	final CharSequence[] items = { "Newsletter", "Season", "Search", "MouthPrint", "Profile" };

	ImageButton listButton = (ImageButton) findViewById(R.id.listButton);
	listButton.setOnClickListener(new View.OnClickListener() {
	    public void onClick(View v) {
		new AlertDialog.Builder(FilterActivity.this).setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int whichButton) {
			dialog.dismiss();
			int selectedPosition = ((AlertDialog) dialog).getListView().getCheckedItemPosition();
			Intent myIntent = null;

			switch (selectedPosition) {
			case 0:
			    myIntent = new Intent(FilterActivity.this, NewsletterActivity.class);
			    break;
			case 1:
			    myIntent = new Intent(FilterActivity.this, SeasonActivity.class);
			    break;
			case 2:
			    myIntent = new Intent(FilterActivity.this, SearchRestaurantsActivity.class);
			    break;
			case 3:
			    myIntent = new Intent(FilterActivity.this, MouthFootprintActivity.class);
			    break;
			case 4:
			    myIntent = new Intent(FilterActivity.this, ProfileActivity.class);
			    break;
			}

			FilterActivity.this.startActivity(myIntent);
		    }
		}).show();
	    }
	});

	mSeekBar = (SeekBar) findViewById(R.id.seek);
	mSeekBar.setOnSeekBarChangeListener(this);
	mProgressText = (TextView) findViewById(R.id.progress);
    }

    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromTouch) {
	mProgressText.setText(progress + " miles");
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}