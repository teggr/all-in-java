package com.robintegg.j2html.bootstrap;

import static j2html.TagCreator.link;
import static j2html.TagCreator.meta;
import static j2html.TagCreator.script;

import j2html.tags.ContainerTag;
import j2html.tags.EmptyTag;
import j2html.tags.Tag;

public class BootstrapTagCreator {

    public static MediaObjectComponent mediaObject() {
        return new MediaObjectComponent();
    }

    public static MediaObjectComponent mediaObject(String imageUrl, String content) {
        return new MediaObjectComponent(imageUrl, content);
    }

    public static MediaObjectComponent mediaObject(String imageUrl, String title, String content) {
        return new MediaObjectComponent(imageUrl, title, content);
    }

    public static MediaObjectListComponent mediaObjectList() {
        return new MediaObjectListComponent();
    }

    public static RowComponent row() {
        return new RowComponent();
    }

    public static ColumnComponent col() {
        return new ColumnComponent();
    }

    public static ColumnComponent col3() {
        return new ColumnComponent(3);
    }

    public static ContainerComponent container() {
        return new ContainerComponent();
    }

    public static ContainerComponent containerFluid() {
        return new ContainerComponent(true);
    }

    public static AlertComponent alert() {
        return new AlertComponent();
    }

    public static EmptyTag encodingMetaTag() {
        return meta().withCharset("utf-8");
    }

    public static EmptyTag bootstrapCSS() {
        return link().withRel("stylesheet").withHref(
                "https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css");
    }

    public static EmptyTag responsiveMetaTag() {
        return meta().withName("viewport").withContent("width=device-width, initial-scale=1, shrink-to-fit=no");
    }

    public static Tag<ContainerTag> popperJS() {
        return script().withSrc("https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js");
    }

    public static Tag<ContainerTag> jqueryJS() {
        return script().withSrc("https://code.jquery.com/jquery-3.2.1.slim.min.js");
    }

    public static Tag<ContainerTag> bootstrapJS() {
        return script().withSrc("https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js");
    }

}
