package moreira.iuri.assessmentandroid;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Random;


public class MainActivity extends Activity {

    Button button ;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();
        addListenerOnButton2();
    }

    public static int getRandom() {
        Random random = new Random();
        boolean isOne = random.nextBoolean();
        if (isOne) return 1;
        else return 2;
    }

    public void addListenerOnButton() {

        button = (Button) findViewById(R.id.btConfirmar);

        button.setOnClickListener(new View.OnClickListener() {
            ImageView imgCarta1 = (ImageView) findViewById(R.id.carta1);
            ImageView imgCarta2 = (ImageView) findViewById(R.id.carta2);
            ImageView imgCarta3 = (ImageView) findViewById(R.id.carta3);

            @Override
            public void onClick(View arg0) {
                RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup);

                int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();

                if (checkedRadioButtonId == -1) {
                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("Atenção");
                    alertDialog.setMessage("Escolha uma carta.");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
                else{
                    int r = MainActivity.getRandom();
                    if (checkedRadioButtonId == R.id.radioButton1) {

                        if(r==2){
                            imgCarta1.setImageResource(R.mipmap.cartacoringa);
                        }else{
                            imgCarta1.setImageResource(R.mipmap.cartanormal);
                        }
                    }
                    if (checkedRadioButtonId == R.id.radioButton2) {
                        if(r==2){
                            imgCarta2.setImageResource(R.mipmap.cartacoringa);
                        }else{
                            imgCarta2.setImageResource(R.mipmap.cartanormal);
                        }
                    }
                    if (checkedRadioButtonId == R.id.radioButton3) {
                        if(r==2){
                            imgCarta3.setImageResource(R.mipmap.cartacoringa);
                        }else{
                            imgCarta3.setImageResource(R.mipmap.cartanormal);
                        }
                    }
                    button.setEnabled(false);
                }

            }

        });
    }

    public void addListenerOnButton2() {

        button2 = (Button) findViewById(R.id.btResetar);

        button2.setOnClickListener(new View.OnClickListener() {
            ImageView imgCarta1 = (ImageView) findViewById(R.id.carta1);
            ImageView imgCarta2 = (ImageView) findViewById(R.id.carta2);
            ImageView imgCarta3 = (ImageView) findViewById(R.id.carta3);

            RadioButton rb1 = (RadioButton) findViewById(R.id.radioButton1);
            RadioButton rb2 = (RadioButton) findViewById(R.id.radioButton2);
            RadioButton rb3 = (RadioButton) findViewById(R.id.radioButton3);

            @Override
            public void onClick(View arg0) {

                        imgCarta1.setImageResource(R.mipmap.cartafundo);


                        imgCarta2.setImageResource(R.mipmap.cartafundo);


                        imgCarta3.setImageResource(R.mipmap.cartafundo);


                button.setEnabled(true);

                rb1.setChecked(false);
                rb2.setChecked(false);
                rb3.setChecked(false);

            }

        });
    }
}
