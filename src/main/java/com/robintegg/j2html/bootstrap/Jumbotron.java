package com.robintegg.j2html.bootstrap;

import static j2html.TagCreator.div;
import static j2html.TagCreator.h1;
import static j2html.TagCreator.hr;
import static j2html.TagCreator.p;

import j2html.tags.ContainerTag;
import j2html.tags.DomContent;

public class Jumbotron extends BootstrapComponent {

    private ContainerTag holder;

    public Jumbotron() {
        holder = div().withClasses("jumbotron");
    }

    public Jumbotron withHeader(String header) {
        holder.with(h1(header));
        return this;
    }

    public Jumbotron withSubHeader(String lead) {
        holder.with(p(lead).withClass("lead"));
        return this;
    }

    public Jumbotron withSeparator() {
        holder.with(hr().withClass("my-4"));
        return this;
    }

    public Jumbotron withText(String subText) {
        holder.with(p(subText));
        return this;
    }

    @Override
    protected DomContent build() {
        return holder;
    }

    public Jumbotron with(DomContent child) {
        holder.with(child);
        return this;
    }

}
