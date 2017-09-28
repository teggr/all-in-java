package com.robintegg.j2html.bootstrap;

import static j2html.TagCreator.link;
import static j2html.TagCreator.meta;
import static j2html.TagCreator.script;

import j2html.tags.ContainerTag;
import j2html.tags.EmptyTag;
import j2html.tags.Tag;

public class Bootstrap {

	public static EmptyTag encodingMetaTag() {
		return meta().withCharset("utf-8");
	}

	public static EmptyTag bootstrapCSS() {
		return link().withRel("stylesheet")
				.withHref("https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css");
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
