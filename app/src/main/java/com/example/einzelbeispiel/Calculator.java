package com.example.einzelbeispiel;

public class Calculator {

    private int matrNr;
    private int sortedMatrNr;

    public Calculator(int matrNr) {
        this.matrNr = matrNr;

        this.sortedMatrNr = sort(matrNr);
    }

    public int getSortedMatrNr() {
        return sortedMatrNr;
    }

    public Integer sort(int n){
        String arr = Integer.toString(n);
        int[] nArr = new int[arr.length()];
        int temp1 = 0;
        for (int i = 0; i < arr.length(); i++) {
            nArr[i] = temp1;
            nArr[i] = Character.getNumericValue(arr.charAt(i));
        }

        //Look for prime and replace with 0
        for (int i = 0; i < nArr.length; i++) {
            if(isPrime(nArr[i]) == true){
                nArr[i] = 0;
            }
        }

        int temp;

        //Bubblesort
        for (int i = 0; i < nArr.length; i++) {
            for (int j = 0; j < nArr.length-1; j++) {
                if(nArr[j] < nArr[j+1]){
                    temp = nArr[j];
                    nArr[j] = nArr[j+1];
                    nArr[j+1] = temp;
                }
            }
        }

        StringBuilder strNum = new StringBuilder();

        //build the string and ignore the 0
        for (int i = 0; i < nArr.length; i++) {
            if(nArr[i] != 0){
                strNum.append(nArr[i]);
            }
        }

        return Integer.parseInt(strNum.toString());
    }

    public boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        for (int i = 2; i < n ; i++) {
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
