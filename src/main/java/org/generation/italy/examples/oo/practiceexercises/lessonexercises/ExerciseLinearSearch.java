package org.generation.italy.examples.oo.practiceexercises.lessonexercises;

public class ExerciseLinearSearch {
    static void main() {

        int[]numbers={1,3,5,7,9,50,55,60};
        int target=11;
        int result=binarySearch(numbers,target);
        IO.println(result);



    }

    public static int binarySearch(int[]numbers,int target) {
        int start = 0;
        int finish = numbers.length - 1;
        int found=-1;
        while(start<=finish){
             int mid=(start+finish)/2;
             if(numbers[mid]==target){
                found=mid;
               return found;
             }else if(numbers[mid]<target){
                start=mid+1;
             }else {
               finish =mid-1;
           }
        }
    return found;
    }

}
