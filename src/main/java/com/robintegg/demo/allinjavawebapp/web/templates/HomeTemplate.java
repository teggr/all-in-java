package com.robintegg.demo.allinjavawebapp.web.templates;

import static com.robintegg.j2html.bootstrap.BootstrapTagCreator.anchorButton;
import static com.robintegg.j2html.bootstrap.BootstrapTagCreator.container;
import static com.robintegg.j2html.bootstrap.BootstrapTagCreator.jumbotron;

import java.util.Map;

import com.robintegg.j2html.bootstrap.AnchorButton;
import com.robintegg.j2html.bootstrap.ContainerComponent;

import j2html.tags.ContainerTag;

public class HomeTemplate extends DefaultPageTemplate {

    @Override
    protected ContainerTag configureBody(ContainerTag body, Map<String, Object> model) {

        AnchorButton actionButton = anchorButton()
                .withHref("/register")
                .withPrimary()
                .withLarge()
                .withText("Learn more");

        ContainerComponent c1 = container().with(jumbotron()
                .withHeader("Hello, World.")
                .withSubHeader("This is a simple hero unit")
                .withSeparator()
                .withText("It uses utility classes")
                .with(actionButton));

        return body.with(c1);

    }

}
