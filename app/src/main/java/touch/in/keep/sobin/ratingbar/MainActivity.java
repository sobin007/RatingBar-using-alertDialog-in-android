package touch.in.keep.sobin.ratingbar;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    RatingBar ratingBar;
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.tv_rating);
        ratingBar = (RatingBar) findViewById(R.id.ratingbar);
        textView1 = (TextView) findViewById(R.id.feedback);
    }

    public  void rating(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        View dialogView = LayoutInflater.from(MainActivity.this).inflate(R.layout.rank_dialog, null);
        final RatingBar ratingBar1 = (RatingBar) dialogView.findViewById(R.id.dialog_ratingbar);
        final EditText feedbackText = (EditText) dialogView.findViewById(R.id.feedback);
        feedbackText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feedbackText.setFocusableInTouchMode(true);
            }
        });

        builder.setView(dialogView);
        builder.setTitle("Share your feedback");

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                textView.setText(String.valueOf( ratingBar1.getRating()));
                ratingBar.setRating(ratingBar1.getRating());
                textView1.setText(feedbackText.getText());

            }
        });

        builder.show();

    }
}
