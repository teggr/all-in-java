package com.robintegg.j2html.bootstrap;

import static j2html.TagCreator.div;

import j2html.tags.ContainerTag;

public class Containers {

	public static ContainerTag container(ContainerTag... tags) {
		return div(tags).withClass("container");
	}

	public static ContainerTag containerFluid(ContainerTag... tags) {
		return div(tags).withClass("container-fluid");
	}

}
