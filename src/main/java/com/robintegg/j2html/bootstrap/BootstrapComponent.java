package com.robintegg.j2html.bootstrap;

import j2html.tags.DomContent;

public abstract class BootstrapComponent extends DomContent {

    protected abstract DomContent build();

    @Override
    public String render() {
        return build().render();
    }

}
