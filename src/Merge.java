public class Merge {
//    static int Maxval (int[]a, int start, int end) {
//        if (start==end)
//            return start;
//        int mid = (int)Math.floor((end+start)/2);
//        int i = Maxval(a, start, mid);
//        int k = Maxval(a, mid+1,end);
//        if (a[i] >= a[k])
//            return i;
//        return k;
//    }

     static int MaxCaller(int a[], int n){
       int max =  Maxval(a,0,a.length-1);
       return  max;
    }

    static int Maxval (int[]a, int start, int end) {
        if (start==end)
            return start;
        int mid = (int)Math.floor((end+start)/2);
        int i = Maxval(a, start, mid);
        int k = Maxval(a, mid+1,end);
        if (a[i] >= a[k])
            return i;
        return k;
    }

    public static void main(String[] args) {
        int a[] = {-98,-9,-12,-123,-5,-7,};
        System.out.println(MaxCaller(a,a.length));
    }
}
