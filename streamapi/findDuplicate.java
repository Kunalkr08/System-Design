package streamapi;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class findDuplicate {
    public static void main(String[] args) {
        List<Integer> elements = List.of(1, 2, 3, 2, 4, 5, 1, 6);
        Set<Integer> seen = new HashSet<>();

        List<Integer> res = elements.stream().filter(n -> !seen.add(n)).collect(Collectors.toList());
        System.out.println(res);
    }
}


// [1,2,3,2,4,5,1,6]