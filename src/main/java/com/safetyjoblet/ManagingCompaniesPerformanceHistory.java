package com.safetyjoblet;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.web4thejob.orm.AbstractHibernateEntity;
@Entity
public class ManagingCompaniesPerformanceHistory extends
		AbstractHibernateEntity {
@Id
	private int mgcphCode;
	@NotNull
	@ManyToOne(targetEntity=ManagingCompanies.class)
	@JoinColumn(name= "ASSET_CODE")
	private ManagingCompanies managingCompanies;
	@NotNull
	@ManyToOne(targetEntity=ManagingCompaniesPerformanceValues.class)
	@JoinColumn(name= "MGCPV_CODE")
	private ManagingCompaniesPerformanceValues managingCompaniesPerformanceValues;
	private String mgcphDescription;
	private Date mgcphDate;

	public int getMgcphCode() {
		return this.mgcphCode;
	}

	public void setMgcphCode(int mgcphCode) {
		this.mgcphCode = mgcphCode;
	}

	public ManagingCompanies getManagingCompanies() {
		return this.managingCompanies;
	}

	public void setManagingCompanies(ManagingCompanies managingCompanies) {
		this.managingCompanies = managingCompanies;
	}

	public ManagingCompaniesPerformanceValues getManagingCompaniesPerformanceValues() {
		return this.managingCompaniesPerformanceValues;
	}

	public void setManagingCompaniesPerformanceValues(
			ManagingCompaniesPerformanceValues managingCompaniesPerformanceValues) {
		this.managingCompaniesPerformanceValues = managingCompaniesPerformanceValues;
	}

	public String getMgcphDescription() {
		return this.mgcphDescription;
	}

	public void setMgcphDescription(String mgcphDescription) {
		this.mgcphDescription = mgcphDescription;
	}

	public Date getMgcphDate() {
		return this.mgcphDate;
	}

	public void setMgcphDate(Date mgcphDate) {
		this.mgcphDate = mgcphDate;
	}

	@Override
	public Serializable getIdentifierValue() {
		return mgcphCode;
	}

	@Override
	public void setAsNew() {
		mgcphCode = 0;
	}

	@Override
	public String toString() {
		return this.mgcphDescription +" "+ this.managingCompaniesPerformanceValues.getMgcpvDesc();
	}

}
