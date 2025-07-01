class compressString {
    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int newLength = compress(chars);
        System.out.println("New Length: " + newLength);
        System.out.println("Compressed Array: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(chars[i] + " ");
        }
    }

    public static int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }

        int index = 0;
        int count = 1;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
            } else {
                chars[index++] = chars[i - 1];
                if (count > 1) {
                    char[] countChars = String.valueOf(count).toCharArray();
                    for (char c : countChars) {
                        chars[index++] = c;
                    }
                }
                count = 1;
            }
        }

        chars[index++] = chars[chars.length - 1];
        if (count > 1) {
            char[] countChars = String.valueOf(count).toCharArray();
            for (char c : countChars) {
                chars[index++] = c;
            }
        }

        return index;
    }
}
