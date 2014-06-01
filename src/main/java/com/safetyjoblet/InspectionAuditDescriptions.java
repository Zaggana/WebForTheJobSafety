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
@Table(name="INSPECTION_AUDIT_DESCRIPTIONS")
public class InspectionAuditDescriptions extends AbstractHibernateEntity {
	@Id
	@Column(name="inadd_Code")
	@GeneratedValue
	private int inaddCode;
	@ManyToOne (targetEntity = InspectionAuditKinds.class)
	@JoinColumn(name="inadk_code")
	private InspectionAuditKinds inspectionAuditKinds;
	@NotBlank
	@Column(name="inadd_Desc")
	private String inaddDesc;
	@OneToMany (targetEntity = InspectionAuditTypes.class)
	private Set<InspectionAuditTypes> inspectionAuditTypeses = new HashSet<InspectionAuditTypes>(
			0);
	@OneToMany (targetEntity = InspectionsAudits.class)
	private Set<InspectionsAudits> inspectionsAuditses = new HashSet<InspectionsAudits>(
			0);

	public int getInaddCode() {
		return this.inaddCode;
	}

	public void setInaddCode(int inaddCode) {
		this.inaddCode = inaddCode;
	}

	public InspectionAuditKinds getInspectionAuditKinds() {
		return this.inspectionAuditKinds;
	}

	public void setInspectionAuditKinds(
			InspectionAuditKinds inspectionAuditKinds) {
		this.inspectionAuditKinds = inspectionAuditKinds;
	}

	public String getInaddDesc() {
		return this.inaddDesc;
	}

	public void setInaddDesc(String inaddDesc) {
		this.inaddDesc = inaddDesc;
	}

	public Set<InspectionAuditTypes> getInspectionAuditTypeses() {
		return this.inspectionAuditTypeses;
	}

	public void setInspectionAuditTypeses(
			Set<InspectionAuditTypes> inspectionAuditTypeses) {
		this.inspectionAuditTypeses = inspectionAuditTypeses;
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
		return inaddCode;
	}

	@Override
	public void setAsNew() {
		inaddCode = 0;
	}

	@Override
	public String toString() {
		return this.inaddDesc;
	}

}
