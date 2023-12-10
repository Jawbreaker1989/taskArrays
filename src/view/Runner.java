package view;

import logic.ServiceArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ServiceArrays serviceArrays = null;

        int mainChoice;
        do {
            System.out.println("Main Menu:");
            System.out.println("1. Create ServiceArrays");
            System.out.println("2. Operations with Arrays");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            mainChoice = scanner.nextInt();

            switch (mainChoice) {
                case 1:
                    // Create ServiceArrays
                    serviceArrays = createServiceArrays(scanner);
                    if (serviceArrays != null) {
                        System.out.println("Array created successfully!");
                    }
                    break;
                case 2:
                    // Operations with Arrays
                    if (serviceArrays != null) {
                        operationsMenu(scanner, serviceArrays);
                    } else {
                        System.out.println("Please create an array first.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (mainChoice != 3);

        scanner.close();
    }

    private static ServiceArrays createServiceArrays(Scanner scanner) {
        System.out.println("Create ServiceArrays Menu:");
        System.out.println("1. Default size");
        System.out.println("2. Custom size");
        System.out.println("3. Given array");
        System.out.print("Enter your choice: ");

        int createChoice = scanner.nextInt();

        switch (createChoice) {
            case 1:
                return new ServiceArrays(10, 999);
            case 2:
                System.out.print("Enter the desired size: ");
                int size = scanner.nextInt();
                return new ServiceArrays(size, 999, 999);
            case 3:
                System.out.print("Enter array elements separated by spaces: ");
                scanner.nextLine(); // consume the newline character
                String elementsInput = scanner.nextLine().trim();
                String[] elementsArray = elementsInput.split("\\s+");
                int[] numbersArray = new int[elementsArray.length];
                for (int i = 0; i < elementsArray.length; i++) {
                    numbersArray[i] = Integer.parseInt(elementsArray[i]);
                }
                return new ServiceArrays(numbersArray);
            default:
                System.out.println("Invalid option. Returning to main menu.");
                return null;
        }
    }

    private static void operationsMenu(Scanner scanner, ServiceArrays serviceArrays) {
        int operationChoice;
        do {
            System.out.println("Operations with Arrays Menu:");
            System.out.println("1. Show current array");
            System.out.println("2. Add element to the array");
            System.out.println("3. Find element in the array");
            System.out.println("4. Find element using Binary Search");
            System.out.println("5. Sort array");
            System.out.println("6. Get Min");
            System.out.println("7. Get Max");
            System.out.println("8. Get Sum");
            System.out.println("9. Get Average");
            System.out.println("10. Delete element from the array");
            System.out.println("11. Replace element in the array");
            System.out.println("12. Exit to main menu");
            System.out.print("Enter your choice: ");

            operationChoice = scanner.nextInt();

            try {
                switch (operationChoice) {
                    case 1:
                        // Show current array
                        System.out.println("Current Array: " + serviceArrays.showNumbers());
                        break;
                    case 2:
                        // Add element to the array
                        System.out.print("Enter element to add: ");
                        int elementToAdd = scanner.nextInt();
                        serviceArrays.addElement(elementToAdd);
                        System.out.println("Element added. Current Array: " + serviceArrays.showNumbers());
                        break;
                    case 3:
                        // Find element in the array
                        System.out.print("Enter element to find: ");
                        int elementToFind = scanner.nextInt();
                        int foundIndex = serviceArrays.findElement(elementToFind);
                        if (foundIndex != -1) {
                            System.out.println("Element found at index: " + foundIndex);
                        } else {
                            System.out.println("Element not found in the array.");
                        }
                        break;
                    case 4:
                        // Find element using Binary Search
                        System.out.print("Enter element to find using Binary Search: ");
                        int binaryElementToFind = scanner.nextInt();
                        int binaryFoundIndex = serviceArrays.findBinary(binaryElementToFind);
                        if (binaryFoundIndex != -1) {
                            System.out.println("Element found at index: " + binaryFoundIndex);
                        } else {
                            System.out.println("Element not found in the array.");
                        }
                        break;
                    case 5:
                        // Sort array
                        sortMenu(scanner, serviceArrays);
                        break;
                    case 6:
                        // Get Min
                        System.out.println("Minimum value in the array: " + serviceArrays.getMin());
                        System.out.println("Current Array: " + serviceArrays.showNumbers());
                        break;
                    case 7:
                        // Get Max
                        System.out.println("Maximum value in the array: " + serviceArrays.getMax());
                        System.out.println("Current Array: " + serviceArrays.showNumbers());
                        break;
                    case 8:
                        // Get Sum
                        System.out.println("Sum of elements in the array: " + serviceArrays.getSum());
                        System.out.println("Current Array: " + serviceArrays.showNumbers());
                        break;
                    case 9:
                        // Get Average
                        System.out.println("Average of elements in the array: " + serviceArrays.getAverage());
                        System.out.println("Current Array: " + serviceArrays.showNumbers());
                        break;
                    case 10:
                        // Delete element from the array
                        System.out.print("Enter element to delete: ");
                        int elementToDelete = scanner.nextInt();
                        int deletedElement = serviceArrays.delete(elementToDelete);
                        if (deletedElement != -1) {
                            System.out.println("Element deleted: " + deletedElement);
                            System.out.println("Current Array: " + serviceArrays.showNumbers());
                        } else {
                            System.out.println("Element not found in the array.");
                        }
                        break;
                    case 11:
                        // Replace element in the array
                        System.out.print("Enter element to replace: ");
                        int oldElement = scanner.nextInt();
                        System.out.print("Enter new element: ");
                        int newElement = scanner.nextInt();
                        int[] replacedArray = serviceArrays.replace(oldElement, newElement);
                        System.out.println("Current Array: " + serviceArrays.showNumbers());
                        if (replacedArray != null) {
                            System.out.println("Element replaced. Updated Array: " + Arrays.toString(replacedArray));
                        } else {
                            System.out.println("Element not found in the array.");
                        }
                        break;
                    case 12:
                        System.out.println("Exiting to main menu.");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine(); 
            }

        } while (operationChoice != 12);
    }

    private static void sortMenu(Scanner scanner, ServiceArrays serviceArrays) {
        System.out.println("Sort Menu:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Insertion Sort");
        System.out.println("4. Shell Sort");
        System.out.print("Enter your choice: ");

        int sortChoice = scanner.nextInt();

        try {
            switch (sortChoice) {
                case 1:
                case 2:
                case 3:
                case 4:
                    int[] sortedArray = serviceArrays.sortNumbers(sortChoice - 1);
                    System.out.println("Array sorted. Updated Array: " + Arrays.toString(sortedArray));
                    System.out.println("Current Array: " + serviceArrays.showNumbers());
                    break;
                default:
                    System.out.println("Invalid sort option.");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine(); 
        }
    }
}
