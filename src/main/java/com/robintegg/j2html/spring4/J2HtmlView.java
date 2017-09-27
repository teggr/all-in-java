package com.robintegg.j2html.spring4;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextException;
import org.springframework.web.servlet.view.AbstractTemplateView;
import org.springframework.web.util.NestedServletException;

import com.robintegg.j2html.template.J2HtmlTemplate;
import com.robintegg.j2html.template.J2HtmlTemplateEngine;

public class J2HtmlView extends AbstractTemplateView {

    private J2HtmlTemplateEngine engine;

    public void setTemplateEngine(J2HtmlTemplateEngine engine) {
        this.engine = engine;
    }

    @Override
    protected void initApplicationContext(ApplicationContext context) {
        super.initApplicationContext(context);
        if (this.engine == null) {
            setTemplateEngine(autodetectJ2HtmlTemplateEngine());
        }
    }

    private J2HtmlTemplateEngine autodetectJ2HtmlTemplateEngine() {
        try {
            return BeanFactoryUtils
                    .beanOfTypeIncludingAncestors(getApplicationContext(), J2HtmlConfig.class, true, false)
                    .getTemplateEngine();
        } catch (NoSuchBeanDefinitionException ex) {
            throw new ApplicationContextException("Expected a single J2HtmlConfig bean in the current "
                    + "Servlet web application context or the parent root context: J2HtmlConfigurer is "
                    + "the usual implementation. This bean may have any name.", ex);
        }
    }

    @Override
    public boolean checkResource(Locale locale) throws Exception {
        try {
            this.engine.resolveTemplate(getUrl());
        } catch (IOException ex) {
            return false;
        }
        return true;
    }

    @Override
    protected void renderMergedTemplateModel(Map<String, Object> model, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        J2HtmlTemplate template = getTemplate(getUrl());
        template.make(model).writeTo(new BufferedWriter(response.getWriter()));

    }

    /**
     * Return a template compiled by the configured Groovy Markup template
     * engine
     * for the given view URL.
     */
    protected J2HtmlTemplate getTemplate(String viewUrl) throws Exception {
        try {
            return this.engine.createTemplateByPath(viewUrl);
        } catch (ClassNotFoundException ex) {
            Throwable cause = (ex.getCause() != null ? ex.getCause() : ex);
            throw new NestedServletException("Could not find class while rendering J2Html view with name '" + getUrl()
                    + "': " + ex.getMessage() + "'", cause);
        }
    }

}
