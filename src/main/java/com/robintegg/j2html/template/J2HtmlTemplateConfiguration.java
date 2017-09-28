package com.robintegg.j2html.template;

import j2html.Config;
import j2html.utils.Indenter;
import j2html.utils.Minifier;
import j2html.utils.TextEscaper;

public class J2HtmlTemplateConfiguration {

    private TextEscaper textEscaper = Config.textEscaper;
    private Minifier cssMinifier = Config.cssMinifier;
    private Minifier jsMinifier = Config.jsMinifier;
    private Indenter indenter = Config.indenter;
    private boolean closeEmptyTags = Config.closeEmptyTags;

    public void setTextEscaper(TextEscaper textEscaper) {
        this.textEscaper = textEscaper;
    }

    public TextEscaper getTextEscaper() {
        return textEscaper;
    }

    public void setCssMinifier(Minifier cssMinifier) {
        this.cssMinifier = cssMinifier;
    }

    public Minifier getCssMinifier() {
        return cssMinifier;
    }

    public void setJsMinifier(Minifier jsMinifier) {
        this.jsMinifier = jsMinifier;
    }

    public Minifier getJsMinifier() {
        return jsMinifier;
    }

    public void setIndenter(Indenter indenter) {
        this.indenter = indenter;
    }

    public Indenter getIndenter() {
        return indenter;
    }

    public void setCloseEmptyTags(boolean closeEmptyTags) {
        this.closeEmptyTags = closeEmptyTags;
    }

    public boolean isCloseEmptyTags() {
        return closeEmptyTags;
    }

}
