/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmgmt.dao;

import empmgmt.dbutil.DBConnection;
import empmgmt.pojo.empPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class EmpDAO {
public static boolean addEmp(empPojo e) throws SQLException {  
    //Connection c=DBConnection.getConnetion();
    //Prepared Statement ps=c.prepareStatement("insert into emp values(?,?,?)");
    //or
    PreparedStatement ps=DBConnection.getConnetion().prepareStatement("insert into emp values(?,?,?)");
    ps.setInt(1, e.getEmpno());
    ps.setString(2,e.getEname());
    ps.setDouble(3, e.getSal());
    int result=ps.executeUpdate();
  //  if(result==1)
  //      return true;
  //return false;  or
  return result==1;
}
public static empPojo findEmpById(int eno)throws SQLException{
    empPojo e=null;
PreparedStatement ps=DBConnection.getConnetion().prepareStatement("Select * from emp where empno=?");    
ps.setInt(1,eno);
ResultSet rs=ps.executeQuery();
if(rs.next()){
    e=new empPojo();
    e.setEmpno(rs.getInt(1));
    e.setEname(rs.getString(2));
    e.setSal(rs.getDouble(3));
}
return e;
}

public static ArrayList<empPojo> getAllEmp() throws SQLException{
    ArrayList<empPojo> empList= new ArrayList<>();
    Statement st=DBConnection.getConnetion().createStatement();
    ResultSet rs=st.executeQuery("select * from emp");
    while(rs.next()){
    empPojo e=new empPojo();
    e.setEmpno(rs.getInt(1));
    e.setEname(rs.getString(2));
    e.setSal(rs.getDouble(3));
    empList.add(e); 
}
    return empList;
}
public static boolean updateEmp(empPojo ex) throws SQLException{
    PreparedStatement ps=DBConnection.getConnetion().prepareStatement("update emp set ename=?,sal=? where empno=? ");
    ps.setString(1, ex.getEname());
    ps.setDouble(2, ex.getSal());
    ps.setInt(3, ex.getEmpno());
    int result=ps.executeUpdate();
    return result==1;
}
public static boolean deleteEmp(empPojo e) throws SQLException{
    PreparedStatement ps=DBConnection.getConnetion().prepareStatement("delete from emp where empno=?");
    ps.setInt(1, e.getEmpno());
    int result=ps.executeUpdate();
    return result==1;
}
}
