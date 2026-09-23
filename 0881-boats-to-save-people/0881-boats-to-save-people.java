class Solution {
    public int numRescueBoats(int[] people, int limit) {
      int n = people.length;
      int low = 0;
      int high = n - 1;
      Arrays.sort(people);
      int count = 0;
      while(low <= high){
        if(people[low] + people[high] <= limit){
            count++;
            low++;
            high--;
        }
        else{
            count++;
            high--;

        }
      }  
      return count;
    }
}