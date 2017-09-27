package com.robintegg.j2html.spring4;

import java.util.Locale;

import org.springframework.web.servlet.view.AbstractTemplateViewResolver;

public class J2HtmlViewResolver extends AbstractTemplateViewResolver {

    public J2HtmlViewResolver() {
        setViewClass(requiredViewClass());
    }

    public J2HtmlViewResolver(String prefix, String suffix) {
        this();
        setPrefix(prefix);
        setSuffix(suffix);
    }

    @Override
    protected Class<?> requiredViewClass() {
        return J2HtmlView.class;
    }

    /**
     * This resolver supports i18n, so cache keys should contain the locale.
     */
    @Override
    protected Object getCacheKey(String viewName, Locale locale) {
        return viewName + '_' + locale;
    }

}
