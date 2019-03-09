/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Network;

import java.util.ArrayList;


public class CountryNetwork {
    private String name;
    ArrayList<StateNetwork> stateList;
    
    public CountryNetwork(){
        stateList= new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<StateNetwork> getStateList() {
        return stateList;
    }

    public void setStateList(ArrayList<StateNetwork> stateList) {
        this.stateList = stateList;
    }
    
    public StateNetwork createAndAddNetwork() {
        StateNetwork network = new StateNetwork();
        stateList.add(network);
        return network;
    }
    
    @Override
    public String toString() {
        return name; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
