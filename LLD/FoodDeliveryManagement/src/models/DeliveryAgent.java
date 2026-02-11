package models;

import java.util.UUID;

public class DeliveryAgent {

    String agentId;
    String name;
    boolean isAvailable;


    public DeliveryAgent(String name) {
        this.agentId = UUID.randomUUID().toString();
        this.name = name;
        isAvailable = true;
    }

        //getters and setters for the delivery agent class

        public String getAgentId() {
            return agentId;
        }

        public void setAgentId(String agentId) {
            this.agentId = agentId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        public synchronized boolean isAvailable() {
            return isAvailable;
        }

        public synchronized void assignOrder(){
            if(!isAvailable){
                return;
            }
            isAvailable = false;
        }

}
