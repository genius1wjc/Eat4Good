package prometheus.mobilize;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.Toast;

public class FavoriteActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.favorite);

//	final CharSequence[] items = { "Newsletter", "Season", "Search", "MouthPrint", "Profile" };

//	ImageButton listButton = (ImageButton) findViewById(R.id.listButton);
//	listButton.setOnClickListener(new View.OnClickListener() {
//	    public void onClick(View v) {
//		new AlertDialog.Builder(FavoriteActivity.this).setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
//		    public void onClick(DialogInterface dialog, int whichButton) {
//			dialog.dismiss();
//			int selectedPosition = ((AlertDialog) dialog).getListView().getCheckedItemPosition();
//			Intent myIntent = null;
//
//			switch (selectedPosition) {
//			case 0:
//			    myIntent = new Intent(FavoriteActivity.this, NewsletterActivity.class);
//			    break;
//			case 1:
//			    myIntent = new Intent(FavoriteActivity.this, SeasonActivity.class);
//			    break;
//			case 2:
//			    myIntent = new Intent(FavoriteActivity.this, SearchRestaurantsActivity.class);
//			    break;
//			case 3:
//			    myIntent = new Intent(FavoriteActivity.this, MouthFootprintActivity.class);
//			    break;
//			case 4:
//			    myIntent = new Intent(FavoriteActivity.this, ProfileActivity.class);
//			    break;
//			}
//
//			FavoriteActivity.this.startActivity(myIntent);
//		    }
//		}).show();
//	    }
//	});
    }
}