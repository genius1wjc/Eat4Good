package prometheus.mobilize;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
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
    }
}