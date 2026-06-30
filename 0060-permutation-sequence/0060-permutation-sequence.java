class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n];
        StringBuilder sb = new StringBuilder();

        factorial[0] = 1;
        for (int i = 0; i < n; i++) {
            numbers.add(i + 1);
            if (i > 0) factorial[i] = factorial[i - 1] * i;
        }

        k--;

        for (int i = n; i > 0; i--) {
            int index = k / factorial[i - 1];
            sb.append(numbers.get(index));
            numbers.remove(index);
            k %= factorial[i - 1];
        }

        return sb.toString();
    }
}