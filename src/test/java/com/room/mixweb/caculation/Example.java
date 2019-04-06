package com.room.mixweb.caculation;

public class Example {
    public static void sort(Comparable[] a){
    }
    public static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }
    public static void exch(Comparable[] a,int i,int j){
        Comparable t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
    public static void show(Comparable[] a){
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
            System.out.println();
        }
    }
    public static boolean isSored(Comparable[] a){
        for (int i=1;i<a.length;i++){
            if (less(a[i],a[i-1]))return false;
        }
        return true;
    }
    public static void main(String[] args){
        int count=0;
        Integer[] array=new Integer[100];
        int i=(int)1.22;
        int j=(int)1.88;
        System.out.println(i+" "+j);
        while (count<100){
             array[count]=(int)(Math.random()*100)+1;
             count++;
        }
        Selection selection=new Selection();
        selection.shell(array);
     //   System.out.println(array.length);
    }

    public static class Selection{
        public void shell(Comparable[] a){
            int n=a.length;
            int h=1;
            while (h<n/3)h=3*h+1;
           show(a);
            System.out.println("");
            while (h>=1){
                for (int i=h;i<n;i++){
                    for (int j=i;j>=h&&less(a[j],a[j-h]);j -=h){
                        exch(a,j,j-h);
                    }
                }
                h=h/3;
            }
            show(a);
        }
        public  void seleSort(Comparable[] a){
              int n=a.length;
              for (int i=0;i<n;i++){
                  int min=i;
                  for (int j=i+1;j<n;j++){
                      if (less(a[j],a[min]))min=j;
                  }
                  exch(a,i,min);
              }
        }
        public void Insertion(Comparable[] a){
            int n=a.length;
            for (int i=1;i<n;i++){
                for (int j=i;j>0&&less(a[j],a[j-1]);j--){
                    exch(a,j,j-1);
                }
            }
        }
    }
}

