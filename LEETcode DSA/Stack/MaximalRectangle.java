import java.util.Stack;

public class MaximalRectangle {

     public static int maximalRectangle(char[][] matrix) {
        int maxArea = 0;

        int arr[] = new int[matrix[0].length];

        for(int i=0; i<matrix.length; i++)
        {
            for(int j=0;j<arr.length; j++)
            {
                arr[j] = (matrix[i][j]=='1') ? arr[j] + 1:0;
            }
            maxArea = Math.max(maxArea,helper(arr));
        }

        return maxArea;
    }

    public static int helper(int arr[])
    {
        int maxArea = 0;
        int []pse = previousSmaller(arr);
        int nse[] = nextSmaller(arr);

        for(int i=0; i<arr.length; i++)
        {
            int area = arr[i] * (nse[i]-pse[i]-1);
            maxArea = Math.max(maxArea,area);

        }
        return maxArea;
    }

    public static int[] previousSmaller(int arr[])
    {
        Stack<Integer> stack = new Stack<>();
        int []pse = new int[arr.length];
        for(int i=0; i<arr.length; i++)
        {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i])
            {
                stack.pop();
            }

            pse[i] = stack.isEmpty() ? -1: stack.peek(); 
            stack.push(i);
        }
        return pse;
    }

    public static int[] nextSmaller(int arr[])
    {
        Stack<Integer> stack = new Stack<>();
        int []nse = new int[arr.length];
        for(int i=arr.length-1; i>=0; i--)
        {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i])
            {
                stack.pop();
            }

            nse[i] = stack.isEmpty() ? arr.length: stack.peek(); 
            stack.push(i);
        }
        return nse;
    }
    public static void main(String[] args) {
        char []matrix[] = { {'0','1'},{'1','0'} };

                           

        System.out.println(maximalRectangle(matrix));

       
        
    }
}
