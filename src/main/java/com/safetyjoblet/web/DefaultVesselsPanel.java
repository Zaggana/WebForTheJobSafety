package com.safetyjoblet.web;

import org.web4thejob.context.ContextUtil;
import org.web4thejob.orm.Path;
import org.web4thejob.web.panel.DefaultMutableEntityViewPanel;
import org.web4thejob.web.panel.DirtyListener;
import org.web4thejob.web.panel.MutableMode;
import org.web4thejob.web.panel.MutablePanel;
import org.web4thejob.web.panel.base.AbstractMutablePanel.DirtyHandler;
import org.web4thejob.web.zbox.EntityDropdownBox;

import com.safetyjoblet.Vessels;

public class DefaultVesselsPanel extends DefaultMutableEntityViewPanel
		implements VesselsPanel {
	public DefaultVesselsPanel(MutableMode mutableMode) {
		super(mutableMode);
	}

	public DefaultVesselsPanel() {
		super();
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
		return VesselsPanel.class;
	}

	public class MyDirtyHandler extends DirtyHandler {

		@Override
		public void onDirty(boolean dirty, Object... args) {
			super.onDirty(dirty, args);

			if (dirty) {
				// do something...
			}
		}
	}

	@Override
	protected void arrangeForRenderScheme() {
		// TODO Auto-generated method stub
		super.arrangeForRenderScheme();

		if (getMutableMode() != MutableMode.READONLY) {
			
			EntityDropdownBox dropdownBox = (EntityDropdownBox) getBoundComponent(ContextUtil
					.getMRS().getPropertyPath(Vessels.class,
							new Path("authoritiesCountries")));
			dropdownBox.setLookupName("countryquery");			
			dropdownBox.reset();
	
		}
	}
}
