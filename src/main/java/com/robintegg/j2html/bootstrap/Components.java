package com.robintegg.j2html.bootstrap;

import static j2html.TagCreator.div;
import static j2html.TagCreator.text;

import j2html.tags.ContainerTag;

public class Components {

	public static ContainerTag alert(ContainerTag... tags) {
		return div(text("this is a primary alert")).withClasses("alert", "alert-primary");
	}

}
