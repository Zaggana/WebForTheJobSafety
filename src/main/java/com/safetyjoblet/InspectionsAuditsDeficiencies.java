package com.safetyjoblet;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.web4thejob.orm.AbstractHibernateEntity;
@Entity
public class InspectionsAuditsDeficiencies extends AbstractHibernateEntity {
    @Id
	private int inaddfCode;
	@NotNull
	@ManyToOne(targetEntity = InspectionsAudits.class)
	private InspectionsAudits inspectionsAudits;
	@ManyToOne(targetEntity = InspectionsAuditsDeficienciesActionValues.class)
	private InspectionsAuditsDeficienciesActionValues inspectionsAuditsDeficienciesActionValues;
	private String inaddfNumber;
	private String inaddfId;
	private String inaddfDesc;
	private Boolean inaddfDetention;
	private String inaddfInspectorReasoning;
	private String inaddfMastersExplanation;
	private String inaddfCorrectiveActions;
	private String inaddfPreventiveActions;
	private Date inaddfDateCleared;

	public int getInaddfCode() {
		return this.inaddfCode;
	}

	public void setInaddfCode(int inaddfCode) {
		this.inaddfCode = inaddfCode;
	}

	public InspectionsAudits getInspectionsAudits() {
		return this.inspectionsAudits;
	}

	public void setInspectionsAudits(InspectionsAudits inspectionsAudits) {
		this.inspectionsAudits = inspectionsAudits;
	}

	public InspectionsAuditsDeficienciesActionValues getInspectionsAuditsDeficienciesActionValues() {
		return this.inspectionsAuditsDeficienciesActionValues;
	}

	public void setInspectionsAuditsDeficienciesActionValues(
			InspectionsAuditsDeficienciesActionValues inspectionsAuditsDeficienciesActionValues) {
		this.inspectionsAuditsDeficienciesActionValues = inspectionsAuditsDeficienciesActionValues;
	}

	public String getInaddfNumber() {
		return this.inaddfNumber;
	}

	public void setInaddfNumber(String inaddfNumber) {
		this.inaddfNumber = inaddfNumber;
	}

	public String getInaddfId() {
		return this.inaddfId;
	}

	public void setInaddfId(String inaddfId) {
		this.inaddfId = inaddfId;
	}

	public String getInaddfDesc() {
		return this.inaddfDesc;
	}

	public void setInaddfDesc(String inaddfDesc) {
		this.inaddfDesc = inaddfDesc;
	}

	public Boolean getInaddfDetention() {
		return this.inaddfDetention;
	}

	public void setInaddfDetention(Boolean inaddfDetention) {
		this.inaddfDetention = inaddfDetention;
	}

	public String getInaddfInspectorReasoning() {
		return this.inaddfInspectorReasoning;
	}

	public void setInaddfInspectorReasoning(String inaddfInspectorReasoning) {
		this.inaddfInspectorReasoning = inaddfInspectorReasoning;
	}

	public String getInaddfMastersExplanation() {
		return this.inaddfMastersExplanation;
	}

	public void setInaddfMastersExplanation(String inaddfMastersExplanation) {
		this.inaddfMastersExplanation = inaddfMastersExplanation;
	}

	public String getInaddfCorrectiveActions() {
		return this.inaddfCorrectiveActions;
	}

	public void setInaddfCorrectiveActions(String inaddfCorrectiveActions) {
		this.inaddfCorrectiveActions = inaddfCorrectiveActions;
	}

	public String getInaddfPreventiveActions() {
		return this.inaddfPreventiveActions;
	}

	public void setInaddfPreventiveActions(String inaddfPreventiveActions) {
		this.inaddfPreventiveActions = inaddfPreventiveActions;
	}

	public Date getInaddfDateCleared() {
		return this.inaddfDateCleared;
	}

	public void setInaddfDateCleared(Date inaddfDateCleared) {
		this.inaddfDateCleared = inaddfDateCleared;
	}

	@Override
	public Serializable getIdentifierValue() {
		return inaddfCode;
	}

	@Override
	public void setAsNew() {
		inaddfCode = 0;
	}

	@Override
	public String toString() {
		return  this.inaddfDesc;
	}

}
