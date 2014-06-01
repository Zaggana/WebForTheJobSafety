package com.safetyjoblet;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.web4thejob.orm.AbstractHibernateEntity;

@Entity
@Table(name="MANAGING_COMPANIES_LAST_PERFORMANCE_VALUE")
public class ManagingCompaniesLastPerformanceValue extends
		AbstractHibernateEntity {
 	@Id
    @Column(name="ASSET_CODE")
    @GeneratedValue
	private int assetCode;
    @Column(name="mgcpv_Desc")
	private String mgcpvDesc;
	@OneToOne(targetEntity=ManagingCompanies.class)
	@JoinColumn(name="ASSET_CODE")
	private ManagingCompanies managingCompanies;
	public int getAssetCode() {
		return this.assetCode;
	}

	public void setAssetCode(int assetCode) {
		this.assetCode = assetCode;
	}

	public String getMgcpvDesc() {
		return this.mgcpvDesc;
	}

	public void setMgcpvDesc(String mgcpvDesc) {
		this.mgcpvDesc = mgcpvDesc;
	}

	public ManagingCompanies getManagingCompanies() {
		return this.managingCompanies;
	}

	public void setManagingCompanies(ManagingCompanies managingCompanies) {
		this.managingCompanies = managingCompanies;
	}

	@Override
	public Serializable getIdentifierValue() {
		return assetCode;
	}

	@Override
	public void setAsNew() {
		assetCode = 0;
	}
    @Override
	public String toString() {
		return managingCompanies.getAssetName() + " "+ mgcpvDesc;
	}
}
