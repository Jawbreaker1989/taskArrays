package view;

import logic.ServiceArrays;

//import java.util.Arrays;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        ServiceArrays serviceArrays = new ServiceArrays(300, 505);

       // System.out.println(serviceArrays.showNumbers());

        //int[] numbers = serviceArrays.getNumbers();

        //System.out.println(Arrays.toString(numbers));

        serviceArrays.addElement(567);
        serviceArrays.addElement(43);
        serviceArrays.addElement(64);
        serviceArrays.addElement(88);

        System.out.println("Show: " + serviceArrays.showNumbers());
        // System.out.println(Arrays.toString(serviceArrays.getNumbers()));
        // ServiceArrays sa = new ServiceArrays(new int[] { 436, 64, 68 });
        // System.out.println(Arrays.toString(serviceArrays.getNumbers()));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the element to search for: ");
        int elementToSearch = scanner.nextInt();
        int indexOfElement = serviceArrays.findElement(elementToSearch);

        if (indexOfElement != -1) {
            System.out.println("Element " + elementToSearch + " found at index: " + indexOfElement);
        } else {
            System.out.println("Element " + elementToSearch + " not found in the array.");
        }
        scanner.close();

        System.out.println("Minimum: " + serviceArrays.getMin());
        System.out.println("Maximum: " + serviceArrays.getMax());
        System.out.println("Sum: " + serviceArrays.getSum());
        System.out.println("Average: " + serviceArrays.getAverage());

    }
}
