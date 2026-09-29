package models;

import java.util.Comparator;

public class Sort <T extends Comparable<T>> {
    private long contaComparacoes;
    private long contaTrocas;

    public long getContaComparacoes() {
        return contaComparacoes;
    }

    public long getContaTrocas() {
        return contaTrocas;
    }

    private void trocar(T[] v, int i, int j) {
        T temp = v[i];
        v[i] = v[j];
        v[j] = temp;
        this.contaTrocas++;
    }

  
    private int particaoHoare(T[] v, int inicio, int fim, Comparator<T> comparador) {
        T pivo = v[inicio];
        
        int i = inicio - 1;
        int j = fim + 1;

        while (true) {
        
            do {
                j--;
                this.contaComparacoes++; 
            } while (comparador.compare(v[j], pivo) > 0);

            do {
                i++;
                this.contaComparacoes++;
            } while (comparador.compare(v[i], pivo) < 0);

            
            if (i >= j) {
                return j; 
            }

            trocar(v, i, j);
        }
    }


    private void quickSortRecursivo(T[] v, int inicio, int fim, Comparator<T> comparador) {
        if (inicio < fim) {
            int q = particaoHoare(v, inicio, fim, comparador); 

            quickSortRecursivo(v, inicio, q, comparador);
            quickSortRecursivo(v, q + 1, fim, comparador);
        }
    }

    public T[] sort(T[] array, Comparator<T> comparador) {
        if (array == null || array.length <= 1) {
            return array; 
        }
        
        this.contaComparacoes = 0;
        this.contaTrocas = 0;

        quickSortRecursivo(array, 0, array.length - 1, comparador);
        
        return array;
    }

    // Método público usando a ordem natural (Comparable)
    public T[] sort(T[] array) {
        return sort(array, (a, b) -> a.compareTo(b));
    }
}
