package com.robintegg.demo.allinjavawebapp;

import static com.robintegg.j2html.bootstrap.Bootstrap.bootstrapCSS;
import static com.robintegg.j2html.bootstrap.Bootstrap.bootstrapJS;
import static com.robintegg.j2html.bootstrap.Bootstrap.encodingMetaTag;
import static com.robintegg.j2html.bootstrap.Bootstrap.jqueryJS;
import static com.robintegg.j2html.bootstrap.Bootstrap.popperJS;
import static com.robintegg.j2html.bootstrap.Bootstrap.responsiveMetaTag;
import static j2html.TagCreator.body;
import static j2html.TagCreator.head;
import static j2html.TagCreator.html;
import static j2html.TagCreator.title;

import java.util.Map;

import j2html.tags.ContainerTag;

public class MainView {

	public static ContainerTag render(Map<String, Object> model, ContainerTag... tags) {
		return html(head(encodingMetaTag(), responsiveMetaTag(), title("Bootstrap Example"), bootstrapCSS()),
				body(tags).with(jqueryJS(), popperJS(), bootstrapJS())).attr("lang", "en");
	}

}
