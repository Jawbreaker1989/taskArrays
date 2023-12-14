package logic;

import java.util.Arrays;
import java.util.Random;

/**
 * Clase que gestiona un arreglo de valores enteros
 */
public class ServiceArrays {
    // Arreglo0
    private int[] numbers;
    // variable que controla la posición del siguiente elemento
    private int position;

    public static final int BURBBLE = 0;
    public static final int SELECTION = 1;
    public static final int INSERTION = 2;
    public static final int SHELL = 3;

    private static final int SIZE_DEFAULT = 10;

    /**
     * Constructor vació
     */
    public ServiceArrays(int beggin, int end) {
        // TODO Instanciar el arreglo de un tamaño de 10 elemetos
        numbers = new int[SIZE_DEFAULT];
        loadElements(10, 999);
        position = SIZE_DEFAULT;
    }

    /**
     * Constructor que inicializa el arreglo
     * 
     * @param size tamaño del arreglo
     */
    public ServiceArrays(int size, int beggin, int end) {
        // TODO Instanciar el arreglo de un tamaño del parámetro
        numbers = new int[size];
        loadElements(10, 999);
        position = size;
    }

    /**
     *
     * @param numbers
     */
    public ServiceArrays(int[] numbers) {
        this.numbers = numbers;
        position = numbers.length;
    }

    /**
     * Permite cargar los valores del arreglo
     * 
     * @param begin
     * @param end
     */
    private void loadElements(int begin, int end) {
        int min = begin <= end ? begin : end;
        int max = begin >= end ? begin : end;
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new Random().nextInt(max - min + 1) + min;
        }
    }

    public int[] getNumbers() {
        return numbers.clone();
    }

    /**
     *
     * @param element
     */
    public void addElement(int element) {
        if (position >= numbers.length) {
            numbers = sureCapacity();
        }
        numbers[position] = element;
        position++;

    }

    /**
     *
     * @return
     */
    private int[] sureCapacity() {
        int newSize = numbers.length + numbers.length / 2;
        int[] newArray = Arrays.copyOf(numbers, newSize);

        return newArray;
    }

    /**
     *
     * @return
     */
    public String showNumbers() {
        int lastIndex = position - 1;

        // Encontrar el índice del último elemento no cero
        while (lastIndex >= 0 && numbers[lastIndex] == 0) {
            lastIndex--;
        }

        int[] nonZeroArray = Arrays.copyOfRange(numbers, 0, lastIndex + 1);

        return Arrays.toString(nonZeroArray);
    }

    /**
     *
     * @param element
     * @return
     */
    public int findElement(int element) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == element) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Búsqueda binaria en el arreglo ordenado.
     * 
     * @param element Elemento a buscar.
     * @return Índice del elemento si se encuentra, -1 si no se encuentra.
     */
    public int findBinary(int element) {
        int[] sortedArray = sortBurbble();
        int left = 0;
        int right = position - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (sortedArray[mid] == element) {
                return mid;
            } else if (element < sortedArray[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    /**
     *
     * @return
     */

    public int getMin() {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < position; i++) {
            if (numbers[i] != 0 && numbers[i] < min) {
                min = numbers[i];
            }
        }

        return min;
    }

    /**
     *
     * @return
     */
    public int getMax() {
        int max = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    /**
     *
     * @return
     */
    public int getSum() {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    /**
     * @return El promedio de los elementos en el arreglo
     */
    public double getAverage() {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        return (double) sum / numbers.length;
    }

    private int[] sortBurbble() {
        int[] sorted = Arrays.copyOf(numbers, position);
        int n = sorted.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = sorted[i];
                int j;
                for (j = i; j >= gap && sorted[j - gap] > temp; j -= gap) {
                    sorted[j] = sorted[j - gap];
                }
                sorted[j] = temp;
            }
        }
        return sorted;
    }

    public int[] sortNumbers(int option) {
        switch (option) {
            case BURBBLE:
                return sortBurbble();
            case SELECTION:
                return sortSelection();
            case INSERTION:
                return sortInsertion();
            case SHELL:
                return sortShell();

            default:
                return null;
        }
    }

    private int[] sortSelection() {
        int[] sorted = Arrays.copyOf(numbers, position);
        for (int i = 0; i < sorted.length; i++) {
            int min = i;
            for (int j = i + 1; j < sorted.length; j++) {
                if (sorted[j] < sorted[min]) {
                    min = j;
                }
            }
            int temp = sorted[i];
            sorted[i] = sorted[min];
            sorted[min] = temp;
        }
        return sorted;
    }

    /**
     * Ordena el arreglo utilizando el algoritmo de ordenación por inserción.
     * 
     * @return Arreglo ordenado.
     */
    private int[] sortInsertion() {
        int[] sorted = Arrays.copyOf(numbers, position);

        for (int i = 1; i < sorted.length; i++) {
            int key = sorted[i];
            int j = i - 1;

            while (j >= 0 && sorted[j] > key) {
                sorted[j + 1] = sorted[j];
                j = j - 1;
            }

            sorted[j + 1] = key;
        }

        return sorted;
    }

    /**
     * Ordena el arreglo utilizando el algoritmo de ordenación Shell.
     * 
     * @return Arreglo ordenado.
     */
    private int[] sortShell() {
        int[] sorted = Arrays.copyOf(numbers, position);
        int size = sorted.length;
        int jump = size / 2;

        while (jump != 0) {
            jump = jump / 2;
            boolean cambios = true;

            while (cambios) {
                cambios = false;

                for (int j = jump; j < size; j++) {
                    if (sorted[j - jump] > sorted[j]) {
                        // Intercambiar elementos
                        int temp = sorted[j];
                        sorted[j] = sorted[j - jump];
                        sorted[j - jump] = temp;
                        cambios = true;
                    }
                }
            }
        }

        return sorted;
    }

    /**
     * Elimina un elemento del arreglo
     * 
     * @param element elemento a eliminar
     * @return el elemento eliminado, -1 si no se encuentra en el arreglo
     */
    public int delete(int element) {
        int index = findElement(element);
        if (index != -1) {
            int deletedElement = numbers[index];
            for (int i = index; i < position - 1; i++) {
                numbers[i] = numbers[i + 1];
            }
            numbers[position - 1] = 0;
            position--;
            return deletedElement;
        }
        return -1;
    }
    /**
 * Reemplaza un elemento del arreglo por otro.
 *
 * @param oldElement elemento a reemplazar
 * @param newElement nuevo elemento
 * @return el arreglo con el elemento reemplazado, o null si el elemento no se encuentra en el arreglo
 */
public int[] replace(int oldElement, int newElement) {
    int index = findElement(oldElement);
    if (index != -1) {
        numbers[index] = newElement;
        return Arrays.copyOf(numbers, position);
    }
    return null;
}
/**
 * Calcula el producto punto entre el arreglo actual y otro arreglo dado.
 *
 * @param secondArray Arreglo con el que se calculará el producto punto.
 * @return Producto punto entre los dos arreglos.
 */
public int getProductoPoint(int[] secondArray) {
    if (secondArray.length != position) {
        throw new IllegalArgumentException("Arrays must have the same length for calculating the dot product.");
    }

    int dotProduct = 0;
    for (int i = 0; i < position; i++) {
        dotProduct += numbers[i] * secondArray[i];
    }

    return dotProduct;
}
/**
     * Genera un segundo arreglo aleatorio con la misma longitud que el arreglo actual,
     * con elementos en el rango entre 10 y 999.
     *
     * @return Segundo arreglo generado aleatoriamente.
     */
    public int[] secondArray() {
        int[] randomArray = new int[position];
        Random random = new Random();

        for (int i = 0; i < position; i++) {
            randomArray[i] = random.nextInt(990) + 10; 
        }

        return randomArray;
    }

    }


