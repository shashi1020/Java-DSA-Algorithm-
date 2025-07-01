class Gernerics<T> {
    T val;
    public T getval()
    {
        return val;
    }
    public void setval(T val)
    {
        this.val = val;
    }
    public void show()
    {
        System.out.println(val.getClass().getName());
    }
}
class gen {
    public static void main(String[] args) {
        Gernerics<Integer> obj = new Gernerics<>();
        obj.setval(10);
        System.out.println(obj.getval());

    }
}