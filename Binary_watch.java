import java.util.*;

public class Solution {
    public List<String> readBinaryWatch(int num) {
    	List<String> l = new ArrayList<String>();
        int[] num1={1,2,4,8,16,32};
        int[] num2={1,2,4,8};
        for(int i=0;i<4;i++)
        {
            List<Integer> hour=new ArrayList<Integer>();
            List<Integer> min=new ArrayList<Integer>();
        	gettime(num2,0,i,0,hour);
        	gettime(num1,0,num-i,0,min);
        	for(int k:hour)
            {
        	    if(k>11) continue;
        	    for(int j:min)
        	    {
        		    if(j>59) continue;
        		    l.add(k+":"+(j<10?"0"+j:j));
        	    }
            }
        }
        return l;
        
    }
    List<Integer> gettime(int[] arr,int pos,int count,int sum,List<Integer> l)
    {
    	if(count==0)
    		l.add(sum);
    	else{
			for (int i = pos; i < arr.length; i++) {
				gettime(arr, i+1, count-1, sum + arr[i], l);
			}
    	}
    	return l;
    }
}