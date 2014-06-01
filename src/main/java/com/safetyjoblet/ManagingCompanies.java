package com.safetyjoblet;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
@Entity
@Table(name="MANAGING_COMPANIES")
@PrimaryKeyJoinColumn(name="ASSET_CODE")
public class ManagingCompanies extends Assets {

	@NotBlank
	@Column(name="MNGC_IMO_NUMBER")
	private String mngcImoNumber;
	@Column(name="MNGC_ADDRESS")
	private String mngcAddress;
	//@NotNull
	@OneToOne(targetEntity=Assets.class)
	@JoinColumn(name= "ASSET_CODE", insertable = false, updatable=false)
	@MapsId
	private Assets assets;
	@OneToMany(targetEntity=ManagingCompaniesPerformanceHistory.class)
	@JoinColumn(name= "ASSET_CODE")
	private Set<ManagingCompaniesPerformanceHistory> managingCompaniesPerformanceHistories = new HashSet<ManagingCompaniesPerformanceHistory>(
			0);
	@OneToMany(targetEntity=OwnerCompanies.class)
	@JoinColumn(name= "ASSET_CODE")
	private Set<OwnerCompanies> ownerCompanieses = new HashSet<OwnerCompanies>(
			0);
	@OneToOne(targetEntity=ManagingCompaniesLastPerformanceValue.class)
	@JoinColumn(name="ASSET_CODE")
	private ManagingCompaniesLastPerformanceValue managingCompaniesLastPerformance;
	public String getMngcImoNumber() {
		return this.mngcImoNumber;
	}

	public void setMngcImoNumber(String mngcImoNumber) {
		this.mngcImoNumber = mngcImoNumber;
	}

	public String getMngcAddress() {
		return this.mngcAddress;
	}

	public void setMngcAddress(String mngcAddress) {
		this.mngcAddress = mngcAddress;
	}

	public Assets getAssets() {
		return this.assets;
	}

	public void setAssets(Assets assets) {
		this.assets = assets;
	}

	public Set<ManagingCompaniesPerformanceHistory> getManagingCompaniesPerformanceHistories() {
		return this.managingCompaniesPerformanceHistories;
	}

	public void setManagingCompaniesPerformanceHistories(
			Set<ManagingCompaniesPerformanceHistory> managingCompaniesPerformanceHistories) {
		this.managingCompaniesPerformanceHistories = managingCompaniesPerformanceHistories;
	}

	public Set<OwnerCompanies> getOwnerCompanieses() {
		return this.ownerCompanieses;
	}

	public void setOwnerCompanieses(Set<OwnerCompanies> ownerCompanieses) {
		this.ownerCompanieses = ownerCompanieses;
	}

	public ManagingCompaniesLastPerformanceValue getManagingCompaniesLastPerformance() {
		return managingCompaniesLastPerformance;
	}

	public void setManagingCompaniesLastPerformance(
			ManagingCompaniesLastPerformanceValue managingCompaniesLastPerformance) {
		this.managingCompaniesLastPerformance = managingCompaniesLastPerformance;
	}

}
