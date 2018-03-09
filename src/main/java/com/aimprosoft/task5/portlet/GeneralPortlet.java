package com.aimprosoft.task5.portlet;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Component;

import com.aimprosoft.task5.context.SpringContext;
import com.aimprosoft.task5.model.Department;
import com.aimprosoft.task5.service.DepartmentService;


/**
 * Portlet implementation class GeneralPortlet
 */
@Component

public class GeneralPortlet extends GenericPortlet {
	
	DepartmentService departmentService = SpringContext.getDepartmentService();

    public void init() {
       
        viewTemplate = getInitParameter("view-jsp");
    }
     

    public void doView(
            RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {
    	String s = "Initial";
    	renderRequest.setAttribute("s", s);
    	Iterable<Department> departments = departmentService.listDepartments();
    	if(departments == null) {
    		renderRequest.setAttribute("deps","Null departments list");
    	}
    	else {
    		StringBuilder sb = new StringBuilder();
    		for(Department d:departments) {
    			sb.append(d).append("<br/>");
    		}
    		renderRequest.setAttribute("deps",sb.toString());
    	}
    	
        include(viewTemplate, renderRequest, renderResponse);
    }

    protected void include(
            String path, RenderRequest renderRequest,
            RenderResponse renderResponse)
        throws IOException, PortletException {

        PortletRequestDispatcher portletRequestDispatcher =
            getPortletContext().getRequestDispatcher(path);

        if (portletRequestDispatcher == null) {
        	System.out.println(path + " is not a valid include");
        }
        else {
            portletRequestDispatcher.include(renderRequest, renderResponse);
        }
    }
 
   
    protected String viewTemplate;

   

}
