package com.flipkart.business;

import com.flipkart.DAO.GymOwnerDAO;
import com.flipkart.bean.GymOwner;

import java.util.List;

public class GymOwnerService implements GymOwnerServiceInterface {
    private static GymOwnerDAO gymOwnerDAO = new GymOwnerDAO();
    public void requestGymOwnerApproval(String gymOwnerId) {
        gymOwnerDAO.sendOwnerApprovalRequest(gymOwnerId);
    }

    public List<GymOwner> viewAllGymOwners() {
        return gymOwnerDAO.getGymOwnerList();
    }


//    public Object addGymOwnerDetails() {
//        //takes gymOwner object as input
//        return new Object();
//    }

    public GymOwner loginGymOwner(String username,String password){
        return gymOwnerDAO.loginGymOwner(username,password);
    }

    public GymOwner registerGymOwner(GymOwner gymOwner) {
        return gymOwnerDAO.registerGymOwner(gymOwner);
    }
}
