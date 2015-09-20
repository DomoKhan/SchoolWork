/*
 * Richard Truong 
 * rtt397
 */

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Your solution goes in this class.
 * 
 * Please do not modify the other files we have provided for you, as we will use
 * our own versions of those files when grading your project. You are
 * responsible for ensuring that your solution works with the original version
 * of all the other files we have provided for you.
 * 
 * That said, please feel free to add additional files and classes to your
 * solution, as you see fit. We will use ALL of your additional files when
 * grading your solution.
 */
public class Program1 extends AbstractProgram1 {
    /**
     * Determines whether a candidate Matching represents a solution to the
     * Stable Matching problem. Study the description of a Matching in the
     * project documentation to help you with this.
     */
    public boolean isStableMatching(Matching given_matching) {
	ArrayList<ArrayList<Integer>> landlord_own = given_matching.getLandlordOwners();
	ArrayList<ArrayList<Integer>> landlord_pref = given_matching.getLandlordPref(); 
	ArrayList<ArrayList<Integer>> tenant_pref = given_matching.getTenantPref();
	int num_landLords = given_matching.getLandlordCount();
	int num_tenants = given_matching.getTenantCount();
	ArrayList<Integer> tenant_matching = given_matching.getTenantMatching();
	for(int i = 0; i < tenant_matching.size(); ++i){
		int apt1 = tenant_matching.get(i); // apt of the first match
		ArrayList<Integer> t1_pref = tenant_pref.get(i); // get tenant 1 preferences
		int t1_prefOf_l1 = t1_pref.get(apt1); // Tenant 1 pref apt rank
		int first_landlord = findLandlord(landlord_own, apt1); // The first landlord index
		if(first_landlord == -1)
			return false;
		ArrayList<Integer> l1_pref = landlord_pref.get(first_landlord);			     // the first landlord preference list
		int l1_prefOf_t1 = l1_pref.indexOf(i); // Landlord 1 pref of tenant 1
		for(int j = i + 1; j < tenant_matching.size(); ++j){
			int apt2 = tenant_matching.get(j); 	// apt of second match;
			ArrayList<Integer> t2_pref = tenant_pref.get(j); // get tenant 2 preference
			int t2_prefOf_l2 = t2_pref.get(apt2);  // get the pref rank of tenant 2 for his apt
			int t1_prefOf_l2 = t1_pref.get(apt2);  // get pref rank of tenant 1 for tenant 2 apt
			int t2_prefOf_l1 = t2_pref.get(apt1);  // get pref rank of tenant 2 for tenant 1 apt
			int second_landlord = findLandlord(landlord_own, apt2);
			if(second_landlord == -1)  // the landlord did not want them;
				return false;
			ArrayList<Integer> l2_pref = landlord_pref.get(second_landlord); // landlord 2 pref list
			int l1_prefOf_t2 = l1_pref.indexOf(j);
			int l2_prefOf_t1 = l2_pref.indexOf(i);
			int l2_prefOf_t2 = l2_pref.indexOf(j);
			if(t1_prefOf_l1 > t1_prefOf_l2 && l1_prefOf_t1 > l1_prefOf_t2)
				return false;
			if(t2_prefOf_l2 > t2_prefOf_l1 && l2_prefOf_t2 > l2_prefOf_t1)
				return false;
		}
	}
	return true; /* TODO remove this line */
    }

    /*
     * Determines which landlord owns the apt
     */ 
     
     public int findLandlord(ArrayList<ArrayList<Integer>> landlord_own, int apt){
	for(int i = 0; i < landlord_own.size(); ++i){
		if(landlord_own.get(i).contains(apt))
			return i;
	}
	return -1;
    }
    /**
     * Determines a solution to the Stable Matching problem from the given input
     * set. Study the project description to understand the variables which
     * represent the input to your solution.
     * 
     * @return A stable Matching.
     */
    public Matching stableMatchingGaleShapley(Matching given_matching) {
        /* TODO implement this function */
        return null; /* TODO remove this line */
    }
}
