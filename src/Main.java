import java.util.*;

public class Main {
    public static List<List<String>> mapping(String[] words) {
        List<List<String>> result = new ArrayList<>();

        for (String word : words) {
            boolean foundGroup = false;

            for (List<String> group : result) {
                if (isAnagram(word, group.get(0))) {
                    group.add(word);
                    foundGroup = true;
                    break;
                }
            }

            if (!foundGroup) {
                List<String> newGroup = new ArrayList<>();
                newGroup.add(word);
                result.add(newGroup);
            }
        }

        return result;
    }

    public static boolean isAnagram(String word1, String word2) {
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();

        sorting(arr1);
        sorting(arr2);

        return Arrays.equals(arr1, arr2);
    }

    public static void sorting(char[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            char temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        String[] arrOfString = {"cook", "save", "taste", "aves", "vase", "state", "map"};

        List<List<String>> result = mapping(arrOfString);

        System.out.println(result);
    }
}
