package com.example.sortjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private final Integer tamanho = 10000;
    private final Integer numeroMax = 1000000;
    private Integer array[];
    Button prepararBtn;
    Button ordenarBtn;
    TextView statusTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prepararBtn = findViewById(R.id.prepararBtn);
        ordenarBtn = findViewById(R.id.ordenarBtn);
        statusTxt = findViewById(R.id.statusTxt);
    }

    public void preparaArray(View v) {
        long begin = System.nanoTime();
        array = new Integer[tamanho];
        Random random = new Random();

        for(int i = 0; i < tamanho; i++) {
            array[i] = random.nextInt(this.numeroMax + 1) + 1;
        }

        long difference = (System.nanoTime() - begin)/1000000;
        prepararBtn.setVisibility(View.INVISIBLE);
        ordenarBtn.setVisibility(View.VISIBLE);
        statusTxt.setText("Finished preparing array in " + difference + "ms");
        this.mostrarArray();
    }

    private void mostrarArray() {
        TextView arrayTxt = findViewById(R.id.arrayTxt);
        arrayTxt.setText(this.imprimeArray());
    }

    private String imprimeArray() {
        StringBuilder arrayString = new StringBuilder();
        for(int i = 0; i < tamanho; i++) {
            String msg = i == (tamanho - 1) ? array[i].toString() : array[i].toString() + ", ";
            arrayString.append(msg);
        }
        return arrayString.toString();
    }

    public void ordenar(View v) {
        long begin = System.nanoTime();
        for (int i = 0; i < this.tamanho; i++) { //Number of passes
            for (int j = 0; j < (this.tamanho - i - 1); j++) { //Notice that j < (length - i)
                //Compare the adjacent positions
                if (array[j] > array[j + 1]) {
                    //Swap the numbers
                    Integer tmp = array[j]; //Temporary variable to hold the current number
                    array[j] = array[j + 1]; //Replace current number with adjacent number
                    array[j + 1] = tmp; //Replace adjacent number with current number
                }
            }
        }

        long difference = (System.nanoTime() - begin)/1000000;
        statusTxt.setText("Finished sorting array in " + difference + "ms");
        ordenarBtn.setVisibility(View.INVISIBLE);
        this.mostrarArray();
    }
}
