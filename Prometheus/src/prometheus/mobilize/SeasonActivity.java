package prometheus.mobilize;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ViewSwitcher;

public class SeasonActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.season);

	final ViewSwitcher switcher = (ViewSwitcher) findViewById(R.id.SeasonSwitcher);

	ImageButton listButton = (ImageButton) findViewById(R.id.listButton);
	listButton.setOnClickListener(new View.OnClickListener() {
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