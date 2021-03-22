package com.company;

import java.util.ArrayList;

public class Bookends {
    public static void main(String[] args){
        String books = "ABGHAAUBUUA";
        String end = "A";
        int uniqueBooks;
        ArrayList<String> bookEnds = splitAtPair(books, end);
        for (int x = 0; x < bookEnds.size(); x++){
            String replace = bookEnds.get(x).replace("A", "");
            bookEnds.set(x, replace);
        }
        System.out.println(bookEnds);
        uniqueBooks = uniqueBooks(bookEnds);

        System.out.println("\n" + uniqueBooks + " unique books");
    }

    public static ArrayList<String> splitAtPair(String a, String b){
        String[] parts = a.split(String.valueOf(b));
        ArrayList<String> books = new ArrayList<>();
        for (int i = 0; i < parts.length; i = i + 2) books.add(parts[i] + b + parts[i+1]);
        return books;
    }

    public static int uniqueBooks(ArrayList<String> a){
        int unique = 0;
        ArrayList<Character> characters = new ArrayList<>();
        for (String x: a){
            char[] array = x.toCharArray();
            for (char y: array){
                if (!characters.contains(y)){
                    characters.add(y);
                    System.out.print(y + " ");
                    unique++;
                }
            }
        }
        return unique;
    }
}
