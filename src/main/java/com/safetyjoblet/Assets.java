package com.safetyjoblet;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotBlank;
import org.web4thejob.orm.AbstractHibernateEntity;
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Assets extends AbstractHibernateEntity {
	@Id
    @Column(name="ASSET_CODE")
	@GeneratedValue
	private int assetCode;
	@NotBlank
	@Column(name="ASSET_NAME")
	private String assetName;	
	@OneToOne (targetEntity = Vessels.class)
    @JoinColumn(name="ASSET_CODE")
	private Vessels vessels;
	@OneToMany (targetEntity = InspectionsAudits.class )

	   
	private Set<InspectionsAudits> inspectionsAuditses = new HashSet<InspectionsAudits>(
			0);
	 @OneToOne (targetEntity = ManagingCompanies.class)
	    @JoinColumn(name="ASSET_CODE")
	private ManagingCompanies managingCompanies;

	public int getAssetCode() {
		return this.assetCode;
	}

	public void setAssetCode(int assetCode) {
		this.assetCode = assetCode;
	}

	public String getAssetName() {
		return this.assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public Vessels getVessels() {
		return this.vessels;
	}

	public void setVessels(Vessels vessels) {
		this.vessels = vessels;
	}

	public Set<InspectionsAudits> getInspectionsAuditses() {
		return this.inspectionsAuditses;
	}

	public void setInspectionsAuditses(
			Set<InspectionsAudits> inspectionsAuditses) {
		this.inspectionsAuditses = inspectionsAuditses;
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
		return this.assetName;
	}
}
