public class flowerbed {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        for(int i=0; i<flowerbed.length && n > 0; i++)
        {
            if(flowerbed[i] == 0)
            {
                boolean isleftempty = (i == 0 || flowerbed[i-1] == 0);
                boolean isRightempty = (i == flowerbed.length-1 || flowerbed[i+1] == 0);
                if(isleftempty && isRightempty)
                {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }
        return n<=0;        
    }
    public static void main(String[] args) {
        int[] flowerbed1 = {1, 0, 0, 0, 1};
        int n1 = 1;
        System.out.println(canPlaceFlowers(flowerbed1, n1)); // Output: true

        int[] flowerbed2 = {1, 0, 0, 0, 1};
        int n2 = 2;
        System.out.println(canPlaceFlowers(flowerbed2, n2)); // Output: false
    }
}
