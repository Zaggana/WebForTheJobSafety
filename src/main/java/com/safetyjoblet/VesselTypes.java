package com.safetyjoblet;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.web4thejob.orm.AbstractHibernateEntity;
@Entity
@Table(name="VESSEL_TYPES")
public class VesselTypes extends AbstractHibernateEntity {
    @Id
    @Column(name="VSTP_CODE")
    @GeneratedValue
	private int vstpCode;
	@NotBlank
	@Column(name="VSTP_DESC")
	private String vstpDesc;
	@OneToMany (targetEntity = Vessels.class)
	private Set<Vessels> vesselses = new HashSet<Vessels>(0);

	public int getVstpCode() {
		return this.vstpCode;
	}

	public void setVstpCode(int vstpCode) {
		this.vstpCode = vstpCode;
	}

	public String getVstpDesc() {
		return this.vstpDesc;
	}

	public void setVstpDesc(String vstpDesc) {
		this.vstpDesc = vstpDesc;
	}

	public Set<Vessels> getVesselses() {
		return this.vesselses;
	}

	public void setVesselses(Set<Vessels> vesselses) {
		this.vesselses = vesselses;
	}

	@Override
	public Serializable getIdentifierValue() {
		return vstpCode;
	}

	@Override
	public void setAsNew() {
		vstpCode = 0;
	}

	@Override
	public String toString() {
		return this.vstpDesc;
	}

}
