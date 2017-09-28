package com.robintegg.j2html.template;

import java.util.Map;

public interface J2HtmlTemplate {

	Writable make();

	Writable make(Map<String, Object> model);

}
