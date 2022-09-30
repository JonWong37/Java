package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
    //... imports class definition...

    // Inside class:
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;

    public AdminUser(int i, String companion) {
        super(i);
        this.role = role;
        this.securityIncidents = new ArrayList<>();
    }

    // TO DO: Implement a constructor that takes an ID and a role
    // TO DO: Implement HIPAACompliantUser!
    // TO DO: Implement HIPAACompliantAdmin!

    public void newIncident(String notes) {
        String report = String.format(
                "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n",
                new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
                "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n",
                new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }

    @Override
    public ArrayList<String> reportSecurityIncidents() {
        return securityIncidents;
    }

    @Override
    public boolean assignPin(int pin) {
        int count = 0;
        while(pin != 0){
            pin = pin / 10;
            count += 1;
        }
        if(count < 6)
        {
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
        authIncident();
        return Objects.equals(confirmedAuthID, this.id);
    }

    // TO DO: Setters & Getters

}
