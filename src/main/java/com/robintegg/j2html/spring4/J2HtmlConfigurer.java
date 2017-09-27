package com.robintegg.j2html.spring4;

import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.robintegg.j2html.template.J2HtmlTemplateConfiguration;
import com.robintegg.j2html.template.J2HtmlTemplateEngine;

public class J2HtmlConfigurer extends J2HtmlTemplateConfiguration
        implements J2HtmlConfig, ApplicationContextAware, InitializingBean {

    // some search search path for classes or annotations

    private J2HtmlTemplateEngine templateEngine;

    private ApplicationContext applicationContext;

    private Locale locale = Locale.getDefault();

    public void setTemplateEngine(J2HtmlTemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @Override
    public J2HtmlTemplateEngine getTemplateEngine() {
        return templateEngine;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (this.templateEngine == null) {
            this.templateEngine = createTemplateEngine();
        }

    }

    private J2HtmlTemplateEngine createTemplateEngine() {
        if (this.templateEngine == null) {
            this.templateEngine = new J2HtmlTemplateEngine(this);
        }
        return this.templateEngine;
    }

}
