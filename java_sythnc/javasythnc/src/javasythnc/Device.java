package javasythnc;

import java.util.Random;
 
public class Device extends Thread {
    private String name;
    private String type;
    private int  connectionnum=0;
    private String sfile;
    Router router;
    private Form OutForm;
    private printOnFile writeon=new printOnFile();
 
    public Device(String name, String type, Router r,Form out) {
        super();
        this.name = name;
        this.type = type;
        this.router = r;
        this.OutForm=out;
    }
 
 
    public void connect(int i) {
       
        connectionnum=i;        
        System.out.println("connection "+connectionnum+":"+this.gettName()+" Occupied");        
        sfile="connection "+connectionnum+":"+this.gettName()+" Occupied"+"\n";
        this.OutForm.addToFrame(sfile);
        writeon.writeonfile(sfile);
   
         
    }
   
   
    public void  performOnlineActivity() throws InterruptedException {
        Random x=new Random();
        int rand_int1 = x.nextInt(9900);       
        System.out.println("connection "+connectionnum+":"+this.gettName()+" performs online activity ");
         sfile="connection "+connectionnum+":"+this.gettName()+" performs online activity "+"\n";
         this.OutForm.addToFrame(sfile);
         writeon.writeonfile(sfile);
          Thread.sleep(rand_int1);
    }
   
   
   
    public void Disconnect() {
          System.out.println("connection "+connectionnum+":"+this.gettName()+" Logged out ");
          sfile="connection "+connectionnum+":"+this.gettName()+" Logged out "+"\n";
          this.OutForm.addToFrame(sfile);
          writeon.writeonfile(sfile);
          
         
    }
   
 
   
    public String gettName() {
        return name;
    }
 
 
    public void settName(String name) {
        this.name = name;
    }
 
 
    public String getType() {
        return type;
    }
   
   
    public void setType(String type) {
        this.type = type;
    }
    public void run() {
         
        try {
       
             this.router.addToRouter(this);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
   
       
           
    }
   
   
   
}
