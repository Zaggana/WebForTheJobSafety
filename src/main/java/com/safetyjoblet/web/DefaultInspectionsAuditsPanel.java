package com.safetyjoblet.web;

import com.safetyjoblet.InspectionAuditDescriptions;
import com.safetyjoblet.InspectionsAudits;
import com.safetyjoblet.Vessels;
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
