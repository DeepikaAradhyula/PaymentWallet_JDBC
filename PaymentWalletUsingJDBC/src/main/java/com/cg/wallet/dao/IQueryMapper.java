package com.cg.wallet.dao;

public interface IQueryMapper {
	public String insert="insert into account(name,email,mobileno,balance) values(?,?,?,?)";
	public String getBal="select balance from account where mobileno=?";
	public String getacc="select * from account where mobileno=?";
	public String update="update account set balance=?,date1=? where mobileno=?";
}
