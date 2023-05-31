package org.example;


public class Main {
    public static void main(String[] args) {
        HashTable ht = new HashTable();
        for (int i = 0; i < 32; i++) {
            ht.put( i + 1, i);
        }
        System.out.println(ht.print());

        ht.replays(30, 2318);
        System.out.println(ht.print());

        ht.remove(30);
        System.out.println(ht.print());

        System.out.println(ht.get(30));
        System.out.println(ht.size());

        System.out.println(ht.containsKey(30));
        System.out.println(ht.containsKey(20));

        System.out.println(ht.containsKey(1));
        System.out.println(ht.containsKey(2023));

    }
}