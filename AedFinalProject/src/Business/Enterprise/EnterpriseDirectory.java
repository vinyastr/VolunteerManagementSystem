/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class EnterpriseDirectory {
    
    private ArrayList<Enterprise> enterpriseList;

    public EnterpriseDirectory() {
        enterpriseList = new ArrayList<>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }
    
    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type){
        Enterprise enterprise = null;
        if (type == Enterprise.EnterpriseType.Government){
            enterprise = new GovernmentEnterprise(name);
            enterpriseList.add(enterprise);
        }
        else if (type == Enterprise.EnterpriseType.Logistic){
            enterprise = new LogisticEnterprise(name);
            enterpriseList.add(enterprise);
        }
        else  if (type == Enterprise.EnterpriseType.Beneficiary){
            enterprise = new BeneficiaryEnterprise(name);
            enterpriseList.add(enterprise);
        }
        else  if (type == Enterprise.EnterpriseType.Entity){
            enterprise = new EntityEnterprise(name);
            enterpriseList.add(enterprise);
        }
        return enterprise;
    }
    
}
