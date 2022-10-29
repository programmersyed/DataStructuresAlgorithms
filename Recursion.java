import java.util.Scanner;

public class Recursion {
    public static void main(String[]args){
        //useful for factorials, traversing trees, and simplifying expressions
        Scanner scan = new Scanner(System.in);
        System.out.println("How many times do you want to say hello");
        int num= scan.nextInt();
        HelloWorld(num);


    }
    static void HelloWorld(int n){
        //Base case
        if (n>0) {
            System.out.println("Hello World! "+n);
            n--;

            HelloWorld(n);
        }


    }

    public static class SelectionSort{



        // selection sort = search through an array and keep track of the minimum value during

        //			         each iteration. At the end of each iteration, we swap values.



        //				 Quadratic time O(n^2)

        //				 small data set = okay

        //				 large data set = BAD



        public static void main(String[] args) {



            int array[] = {8, 7, 9, 2, 3, 1, 5, 4, 6};



            selectionSort(array);



            for(int i : array) {

                System.out.print(i);

            }

        }



        private static void selectionSort(int[] array) {



            for(int i = 0; i < array.length - 1; i++) {

                int min = i;

                for(int j = i + 1; j < array.length; j++) {

                    if(array[min] > array[j]) {

                        min = j;

                    }

                }



                int temp = array[i];

                array[i] = array[min];

                array[min] = temp;

            }



        }

        public static class QuickSort{



            public static void main(String args[])

            {

                // quick sort = moves smaller elements to left of a pivot.

                //			   recursively divide array in 2 partitions


                //                       run-time complexity = Best case O(n log(n))

                //				   		                   Average case O(n log(n))

                //				   		                   Worst case O(n^2) if already sorted



                //                       space complexity    = O(log(n)) due to recursion



                int[] array = {8, 2, 5, 3, 9, 4, 7, 6, 1};



                quickSort(array, 0, array.length - 1);



                for(int i : array){

                    System.out.print(i + " ");

                }

            }



            private static void quickSort(int[] array, int start, int end) {



                if(end <= start) return; //base case



                int pivot = partition(array, start, end);

                quickSort(array, start, pivot - 1);

                quickSort(array, pivot + 1, end);

            }

            private static int partition(int[] array, int start, int end) {



                int pivot = array[end];

                int i = start - 1;



                for(int j = start; j <= end; j++) {

                    if(array[j] < pivot) {

                        i++;

                        int temp = array[i];

                        array[i] = array[j];

                        array[j] = temp;

                    }

                }

                i++;

                int temp = array[i];

                array[i] = array[end];

                array[end] = temp;



                return i;

            }

            public static class MergeSort{



                public static void main(String args[])

                {

                    // merge sort = recursively divide array in 2, sort, re-combine

                    // run-time complexity = O(n Log n)

                    // space complexity    = O(n)



                    int[] array = {8, 2, 5, 3, 4, 7, 6, 1};



                    mergeSort(array);



                    for(int i = 0; i < array.length; i++){

                        System.out.print(array[i]+ " ");

                    }

                }



                private static void mergeSort(int[] array) {



                    int length = array.length;

                    if (length <= 1) return; //base case



                    int middle = length / 2;

                    int[] leftArray = new int[middle];

                    int[] rightArray = new int[length - middle];



                    int i = 0; //left array

                    int j = 0; //right array



                    for(; i < length; i++) {

                        if(i < middle) {

                            leftArray[i] = array[i];

                        }

                        else {

                            rightArray[j] = array[i];

                            j++;

                        }

                    }

                    mergeSort(leftArray);

                    mergeSort(rightArray);

                    merge(leftArray, rightArray, array);

                }



                private static void merge(int[] leftArray, int[] rightArray, int[] array) {



                    int leftSize = array.length / 2;

                    int rightSize = array.length - leftSize;

                    int i = 0, l = 0, r = 0; //indices



                    //check the conditions for merging

                    while(l < leftSize && r < rightSize) {

                        if(leftArray[l] < rightArray[r]) {

                            array[i] = leftArray[l];

                            i++;

                            l++;

                        }

                        else {

                            array[i] = rightArray[r];

                            i++;

                            r++;

                        }

                    }

                    while(l < leftSize) {

                        array[i] = leftArray[l];

                        i++;

                        l++;

                    }

                    while(r < rightSize) {

                        array[i] = rightArray[r];

                        i++;

                        r++;

                    }

                }

                public static class LinearSearch {
                    //Big O = O(n) only for small to medium data sets and does not need to be sorted
                    public static void main(String[] args) {
                        int[] array = {5, 4, 4, 4, 3, 2, 32, 3, 23, 5};
                        int index = linearSearch(array, 4);
                        if (index != -1) {
                            System.out.println("Hurray, its found");
                        } else System.out.println("Not available");

                    }

                    private static int linearSearch(int[] array, int value) {
                        for (int i = 0; i < array.length; i++) {
                            if (array[i] == value) {
                                return i;
                            }
                        }
                        return -1;
                    }

                    public static class InterpolationSearch{



                        public static void main(String args[]){



                            //interpolation search =  improvement over binary search best used for "uniformly" distributed data

                            //					     "guesses" where a value might be based on calculated probe results

                            //				             if probe is incorrect, search area is narrowed, and a new probe is calculated



                            //						  average case: O(log(log(n)))

                            //						  worst case: O(n) [values increase exponentially]



                            int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};



                            int index = interpolationSearch(array, 8);



                            if(index != -1) {

                                System.out.println("Element found at index: "+ index);

                            }

                            else {

                                System.out.println("Element not found");

                            }

                        }



                        private static int interpolationSearch(int[] array, int value) {



                            int high = array.length - 1;

                            int low = 0;



                            while(value >= array[low] && value <= array[high] && low <= high) {



                                int probe = low + (high - low) * (value - array[low]) /

                                        (array[high] - array[low]);





                                //System.out.println("probe: " + probe);



                                if(array[probe] == value) {

                                    return probe;

                                }

                                else if(array[probe] < value) {

                                    low = probe + 1;

                                }

                                else {

                                    high = probe -1;

                                }

                            }



                            return -1;

                        }

                        public static class InsertionSort{



                            // Insertion sort = after comparing elements to the left,

                            //				shift elements to the right to make room to insert a value



                            //				Quadratic time O(n^2)

                            //				small data set = decent

                            //				large data set = BAD



                            //				Less steps than Bubble sort

                            //				Best case is O(n) compared to Selection sort O(n^2)



                            public static void main(String[] args) {



                                int array[] = {9, 1, 8, 2, 7, 3, 6, 5, 4};



                                insertionSort(array);



                                for(int i : array) {

                                    System.out.print(i + " ");

                                }

                            }



                            private static void insertionSort(int[] array) {



                                for(int i = 1; i < array.length; i++) {

                                    int temp = array[i];

                                    int j = i - 1;



                                    while(j >= 0 && array[j] > temp) {

                                        array[j + 1] = array[j];

                                        j--;

                                    }

                                    array[j + 1] = temp;

                                }

                            }

                            public static class HeapSort {
                                public static class BubbleSort{



                                    // bubble sort = pairs of adjacent elements are compared, and the elements

                                    //		            swapped if they are not in order.



                                    //				 Quadratic time O(n^2)

                                    //				 small data set = okay-ish

                                    //				 large data set = BAD (plz don't)



                                    public static void main(String[] args) {



                                        int array[] =  {9, 12, 821, 32, 7, 3, 64, 4, 5};



                                        bubbleSort(array);



                                        for(int i : array) {

                                            System.out.print(i+", ");

                                        }

                                    }



                                    public static void bubbleSort(int array[]) {



                                        for(int i = 0; i < array.length - 1; i++) {

                                            for(int j = 0; j < array.length - i - 1; j++) {

                                                if(array[j] > array[j+1]) {

                                                    int temp = array[j];

                                                    array[j] = array[j+1];

                                                    array[j+1] = temp;

                                                }

                                            }

                                        }

                                    }

                                    public static class BinarySearch {
                                        public static void main(String[] args) {
                                            int array[] = new int[100000];
                                            int target = 36;
                                            for (int i = 0; i < array.length; i++) {
                                                array[i] = i;
                                            }
                                            int index = binarySearch(array, target);
                                            //int index = Arrays.binarySearch(array,target); The easy way and the good way and the proper way
                                            if (index == -1) {
                                                System.out.println("Unavailable");
                                            } else System.out.println("Target found at " + index);

                                        }

                                        private static int binarySearch(int[] array, int target) {
                                            int low = 0;
                                            int high = array.length - 1;
                                            while (low <= high) {
                                                int middle = low + (high - low) / 2;
                                                int value = array[middle];
                                                System.out.println("Middle = " + value);

                                                if (value < target) {
                                                    low = middle + 1;
                                                } else if (value > target) {
                                                    high = middle - 1;

                                                } else return middle; //target found
                                            }
                                            return -1;//not found
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
