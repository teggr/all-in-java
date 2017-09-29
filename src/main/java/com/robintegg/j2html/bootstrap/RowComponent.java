package com.robintegg.j2html.bootstrap;

import static j2html.TagCreator.div;

import j2html.tags.ContainerTag;
import j2html.tags.DomContent;

public class RowComponent extends BootstrapComponent {

    private ContainerTag holder;

    public RowComponent() {
        holder = div().withClass("row");
    }
    
    public RowComponent withColumn(ColumnComponent column) {
        holder.with(column);
        return this;
    }

    @Override
    protected DomContent build() {
        return holder;
    }

}
