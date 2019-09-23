package com.cg.walletaccounttest.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.onlinewallet.dto.WalletAccount;
import com.cg.onlinewallet.dto.WalletUser;
import com.cg.onlinewallet.exception.MyException;
import com.cg.onlinewallet.dao.WalletUserDao;
import com.cg.onlinewallet.dao.WalletUserDaoImpl;


public class WalletAccountDaoTest {
	private WalletUserDao walletUserDao;
	private WalletUser walletUser;
	
	@BeforeAll
	public static void set() {
		
	}
	
	@BeforeEach
	public void setObject() {
		 walletUserDao= new WalletUserDaoImpl();
		 walletUser = new WalletUser();
	}
	
	@Test
	public void checkAddAmount() {
		walletUser = walletUserDao.getUser((1));
		Double value=walletUserDao.checkBalance(1);
		walletUserDao.addAmount(1, 10.00);
		Double updatedValue=walletUserDao.checkBalance(1);
		assertEquals(value,updatedValue-10);
	}
	
	@Test
	public void checkTransferAmount() {
		Double value=walletUserDao.checkBalance(1);
		walletUserDao.transferAmount(1,"1234567890", 100.00);
		assertEquals(value,walletUserDao.checkBalance(1)+100.0);
	}
	
	@Test
	public void checkTransferToAccount() {
		Double value=walletUserDao.checkBalance(1);
		walletUserDao.transferAmount(1,835238, 100.00);
		assertEquals(value,walletUserDao.checkBalance(1)+100.0);
		
	}
	@Test
	public void checkGetUser() {
		String value=walletUser.getUserName();
	
		assertEquals(value,"Venkatesh");
		
	}
	
	@Test
	public void checkGetAccount() {
		Integer value=walletUser.getUserId();
	
		assertEquals(value,1);
		
	}
	@Test
	public void checkApproveAccount() {
		 WalletAccount value=walletUser.getAccount();
	
		assertEquals(value.getAccountStatus(),"Approved");
		
	}
	
	
	
	
	@AfterAll
	public static void finish() {
		System.out.println("Program has been executed");
	}
	
	@AfterEach
	public  void afterTest() {
	
	}
	
	

}
