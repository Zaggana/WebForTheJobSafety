package com.safetyjoblet;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.web4thejob.orm.AbstractHibernateEntity;
@Entity
public class VesselsRiskProfileValues extends AbstractHibernateEntity {
    @Id
	private int vrpvCode;
	private String vrpvDesc;
	@OneToMany (targetEntity = VesselsRiskProfileValues.class)
	@JoinColumn(name="VRPV_CODE")
	private Set<VesselsRiskProfileHistory> vesselsRiskProfileHistories = new HashSet<VesselsRiskProfileHistory>(
			0);

	public int getVrpvCode() {
		return this.vrpvCode;
	}

	public void setVrpvCode(int vrpvCode) {
		this.vrpvCode = vrpvCode;
	}

	public String getVrpvDesc() {
		return this.vrpvDesc;
	}

	public void setVrpvDesc(String vrpvDesc) {
		this.vrpvDesc = vrpvDesc;
	}

	public Set<VesselsRiskProfileHistory> getVesselsRiskProfileHistories() {
		return this.vesselsRiskProfileHistories;
	}

	public void setVesselsRiskProfileHistories(
			Set<VesselsRiskProfileHistory> vesselsRiskProfileHistories) {
		this.vesselsRiskProfileHistories = vesselsRiskProfileHistories;
	}

	@Override
	public Serializable getIdentifierValue() {
		return vrpvCode;
	}

	@Override
	public void setAsNew() {
		vrpvCode = 0;
	}

	@Override
	public String toString() {
		return this.vrpvDesc;
	}


}
