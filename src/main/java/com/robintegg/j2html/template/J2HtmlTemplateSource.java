package com.robintegg.j2html.template;

import java.util.Map;

import j2html.tags.ContainerTag;

public interface J2HtmlTemplateSource {

	ContainerTag make(Map<String, Object> model);

}
