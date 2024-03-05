package com.cashnex.model;

import java.sql.Date;

public class Transaction {
	private int transactionId;
	private int accountId; // Foreign key referencing the Account entity
	private String type; // deposit, withdrawal, transfer.
	private double amount;
	private Date date;

}
