package fr.inra.orleans;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Service {
	
	private Service() {} ;
			
	private static class serviceHolder {
	
            private static final Service INSTANCE = new Service() ;
	
        }
	
	public static Service getInstance()  {
	    return serviceHolder.INSTANCE ;
	}
	
	
	public Response ping(int duration) throws InterruptedException, UnknownHostException {
	    
            Thread.sleep(duration)                      ;
            InetAddress IP = InetAddress.getLocalHost() ;
            String hostName = InetAddress.getLocalHost().getHostName();
            
            if(duration == 0 )
                
              return new Response( " Pong From : "              + 
                                     hostName                   +
                                     " - "                      + 
                                    IP.getHostAddress() + " " ) ;
            else
                
              return new Response( " Pong From : "       + 
                                     hostName            +
                                     " - "               + 
                                     IP.getHostAddress() +
                                     "  ---> Sleep = "   +
                                     duration            + 
                                     " ms "            ) ;
            
	}

}
