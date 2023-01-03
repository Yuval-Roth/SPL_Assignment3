package bgu.spl.net.impl.stomp.Backend;

import java.util.HashMap;

import bgu.spl.net.genericServers.interfaces.ConnectionHandler;
import bgu.spl.net.impl.stomp.StompExceptions.SubscriptionException;

public class SubscriptionController {

    private final HashMap<ConnectionHandler<String>, HashMap<Integer,String>> handlerAndSubIdToTopic;

    public SubscriptionController() {
        handlerAndSubIdToTopic = new HashMap<>();
    }

    public void addSub(ConnectionHandler<String> handler, int subId, String topic) throws SubscriptionException {

        //if the handler is not in the map, add it
        if (!handlerAndSubIdToTopic.containsKey(handler) == false) {
            handlerAndSubIdToTopic.put(handler, new HashMap<>());
        }

        //if the subId already exists, throw an exception
        if(handlerAndSubIdToTopic.get(handler).containsKey(subId)) {

            //TODO change this to a more specific exception
            throw new SubscriptionException ("SubId already exists");
        }
        
        handlerAndSubIdToTopic.get(handler).put(subId, topic);
    }

    public void removeSub(ConnectionHandler<String> handler, int subId) throws SubscriptionException {

        if(handlerAndSubIdToTopic.get(handler).containsKey(subId) == false) {

            //TODO change this to a more specific exception
            throw new SubscriptionException("SubId does not exist");
        }
    
        handlerAndSubIdToTopic.get(handler).remove(subId);
    }

    public String getTopic(ConnectionHandler<String> handler, int subId) throws SubscriptionException {

        if(handlerAndSubIdToTopic.get(handler).containsKey(subId) == false) {

            //TODO change this to a more specific exception
            throw new SubscriptionException("SubId does not exist");
        }

        return handlerAndSubIdToTopic.get(handler).get(subId);
    }



}
