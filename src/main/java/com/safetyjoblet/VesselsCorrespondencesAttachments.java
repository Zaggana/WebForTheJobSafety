package com.safetyjoblet;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.web4thejob.orm.AbstractHibernateEntity;
import org.web4thejob.orm.annotation.MediaHolder;
@Entity
public class VesselsCorrespondencesAttachments extends AbstractHibernateEntity {
    @Id
	private int vcraCode;
	@NotNull
	@ManyToOne (targetEntity = VesselsCorrespondences.class)
	private VesselsCorrespondences vesselsCorrespondences;
	private String vcraName;
	@MediaHolder
	private byte[] vcraAttachment;

    @OneToOne(targetEntity=VesselsCorrespondencesAttachmentsPreview.class)
    @JoinColumn(name="VCRA_CODE")
    private VesselsCorrespondencesAttachmentsPreview vesselsCorrespondencesAttachmentsPreview;

	public int getVcraCode() {
		return this.vcraCode;
	}

	public void setVcraCode(int vcraCode) {
		this.vcraCode = vcraCode;
	}

	public VesselsCorrespondences getVesselsCorrespondences() {
		return this.vesselsCorrespondences;
	}

	public void setVesselsCorrespondences(
			VesselsCorrespondences vesselsCorrespondences) {
		this.vesselsCorrespondences = vesselsCorrespondences;
	}

	public String getVcraName() {
		return this.vcraName;
	}

	public void setVcraName(String vcraName) {
		this.vcraName = vcraName;
	}

	public byte[] getVcraAttachment() {
		return this.vcraAttachment;
	}

	public void setVcraAttachment(byte[] vcraAttachment) {
		this.vcraAttachment = vcraAttachment;
	}

    public VesselsCorrespondencesAttachmentsPreview getVesselsCorrespondencesAttachmentsPreview() {
        return vesselsCorrespondencesAttachmentsPreview;
    }

    public void setVesselsCorrespondencesAttachmentsPreview(
            VesselsCorrespondencesAttachmentsPreview vesselsCorrespondencesAttachmentsPreview)
    {
        this.vesselsCorrespondencesAttachmentsPreview = vesselsCorrespondencesAttachmentsPreview;
    }

    @Override
	public Serializable getIdentifierValue() {
		return vcraCode;
	}

	@Override
	public void setAsNew() {
		vcraCode = 0;
	}

	@Override
	public String toString() {
		return this.vcraName;
	}

}
