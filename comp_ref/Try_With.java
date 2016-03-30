import java.io.*;

class Try_With {
   public static void main(String args[]) {
      int i;

      if (args.length != 2) {
         System.out.println("args has incorrect parameters.");
         return;
      }

      try (FileInputStream fin = new FileInputStream(args[0]);
            FileOutputStream fout = new FileOutputStream(args[1]))
      {
         do {
            i = fin.read();
            if (i != -1) fout.write(i);
         } while (i != -1);
      } catch(IOException e) {
         System.out.println("I/O Error: " + e);
      }
   }
}