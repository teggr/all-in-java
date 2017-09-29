package com.robintegg.j2html.bootstrap;

import static j2html.TagCreator.ul;

import j2html.tags.ContainerTag;
import j2html.tags.DomContent;

public class MediaObjectListComponent extends BootstrapComponent {

    private ContainerTag holder;

    public MediaObjectListComponent() {
        holder = ul().withClass("list-unstyled");
    }

    public MediaObjectListComponent withMediaObject(MediaObjectComponent mo) {
        holder.with(mo);
        return this;
    }

    @Override
    protected DomContent build() {
        return holder;
    }

}
