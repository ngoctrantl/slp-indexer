package com.bitcoin.indexer.repository.db;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import com.bitcoin.indexer.blockchain.domain.slp.SlpTokenId;
import com.bitcoin.indexer.blockchain.domain.slp.SlpUtxo;

public class SlpUtxoType implements Serializable {
	private static final long serialVersionUID = 1L;

	private String slpTokenId;

	private String tokenTransactionType;

	private String tokenType;

	private String amount;

	private boolean hasBaton;

	private String tokenTicker;

	private String tokenName;

	public SlpUtxoType() {
	}

	public SlpUtxoType(String slpTokenId, String tokenTransactionType, String tokenType, String amount, boolean hasBaton, String tokenTicker, String tokenName) {
		this.slpTokenId = Objects.requireNonNull(slpTokenId);
		this.tokenTransactionType = Objects.requireNonNull(tokenTransactionType);
		this.tokenType = Objects.requireNonNull(tokenType);
		this.amount = Objects.requireNonNull(amount);
		this.hasBaton = hasBaton;
		this.tokenTicker = Objects.requireNonNull(tokenTicker);
		this.tokenName = Objects.requireNonNull(tokenName);
	}

	public SlpUtxo toDomain() {
		return SlpUtxo.create(
				new SlpTokenId(getSlpTokenId()),
				new BigDecimal(getAmount()),
				isHasBaton(),
				getTokenTicker(),
				getTokenTransactionType(),
				getTokenName(),
				getTokenType());
	}

	public org.bson.Document toDocument() {
		org.bson.Document update = new org.bson.Document();
		update.put("slpTokenId", slpTokenId);
		update.put("tokenTransactionType", tokenTransactionType);
		update.put("tokenType", tokenType);
		update.put("amount", amount);
		update.put("hasBaton", hasBaton);
		update.put("tokenTicker", tokenTicker);
		update.put("tokenName", tokenName);
		return update;
	}

	public String getSlpTokenId() {
		return slpTokenId;
	}

	public String getTokenTransactionType() {
		return tokenTransactionType;
	}

	public String getAmount() {
		return amount;
	}

	public boolean isHasBaton() {
		return hasBaton;
	}

	public String getTokenTicker() {
		return tokenTicker;
	}

	public String getTokenName() {
		return tokenName;
	}

	public String getTokenType() {
		return tokenType;
	}
}
