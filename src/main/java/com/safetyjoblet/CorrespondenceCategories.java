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
public class CorrespondenceCategories extends AbstractHibernateEntity {
    @Id
	private int crctCode;
	@NotBlank
	private String crctDesc;
	@OneToMany (targetEntity = VesselsCorrespondences.class)
	private Set<VesselsCorrespondences> vesselsCorrespondenceses = new HashSet<VesselsCorrespondences>(
			0);

	public int getCrctCode() {
		return this.crctCode;
	}

	public void setCrctCode(int crctCode) {
		this.crctCode = crctCode;
	}

	public String getCrctDesc() {
		return this.crctDesc;
	}

	public void setCrctDesc(String crctDesc) {
		this.crctDesc = crctDesc;
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
		return crctCode;
	}

	@Override
	public void setAsNew() {
		crctCode = 0;
	}

	@Override
	public String toString() {
		return this.crctDesc;
	}

}
