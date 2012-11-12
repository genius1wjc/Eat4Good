package prometheus.mobilize;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SearchFoodsActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.search_foods);

	Button filterButton = (Button) findViewById(R.id.filterButton);
	filterButton.setOnClickListener(new View.OnClickListener() {
	    @Override
	    public void onClick(View v) {
		Intent myIntent = new Intent(SearchFoodsActivity.this, FilterActivity.class);
		SearchFoodsActivity.this.startActivity(myIntent);
	    }
	});

	ImageView viewDetail = (ImageView) findViewById(R.id.viewDetail);
	viewDetail.setOnClickListener(new View.OnClickListener() {
	    public void onClick(View v) {
		Intent myIntent = new Intent(SearchFoodsActivity.this, FoodDetailActivity.class);
		SearchFoodsActivity.this.startActivity(myIntent);
	    }
	});

	TextView filterTest1 = (TextView) findViewById(R.id.filterTest1);
	filterTest1.setOnTouchListener(new OnTouchListener() {

	    @Override
	    public boolean onTouch(View arg0, MotionEvent arg1) {
		Toast.makeText(getApplicationContext(), "msg msg", Toast.LENGTH_SHORT).show();

		CharSequence[] items1 = { "Search restaurants", "Search Market" };
		new AlertDialog.Builder(SearchFoodsActivity.this).setSingleChoiceItems(items1, 0, new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int whichButton) {
			dialog.dismiss();
			int selectedPosition = ((AlertDialog) dialog).getListView().getCheckedItemPosition();
			Intent myIntent = null;

			switch (selectedPosition) {
			case 0:
			    myIntent = new Intent(SearchFoodsActivity.this, SearchRestaurantsActivity.class);
			    break;
			case 1:
			    myIntent = new Intent(SearchFoodsActivity.this, SearchMarketsActivity.class);
			    break;
			}

			SearchFoodsActivity.this.startActivity(myIntent);
		    }
		}).show();

		return false;
	    }
	});

	final CharSequence[] items = { "Newsletter", "Season", "MouthPrint", "Profile" };

	ImageButton listButton = (ImageButton) findViewById(R.id.listButton);
	listButton.setOnClickListener(new View.OnClickListener() {
	    public void onClick(View v) {
		new AlertDialog.Builder(SearchFoodsActivity.this).setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int whichButton) {
			dialog.dismiss();
			int selectedPosition = ((AlertDialog) dialog).getListView().getCheckedItemPosition();
			Intent myIntent = null;

			switch (selectedPosition) {
			case 0:
			    myIntent = new Intent(SearchFoodsActivity.this, NewsletterActivity.class);
			    break;
			case 1:
			    myIntent = new Intent(SearchFoodsActivity.this, SeasonActivity.class);
			    break;
			case 2:
			    myIntent = new Intent(SearchFoodsActivity.this, MouthFootprintActivity.class);
			    break;
			case 3:
			    myIntent = new Intent(SearchFoodsActivity.this, ProfileActivity.class);
			    break;
			}

			SearchFoodsActivity.this.startActivity(myIntent);
		    }
		}).show();
	    }
	});
    }
}