package com.endava;

import com.endava.models.Gender;
import com.endava.models.Major;
import com.endava.models.Student;
import com.endava.models.User;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.endava.models.Gender.FEMALE;
import static com.endava.models.Gender.MALE;

public class Main {

    public static final List<User> USERS = Arrays.asList(new User("Vasea", MALE, 39),
            new User("Sveta", FEMALE, 30),
            new User("Jenea", MALE, 40),
            new User("Igor", MALE, 55),
            new User("Sveta", FEMALE, 30),
            new User("Jenea", MALE, 40));


    public static final List<Student> STUDENTS = Arrays.asList(
            new Student( "Valera", Gender.MALE, 23, new Major("english", 64)),
            new Student( "Ira", Gender.FEMALE, 21, new Major("math", 54)),
            new Student( "Valera", Gender.FEMALE, 21, new Major("math", 79)),
            new Student( "Vasea", Gender.MALE, 29, new Major("phisics", 71)),
            new Student( "Valera", Gender.MALE, 34, new Major("geo", 71)));




    public static void main(String args[]) {

        String str = "some  text for testing split";
        String[] strArr = str.split(" ");
        List<String> list = Arrays.asList(strArr);
        for (String el : list
                ) {
            if (el.contains(" ")) list.remove(el);
        }
        for (String s : strArr
                ) {
            System.out.println(s);
        }
        printDelimiterLine();
        printDelimiterLine();

        List<String> strList = Arrays.asList("abc", "kjk", "rty", "123");

        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
                .stream()
                .filter(num -> num % 2 == 0)
                .filter(num -> num % 3 == 0)
                .filter(num -> num > 6)
                .forEach(System.out::println);

        printDelimiterLine();

        USERS.stream()
                .parallel()
                .map(User::getName)
                .filter(string -> string.startsWith("A"))
                .forEach(System.out::println);

        printDelimiterLine();

        System.out.println(USERS
                .stream()
                .collect(Collectors.groupingBy(User::getGender)));
        printDelimiterLine();

        System.out.println(Stream.of(new User("Vasea", MALE, 39),
                new User("Sveta", FEMALE, 30),
                new User("Jenea", MALE, 40))
                .map(User::getName)
                .collect(Collectors.joining(" *** ")));

        printDelimiterLine();

        System.out.println(Stream.of(new User("Vasea", MALE, 40),
                new User("Sveta", FEMALE, 30),
                new User("Jenea", MALE, 40))
                .collect(Collectors.groupingBy(User::getName, Collectors.counting())));
//                .collect(Collectors.groupingBy(User::getGender, Collectors.counting())));

        printDelimiterLine();

        System.out.println(
                USERS.stream()
                        .filter(user -> user.getGender() == MALE)
                        .sorted(Comparator.comparing(User::getAge))
                        .collect(Collectors.toSet()));

        printDelimiterLine();


        printCountEachWord("some info for testing info some other information");

//        printDelimiterLine();

        sortPoepleByAge(USERS, 50);

        printDelimiterLine();

        printCountEachWord("some phrase to test method");

        printDelimiterLine();

        System.out.println("Valera wirh the best Major"
                            + findValeraWithBestOfAllMajors(STUDENTS));

        printDelimiterLine();

        System.out.println("The youngest user : "+ getYoungestUser(USERS));

        printDelimiterLine();

        System.out.println("Sorted collection NO duplicates:\n"
                            + sortCollectionAndRemoveDuplicates(strList));

        printDelimiterLine();

//        Map<String, Long> counts =
//                list.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));

    }

    public static void printDelimiterLine() {
        System.out.println("\n-------------------------------------------------------\n");
    }

    public static void printCountEachWord(String str) {
        String[] strArr = str.split(" ");
        System.out.println("Show each word occurance: "
                + Arrays.asList(strArr).stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting())));
    }


    public static void sortPoepleByAge(List<User> list, int age) {
        System.out.println("Poeple older than " + age + " years "
                + list.stream().min(Comparator.comparingInt(User::getAge))
        );
    }

    public static Map<String, Optional<Student>> findValeraWithBestOfAllMajors(List<Student> students){
        return students.stream()
                .filter(s -> s.getName().equals("Valera"))
                .collect(Collectors.groupingBy(s -> s.getMajor().getName()
                        ,Collectors.maxBy(Comparator.comparing(s->s.getMajor().getScore()))));
    }

    public static User getYoungestUser(List<User> users){
        return users.stream()
                .min(Comparator.comparingInt(User::getAge))
                .get();
    }

    public static Collection<String> sortCollectionAndRemoveDuplicates(Collection<String> collection){
        return collection.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
