package javasythnc;

import java.util.ArrayList;
import java.util.Scanner;
 
public class Network {
    public static void main(String[] args) {
       
        int N,TC;
        String TCL;
        Form outform=new Form();
        ArrayList<Device> devicesNeedToConnect = new ArrayList<Device>();
        printOnFile f=new printOnFile();
       
       
        System.out.println(" What is number of WI-FI Connections?");
        Scanner x=new Scanner(System.in);
        N=x.nextInt();
        outform.addToFrame2(String.valueOf(N));
       
       
        Semaphore semaphore=new Semaphore(N);
        Router r=new Router(N,semaphore);
        
       
       
        System.out.println("What is number of devices Clients want to connect?");
        Scanner y=new Scanner(System.in);
        TC=y.nextInt();
       
       
        for(int i=0;i<TC;++i) {
               Scanner v=new Scanner(System.in);
               TCL=v.nextLine();
               String[] parts = TCL.split(" ");
               Device d=new Device(parts[0], parts[1], r,outform);
               devicesNeedToConnect.add(d);
        }
       
       
        Device m;
        f.clearfilecontent();
        for(int i=0;i<TC;i++) {
            m=devicesNeedToConnect.get(i);
            m.start();
           
        }
       
       
       
     
     
       
 
    }
 
}


