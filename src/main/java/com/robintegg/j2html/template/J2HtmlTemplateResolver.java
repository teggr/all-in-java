package com.robintegg.j2html.template;

import java.io.IOException;

public interface J2HtmlTemplateResolver {

    void configure(J2HtmlTemplateConfiguration configuration);

    J2HtmlTemplateSource resolveTemplate(String templatePath) throws IOException;

}
