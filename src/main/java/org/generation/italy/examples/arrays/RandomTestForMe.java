package org.generation.italy.examples.arrays;

 class RandomTestForMe {
    static void main() {
        int[] accountsInt = {1,2,3,4,5};
        System.out.println(accountsInt.length);
        for (int i : accountsInt)
            System.out.println(i);
        boolean test = removeAccount(2, accountsInt);
        for (int i : accountsInt)
            System.out.println(i);
        System.out.println();
        test = removeAccount(1, accountsInt);
        for (int i : accountsInt)
            System.out.println(i);
    }

    public static boolean removeAccount(int removeNumber, int[] accounts) {
        int indexToRemove = removeNumber-1;                             //Considero che il numero dell'account da rimuovere sia da 1 a 5, non da 0 a 4
        if (accounts[indexToRemove]==0) {
            return false;
        } else if (indexToRemove==accounts.length-1){
            accounts[indexToRemove]=0;
            return true;
        } else {
            for (int i=indexToRemove; i<accounts.length-1; i++) {
                accounts[i]=accounts[i+1];
            }
            accounts[accounts.length-1] = 0;
        }
        return true;
    }
}
