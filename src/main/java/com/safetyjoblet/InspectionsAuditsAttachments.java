package com.safetyjoblet;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.web4thejob.orm.AbstractHibernateEntity;
import org.web4thejob.orm.annotation.MediaHolder;
@Entity
public class InspectionsAuditsAttachments extends AbstractHibernateEntity {
    @Id
	private int inadaCode;
	@NotNull
	@ManyToOne (targetEntity = InspectionsAudits.class)
	private InspectionsAudits inspectionsAudits;
	private String inadaName;
	@MediaHolder
	private byte[] inadaAttachment;


    @OneToOne(targetEntity=InspectionsAuditsAttachmentsPreview.class)
    @JoinColumn(name="INADA_CODE")
    private InspectionsAuditsAttachmentsPreview inspectionsAuditsAttachmentsPreview;

	public int getInadaCode() {
		return this.inadaCode;
	}

	public void setInadaCode(int inadaCode) {
		this.inadaCode = inadaCode;
	}

	public InspectionsAudits getInspectionsAudits() {
		return this.inspectionsAudits;
	}

	public void setInspectionsAudits(InspectionsAudits inspectionsAudits) {
		this.inspectionsAudits = inspectionsAudits;
	}

	public String getInadaName() {
		return this.inadaName;
	}

	public void setInadaName(String inadaName) {
		this.inadaName = inadaName;
	}

	public byte[] getInadaAttachment() {
		return this.inadaAttachment;
	}

	public void setInadaAttachment(byte[] inadaAttachment) {
		this.inadaAttachment = inadaAttachment;
	}

    public InspectionsAuditsAttachmentsPreview getInspectionsAuditsAttachmentsPreview() {
        return inspectionsAuditsAttachmentsPreview;
    }

    public void setInspectionsAuditsAttachmentsPreview(
            InspectionsAuditsAttachmentsPreview inspectionsAuditsAttachmentsPreview)
    {
        this.inspectionsAuditsAttachmentsPreview = inspectionsAuditsAttachmentsPreview;
    }


    @Override
	public Serializable getIdentifierValue() {
		return inadaCode;
	}

	@Override
	public void setAsNew() {
		inadaCode = 0;
	}

	@Override
	public String toString() {
		return this.inadaName;
	}

}
