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
public class CorrespondenceDirections extends AbstractHibernateEntity {
    @Id
	private int crdrCode;
	@NotBlank
	private String crdrDesc;
	@OneToMany (targetEntity = VesselsCorrespondences.class)
	private Set<VesselsCorrespondences> vesselsCorrespondenceses = new HashSet<VesselsCorrespondences>(
			0);

	public int getCrdrCode() {
		return this.crdrCode;
	}

	public void setCrdrCode(int crdrCode) {
		this.crdrCode = crdrCode;
	}

	public String getCrdrDesc() {
		return this.crdrDesc;
	}

	public void setCrdrDesc(String crdrDesc) {
		this.crdrDesc = crdrDesc;
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
		return crdrCode;
	}

	@Override
	public void setAsNew() {
		crdrCode = 0;
	}

	@Override
	public String toString() {
		return this.crdrDesc;
	}

}
