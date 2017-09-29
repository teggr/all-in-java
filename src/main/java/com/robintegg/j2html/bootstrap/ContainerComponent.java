package com.robintegg.j2html.bootstrap;

import static j2html.TagCreator.div;

import j2html.tags.ContainerTag;
import j2html.tags.DomContent;

public class ContainerComponent extends BootstrapComponent {

    private ContainerTag holder;

    public ContainerComponent(boolean fluid) {
        if (fluid) {
            holder = div().withClass("container-fluid");
        } else {
            holder = div().withClass("container");
        }
    }

    public ContainerComponent() {
        this(false);
    }

    public ContainerComponent with(DomContent child) {
        holder.with(child);
        return this;
    }

    public ContainerComponent with(DomContent... children) {
        holder.with(children);
        return this;
    }

    @Override
    protected DomContent build() {
        return holder;
    }

}
