import java.util.*;

public class calcwatercap {    
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int capacity = 0;
        
        while (left < right) {
            int ht = Math.min(height[left], height[right]);
            int wdt = right - left;
            int currcapacity = ht * wdt;
            capacity = Math.max(capacity, currcapacity);
            
            if (height[left] <= height[right]) {
                left++; // Move the left pointer towards right
            } else {
                right--; // Move the right pointer towards left
            }
        }

        return capacity;
    }

    public static void main(String[] args) {
        int height[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        
        if (height.length < 2) {
            System.out.println("At least two heights are required to calculate water capacity.");
            return;
        }
        
        int capacity = maxArea(height);
        System.out.println("Maximum water capacity: " + capacity); // Output: 49
    }
}
