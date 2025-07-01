class Thread1 extends Thread{
    public void run(){
    for(int i=2; i<=10; i+=2)
    {
        System.out.println(i);
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e)
        {

        }
    }
    }
}   


class Thread2 extends Thread{
    public void run(){
        for(int i=1; i<=10; i+=2)
        {
            System.out.println(i);
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
            }
        }
    }
    
}

public class printDelay {
    

    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        t1.start();
        t2.start();
// 1->
        // for(int i=1; i<=10; i+=2)
        // {
        //     System.out.println(i);
        //     try{
        //         Thread.sleep(1000);
        //     }catch(InterruptedException e){
        //     }
        // }
   
    }
}


// class Thread1 extends Thread{
//     public void run(){
//     for(int i=2; i<=10; i++)
//     {
//         System.out.println("hello");
//         try{
//             Thread.sleep(1000);
//         }catch(InterruptedException e)
//         {

//         }
//     }
//     }
// }   


// class Thread2 extends Thread{
//     public void run(){
//         for(int i=1; i<=10; i++)
//         {
//             System.out.println("world");
//             try{
//                 Thread.sleep(1000);
//             }catch(InterruptedException e){
//             }
//         }
//     }
    
// }

// public class printDelay {
    
//     public static void main(String[] args) {
//         Thread1 t1 = new Thread1();
//         Thread2 t2 = new Thread2();
//         t1.start();
//         t2.start();
   
//     }
// }
