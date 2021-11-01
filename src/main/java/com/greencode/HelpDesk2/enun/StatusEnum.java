package com.greencode.HelpDesk2.enun;

public enum StatusEnum {

    NEW,
    ASSIGNED,
    RESOLVED,
    APPROVED,
    DISAPPROVED,
    CLOSED;

    public static StatusEnum getStatus ( String status ) {
        switch (status){
            case "ASSIGNED" : return ASSIGNED;
            case "RESOLVED" : return RESOLVED;
            case "APPROVED" : return APPROVED;
            case "DISAPPROVED" : return DISAPPROVED;
            case "CLOSED" : return CLOSED;
            case "New" :
            default: return NEW;
        }
    }
}


