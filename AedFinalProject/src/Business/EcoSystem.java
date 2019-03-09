package Business;

import Business.Enterprise.Enterprise;
import Business.Network.CountryNetwork;
import Business.Network.StateNetwork;
import Business.Organization.Organization;
import Business.Role.BeneficiaryAdminRole;
import Business.Role.EntityAdminRole;
import Business.Role.GovtAdminRole;
import Business.Role.Role;
import Business.Role.CountryAdminRole;
import Business.SignUp.SignUpRequestCountry;
import Business.SignUp.SignUpRequestEnterprise;
import Business.SignUp.SignUpRequestOrganization;
import Business.SignUp.SignUpRequestState;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkRequest;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Administrator
 */
public class EcoSystem extends Organization {

    private static EcoSystem business;
    private ArrayList<CountryNetwork> networkList;
    public int employeeCount;
    public int eventCount;
     public int orgCount;
     public int pCounter;

    public static EcoSystem getInstance() {
        if (business == null) {
            business = new EcoSystem();
        }
        return business;
    }

    private EcoSystem() {
        super(null, null, null);
        networkList = new ArrayList<>();

    }

    public ArrayList<CountryNetwork> getNetworkList() {
        return networkList;
    }

    public static void setInstance(EcoSystem system) {
        business = system;
    }

    public CountryNetwork createAndAddNetwork() {
        CountryNetwork network = new CountryNetwork();
        networkList.add(network);
        return network;
    }

    @Override
    public HashSet<Role> getSupportedRole() {
        roles.add(new CountryAdminRole());
        roles.add(new GovtAdminRole());
        roles.add(new EntityAdminRole());
        roles.add(new BeneficiaryAdminRole());
        return roles;
    }

    public static boolean checkIfUsernameIsUnique(String username) {

        //  if (!this.getUserAccountDirectory().checkIfUsernameIsUnique(username)) {
        for (WorkRequest wrkReq : business.getWorkQueue().getWorkRequestList()) {
            if (wrkReq instanceof SignUpRequestEnterprise) {
                if(((SignUpRequestEnterprise) wrkReq).getUserName().equals(username)){
                return false;
                }
            } else if (wrkReq instanceof SignUpRequestCountry) {
                if(((SignUpRequestCountry) wrkReq).getUserName().equals(username)){
                return false;
                }
            } else if (wrkReq instanceof SignUpRequestState) {
                if(((SignUpRequestState) wrkReq).getUserName().equals(username)){
                return false;
                }
            }
        }

        for (CountryNetwork cnetwork : business.getNetworkList()) {
            for (StateNetwork network : cnetwork.getStateList()) {
                for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                    for (UserAccount ua : enterprise.getUserAccountDirectory().getUserAccountList()) {
                        if (ua.getUsername().equalsIgnoreCase(username)) {
                            return false;
                        }
                    }
                    for (WorkRequest workReq : enterprise.getWorkQueue().getWorkRequestList()) {
                        if (workReq instanceof SignUpRequestOrganization) {
                            if(((SignUpRequestOrganization) workReq).getUserName().equalsIgnoreCase(username)){
                            return false;
                            }
                        }
                    }

                    for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                        for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
                            if (ua.getUsername().equalsIgnoreCase(username)) {
                                return false;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}
