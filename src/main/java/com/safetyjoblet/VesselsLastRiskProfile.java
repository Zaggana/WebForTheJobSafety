package com.safetyjoblet;

import org.web4thejob.orm.AbstractHibernateEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by lena on 31/5/2014.
 */

@Entity
@Table(name="VESSELS_LAST_RISK_PROFILE_VALUE")
public class VesselsLastRiskProfile extends AbstractHibernateEntity {
    @Id
    @Column(name = "ASSET_CODE")
    @GeneratedValue
    private int assetCode;
    @Column(name = "VRPV_DESC")
    private String vrpvDesc;
    @OneToOne(targetEntity = Vessels.class)
    @JoinColumn(name = "ASSET_CODE")
    private Vessels vessels;

    public int getAssetCode() {
        return this.assetCode;
    }

    public void setAssetCode(int assetCode) {
        this.assetCode = assetCode;
    }

    public String getVrpvDesc() {
        return this.vrpvDesc;
    }

    public void setVrpvDesc(String vrpvDesc) {
        this.vrpvDesc = vrpvDesc;
    }

    public Vessels getVessels() {
        return this.vessels;
    }

    public void setVessels(Vessels vessels) {
        this.vessels = vessels;
    }

    @Override
    public Serializable getIdentifierValue() {
        return assetCode;
    }

    @Override
    public void setAsNew() {
        assetCode = 0;
    }

    @Override
    public String toString() {
        return vessels.getAssetName() + " " + vrpvDesc;
    }
}
