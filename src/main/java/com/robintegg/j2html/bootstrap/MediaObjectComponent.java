package com.robintegg.j2html.bootstrap;

import static j2html.TagCreator.div;
import static j2html.TagCreator.h5;
import static j2html.TagCreator.img;
import static j2html.TagCreator.text;

import j2html.tags.ContainerTag;
import j2html.tags.DomContent;

public class MediaObjectComponent extends BootstrapComponent {

    private ContainerTag holder;

    public MediaObjectComponent() {
        this("http://via.placeholder.com/64x64", "loren ipsum");
    }

    public MediaObjectComponent(String imageUrl, String content) {
        this(imageUrl, "My title", content);
    }

    public MediaObjectComponent(String imageUrl, String title, String content) {
        holder = div(
                img().withClasses("d-flex", "mr-3").withSrc(imageUrl).withAlt(
                        "generic placeholder"),
                div(h5(title).withClass("mt-0"), text(content)).withClass("media-body"))
                        .withClass("media");
    }

    @Override
    protected DomContent build() {
        return holder;
    }

}
