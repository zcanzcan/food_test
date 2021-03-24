package com.order.db;

import java.sql.Date;

public class OrderBean {
	
    private int f_or_num;  			//�ֹ���ȣ(DB���̺�)
    private String f_or_trade_num;  //�ֹ���ȣ(�����Ȯ�ο�)
    
    private int f_or_gs_num;		// �ֹ���ǰ ��ȣ
    private String f_or_gs_name;	// �ֹ���ǰ �̸�
    private int f_or_bas_amount; 	// �ֹ� ����
    
    private String f_or_mem_addr1;	// ȸ�������� �ּ� 1
    private String f_or_mem_addr2;	// ȸ�������� �ּ� 2
    private String f_or_mem_id; 	// �ֹ��� ��� ID
    
    private String f_or_rec_name; 	// �޴� ��� �̸�
    private String f_or_rec_addr1; 	// �޴� ��� �ּ�
    private String f_or_rec_addr2; 	// �޴� ��� �ּ�2
    private String f_or_rec_phone;  // �޴� ��� ��ȭ��ȣ
    private String f_or_memo;  		// ��� �޼���
    
    private int f_or_sum;  		 	// ���� �ݾ�
    private String f_or_trade_type;	// ���� Ÿ��
    private String f_or_trade_payer; // ������ 
    private Date f_or_trade_date;  	// �����ð�
    
    private String f_or_trans_num;  //�ù� ������ȣ 
    private Date f_or_date; 		// �ð�����(DB���̺�)
    private int f_or_status; 		// �ֹ�����
    
    
	public int getF_or_num() {
		return f_or_num;
	}
	public void setF_or_num(int f_or_num) {
		this.f_or_num = f_or_num;
	}
	public String getF_or_trade_num() {
		return f_or_trade_num;
	}
	public void setF_or_trade_num(String f_or_trade_num) {
		this.f_or_trade_num = f_or_trade_num;
	}
	public int getF_or_gs_num() {
		return f_or_gs_num;
	}
	public void setF_or_gs_num(int f_or_gs_num) {
		this.f_or_gs_num = f_or_gs_num;
	}
	public String getF_or_gs_name() {
		return f_or_gs_name;
	}
	public void setF_or_gs_name(String f_or_gs_name) {
		this.f_or_gs_name = f_or_gs_name;
	}
	public int getF_or_bas_amount() {
		return f_or_bas_amount;
	}
	public void setF_or_bas_amount(int f_or_bas_amount) {
		this.f_or_bas_amount = f_or_bas_amount;
	}
	public String getF_or_mem_addr1() {
		return f_or_mem_addr1;
	}
	public void setF_or_mem_addr1(String f_or_mem_addr1) {
		this.f_or_mem_addr1 = f_or_mem_addr1;
	}
	public String getF_or_mem_addr2() {
		return f_or_mem_addr2;
	}
	public void setF_or_mem_addr2(String f_or_mem_addr2) {
		this.f_or_mem_addr2 = f_or_mem_addr2;
	}
	public String getF_or_mem_id() {
		return f_or_mem_id;
	}
	public void setF_or_mem_id(String f_or_mem_id) {
		this.f_or_mem_id = f_or_mem_id;
	}
	public String getF_or_rec_name() {
		return f_or_rec_name;
	}
	public void setF_or_rec_name(String f_or_rec_name) {
		this.f_or_rec_name = f_or_rec_name;
	}
	public String getF_or_rec_addr1() {
		return f_or_rec_addr1;
	}
	public void setF_or_rec_addr1(String f_or_rec_addr1) {
		this.f_or_rec_addr1 = f_or_rec_addr1;
	}
	public String getF_or_rec_addr2() {
		return f_or_rec_addr2;
	}
	public void setF_or_rec_addr2(String f_or_rec_addr2) {
		this.f_or_rec_addr2 = f_or_rec_addr2;
	}
	public String getF_or_rec_phone() {
		return f_or_rec_phone;
	}
	public void setF_or_rec_phone(String f_or_rec_phone) {
		this.f_or_rec_phone = f_or_rec_phone;
	}
	public String getF_or_memo() {
		return f_or_memo;
	}
	public void setF_or_memo(String f_or_memo) {
		this.f_or_memo = f_or_memo;
	}
	public int getF_or_sum() {
		return f_or_sum;
	}
	public void setF_or_sum(int f_or_sum) {
		this.f_or_sum = f_or_sum;
	}
	public String getF_or_trade_type() {
		return f_or_trade_type;
	}
	public void setF_or_trade_type(String f_or_trade_type) {
		this.f_or_trade_type = f_or_trade_type;
	}
	public String getF_or_trade_payer() {
		return f_or_trade_payer;
	}
	public void setF_or_trade_payer(String f_or_trade_payer) {
		this.f_or_trade_payer = f_or_trade_payer;
	}
	public Date getF_or_trade_date() {
		return f_or_trade_date;
	}
	public void setF_or_trade_date(Date f_or_trade_date) {
		this.f_or_trade_date = f_or_trade_date;
	}
	public String getF_or_trans_num() {
		return f_or_trans_num;
	}
	public void setF_or_trans_num(String f_or_trans_num) {
		this.f_or_trans_num = f_or_trans_num;
	}
	public Date getF_or_date() {
		return f_or_date;
	}
	public void setF_or_date(Date f_or_date) {
		this.f_or_date = f_or_date;
	}
	public int getF_or_status() {
		return f_or_status;
	}
	public void setF_or_status(int f_or_status) {
		this.f_or_status = f_or_status;
	}
	
	
	@Override
	public String toString() {
		return "OrderBean [f_or_num=" + f_or_num + ", f_or_trade_num=" + f_or_trade_num + ", f_or_gs_num=" + f_or_gs_num
				+ ", f_or_gs_name=" + f_or_gs_name + ", f_or_bas_amount=" + f_or_bas_amount + ", f_or_mem_addr1="
				+ f_or_mem_addr1 + ", f_or_mem_addr2=" + f_or_mem_addr2 + ", f_or_mem_id=" + f_or_mem_id
				+ ", f_or_rec_name=" + f_or_rec_name + ", f_or_rec_addr1=" + f_or_rec_addr1 + ", f_or_rec_addr2="
				+ f_or_rec_addr2 + ", f_or_rec_phone=" + f_or_rec_phone + ", f_or_memo=" + f_or_memo + ", f_or_sum="
				+ f_or_sum + ", f_or_trade_type=" + f_or_trade_type + ", f_or_trade_payer=" + f_or_trade_payer
				+ ", f_or_trade_date=" + f_or_trade_date + ", f_or_trans_num=" + f_or_trans_num + ", f_or_date="
				+ f_or_date + ", f_or_status=" + f_or_status + "]";
	}

}
