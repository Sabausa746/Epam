package com.epam.rd.autotasks;

import java.util.ArrayList;

class CycleSwap {
    static void cycleSwap(int[] array) {
//        ArrayList<Integer> list = new ArrayList<>();
//        try{
//            list.add(array[array.length - 1]);
//        }catch (ArrayIndexOutOfBoundsException e){
//            return;
//        }
//        for (int i = 0; i < array.length-1; i++) {
//            list.add(array[i]);
//        }
//
//        for (int i = 0; i < list.size(); i++) {
//            array[i] = list.get(i);
//        }
        if (array.length == 0) {
            return;
        }

        int lastElement = array[array.length - 1];
        System.arraycopy(array, 0, array, 1, array.length - 1);
        array[0] = lastElement;

    }

    static void cycleSwap(int[] array, int shift) {
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = array.length-shift; i <array.length; i++) {
//            try{
//                list.add(array[i]);
//            }catch (ArrayIndexOutOfBoundsException e){
//                return;
//            }
//        }
//        for (int i = 0; i < array.length - shift ; i++) {
//            list.add(array[i]);
//        }
//
//        for (int i = 0; i < list.size(); i++) {
//            array[i] = list.get(i);
//        }
        if (array.length == 0) {
            return;
        }

        shift = shift % array.length;
        if (shift < 0) {
            shift += array.length;
        }

        int[] temp = new int[shift];
        System.arraycopy(array, array.length - shift, temp, 0, shift);
        System.arraycopy(array, 0, array, shift, array.length - shift);
        System.arraycopy(temp, 0, array, 0, shift);
    }
}
