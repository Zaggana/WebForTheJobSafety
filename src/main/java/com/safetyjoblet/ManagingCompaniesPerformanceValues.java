package com.safetyjoblet;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.web4thejob.orm.AbstractHibernateEntity;
@Entity
public class ManagingCompaniesPerformanceValues extends AbstractHibernateEntity {
    @Id
    @Column(name= "MGCPV_CODE")
	private int mgcpvCode;
	private String mgcpvDesc;
	@OneToMany(targetEntity=ManagingCompaniesPerformanceValues.class)
	@JoinColumn(name= "MGCPV_CODE")
	private Set<ManagingCompaniesPerformanceHistory> managingCompaniesPerformanceHistories = new HashSet<ManagingCompaniesPerformanceHistory>(
			0);

	public int getMgcpvCode() {
		return this.mgcpvCode;
	}

	public void setMgcpvCode(int mgcpvCode) {
		this.mgcpvCode = mgcpvCode;
	}

	public String getMgcpvDesc() {
		return this.mgcpvDesc;
	}

	public void setMgcpvDesc(String mgcpvDesc) {
		this.mgcpvDesc = mgcpvDesc;
	}

	public Set<ManagingCompaniesPerformanceHistory> getManagingCompaniesPerformanceHistories() {
		return this.managingCompaniesPerformanceHistories;
	}

	public void setManagingCompaniesPerformanceHistories(
			Set<ManagingCompaniesPerformanceHistory> managingCompaniesPerformanceHistories) {
		this.managingCompaniesPerformanceHistories = managingCompaniesPerformanceHistories;
	}

	@Override
	public Serializable getIdentifierValue() {
		return mgcpvCode;
	}

	@Override
	public void setAsNew() {
		mgcpvCode = 0;
	}

	@Override
	public String toString() {
		return this.mgcpvDesc;
	}

}
