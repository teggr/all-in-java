package com.robintegg.demo.allinjavawebapp.web.templates;

import static com.robintegg.j2html.bootstrap.BootstrapTagCreator.col;
import static com.robintegg.j2html.bootstrap.BootstrapTagCreator.col3;
import static com.robintegg.j2html.bootstrap.BootstrapTagCreator.container;
import static com.robintegg.j2html.bootstrap.BootstrapTagCreator.mediaObject;
import static com.robintegg.j2html.bootstrap.BootstrapTagCreator.row;
import static j2html.TagCreator.h1;
import static j2html.TagCreator.input;

import java.util.Map;

import com.robintegg.j2html.bootstrap.ContainerComponent;
import com.robintegg.j2html.bootstrap.RowComponent;

import j2html.TagCreator;
import j2html.tags.ContainerTag;

public class RegisterHomeTemplate extends DefaultPageTemplate {

	@Override
	protected ContainerTag configureBody(ContainerTag body, Map<String, Object> model) {

		RowComponent row1 = row().withColumn(col3().with(h1("Register"))).withColumn(col());

		RowComponent row2 = row().withColumn(
				col().with(mediaObject("https://cdn0.iconfinder.com/data/icons/user-pictures/100/matureman1-64.png",
						"The second row", "This is the accompanying text")));

		ContainerTag form = TagCreator.form().withMethod("post").with(input().withType("text").withName("firstName"))
				.with(input().withType("text").withName("age")).with(input().withType("text").withName("lastName"))
				.with(input().withType("submit").withValue("Create user"));

		RowComponent row3 = row().withColumn(col().with(form));

		ContainerComponent c1 = container().with(row1, row2, row3);

		return body.with(c1);

	}

}
