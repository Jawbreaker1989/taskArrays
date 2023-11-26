package view;

import logic.ServiceArrays;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        ServiceArrays serviceArrays = new ServiceArrays(300, 505);

        System.out.println(serviceArrays.showNumbers());

        int[] numbers = serviceArrays.getNumbers();

        System.out.println(Arrays.toString(numbers));

        serviceArrays.addElement(567);
        serviceArrays.addElement(43);
        serviceArrays.addElement(64);

        System.out.println(" show " + serviceArrays.showNumbers());
        System.out.println(Arrays.toString(serviceArrays.getNumbers()));
        ServiceArrays sa = new ServiceArrays(new int[] { 43, 64, 68 });
        System.out.println(Arrays.toString(sa.getNumbers()));
        System.out.println(sa.findElement(68));

    }
}
