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
public class VesselsRiskProfileHistory extends AbstractHibernateEntity {
    @Id
	private int vrphCode;
	@NotNull
	@ManyToOne (targetEntity = Vessels.class)
	@JoinColumn(name="ASSET_CODE")
	private Vessels vessels;
	@NotNull
	@ManyToOne (targetEntity = VesselsRiskProfileValues.class)
	@JoinColumn(name="VRPV_CODE")
	private VesselsRiskProfileValues vesselsRiskProfileValues;
	private String vrphDescription;
	private Date vrphDate;

	public int getVrphCode() {
		return this.vrphCode;
	}

	public void setVrphCode(int vrphCode) {
		this.vrphCode = vrphCode;
	}

	public Vessels getVessels() {
		return this.vessels;
	}

	public void setVessels(Vessels vessels) {
		this.vessels = vessels;
	}
	
	public VesselsRiskProfileValues getVesselsRiskProfileValues() {
		return this.vesselsRiskProfileValues;
	}

	public void setVesselsRiskProfileValues(
			VesselsRiskProfileValues vesselsRiskProfileValues) {
		this.vesselsRiskProfileValues = vesselsRiskProfileValues;
	}

	public String getVrphDescription() {
		return this.vrphDescription;
	}

	public void setVrphDescription(String vrphDescription) {
		this.vrphDescription = vrphDescription;
	}

	public Date getVrphDate() {
		return this.vrphDate;
	}

	public void setVrphDate(Date vrphDate) {
		this.vrphDate = vrphDate;
	}

	@Override
	public Serializable getIdentifierValue() {
		return vrphCode;
	}

	@Override
	public void setAsNew() {
		vrphCode = 0;
	}

	@Override
	public String toString() {
		return this.vrphDescription + " "+ this.vesselsRiskProfileValues.getVrpvDesc();
	}

}
