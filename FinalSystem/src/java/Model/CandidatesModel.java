/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author User
 */
public class CandidatesModel {
    
    private String UserID;
    private String Name;
    private String PreferenceNo; 
    
public CandidatesModel(String UserID,String Name,String PreferenceNo){      
          this.setUserID(UserID);
          this.setName(Name);
          this.setPreferenceNo(PreferenceNo);
        }
public CandidatesModel() {
 }
    
public void setUserID(String UserID) {
  this.UserID = UserID;
 }

public String getUserID() {
  return UserID;
 }

public void setName(String Name) {
  this.Name = Name;
 }

public String getName() {
  return Name;
 }

public void setPreferenceNo(String PreferenceNo) {
  this.PreferenceNo = PreferenceNo;
 }

public String getPreferenceNo() {
  return PreferenceNo;
 }

}
