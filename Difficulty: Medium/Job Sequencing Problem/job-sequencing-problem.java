/*
struct Job
{
   int id;	 // Job Id
   int deadline; // Deadline of job
   int profit; // Profit if job is over before or on deadline
};
*/

class Solution {
    int[] JobScheduling(Job arr[], int n) {
        // code here
        Arrays.sort(arr, (a,b)->Integer.compare(b.profit,a.profit));
        int maxdeadline =0;
        
        for(Job j: arr){
            maxdeadline = Math.max(maxdeadline, j.deadline);
        }
        
        int[] slots = new int[maxdeadline+1];
        Arrays.fill(slots,-1);
        int cnt=0;
        int pro=0;
        
        for(Job i : arr){
            
            for(int j=i.deadline; j>0;j--){
                if(slots[j]==-1){
                    slots[j]=i.id;
                    cnt++;
                    pro+=i.profit;
                    break;
                }
            }
        }
        
        return new int[]{cnt, pro};
        
    }
}