public class steps {
    public static void main(String[] args) {
        Thread t1 = new Thread(()-> System.out.println("step1 completed"));
        Thread t2 = new Thread(()-> System.out.println("step2 completed"));
        Thread t3 = new Thread(()-> System.out.println("step3 completed"));


        t1.start();
        try{
            t1.join(); //waits for t1 to finish

        }catch(InterruptedException e){
                e.printStackTrace();
        }

        t2.start();
        try{
            t2.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        } 

        t3.start();
        try{
            t3.join();
        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }
       
        
        
    }
}
