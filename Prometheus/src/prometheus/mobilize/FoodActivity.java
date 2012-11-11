package prometheus.mobilize;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class FoodActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.food);

	Intent intent = getIntent();
	String title = intent.getExtras().getString("title");

	if (!title.equals(null))
	    setTitle(title);
    }
}