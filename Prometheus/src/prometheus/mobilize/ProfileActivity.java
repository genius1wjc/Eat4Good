package prometheus.mobilize;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends Activity {
    /** Called when the activity is first created. */
    String[] str = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.profile);

	final CharSequence[] items = { "Newsletter", "Season", "Search", "MouthPrint" };

	ImageButton listButton = (ImageButton) findViewById(R.id.listButton);
	listButton.setOnClickListener(new View.OnClickListener() {
	    public void onClick(View v) {
		new AlertDialog.Builder(ProfileActivity.this).setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int whichButton) {
			dialog.dismiss();
			int selectedPosition = ((AlertDialog) dialog).getListView().getCheckedItemPosition();
			Intent myIntent = null;

			switch (selectedPosition) {
			case 0:
			    myIntent = new Intent(ProfileActivity.this, NewsletterActivity.class);
			    break;
			case 1:
			    myIntent = new Intent(ProfileActivity.this, SeasonActivity.class);
			    break;
			case 2:
			    myIntent = new Intent(ProfileActivity.this, SearchRestaurantsActivity.class);
			    break;
			case 3:
			    myIntent = new Intent(ProfileActivity.this, MouthFootprintActivity.class);
			    break;
			}

			ProfileActivity.this.startActivity(myIntent);
		    }
		}).show();
	    }
	});

	new RetreiveFeedTask().execute();
    }

    class RetreiveFeedTask extends AsyncTask<Void, Void, String[]> {

	private Exception exception;

	protected void onPostExecute(String[] str) {
	    ProgressBar progressBar1 = (ProgressBar) findViewById(R.id.progressBar1);
	    progressBar1.setProgress(Integer.parseInt(str[0]));

	    TextView TextView01 = (TextView) findViewById(R.id.TextView01);
	    TextView01.setText(str[1]);

	    TextView row1TextView = (TextView) findViewById(R.id.row1TextView);
	    row1TextView.setText(str[2]);
	}

	@Override
	protected String[] doInBackground(Void... params) {
	    try {
		return getScores();
	    } catch (Exception e) {
		this.exception = e;
		return null;
	    }
	}
    }

    private String[] getScores() {
	HttpClient httpClient = new DefaultHttpClient();
	HttpGet httpGet = new HttpGet("http://m2.cip.gatech.edu/developer/nyancatzzz/widget/base_widget/content/api/hello");
	try {
	    HttpResponse response = httpClient.execute(httpGet);
	    String result = EntityUtils.toString(response.getEntity());
	    String[] str = result.split(",");

	    return str;
	    // Toast.makeText(ProfileActivity.this, result, Toast.LENGTH_LONG).show();
	} catch (Exception e) {
	    Toast.makeText(ProfileActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
	}
	return null;
    }
}