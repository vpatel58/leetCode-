class Solution {
    public List<String> fizzBuzz(int n) {

        ArrayList<String> string = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                string.add("FizzBuzz");
            } else if (i % 3 == 0) {
                string.add("Fizz");
            } else if (i % 5 == 0) {
                string.add("Buzz");
            } else {
                string.add(String.valueOf(i));
            }
        }

        return string;
    }
}
