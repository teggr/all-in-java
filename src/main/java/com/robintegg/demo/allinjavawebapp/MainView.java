package com.robintegg.demo.allinjavawebapp;

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

import j2html.tags.ContainerTag;
import j2html.tags.DomContent;

public class MainView {

    public static ContainerTag render(Map<String, Object> model, DomContent... children) {
        return html(head(encodingMetaTag(), responsiveMetaTag(), title("Bootstrap Example"), bootstrapCSS()),
                body(children).with(jqueryJS(), popperJS(), bootstrapJS())).attr("lang", "en");
    }

}
