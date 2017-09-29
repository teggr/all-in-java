package com.robintegg.j2html.bootstrap;

import static j2html.TagCreator.div;
import static j2html.TagCreator.text;

import j2html.tags.DomContent;

public class AlertComponent extends BootstrapComponent {

    @Override
    protected DomContent build() {
        return div(text("this is a primary alert")).withClasses("alert", "alert-primary");
    }

}
