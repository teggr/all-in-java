package com.robintegg.j2html.bootstrap;

import static j2html.TagCreator.div;

import j2html.tags.ContainerTag;
import j2html.tags.DomContent;

public class ColumnComponent extends BootstrapComponent {

    private ContainerTag holder;

    public ColumnComponent() {
        holder = div().withClass("col");
    }

    public ColumnComponent(int size) {
        holder = div().withClass("col" + size);
    }

    public ColumnComponent with(DomContent child) {
        holder.with(child);
        return this;
    }

    @Override
    protected DomContent build() {
        return holder;
    }

}
