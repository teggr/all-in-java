package com.robintegg.demo.allinjavawebapp.web.templates;

import static com.robintegg.j2html.bootstrap.BootstrapTagCreator.bootstrapCSS;
import static com.robintegg.j2html.bootstrap.BootstrapTagCreator.bootstrapJS;
import static com.robintegg.j2html.bootstrap.BootstrapTagCreator.encodingMetaTag;
import static com.robintegg.j2html.bootstrap.BootstrapTagCreator.jqueryJS;
import static com.robintegg.j2html.bootstrap.BootstrapTagCreator.popperJS;
import static com.robintegg.j2html.bootstrap.BootstrapTagCreator.responsiveMetaTag;
import static j2html.TagCreator.body;
import static j2html.TagCreator.head;
import static j2html.TagCreator.html;
import static j2html.TagCreator.title;

import java.util.Map;

import com.robintegg.j2html.template.J2HtmlTemplateSource;

import j2html.tags.ContainerTag;

public class DefaultPageTemplate implements J2HtmlTemplateSource {

    @Override
    public ContainerTag make(Map<String, Object> model) {
        return html(head(encodingMetaTag(), responsiveMetaTag(), title(createTitle(model)), bootstrapCSS()),
                makeBody(model).with(jqueryJS(), popperJS(), bootstrapJS())).attr("lang", "en");
    }

    protected String createTitle(Map<String, Object> model) {
        return model.getOrDefault("title", "Default Page").toString();
    }

    private ContainerTag makeBody(Map<String, Object> model) {
        return configureBody(body(), model);
    }

    protected ContainerTag configureBody(ContainerTag body, Map<String, Object> model) {
        return body;
    }

}
