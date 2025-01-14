package com.app;


public class QuickSort {
    public void quickSort(int[] array, int inicio, int fim) {
        if (inicio < fim) {
            Particionamento particionamento = new Particionamento(array, inicio, fim);
            int posicaoPivo = particionamento.executar();
            quickSort(array, inicio, posicaoPivo - 1);
            quickSort(array, posicaoPivo + 1, fim);
        }
    }
}

class Particionamento {
    private int[] array;
    private int inicio;
    private int fim;
    private int pivo;
    private int i;
    private int j;

    public Particionamento(int[] array, int inicio, int fim) {
        this.array = array;
        this.inicio = inicio;
        this.fim = fim;
    }

    public int executar() {
        inicializar();
        varrerVetor();
        trocarPivo();
        return j;
    }

    private void inicializar() {
        pivo = array[inicio];
        i = inicio + 1;
        j = fim;
    }

    private void varrerVetor() {
        while (i <= j) {
            if (array[i] <= pivo) {
                i++;
            } else if (array[j] > pivo) {
                j--;
            } else {
                trocarElementos(i, j);
                i++;
                j--;
            }
        }
    }

    private void trocarElementos(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void trocarPivo() {
        array[inicio] = array[j];
        array[j] = pivo;
    }
}