package moreira.iuri.assessmentandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends Activity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();
    }

    public void addListenerOnButton() {

        button = (Button) findViewById(R.id.btConfirmar);


        button.setOnClickListener(new View.OnClickListener() {
            ImageView img = (ImageView) findViewById(R.id.carta1);
            @Override
            public void onClick(View arg0) {

                img.setImageResource(R.mipmap.cartacoringa);

            }

        });

    }
}
