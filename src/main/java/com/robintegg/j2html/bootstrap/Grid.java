package com.robintegg.j2html.bootstrap;

import static j2html.TagCreator.div;

import j2html.tags.ContainerTag;

public class Grid {

	public static ContainerTag row(ContainerTag... tags) {
		return div(tags).withClass("row");
	}

	public static ContainerTag col(ContainerTag... tags) {
		return div(tags).withClass("col");
	}

	public static ContainerTag col3(ContainerTag... tags) {
		return div(tags).withClass("col-3");
	}

}
