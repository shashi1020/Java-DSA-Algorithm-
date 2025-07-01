import java.util.LinkedList;

class LLJCF {

    public static void main(String[] args) {
        LinkedList<Integer> LL = new LinkedList<>();
        LL.addFirst(10);
        LL.addLast(9);
        LL.add(5);
        LL.addLast(9);
        LL.addLast(10);
        System.out.println(LL);
        LL.removeLast();
        LL.removeFirst();
        System.out.println(LL);
        
    }
}