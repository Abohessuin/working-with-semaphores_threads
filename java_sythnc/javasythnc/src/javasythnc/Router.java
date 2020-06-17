package javasythnc;



public class Router {
	
	   private int capacity;
	   private Semaphore space;
	   private boolean arr[];
      
	   
	   public Router(int capacity, Semaphore space) {
			this.capacity = capacity;
			this.space = space;
			this.arr = new boolean[capacity];
		}

   
	public void addToRouter(Device d) throws InterruptedException {
		    space.P(d);
		    int idx = 0;
		    for(int i=0;i<capacity;++i) {
		    	if(arr[i]==false) {
		    		arr[i]=true;
		    		idx = i;
		    		break;
		    	}
		    }                
		    d.connect(idx+1);
		    d.performOnlineActivity();
		    d.Disconnect();
		    arr[idx] = false;
		  //  element.V();
		    space.V();
		    
		}
}
	   
	  