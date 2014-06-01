package com.safetyjoblet;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;
import org.web4thejob.orm.AbstractHibernateEntity;
@Entity
public class InspectionsAuditsDeficienciesActionValues extends
		AbstractHibernateEntity {
    @Id
	private int inaddfavCode;
	@NotBlank
	private String inaddfavDesc;
	@OneToMany (targetEntity = InspectionsAuditsDeficienciesActionValues.class)
	private Set<InspectionsAuditsDeficiencies> inspectionsAuditsDeficiencieses = new HashSet<InspectionsAuditsDeficiencies>(
			0);

	public int getInaddfavCode() {
		return this.inaddfavCode;
	}

	public void setInaddfavCode(int inaddfavCode) {
		this.inaddfavCode = inaddfavCode;
	}

	public String getInaddfavDesc() {
		return this.inaddfavDesc;
	}

	public void setInaddfavDesc(String inaddfavDesc) {
		this.inaddfavDesc = inaddfavDesc;
	}

	public Set<InspectionsAuditsDeficiencies> getInspectionsAuditsDeficiencieses() {
		return this.inspectionsAuditsDeficiencieses;
	}

	public void setInspectionsAuditsDeficiencieses(
			Set<InspectionsAuditsDeficiencies> inspectionsAuditsDeficiencieses) {
		this.inspectionsAuditsDeficiencieses = inspectionsAuditsDeficiencieses;
	}

	@Override
	public Serializable getIdentifierValue() {
		return inaddfavCode;
	}

	@Override
	public void setAsNew() {
		inaddfavCode = 0;
	}

	@Override
	public String toString() {
		return this.inaddfavDesc;
	}

}
