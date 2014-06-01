package com.safetyjoblet.web;

import com.safetyjoblet.*;
import org.web4thejob.context.ContextUtil;
import org.web4thejob.orm.Path;
import org.web4thejob.orm.query.Condition;
import org.web4thejob.orm.query.Query;
import org.web4thejob.setting.SettingEnum;
import org.web4thejob.web.panel.DefaultMutableEntityViewPanel;
import org.web4thejob.web.panel.DirtyListener;
import org.web4thejob.web.panel.MutableMode;
import org.web4thejob.web.panel.MutablePanel;
import org.web4thejob.web.zbox.EntityDropdownBox;
import org.zkoss.zk.ui.util.Clients;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by lena on 7/5/2014.
 */
public class DefaultInspectionsAuditsPanel extends DefaultMutableEntityViewPanel implements InspectionsAuditsPanel {

    public DefaultInspectionsAuditsPanel(MutableMode mutableMode) {
        super(mutableMode);
    }

    public DefaultInspectionsAuditsPanel() {
        super();
    }

    @Override
    protected void registerSettings() {
        super.registerSettings();
        setSettingValue(SettingEnum.TARGET_TYPE,InspectionsAudits.class);
    }

    @Override
    protected DirtyListener getDirtyListener() {
        if (dirtyHandler == null) {
            dirtyHandler = new MyDirtyHandler();
        }

        return dirtyHandler;
    }

    @Override
    protected Class<? extends MutablePanel> getMutableType() {
        return InspectionsAuditsPanel.class;
    }

    public class MyDirtyHandler extends DirtyHandler {

        @Override
        public void onDirty(boolean dirty, Object... args) {
            super.onDirty(dirty, args);

            if (dirty) {
                // do something...
                if (args != null && args[0].equals("inspectionAuditKinds")) {

                    Query query = ContextUtil.getEntityFactory().buildQuery(InspectionAuditDescriptions.class);
                    query.addCriterion(new Path("inspectionAuditKinds"), Condition.EQ, ((InspectionsAudits) getTargetEntity()).getInspectionAuditKinds());

                    EntityDropdownBox dropdownBox = (EntityDropdownBox) getBoundComponent(ContextUtil
                            .getMRS().getPropertyPath(InspectionsAudits.class,
                                    new Path("inspectionAuditDescriptions")));
                    dropdownBox.setLookupQuery(query);
                    dropdownBox.reset();

                }

                if (args != null && args[0].equals("authoritiesCountriesByAthcntCodeCountry")) {

                    Query query = ContextUtil.getEntityFactory().buildQuery(Ports.class);
                    query.addCriterion(new Path("authoritiesCountries"), Condition.EQ, ((InspectionsAudits) getTargetEntity()).getAuthoritiesCountriesByAthcntCodeCountry());
                    query.addOrderBy(new Path("portDesc"));

                    EntityDropdownBox dropdownBox = (EntityDropdownBox) getBoundComponent(ContextUtil
                            .getMRS().getPropertyPath(InspectionsAudits.class,
                                    new Path("ports")));

                    dropdownBox.setLookupQuery(query);
                    dropdownBox.reset();

                }

                if (args != null && args[0].equals("inspectionAuditDescriptions")) {

                    Query query = ContextUtil.getEntityFactory().buildQuery(InspectionAuditTypes.class);
                    query.addCriterion(new Path("inspectionAuditDescriptions"), Condition.EQ, ((InspectionsAudits) getTargetEntity()).getInspectionAuditDescriptions());

                    EntityDropdownBox dropdownBox = (EntityDropdownBox) getBoundComponent(ContextUtil
                            .getMRS().getPropertyPath(InspectionsAudits.class,
                                    new Path("inspectionAuditTypes")));
                    dropdownBox.setLookupQuery(query);
                    dropdownBox.reset();

                }

                if (args != null && args[0].equals("inspectionAuditTypes")) {

                    Query query = ContextUtil.getEntityFactory().buildQuery(AuthoritiesCountries.class);
                    List<Integer> inspectionAuditTypeValues = new ArrayList<Integer>();
                    if(((InspectionsAudits) getTargetEntity()).getInspectionAuditTypes()!=null)
                        inspectionAuditTypeValues.add(((InspectionsAudits) getTargetEntity()).getInspectionAuditTypes().getInadtCode());
                    inspectionAuditTypeValues.add(-1);

                    query.addCriterion(new Path("inspectionAuditTypesFake"), Condition.IN, inspectionAuditTypeValues);
                    query.addOrderBy(new Path("atchcntIsAuthority"), true);
                    query.addOrderBy(new Path("athcntDesc"));

                    EntityDropdownBox dropdownBox = (EntityDropdownBox) getBoundComponent(ContextUtil
                            .getMRS().getPropertyPath(InspectionsAudits.class,
                                    new Path("authoritiesCountriesByAthcntCodeAuthority")));
                    dropdownBox.setLookupQuery(query);
                    dropdownBox.reset();

                }

            }
        }
    }

    @Override
    protected void arrangeForRenderScheme() {
        // TODO Auto-generated method stub
        super.arrangeForRenderScheme();

        if (getMutableMode() != MutableMode.READONLY) {

            EntityDropdownBox dropdownBox = (EntityDropdownBox) getBoundComponent(ContextUtil
                    .getMRS().getPropertyPath(InspectionsAudits.class,
                            new Path("authoritiesCountriesByAthcntCodeCountry")));
            dropdownBox.setLookupName("countryquery");
            dropdownBox.reset();

        }
    }
}
