//import java.io.*;
import java.util.*;

public class Main
{
    public static int[] list;
    public static String listTypeString = "";

	public static void main(String[] args) {
        createList();
        sortList();

	}

    public static void sortList(){
        Scanner input = new Scanner(System.in);
        System.out.println("1. Insertion Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Quick Sort");
        System.out.println("4. Merge Sort");
        System.out.println("5. Heap Sort");
        System.out.println("6. Radix Sort");
        System.out.print("Select your sorting aloritgm: ");
        int sort = input.nextInt();
        input.close();

        System.out.println("Experiment Results:");
        System.out.println("Input Size: "+list.length);
        System.out.println("Data Type: "+listTypeString);
        switch (sort){
            case 1:
                System.out.println("Sort: Insertion");
                InsertionSort obj1 = new InsertionSort();
                obj1.insertionSort(list);
                System.out.println("Comparisons: "+obj1.comparisons);
                System.out.println("Movement: "+obj1.movements);
                break;
            case 2:
                System.out.println("Sort: Selection");
                SelectionSort obj2 = new SelectionSort();
                obj2.selectionSort(list);
                System.out.println("Comparisons: "+obj2.comparisons);
                System.out.println("Movement: "+obj2.movements);
                break;
            case 3:
                System.out.println("Sort: Quick");
                QuickSort obj3 = new QuickSort();
                obj3.quickSort(list);
                System.out.println("Comparisons: "+obj3.comparisons);
                System.out.println("Movement: "+obj3.movements);
                break;
            case 4:
                System.out.println("Sort: Merge");
                MergeSort obj4 = new MergeSort();
                obj4.mergeSort(list);
                System.out.println("Comparisons: "+obj4.comparisons);
                System.out.println("Movement: "+obj4.movements);
                break;
            case 5:
                System.out.println("Sort: Heap");
                HeapSort obj5 = new HeapSort();
                Integer[] list2 = new Integer[list.length];
                Arrays.setAll(list2, i -> list[i]);
                obj5.heapSort(list2);
                System.out.println("Comparisons: "+obj5.comparisons);
                System.out.println("Movement: "+obj5.movements);
                break;
            case 6:
                System.out.println("Sort: Radix");
                RadixSort obj6 = new RadixSort();
                obj6.radixsort(list, list.length);
                System.out.println("Comparisons: "+obj6.comparisons);
                System.out.println("Movement: "+obj6.movements);
                break;

        }
    }
    public static void createList(){
        Scanner input = new Scanner(System.in);
        System.out.println("1. InOrder");
        System.out.println("2. ReverseOrder");
        System.out.println("3. AlmostOrder");
        System.out.println("4. RandomOrder");
        System.out.print("Please select the data type of list you would wish to use: ");
        int listType = input.nextInt();
        

        System.out.println("1. 5000");
        System.out.println("2. 15000");
        System.out.println("3. 50000");
        System.out.print("Select the size of the list: ");
        int size = input.nextInt();
        System.out.println("test");
        if(size == 3)
            size = 50000;
        else if(size == 2)
            size = 15000;
        else
            size = 5000;
        
        if(listType == 1){
            createInOrder(size);
            listTypeString = "Inorder";
        }else if (listType == 2){
            createReverseOrder(size);
            listTypeString = "Reverse Order";
        }else if (listType == 3){
            createAlmostOrder(size);
            listTypeString = "Almost Order";
        }else{
            createRandomOrder(size);
            listTypeString = "Random Order";
        }
    }

    public static void createInOrder(int size){
        list = new int[size];
        for(int i = 0; i<size; i++){
            list[i] = i;
        }
    }

    public static void createReverseOrder(int size){
        list = new int[size];
        for(int i = size-1; i>=0;i--){
            list[i] = size - i;
        }
    }

    public static void createAlmostOrder(int size){
        createInOrder(size);
        Random rand = new Random();
        for(int i = 0; i<size; i+=5){
            int randomIndex = rand.nextInt(size);
            int temp  = list[randomIndex];
            list[randomIndex] = list[i];
            list[i] = temp;
        }
    }

    public static void createRandomOrder(int size){
        createInOrder(size);
        Random rand = new Random();
        for(int i = 0; i<size; i++){
            int randomIndex = rand.nextInt(size);
            int temp  = list[randomIndex];
            list[randomIndex] = list[i];
            list[i] = temp;
        }
    }
}