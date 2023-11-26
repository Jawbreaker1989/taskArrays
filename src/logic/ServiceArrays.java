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
    public static final int BUBBLE = 0;
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

}
