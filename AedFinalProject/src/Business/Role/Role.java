/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.CountryNetwork;
import Business.Network.StateNetwork;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public abstract class Role {

    public enum RoleType {

        CountryAdmin("CountryAdmin"),
        EcoSystemAdmin ("EcoSystemAdmin"),
        BeneficiaryAdmin("BeneficiaryAdmin"),
        EntityAdmin("EntityAdmin"),
        GovtAdmin("GovtAdmin"),
        LogisticAdmin("LogisticAdmin"),
        OldAgeAdmin("OldAgeAdmin"),
        OrphanageAdmin("OrphanageAdmin"),
        HomelessAdmin("HomelessAdmin"),
        DisasterAdmin("DisasterAdmin"),
        HospitalAdmin("HospitalAdmin"),
        EducationAdmin("EducationAdmin"),
        NGOAdmin("NGOAdmin"),
        MNCAdmin("MNCAdmin"),
        IndividualAdmin("IndividualAdmin"),
        TransportationAdmin("TransportationAdmin"),
        RentalAdmin("RentalAdmin"),
        BGVAdmin("BGVAdmin");

        private String value;

        private RoleType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public abstract JPanel createWorkArea(JPanel userProcessContainer,
            UserAccount account,
            Organization organization,
            Enterprise enterprise,
            StateNetwork network,
            CountryNetwork cNetwork,
            EcoSystem business);

    @Override
    public String toString() {
        return this.getClass().getName();
    }

}
