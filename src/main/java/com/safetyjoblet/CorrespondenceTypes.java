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
public class CorrespondenceTypes extends AbstractHibernateEntity {
    @Id
	private int crtpCode;
	@NotBlank
	private String crtpDesc;
	@OneToMany (targetEntity = VesselsCorrespondences.class)
	private Set<VesselsCorrespondences> vesselsCorrespondenceses = new HashSet<VesselsCorrespondences>(
			0);

	public int getCrtpCode() {
		return this.crtpCode;
	}

	public void setCrtpCode(int crtpCode) {
		this.crtpCode = crtpCode;
	}

	public String getCrtpDesc() {
		return this.crtpDesc;
	}

	public void setCrtpDesc(String crtpDesc) {
		this.crtpDesc = crtpDesc;
	}

	public Set<VesselsCorrespondences> getVesselsCorrespondenceses() {
		return this.vesselsCorrespondenceses;
	}

	public void setVesselsCorrespondenceses(
			Set<VesselsCorrespondences> vesselsCorrespondenceses) {
		this.vesselsCorrespondenceses = vesselsCorrespondenceses;
	}

	@Override
	public Serializable getIdentifierValue() {
		return crtpCode;
	}

	@Override
	public void setAsNew() {
		crtpCode = 0;
	}

	@Override
	public String toString() {
		return this.crtpDesc;
	}

}
