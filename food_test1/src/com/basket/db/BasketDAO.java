package com.basket.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.admin.goods.db.GoodsBean;



public class BasketDAO {
  Connection con = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;
  String sql = "";
  
  public Connection getCon() throws Exception {
    Context initCTX = new InitialContext();
    DataSource ds = (DataSource)initCTX.lookup("java:comp/env/jdbc/foodDB");
    con = ds.getConnection();
    
    return con;
  }
  
  public void closeDB() {
    try {
      if(rs != null){ rs.close(); }
      if(pstmt != null){ pstmt.close(); }
      if(con != null){ con.close(); }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
  //checkGoods(basket)
  public int checkGoods(BasketBean basket){
    int check = -1;
    
    try {
      con = getCon();
      sql = "select * from f_basket "
          + "where f_bas_mem_id=? and f_bas_gs_num=? and "
          + "f_bas_size=?";
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, basket.getF_bas_mem_id());
      pstmt.setInt(2, basket.getF_bas_gs_num());
      pstmt.setString(3, basket.getF_bas_size());
      rs = pstmt.executeQuery();
      if(rs.next()){
        // ��ٱ��Ͽ� ������ �ɼ��� ��ǰ�� ���� �� ������ ����(update)
        check = 1;
        sql = "update f_basket set f_bas_amount=f_bas_amount+? "
            + "where f_bas_mem_id=? and f_bas_gs_num=? and "
            + "f_bas_size=?";
        pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, basket.getF_bas_amount());
        pstmt.setString(2, basket.getF_bas_mem_id());
        pstmt.setInt(3, basket.getF_bas_gs_num());
        pstmt.setString(4, basket.getF_bas_size());
        pstmt.executeUpdate();
         
        System.out.println("DAO : ���� ��ǰ ���� ���� �Ϸ�!");
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      closeDB();
    }
     
    return check;
  }
  // checkGoods(basket)

  //basketAdd(basket)
  public void basketAdd(BasketBean basket){
    int b_num = 0;
    
    try {
      con = getCon();
      sql = "select max(f_bas_num) from f_basket";
      pstmt = con.prepareStatement(sql);
      rs = pstmt.executeQuery();
      if(rs.next()){
        // rs.getInt("max(b_num)")+1;
        b_num = rs.getInt(1)+1;
      }
      System.out.println("DAO : ��ٱ��� ��ȣ"+b_num);
      
      sql = "insert into f_basket values(?, ?, ?, ?, ?, now())";
      pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, basket.getF_bas_num());
      pstmt.setString(2, basket.getF_bas_mem_id());
      pstmt.setInt(3, basket.getF_bas_gs_num());
      pstmt.setInt(4, basket.getF_bas_amount());
      pstmt.setString(5, basket.getF_bas_size());
      pstmt.executeUpdate();
      System.out.println("DAO : ��ٱ��� ���� �Ϸ�!");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      closeDB();
    }
  }
  // basketAdd(basket)
  
  // getBasketList(id)
  public Vector getBasketList(String id){
    // ��ǰ���� + ��ٱ��� ���� ����
    Vector totalList = new Vector();
    
    // ��ٱ��� ���� ����(��ǰ��ȣ, ���ż���, �ɼ� ...)
    List basketList = new ArrayList();
    
    // ��ǰ���� ����(��ǰ�̹���, ����, �̸� ...)
    List goodsList = new ArrayList();
    
    try {
      con = getCon();
      sql = "select * from f_basket where f_bas_mem_id=?";
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, id);
      rs = pstmt.executeQuery();
      while(rs.next()){
        // ��ٱ��� ������ ����(bean �� List)
        BasketBean basket = new BasketBean();
        basket.setF_bas_date(rs.getString("f_bas_date"));
        basket.setF_bas_amount(rs.getInt("f_bas_amount"));
        basket.setF_bas_gs_num(rs.getInt("f_bas_gs_num"));
        basket.setF_bas_size(rs.getString("f_bas_size"));
        basket.setF_bas_mem_id(rs.getString("f_bas_mem_id"));
        basket.setF_bas_num(rs.getInt("f_bas_num"));
        basketList.add(basket);
        
        // ��ٱ��Ͽ� ����� ��ǰ�� ������ DB���� ��������
        sql = "select * from f_goods where f_gs_num=?";
        PreparedStatement pstmt2 = con.prepareStatement(sql);
        pstmt2.setInt(1, basket.getF_bas_gs_num());
        ResultSet rs2 = pstmt2.executeQuery();
        if(rs2.next()){
          GoodsBean gb = new GoodsBean();
          gb.setF_gs_name(rs2.getString("f_gs_name"));
          gb.setF_gs_price(rs2.getInt("f_gs_price"));
          gb.setF_gs_img(rs2.getString("f_gs_img"));
          // ... �� �� ������ ����
          goodsList.add(gb);
        }// if ��
      }// while ��
      System.out.println("DAO : ��ٱ��� + ��ǰ���� ���� �Ϸ�(List)");
      
      totalList.add(basketList);
      totalList.add(goodsList);
      
      System.out.println("DAO : ����0-��ٱ��ϸ���Ʈ, ����1-��ǰ����Ʈ");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      closeDB();
    }
    
    return totalList;
  }
  // getBasketList(id)  
  
  // basketDelete(f_bas_num)
  public void basketDelete(int f_bas_num){
    try {
      con = getCon();
      sql = "delete from f_basket where f_bas_num=?";
      pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, f_bas_num);
      pstmt.executeUpdate();
      
      System.out.println("DAO : ��ٱ��� ���� �Ϸ�!");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      closeDB();
    }
  }
  // basketDelete(f_bas_num)
  
  // basketDelete(id)
  public void basketDelete(String id){
    try {
      con = getCon();
      sql = "delete from f_basket where f_bas_mem_id=?";
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, id);
      pstmt.executeUpdate();
      System.out.println("DAO : �ֹ� �� ��ٱ��� ���� �Ϸ�");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      closeDB();
    }
  }
  // basketDelete(id)
  
}
