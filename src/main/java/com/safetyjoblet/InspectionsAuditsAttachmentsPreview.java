package com.safetyjoblet;

import org.web4thejob.orm.AbstractHibernateEntity;
import org.web4thejob.orm.annotation.MediaHolder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by lena on 31/5/2014.
 */
@Entity
@Table(name="INSPECTIONS_AUDITS_ATTACHMENTS_PREVIEW")
public class InspectionsAuditsAttachmentsPreview extends AbstractHibernateEntity {

    @Id
    @Column(name = "INADA_CODE")
    @GeneratedValue
    private int inadaCode;

    @OneToOne(targetEntity = InspectionsAuditsAttachments.class)
    @JoinColumn(name = "INADA_CODE")
    private InspectionsAuditsAttachments inspectionsAuditsAttachments;

    @MediaHolder
    private byte[] inadaAttachment;

    public int getInadaCode() {
        return this.inadaCode;
    }

    public void setInadaCode(int inadaCode) {
        this.inadaCode = inadaCode;
    }

    public InspectionsAuditsAttachments getInspectionsAuditsAttachments()
    {
        return this.inspectionsAuditsAttachments;
    }

    public void setInspectionsAuditsAttachments(InspectionsAuditsAttachments inspectionsAuditsAttachments) {
        this.inspectionsAuditsAttachments = inspectionsAuditsAttachments;
    }

    public byte[] getInadaAttachment()
    { return  this.inadaAttachment; }

    public  void setInadaAttachment(byte[] inadaAttachment)
    {
        this.inadaAttachment = inadaAttachment;
    }

    @Override
    public Serializable getIdentifierValue() {
        return inadaCode;
    }

    @Override
    public void setAsNew() {
        inadaCode = 0;
    }

}
