package com.safetyjoblet;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.web4thejob.orm.AbstractHibernateEntity;
@Entity
public class Ports extends AbstractHibernateEntity {
    @Id
	private int portCode;
	@NotNull
	@ManyToOne (targetEntity = AuthoritiesCountries.class)
	private AuthoritiesCountries authoritiesCountries;
	@NotBlank
	private String portDesc;
	@OneToMany (targetEntity = InspectionsAudits.class)
	private Set<InspectionsAudits> inspectionsAuditses = new HashSet<InspectionsAudits>(
			0);

	public int getPortCode() {
		return this.portCode;
	}

	public void setPortCode(int portCode) {
		this.portCode = portCode;
	}

	public AuthoritiesCountries getAuthoritiesCountries() {
		return this.authoritiesCountries;
	}

	public void setAuthoritiesCountries(
			AuthoritiesCountries authoritiesCountries) {
		this.authoritiesCountries = authoritiesCountries;
	}

	public String getPortDesc() {
		return this.portDesc;
	}

	public void setPortDesc(String portDesc) {
		this.portDesc = portDesc;
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
		return portCode;
	}

	@Override
	public void setAsNew() {
		portCode = 0;
	}

	@Override
	public String toString() {
		return this.portDesc;
	}

}
