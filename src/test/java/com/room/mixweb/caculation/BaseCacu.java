package com.room.mixweb.caculation;

public class BaseCacu {
    public class seleter{
        public Integer rank(Integer key,int a[]){
            int mid=0;
            int top=a.length-1;
            int foot=0;
            while (foot<top){
                mid=foot+(top-foot)/2;
                if (key<a[mid])top=mid-1;
                if (key>a[mid])foot=mid+1;
                if (key==a[mid])return mid;

            }
            return -1;
        }
    }
}
