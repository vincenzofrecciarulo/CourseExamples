static void main() {
    int[] numbers = {1,2,3,4,5,6,7,8,9};
}

public static int indexOf(int[] numbers, int num){
int start=0;
int end=numbers.length/2;
int found =0;
while (start != end){
    if(num<numbers[end]){
        end=end/2;
    }else{
        start=end;
        end=numbers.length-1;
    }
}
return start;
}
