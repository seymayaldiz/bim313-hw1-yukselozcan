package edu.bim313;

import org.paukov.combinatorics3.Generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static edu.bim313.TurkishNetwork.cities;
import static edu.bim313.TurkishNetwork.distance;

public class App {
    public static void main(String[] args) {
        List<List<String>> combinations = Generator.combination(cities).simple(3).stream().collect(Collectors.toList());
        for (int i = 0; i < combinations.size(); i++) {
            List<String> control = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                control.add(combinations.get(i).get(j));
            }
            int m1 = Arrays.asList(cities).indexOf(control.get(0));
            int m2 = Arrays.asList(cities).indexOf(control.get(1));
            int m3 = Arrays.asList(cities).indexOf(control.get(2));
            if (((distance[m1][m2] + distance[m1][m3]) <= distance[m2][m3]) || ((distance[m1][m2] + distance[m2][m3]) <= distance[m1][m3]) || (((distance[m1][m3] + distance[m2][m3]) <= distance[m1][m2]))) {
                System.out.println( cities[m1] + " " + cities[m2] + " " + cities[m3]);
            }
        }

    }
}
