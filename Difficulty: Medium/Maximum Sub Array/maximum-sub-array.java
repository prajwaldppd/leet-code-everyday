// User function Template for Java

class Solution {
    public ArrayList<Integer> findSubarray(int arr[]) {
        // code here
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int start =0;
        int ansStart=0;
        int ansEnd=0;
        
        for(int i=0;i<arr.length;i++){
            
            if(sum==0){
                start=i;
            }
            
            sum+=arr[i];
            
            if(arr[i]<0){
                sum=0;
                continue;
            }
            
             if(sum>max){
                
                max=sum;
                ansStart=start;
                ansEnd =i;
            }
            else if(sum==max && arr[i] == 0){
                
                max=sum;
                ansStart=start;
                ansEnd =i;
            }
            
            if(sum<0){
                sum=0;
            }
        }
        

        
        ArrayList<Integer> list = new ArrayList<>();
        
        if(max<0){
            list.add(-1);
            return list;
        }
        
        for(int i= ansStart; i<=ansEnd; i++){
            list.add(arr[i]);
        }
        
        return list;
        
        
    }
}