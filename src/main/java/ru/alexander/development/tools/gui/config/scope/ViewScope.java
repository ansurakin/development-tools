package ru.alexander.development.tools.gui.config.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import javax.faces.context.FacesContext;
import java.util.Map;

/**
 * Simple implementation of a view scope in spring, because we the managed beans
 * are created by spring here and not JSF. Therefore we could not use the view
 * scope in JSF and have to provide our own.
 * 
 * @author MIS
 *
 */
public class ViewScope implements Scope {

        @Override
	public Object get(String name, ObjectFactory<?> objectFactory) {
		Map<String, Object> viewMap = FacesContext.getCurrentInstance().getViewRoot().getViewMap();

		if (viewMap.containsKey(name)) {
			return viewMap.get(name);
		} else {
			Object object = objectFactory.getObject();
			viewMap.put(name, object);

			return object;
		}
	}

        @Override
	public Object remove(String name) {
		return FacesContext.getCurrentInstance().getViewRoot().getViewMap().remove(name);
	}

        @Override
	public String getConversationId() {
		return null;
	}

        @Override
	public void registerDestructionCallback(String name, Runnable callback) {
		// Not supported
	}

        @Override
	public Object resolveContextualObject(String key) {
		return null;
	}
}
