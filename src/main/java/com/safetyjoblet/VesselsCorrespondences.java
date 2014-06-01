package com.safetyjoblet;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.web4thejob.orm.AbstractHibernateEntity;
@Entity
public class VesselsCorrespondences extends AbstractHibernateEntity {
    @Id
	private int vscrCode;
	@NotNull
	@ManyToOne (targetEntity = Vessels.class)
	@JoinColumn(name="ASSET_CODE")
	private Vessels vessels;
	@NotNull
	@ManyToOne (targetEntity = CorrespondenceTypes.class)

	private CorrespondenceTypes correspondenceTypes;
	@NotNull
	@ManyToOne (targetEntity = CorrespondenceCategories.class)

	private CorrespondenceCategories correspondenceCategories;
	@NotNull
	@ManyToOne (targetEntity = CorrespondenceDirections.class)

	private CorrespondenceDirections correspondenceDirections;
	@NotNull
	private Date vscrDate;
	private String vscrDesc;
	private Boolean vscrConfirmation;
	@NotBlank
	private String vscrNumber;
	@OneToMany (targetEntity = VesselsCorrespondencesAttachments.class)
	private Set<VesselsCorrespondencesAttachments> vesselsCorrespondencesAttachmentses = new HashSet<VesselsCorrespondencesAttachments>(
			0);

	public int getVscrCode() {
		return this.vscrCode;
	}

	public void setVscrCode(int vscrCode) {
		this.vscrCode = vscrCode;
	}

	public Vessels getVessels() {
		return this.vessels;
	}

	public void setVessels(Vessels vessels) {
		this.vessels = vessels;
	}

	public CorrespondenceTypes getCorrespondenceTypes() {
		return this.correspondenceTypes;
	}

	public void setCorrespondenceTypes(CorrespondenceTypes correspondenceTypes) {
		this.correspondenceTypes = correspondenceTypes;
	}

	public CorrespondenceCategories getCorrespondenceCategories() {
		return this.correspondenceCategories;
	}

	public void setCorrespondenceCategories(
			CorrespondenceCategories correspondenceCategories) {
		this.correspondenceCategories = correspondenceCategories;
	}

	public CorrespondenceDirections getCorrespondenceDirections() {
		return this.correspondenceDirections;
	}

	public void setCorrespondenceDirections(
			CorrespondenceDirections correspondenceDirections) {
		this.correspondenceDirections = correspondenceDirections;
	}

	public Date getVscrDate() {
		return this.vscrDate;
	}

	public void setVscrDate(Date vscrDate) {
		this.vscrDate = vscrDate;
	}

	public String getVscrDesc() {
		return this.vscrDesc;
	}

	public void setVscrDesc(String vscrDesc) {
		this.vscrDesc = vscrDesc;
	}

	public Boolean getVscrConfirmation() {
		return this.vscrConfirmation;
	}

	public void setVscrConfirmation(Boolean vscrConfirmation) {
		this.vscrConfirmation = vscrConfirmation;
	}

	public String getVscrNumber() {
		return this.vscrNumber;
	}

	public void setVscrNumber(String vscrNumber) {
		this.vscrNumber = vscrNumber;
	}

	public Set<VesselsCorrespondencesAttachments> getVesselsCorrespondencesAttachmentses() {
		return this.vesselsCorrespondencesAttachmentses;
	}

	public void setVesselsCorrespondencesAttachmentses(
			Set<VesselsCorrespondencesAttachments> vesselsCorrespondencesAttachmentses) {
		this.vesselsCorrespondencesAttachmentses = vesselsCorrespondencesAttachmentses;
	}

	@Override
	public Serializable getIdentifierValue() {
		return vscrCode;
	}

	@Override
	public void setAsNew() {
		vscrCode = 0;
	}
	@Override
	public String toString() {
		return this.vscrDesc;
	}
}
