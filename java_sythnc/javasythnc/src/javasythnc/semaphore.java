package javasythnc;

class Semaphore {

  protected int value = 0 ;

  protected Semaphore() { value = 0 ; }

  protected Semaphore(int initial) { value = initial ; }
  private printOnFile writeon=new printOnFile();
  private String sfile;

  public synchronized void P(Device device) {
    value-- ;
    
    if (value < 0) {
      try {
    	  System.out.println("("+device.gettName()+")"+"("+device.getType()+")"+" arrived and waiting");
    	  sfile="("+device.gettName()+")"+"("+device.getType()+")"+" arrived and waiting";
    	  writeon.writeonfile(sfile);
    	  //Thread.sleep(10000);
          wait() ; 
          } 
         catch(  InterruptedException e ) { }
  }else {
	  System.out.println("("+device.gettName()+")"+"("+device.getType()+")"+" arrived");
	  sfile="("+device.gettName()+")"+"("+device.getType()+")"+" arrived";
	  writeon.writeonfile(sfile);
  }
  }
  public synchronized void V() {
    value++ ; 
    if (value <= 0) notify() ;
  }
}
