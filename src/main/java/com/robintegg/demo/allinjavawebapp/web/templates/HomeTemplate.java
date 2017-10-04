package com.robintegg.demo.allinjavawebapp.web.templates;

import static com.robintegg.j2html.bootstrap.BootstrapTagCreator.anchorButton;
import static com.robintegg.j2html.bootstrap.BootstrapTagCreator.col;
import static com.robintegg.j2html.bootstrap.BootstrapTagCreator.container;
import static com.robintegg.j2html.bootstrap.BootstrapTagCreator.jumbotron;
import static com.robintegg.j2html.bootstrap.BootstrapTagCreator.mediaObject;
import static com.robintegg.j2html.bootstrap.BootstrapTagCreator.mediaObjectList;
import static com.robintegg.j2html.bootstrap.BootstrapTagCreator.row;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.robintegg.demo.allinjavawebapp.domain.User;
import com.robintegg.j2html.bootstrap.AnchorButton;
import com.robintegg.j2html.bootstrap.ContainerComponent;
import com.robintegg.j2html.bootstrap.MediaObjectListComponent;

import j2html.tags.ContainerTag;

public class HomeTemplate extends DefaultPageTemplate {

	@Override
	protected ContainerTag configureBody(ContainerTag body, Map<String, Object> model) {

		AnchorButton actionButton = anchorButton().withHref("/register").withPrimary().withLarge().withText("Register");

		ContainerComponent c1 = container()
				.with(jumbotron().withHeader("Hello, World.").withSubHeader("This is a simple registration form")
						.withSeparator().withText("Below is all the users.").with(actionButton));

		MediaObjectListComponent list = mediaObjectList();

		List<User> users = (List<User>) model.getOrDefault("users", Collections.emptyList());
		for (User user : users) {
			list.withMediaObject(mediaObject("", user.getFirstName(), String.valueOf(user.getAge())));
		}

		ContainerComponent c2 = container().with(row().withColumn(col().with(list)));

		return body.with(c1).with(c2);

	}

}
