package com.safetyjoblet;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.web4thejob.orm.AbstractHibernateEntity;
@Entity
@Table(name="OWNER_COMPANIES")
public class OwnerCompanies extends AbstractHibernateEntity {
    @Id
    @Column(name="OWNC_CODE")
    @GeneratedValue
	private int owncCode;
	@NotNull
	//This is for the Managing Company
	@ManyToOne(targetEntity = ManagingCompanies.class)
	@JoinColumn(name="ASSET_CODE")
	private ManagingCompanies managingCompanies;
	@NotBlank
    @Column(name="OWNC_DESC")
	private String owncDesc;
    @Column(name="OWNC_ADDRESS")
	private String owncAddress;
	//This is for the Vessels
    @OneToMany (targetEntity = Vessels.class)
	private Set<Vessels> vesselses = new HashSet<Vessels>(0);

	public int getOwncCode() {
		return this.owncCode;
	}

	public void setOwncCode(int owncCode) {
		this.owncCode = owncCode;
	}

	public ManagingCompanies getManagingCompanies() {
		return this.managingCompanies;
	}

	public void setManagingCompanies(ManagingCompanies managingCompanies) {
		this.managingCompanies = managingCompanies;
	}

	public String getOwncDesc() {
		return this.owncDesc;
	}

	public void setOwncDesc(String owncDesc) {
		this.owncDesc = owncDesc;
	}

	public String getOwncAddress() {
		return this.owncAddress;
	}

	public void setOwncAddress(String owncAddress) {
		this.owncAddress = owncAddress;
	}

	public Set<Vessels> getVesselses() {
		return this.vesselses;
	}

	public void setVesselses(Set<Vessels> vesselses) {
		this.vesselses = vesselses;
	}

	@Override
	public Serializable getIdentifierValue() {
		return owncCode;
	}

	@Override
	public void setAsNew() {
		owncCode = 0;
	}

	@Override
	public String toString() {
		return this.owncDesc;
	}
}
