package com.cg.wallet;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cg.wallet.beans.Account;
import com.cg.wallet.exception.WalletException;
import com.cg.wallet.service.IWalletService;
import com.cg.wallet.service.WalletServiceImpl;

public class WalletTest {
	private IWalletService service;

	@Before
	public void init() {
		service = new WalletServiceImpl();
	}

	@Test
	public void testCreateAccountForMobileNo() {
		Account ac = new Account();
		ac.setMobileno("1234");
		ac.setName("Mary");
		ac.setEmail("mary@gmail.com");
		ac.setBalance(200.0);
		try {
			service.createAccount(ac);
		} catch (WalletException e) {
			Assert.assertEquals("Mobile number should contain 10 digits",
					e.getMessage());
		}
	}

	@Test
	public void testCreateAccountForName() {
		Account ac = new Account();
		ac.setMobileno("1234567890");
		ac.setName("mark34");
		ac.setEmail("mark@gmail.com");
		ac.setBalance(500.0);
		try {
			service.createAccount(ac);
		} catch (WalletException e) {
			Assert.assertEquals(
					"Name should start with capital letter and should contain only alphabets",
					e.getMessage());
		}
	}

	@Test
	public void testCreateAccountForNameIsEmpty() {
		Account ac = new Account();
		ac.setMobileno("1234567890");
		ac.setName("");
		ac.setEmail("deepu@gmail.com");
		ac.setBalance(200.0);
		try {
			service.createAccount(ac);
		} catch (WalletException e) {
			Assert.assertEquals("Name cannot be empty", e.getMessage());
		}
	}

	@Test
	public void testCreateAccountForEmailId() {
		Account ac = new Account();
		ac.setMobileno("1234567890");
		ac.setName("DeepikaS");
		ac.setEmail("deepu@@23gmail.com");
		ac.setBalance(200.0);
		try {
			service.createAccount(ac);
		} catch (WalletException e) {
			Assert.assertEquals("Enter valid emailid", e.getMessage());
		}
	}

	@Test
	public void testCreateAccountForBalance() {
		Account ac = new Account();
		ac.setMobileno("1234567890");
		ac.setName("Deepika");
		ac.setEmail("deepu@gmail.com");
		ac.setBalance(-20);
		try {
			service.createAccount(ac);
		} catch (WalletException e) {
			Assert.assertEquals("Balance should be greater than zero",
					e.getMessage());
		}
	}

	@Test
	public void testCreateAccount() {
		Account ac = new Account();
		ac.setMobileno("9848468242");
		ac.setName("Deepika");
		ac.setEmail("deepu@gmail.com");
		ac.setBalance(20000.0);

		try {
			String s = service.createAccount(ac);
			Assert.assertNotNull(s);
		} catch (WalletException e) {
			e.getMessage();

		}

	}

	@Test
	public void testShowBalanceForMobileNo() {
		
		try {
			service.showBalance("95059");
		} catch (WalletException e) {
		
			Assert.assertEquals("Mobile number should contain 10 digits",
					e.getMessage());
		}
	}

	
	
	@Test
	public void testShowBalance() {
		Account ac = new Account();
		ac.setMobileno("9505928505");
		try {
			double ac1 = service.showBalance(ac.getMobileno());
			assertNotNull(ac1);
		} catch (WalletException e) {

			System.out.println(e.getMessage());
		}
	}


	@Test
	public void testDepositForMobileNo() {
		Account ac = new Account();
		ac.setMobileno("95059345");
		try {
			service.deposit(ac.getMobileno(), 230);
		} catch (WalletException e) {
			// TODO Auto-generated catch block
			Assert.assertEquals("Mobile number should contain 10 digits",
					e.getMessage());
		}
	}

	

	@Test
	public void testDepositForDepositAmount() {
		Account ac = new Account();
		ac.setMobileno("9505928505");
		try {
			service.deposit(ac.getMobileno(), -230);
		} catch (WalletException e) {
			// TODO Auto-generated catch block
			Assert.assertEquals("Deposit amount must be greater than zero",
					e.getMessage());
		}
	}
	@Test
	public void testDepositForDepositAmount2() {
		Account ac = new Account();
		ac.setMobileno("9505928505");
		try {
			service.deposit(ac.getMobileno(), 0);
		} catch (WalletException e) {
			// TODO Auto-generated catch block
			Assert.assertEquals("Deposit amount must be greater than zero",
					e.getMessage());
		}
	}

	@Test
	public void testDeposit() {
		Account ac = new Account();
		ac.setMobileno("9505928505");
		try {
			Account ac1 = service.deposit(ac.getMobileno(), 230);
			assertNotNull(ac1);
		} catch (WalletException e) {

			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testWithDrawForMobileNo() {
		Account ac = new Account();
		ac.setMobileno("95059345");
		try {
			service.withdraw(ac.getMobileno(), 230);
		} catch (WalletException e) {
			// TODO Auto-generated catch block
			Assert.assertEquals("Mobile number should contain 10 digits",
					e.getMessage());
		}
	}



	@Test
	public void testWithdrawForAmountt() {
		Account ac = new Account();
		ac.setMobileno("9505928555");
		try {
			service.withdraw(ac.getMobileno(), -230);
		} catch (WalletException e) {
			// TODO Auto-generated catch block
			Assert.assertEquals(
					"The amount to be withdrawn should be greater than available balance and greater than zero",
					e.getMessage());
		}
	}
	@Test
	public void testWithdraw() {
		Account ac = new Account();
		ac.setMobileno("9848468242");
		try {
			Account ac1 = service.deposit(ac.getMobileno(), 230);
			assertNotNull(ac1);
		} catch (WalletException e) {

			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testFundTransferForMobileNo() {
		Account ac = new Account();
		Account ac2 = new Account();
		ac.setMobileno("95059345");
		ac2.setMobileno("1234");
		try {
			service.fundTransfer(ac.getMobileno(), ac2.getMobileno(), 230);
		} catch (WalletException e) {
			// TODO Auto-generated catch block
			Assert.assertEquals("Mobile number should contain 10 digits",
					e.getMessage());
		}
	}
	
	@Test
	public void testFundTransferForMobileNo2() {
		Account ac = new Account();
		Account ac2 = new Account();
		ac.setMobileno("95059345");
		ac2.setMobileno("9848468242");
		try {
			service.fundTransfer(ac.getMobileno(), ac2.getMobileno(), 230);
		} catch (WalletException e) {
			// TODO Auto-generated catch block
			Assert.assertEquals("Mobile number should contain 10 digits",
					e.getMessage());
		}
	}
	
	@Test
	public void testFundTransferForMobileNo3() {
		Account ac = new Account();
		Account ac2 = new Account();
		ac.setMobileno("9848468242");
		ac2.setMobileno("950");
		try {
			service.fundTransfer(ac.getMobileno(), ac2.getMobileno(), 230);
		} catch (WalletException e) {
			// TODO Auto-generated catch block
			Assert.assertEquals("Mobile number should contain 10 digits",
					e.getMessage());
		}
	}



	@Test
	public void testFundTransferForAmount() {
		Account ac = new Account();
		Account ac2 = new Account();
		ac.setMobileno("9505928555");
		ac2.setMobileno("9848468242");
		try {
			service.fundTransfer(ac.getMobileno(), ac2.getMobileno(), -230);
		} catch (WalletException e) {
			// TODO Auto-generated catch block
			Assert.assertEquals(
					"The amount to be withdrawn should be greater than available balance and greater than zero",
					e.getMessage());
		}
	}

	@Test
	public void testFundTransfer() {
		Account ac = new Account();
		Account ac2 = new Account();
		ac.setMobileno("9505928555");
		ac2.setMobileno("9848468242");
		try {
			assertTrue(service.fundTransfer(ac.getMobileno(),
					ac2.getMobileno(), 230));
		} catch (WalletException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testPrinttransactionDetails() {
		Account ac = new Account();
		ac.setMobileno("9848468242");
		try {
			Account acc = service.printTransactionDetails(ac.getMobileno());
			assertNotNull(acc);
		} catch (WalletException e) {
			System.err.println(e.getMessage());
		}

	}

}