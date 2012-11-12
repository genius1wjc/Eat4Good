package prometheus.mobilize;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class LoginActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.login);

	SpannableString ss = new SpannableString("Click here if you forget your username or password");

	ss.setSpan(new URLSpan("tel:4155551212"), 6, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

	TextView forgetTextView = (TextView) findViewById(R.id.forgetTextView);
	forgetTextView.setText(ss);
	forgetTextView.setMovementMethod(LinkMovementMethod.getInstance());

	Button loginButton = (Button) findViewById(R.id.loginButton);
	loginButton.setOnClickListener(new View.OnClickListener() {
	    public void onClick(View v) {
		Intent myIntent = new Intent(LoginActivity.this, ProfileActivity.class);
		LoginActivity.this.startActivity(myIntent);
	    }
	});

	final CharSequence[] items = { "Newsletter", "Season", "Search", "MouthPrint", "Profile" };

	ImageButton listButton = (ImageButton) findViewById(R.id.listButton);
	listButton.setOnClickListener(new View.OnClickListener() {
	    public void onClick(View v) {
		new AlertDialog.Builder(LoginActivity.this).setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int whichButton) {
			dialog.dismiss();
			int selectedPosition = ((AlertDialog) dialog).getListView().getCheckedItemPosition();
			Intent myIntent = null;

			switch (selectedPosition) {
			case 0:
			    myIntent = new Intent(LoginActivity.this, NewsletterActivity.class);
			    break;
			case 1:
			    myIntent = new Intent(LoginActivity.this, SeasonActivity.class);
			    break;
			case 2:
			    myIntent = new Intent(LoginActivity.this, SearchRestaurantsActivity.class);
			    break;
			case 3:
			    myIntent = new Intent(LoginActivity.this, MouthFootprintActivity.class);
			    break;
			case 4:
			    myIntent = new Intent(LoginActivity.this, ProfileActivity.class);
			    break;
			}

			LoginActivity.this.startActivity(myIntent);
		    }
		}).show();
	    }
	});
    }
}