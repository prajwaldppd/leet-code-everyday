class Solution {
    public int minPlatform(int arr[], int dep[]) {
        //  code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int platform =0;
        int maxplatfrom =0;
        
        int i=0,j=0;
        while(i<arr.length && j<dep.length){
            if(arr[i]<=dep[j]){
                platform++;
                i++;
            }else{
                platform--;
                j++;
            }
            maxplatfrom = Math.max(platform,maxplatfrom);
        }
        
        return maxplatfrom;
    }
}
