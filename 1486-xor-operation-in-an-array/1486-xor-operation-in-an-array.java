class Solution {
    public int xorOperation(int n, int start) {
int xor = 0;
for(int i = 1 ; i <= n ; i++){
    xor = xor ^ start;
    start = start + 2;
}
return xor;

    }
}