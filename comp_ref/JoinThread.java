class NewThread implements Runnable {
   String name;
   Thread t;

   NewThread(String threadname) {
      name = threadname;
      t = new Thread(this, name);
      System.out.println(name + " thread started");
      t.start();
   }

   public void run() {
      try {
         for (int i = 5; i > 0; i--) {
            System.out.println(name + ": " + i);
            Thread.sleep(500);
         }
      } catch (InterruptedException e) {
         System.out.println(name + " interrupted.");
      }
      System.out.println(name + " exiting.");
   }
}

class JoinThread {
   public static void main(String args[]) {
      NewThread ob1 = new NewThread("One");
      NewThread ob2 = new NewThread("Two");
      NewThread ob3 = new NewThread("Three");

      System.out.println("Thread one is alive: " + ob1.t.isAlive());
      System.out.println("1's priority " + ob1.t.getPriority());
      System.out.println("Thread two is alive: " + ob2.t.isAlive());
      System.out.println("Thread three is alive: " + ob3.t.isAlive());

      try {
         System.out.println("Waiting for threads to finish.");
         ob1.t.join();
         ob2.t.join();
         ob3.t.join();
      } catch (InterruptedException e) {
         System.out.println("Main thread interrupted.");
      }
      System.out.println("Main thread exiting.");
   }
}