package com.robintegg.j2html.bootstrap;

import static j2html.TagCreator.a;

import java.util.ArrayList;
import java.util.List;

import j2html.tags.ContainerTag;
import j2html.tags.DomContent;

public class AnchorButton extends BootstrapComponent {

    private ContainerTag holder;
    private List<String> classes = new ArrayList<>();

    public AnchorButton() {
        holder = a().withClass("btn");
    }

    @Override
    protected DomContent build() {
        return holder.withClasses(classes.toArray(new String[] {}));
    }

    public AnchorButton withHref(String href) {
        holder.withHref(href);
        return this;
    }

    public AnchorButton withPrimary() {
        classes.add("btn-primary");
        return this;
    }

    public AnchorButton withLarge() {
        classes.add("btn-lg");
        return this;
    }

    public AnchorButton withText(String text) {
        holder.withText(text);
        return this;
    }

}
