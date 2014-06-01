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

import org.hibernate.validator.constraints.NotBlank;
import org.web4thejob.orm.AbstractHibernateEntity;
@Entity
@Table(name="INSPECTION_AUDIT_TYPES")
public class InspectionAuditTypes extends AbstractHibernateEntity {
    @Id
    @Column(name="INADT_CODE")
    @GeneratedValue
	private int inadtCode;
    @ManyToOne (targetEntity = InspectionAuditDescriptions.class)
    @JoinColumn(name="INADD_CODE")
	private InspectionAuditDescriptions inspectionAuditDescriptions;
	@NotBlank
	@Column(name="inadt_Desc")
	private String inadtDesc;
	@OneToMany (targetEntity = AuthoritiesCountries.class)
	@JoinColumn(name="INADT_CODE")
	private Set<AuthoritiesCountries> authoritiesCountrieses = new HashSet<AuthoritiesCountries>(
			0);
	@OneToMany (targetEntity = InspectionsAudits.class)
	@JoinColumn(name="INADT_CODE")
	private Set<InspectionsAudits> inspectionsAuditses = new HashSet<InspectionsAudits>(
			0);

	public int getInadtCode() {
		return this.inadtCode;
	}

	public void setInadtCode(int inadtCode) {
		this.inadtCode = inadtCode;
	}

	public InspectionAuditDescriptions getInspectionAuditDescriptions() {
		return this.inspectionAuditDescriptions;
	}

	public void setInspectionAuditDescriptions(
			InspectionAuditDescriptions inspectionAuditDescriptions) {
		this.inspectionAuditDescriptions = inspectionAuditDescriptions;
	}

	public String getInadtDesc() {
		return this.inadtDesc;
	}

	public void setInadtDesc(String inadtDesc) {
		this.inadtDesc = inadtDesc;
	}

	public Set<AuthoritiesCountries> getAuthoritiesCountrieses() {
		return this.authoritiesCountrieses;
	}

	public void setAuthoritiesCountrieses(
			Set<AuthoritiesCountries> authoritiesCountrieses) {
		this.authoritiesCountrieses = authoritiesCountrieses;
	}

	public Set<InspectionsAudits> getInspectionsAuditses() {
		return this.inspectionsAuditses;
	}

	public void setInspectionsAuditses(
			Set<InspectionsAudits> inspectionsAuditses) {
		this.inspectionsAuditses = inspectionsAuditses;
	}

	@Override
	public Serializable getIdentifierValue() {
		return inadtCode;
	}

	@Override
	public void setAsNew() {
		inadtCode = 0;
	}

	@Override
	public String toString() {
		return this.inadtDesc;
	}

}
