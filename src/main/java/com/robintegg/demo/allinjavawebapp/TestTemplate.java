package com.robintegg.demo.allinjavawebapp;

import static com.robintegg.j2html.bootstrap.Components.alert;
import static com.robintegg.j2html.bootstrap.Containers.container;
import static com.robintegg.j2html.bootstrap.Grid.col;
import static com.robintegg.j2html.bootstrap.Grid.col3;
import static com.robintegg.j2html.bootstrap.Grid.row;
import static com.robintegg.j2html.bootstrap.MediaObject.mediaObject;
import static com.robintegg.j2html.bootstrap.MediaObject.mediaObjectList;
import static j2html.TagCreator.h1;

import java.util.Map;

import com.robintegg.j2html.template.J2HtmlTemplateSource;

import j2html.tags.ContainerTag;

public class TestTemplate implements J2HtmlTemplateSource {

	@Override
	public ContainerTag make(Map<String, Object> model) {
		return MainView.render(model,
				container(row(col3(h1("Hello, world!")), col()), row(col(mediaObject())), row(col(mediaObjectList()))),
				container(alert()));
	}

}
