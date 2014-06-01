package com.safetyjoblet;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotBlank;
import org.web4thejob.orm.AbstractHibernateEntity;
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Entity
@Table(name="AUTHORITIES_COUNTRIES")
public class AuthoritiesCountries extends AbstractHibernateEntity {
    @Id
    @Column(name="ATHCNT_CODE")
	private int athcntCode;
    @ManyToOne (targetEntity = InspectionAuditTypes.class )
    @JoinColumn(name="INADT_CODE")
	private InspectionAuditTypes inspectionAuditTypes;

    private transient int inspectionAuditTypesFake;
	@NotBlank
	@Column(name="athcnt_Desc")
	private String athcntDesc;
	@Column(name="ATCHCNT_IS_AUTHORITY")
	private boolean atchcntIsAuthority;
	@Column(name="ATCHCNT_ACTIVE")
	private boolean atchcntActive;
	@OneToMany (targetEntity = Ports.class)
	private Set<Ports> portses = new HashSet<Ports>(0);
	
	@OneToMany (targetEntity = Vessels.class)	
	private Set<Vessels> vesselses = new HashSet<Vessels>(0);
	
	@OneToMany (targetEntity = InspectionsAudits.class )
	private Set<InspectionsAudits> inspectionsAuditsesForAthcntCodeAuthority = new HashSet<InspectionsAudits>(
			0);
	
	@OneToMany (targetEntity = InspectionsAudits.class )
	private Set<InspectionsAudits> inspectionsAuditsesForAthcntCodeCountry = new HashSet<InspectionsAudits>(
			0);

	public int getAthcntCode() {
		return this.athcntCode;
	}

	public void setAthcntCode(int athcntCode) {
		this.athcntCode = athcntCode;
	}

	public InspectionAuditTypes getInspectionAuditTypes() {
		return this.inspectionAuditTypes;
	}

	public void setInspectionAuditTypes(
			InspectionAuditTypes inspectionAuditTypes) {
		this.inspectionAuditTypes = inspectionAuditTypes;
	}

	public String getAthcntDesc() {
		return this.athcntDesc;
	}

	public void setAthcntDesc(String athcntDesc) {
		this.athcntDesc = athcntDesc;
	}

	public boolean isAtchcntIsAuthority() {
		return this.atchcntIsAuthority;
	}

	public void setAtchcntIsAuthority(boolean atchcntIsAuthority) {
		this.atchcntIsAuthority = atchcntIsAuthority;
	}

	public boolean isAtchcntActive() {
		return this.atchcntActive;
	}

	public void setAtchcntActive(boolean atchcntActive) {
		this.atchcntActive = atchcntActive;
	}

	public Set<Ports> getPortses() {
		return this.portses;
	}

	public void setPortses(Set<Ports> portses) {
		this.portses = portses;
	}

	public Set<Vessels> getVesselses() {
		return this.vesselses;
	}

	public void setVesselses(Set<Vessels> vesselses) {
		this.vesselses = vesselses;
	}
	@OneToMany (targetEntity = InspectionsAudits.class)	
	@JoinColumn(name="ATHCNT_CODE")
	public Set<InspectionsAudits> getInspectionsAuditsesForAthcntCodeAuthority() {
		return this.inspectionsAuditsesForAthcntCodeAuthority;
	}

	public void setInspectionsAuditsesForAthcntCodeAuthority(
			Set<InspectionsAudits> inspectionsAuditsesForAthcntCodeAuthority) {
		this.inspectionsAuditsesForAthcntCodeAuthority = inspectionsAuditsesForAthcntCodeAuthority;
	}
	@OneToMany (targetEntity = InspectionsAudits.class)
	@JoinColumn(name="ATHCNT_CODE")
	public Set<InspectionsAudits> getInspectionsAuditsesForAthcntCodeCountry() {
		return this.inspectionsAuditsesForAthcntCodeCountry;
	}

	public void setInspectionsAuditsesForAthcntCodeCountry(
			Set<InspectionsAudits> inspectionsAuditsesForAthcntCodeCountry) {
		this.inspectionsAuditsesForAthcntCodeCountry = inspectionsAuditsesForAthcntCodeCountry;
	}

    public void setInspectionAuditTypesFake(int inspectionAuditTypesFake) {
        this.inspectionAuditTypesFake = inspectionAuditTypesFake;
    }

    public int getInspectionAuditTypesFake()
    {
        return inspectionAuditTypesFake;
    }

    @Override
	public Serializable getIdentifierValue() {
		return athcntCode;
	}

	@Override
	public void setAsNew() {
		athcntCode = 0;
	}

	@Override
	public String toString() {
		return this.athcntDesc;
	}

}
