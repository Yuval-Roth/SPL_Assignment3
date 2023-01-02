package bgu.spl.net.impl.stomp.Service.interfaces;

import bgu.spl.net.api.Connections;
import bgu.spl.net.api.MessagingProtocol;

public interface StompMessagingProtocol extends MessagingProtocol<String>  {
    
	/**
	 * Used to initiate the current client protocol with it's personal connection ID and the connections implementation
	**/
    void start(int connectionId, Connections<String> connections);
    
    boolean shouldTerminate();
    
    String process(String message);
}
