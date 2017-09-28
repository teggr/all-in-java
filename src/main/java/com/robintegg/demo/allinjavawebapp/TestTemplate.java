package com.robintegg.demo.allinjavawebapp;

import static j2html.TagCreator.body;
import static j2html.TagCreator.h1;
import static j2html.TagCreator.img;

import com.robintegg.j2html.template.J2HtmlTemplateSource;

import j2html.tags.ContainerTag;

public class TestTemplate implements J2HtmlTemplateSource {

    @Override
    public ContainerTag getContainerTag() {
        return body(h1("Result!!!").withClass("example"), img().withSrc("img/hello.png"));
    }

}
