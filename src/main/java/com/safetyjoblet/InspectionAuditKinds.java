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
@Table(name="INSPECTION_AUDIT_KINDS")
public class InspectionAuditKinds extends AbstractHibernateEntity {
    @Id
    @Column(name="inadk_Code")
    @GeneratedValue
	private int inadkCode;
	@NotBlank
	@Column(name="inadk_Desc")
	private String inadkDesc;
	@OneToMany (targetEntity = InspectionAuditDescriptions.class)
	
	private Set<InspectionAuditDescriptions> inspectionAuditDescriptionses = new HashSet<InspectionAuditDescriptions>(
			0);
	@OneToMany (targetEntity = InspectionsAudits.class)
	private Set<InspectionsAudits> inspectionsAuditses = new HashSet<InspectionsAudits>(
			0);

	public int getInadkCode() {
		return this.inadkCode;
	}

	public void setInadkCode(int inadkCode) {
		this.inadkCode = inadkCode;
	}

	public String getInadkDesc() {
		return this.inadkDesc;
	}

	public void setInadkDesc(String inadkDesc) {
		this.inadkDesc = inadkDesc;
	}

	public Set<InspectionAuditDescriptions> getInspectionAuditDescriptionses() {
		return this.inspectionAuditDescriptionses;
	}

	public void setInspectionAuditDescriptionses(
			Set<InspectionAuditDescriptions> inspectionAuditDescriptionses) {
		this.inspectionAuditDescriptionses = inspectionAuditDescriptionses;
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
		return inadkCode;
	}

	@Override
	public void setAsNew() {
		inadkCode = 0;
	}

	@Override
	public String toString() {
		return this.inadkDesc;
	}

}
