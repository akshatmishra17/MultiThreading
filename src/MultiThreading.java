import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;
class Multithreading
{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Threads:");
        int n = sc.nextInt();
        int start=1;
        int end=1000000000/n;
        for(int i=1;i<=n;i++) {
            File file = new File("C:\\Users\\hp\\IdeaProjects\\Akshat Mishra_Multithreading3\\"+i+".txt");
            PrintStream st = new PrintStream(file);
            System.setOut(st);
            Thread t = new Thread(new Multi(start,end,i));
            t.start();
            try {
                t.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            start=end+1;
            end=(i+1)*1000000000/n;
        }
    }
}
class Multi implements Runnable{

    int start;
    int end;
    int id;

    public Multi(int s, int e, int id)
    {
        this.start = s;
        this.end = e;
        this.id = id;
    }

    @Override
    public void run() {
        long start_time = System.currentTimeMillis();
        for(int i=start;i<=end;i++)
        {
            System.out.println(i);
        }
        long end_time = System.currentTimeMillis();
        System.out.println("Execution Time: "+(end_time-start_time));
    }
}
