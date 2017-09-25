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
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends Activity {

    Button btTentarSorte ;
    Button btJogarNovamente;
    TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tentarSorte();
        jogarNovamente();
    }

    public static boolean gerarCartaRandomicamente() {
        Random random = new Random();
        boolean isTrue = random.nextBoolean();
        if (isTrue) return true;
        else return false;
    }

    public void tentarSorte() {
        btTentarSorte = (Button) findViewById(R.id.btConfirmar);
        textResultado = (TextView) findViewById(R.id.textResultado);

        btTentarSorte.setOnClickListener(new View.OnClickListener() {
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
                    boolean isTrue = MainActivity.gerarCartaRandomicamente();
                    if (checkedRadioButtonId == R.id.radioButton1) {

                        if(isTrue){
                            imgCarta1.setImageResource(R.mipmap.cartacoringa);
                            textResultado.setText("Perdeu playboy!");
                        }else{
                            imgCarta1.setImageResource(R.mipmap.cartanormal);
                            textResultado.setText("Ganhou!");
                        }
                    }
                    if (checkedRadioButtonId == R.id.radioButton2) {
                        if(isTrue){
                            imgCarta2.setImageResource(R.mipmap.cartacoringa);
                            textResultado.setText("Perdeu playboy!");
                        }else{
                            imgCarta2.setImageResource(R.mipmap.cartanormal);
                            textResultado.setText("Ganhou!");
                        }
                    }
                    if (checkedRadioButtonId == R.id.radioButton3) {
                        if(isTrue){
                            imgCarta3.setImageResource(R.mipmap.cartacoringa);
                            textResultado.setText("Perdeu playboy!");
                        }else{
                            imgCarta3.setImageResource(R.mipmap.cartanormal);
                            textResultado.setText("Ganhou!");
                        }
                    }
                    btTentarSorte.setEnabled(false);
                }
            }
        });
    }

    public void jogarNovamente() {

        btJogarNovamente = (Button) findViewById(R.id.btResetar);
        textResultado = (TextView) findViewById(R.id.textResultado);

        btJogarNovamente.setOnClickListener(new View.OnClickListener() {
            ImageView imgCarta1 = (ImageView) findViewById(R.id.carta1);
            ImageView imgCarta2 = (ImageView) findViewById(R.id.carta2);
            ImageView imgCarta3 = (ImageView) findViewById(R.id.carta3);

            RadioButton rb1 = (RadioButton) findViewById(R.id.radioButton1);
            RadioButton rb2 = (RadioButton) findViewById(R.id.radioButton2);
            RadioButton rb3 = (RadioButton) findViewById(R.id.radioButton3);

            @Override
            public void onClick(View arg0) {
                textResultado.setText("");

                imgCarta1.setImageResource(R.mipmap.cartafundo);
                imgCarta2.setImageResource(R.mipmap.cartafundo);
                imgCarta3.setImageResource(R.mipmap.cartafundo);

                btTentarSorte.setEnabled(true);

                rb1.setChecked(false);
                rb2.setChecked(false);
                rb3.setChecked(false);
            }
        });
    }
}
