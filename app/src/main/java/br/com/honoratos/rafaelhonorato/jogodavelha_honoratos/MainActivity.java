package br.com.honoratos.rafaelhonorato.jogodavelha_honoratos;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    private View view;
    //const. para pegar qual btn foi cliclado
    private final String QUADRADO = "quadrado";
    //const. para setText dos btns clicados
    private final String CIRCULO = "O";
    private final String XIS = "X";
    //const. para pegar o ultimo "jogador"
    private String lastPlay = "X";
    private boolean venceu = false;
    //resultados para comparação final
    int[][] resultados = new int[][]{
            {1,2,3},
            {4,5,6},
            {7,8,9},

            {1,4,7},
            {2,5,8},
            {3,6,9},

            {1,5,9},
            {3,5,7}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView(getLayoutInflater().inflate(R.layout.activity_main, null));
        setContentView(getView());
    }

    public Button getQuadrado(int tagNum){
        return (Button)getView().findViewWithTag( QUADRADO+tagNum );
    }
    public void clickQuadrado(View v){

        if(!venceu) {
            if (((Button) v).getText().equals("")) {
                if (lastPlay.equals("X")) {
                    ((Button) v).setText("O");
                    setLastPlay("O");
                } else {
                    ((Button) v).setText("X");
                    setLastPlay("X");
                }
            } else {
                mensagemToast("Ops! Escolha outro botão");
            }
            vencedor();
        }
    }
    public void vencedor(){
        for(int x=0 ;x<=7; ++x ){
            String s1 = getQuadrado(resultados[x][0]).getText().toString();
            String s2 = getQuadrado(resultados[x][1]).getText().toString();
            String s3 = getQuadrado(resultados[x][2]).getText().toString();

            if(!s1.equals("") && !s2.equals("") && !s3.equals("")) {
                if (s1.equals(s2) && (s2.equals(s3))) {
                    mensagemToast("Parabéns "+s1+", você é o vencedor!");
                    setColorLinha(resultados[x][0],R.color.green);
                    setColorLinha(resultados[x][1],R.color.green);
                    setColorLinha(resultados[x][2],R.color.green);
                    venceu = true;
                }
            }
        }
    }
    public void setColorLinha(int btn, int color){
        getQuadrado(btn).setTextColor(getResources().getColor(color));
    }
    public void novoJogo(View v){
        for(int i=1;i<=9;++i){
            if(getQuadrado(i)!=null){
                getQuadrado(i).setText("");
                getQuadrado(i).setTextColor(getResources().getColor(R.color.blue));
                venceu = false;
            }
        }
    }
    public void mensagemToast(String texto){
        Toast toast = Toast.makeText(getView().getContext(), texto, Toast.LENGTH_SHORT);
        LinearLayout toastLayout = (LinearLayout) toast.getView();
        TextView toastTV = (TextView) toastLayout.getChildAt(0);
        toastTV.setTextSize(30);
        toast.show();
    }
    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public String getLastPlay() {
        return lastPlay;
    }

    public void setLastPlay(String lastPlay) {
        this.lastPlay = lastPlay;
    }
}
