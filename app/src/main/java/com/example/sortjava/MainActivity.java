package com.example.sortjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private final Integer tamanho = 10000;
    private final Integer numeroMax = 1000000;
    private Integer array[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.preparaArray();
        this.mostrarArray();
    }

    private void preparaArray() {
        array = new Integer[tamanho];
        Random random = new Random();

        for(int i = 0; i < tamanho; i++) {
            array[i] = random.nextInt(this.numeroMax + 1) + 1;
        }
    }

    private void mostrarArray() {
        TextView arrayTxt = (TextView) findViewById(R.id.arrayTxt);
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
        this.mostrarArray();
    }
}
