package com.robintegg.demo.allinjavawebapp;

import static j2html.TagCreator.body;
import static j2html.TagCreator.h1;
import static j2html.TagCreator.head;
import static j2html.TagCreator.html;
import static j2html.TagCreator.link;
import static j2html.TagCreator.meta;
import static j2html.TagCreator.script;
import static j2html.TagCreator.title;

import com.robintegg.j2html.template.J2HtmlTemplateSource;

import j2html.tags.ContainerTag;
import j2html.tags.DomContent;
import j2html.tags.EmptyTag;
import j2html.tags.Tag;

public class TestTemplate implements J2HtmlTemplateSource {

    @Override
    public ContainerTag getContainerTag() {
        return mainView(h1("Hello, world!"));
    }

    private static ContainerTag mainView(DomContent... tags) {
        return html(head(encodingMetaTag(), responsiveMetaTag(), title("Bootstrap Example"), bootstrapCSS()),
                body(tags).with(jqueryJS(), popperJS(), bootstrapJS())).attr("lang", "en");
    }

    private static EmptyTag encodingMetaTag() {
        return meta().withCharset("utf-8");
    }

    private static EmptyTag bootstrapCSS() {
        return link().withRel("stylesheet").withHref(
                "https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css");
    }

    private static EmptyTag responsiveMetaTag() {
        return meta().withName("viewport").withContent("width=device-width, initial-scale=1, shrink-to-fit=no");
    }

    private static Tag<ContainerTag> popperJS() {
        return script().withSrc("https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js");
    }

    private static Tag<ContainerTag> jqueryJS() {
        return script().withSrc("https://code.jquery.com/jquery-3.2.1.slim.min.js");
    }

    private static Tag<ContainerTag> bootstrapJS() {
        return script().withSrc("https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js");
    }

}
