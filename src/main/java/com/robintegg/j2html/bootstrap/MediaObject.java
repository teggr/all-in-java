package com.robintegg.j2html.bootstrap;

import static j2html.TagCreator.div;
import static j2html.TagCreator.h5;
import static j2html.TagCreator.img;
import static j2html.TagCreator.text;
import static j2html.TagCreator.ul;

import j2html.tags.ContainerTag;

public class MediaObject {

	public static ContainerTag mediaObject(ContainerTag... tags) {

		return div(
				img().withClasses("d-flex", "mr-3").withSrc("http://via.placeholder.com/64x64")
						.withAlt("generic placeholder"),
				div(h5("Media heading").withClass("mt-0"), text("loren ipsum")).withClass("media-body"))
						.withClass("media");
	}

	public static ContainerTag mediaObjectList(ContainerTag... tags) {

		return ul(mediaObject(), mediaObject()).withClass("list-unstyled");

	}

}
