
// Sliding Window Approach
import java.util.*;
public class rough {
    /*
A team is given set of projects. Each project has predetermined value associated with it the team must select the fixed number of projects from this set to achieve highest total value the project values are given in the form of an array and the objective is strategically choosing k projects. 
Note : in each step you can select one project from start or end of the array

The first line of input contains an integer k denoting number of projects to be choosen
n-projects.length
The next n lines of input contain an integer denoting array elements 


Return an integer denoting maximum value that can be obtained

Exe limit time 
2seconds
 */
    public static int SelectProjects( List<Integer> project,int k)
    {
        int n = project.size();
        int currSum = 0;
        for(int i=0; i<k; i++)
        {
            currSum += project.get(i); 
        }
        int maxSum = currSum;
        for(int i=0; i<k; i++)
        { 
            currSum -= project.get(k-1-i);
            currSum += project.get(n-1-i);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
    
/*Imagine youre quantum computing engineer responsible for monitoring the performance of  a cutting edge quantum server. the server generates error logs every second with each index in a list representing the count of errors occuring in that specific second.
Your task is to create a robust algorithm or function that efficiently determines the maximum number of errors that can occour within any contigious k second window. This is cricial for quickly identifying and addressing potential issues in the quantum server operation 
Input format
List<long> error count count of error in that second
Int k contains window size 
input - 12 43 34 23 48 
Return max number of errors that can occour the k-size window 

Exe time limit 
10 sec
 */

    public static long MaxErrorInWindow(List<Long> error_count, long k)
    {
        int n = error_count.size();
        if(n<k || n<=0)
        {
            throw new IllegalArgumentException("invlid window Size");
        }
        long currSum = 0;
        for(int i=0; i<k; i++)
        {
            currSum += error_count.get(i);
        }
        long maxCount = currSum;
        for(int i=(int)k; i<n; i++)
        {
            currSum =currSum  + error_count.get(i)- error_count.get(i-(int)k);
            maxCount = Math.max(maxCount, currSum);
        }
        return maxCount;
    }
        
/*There is lucky draw for children . There is stack containing chocolates red and green red chocolatees considered best . Stack is covered preventing children from seeing chocolates. Each child has two options  they can either pick a chocolate from first position or last position of the stack your task is to determine how many children will receive a red chocolates 
 * stack - RGRGRGR & choice= FLFL
*/

public static int CountredChild(List<String> chocolates, String choices)
{
    
    int count = 0;
    int j = 0;
    int k=chocolates.size()-1;

    for(int i=0; i < choices.length(); i++)
    {
        if(choices.charAt(i) == 'F' && j<=k)
        {
            if(chocolates.get(j).equals("R"))
            {
                count++;
            }
            j++;
        }else if(choices.charAt(i) == 'L'&& j<=k)
        {
            if(chocolates.get(k).equals("R"))
            {
                count++;
            }
            k--;
        }
    }
    
    return count;
} 


    public static void main(String[] args) {
    //     long k = 2;
       List<String> list = new ArrayList<>(Arrays.asList("R", "G", "R", "R", "G", "G", "R"));
       System.out.println(CountredChild( list, "FLFL"));

    }
}

