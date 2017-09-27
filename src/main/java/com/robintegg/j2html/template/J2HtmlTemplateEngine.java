package com.robintegg.j2html.template;

import static j2html.TagCreator.body;
import static j2html.TagCreator.h1;
import static j2html.TagCreator.img;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Map;

public class J2HtmlTemplateEngine {

    private final class StringWritable implements Writable {
        private String render;

        public StringWritable(String render) {
            this.render = render;
        }

        @Override
        public Writer writeTo(Writer writer) throws IOException {
            PrintWriter printWriter = new PrintWriter(writer);
            printWriter.write(render);
            printWriter.flush();
            return writer;
        }
    }

    public J2HtmlTemplateEngine(J2HtmlTemplateConfiguration templateConfiguration) {
        // TODO Auto-generated constructor stub
    }

    public void resolveTemplate(String url) throws IOException {
        // TODO Auto-generated method stub

    }

    public J2HtmlTemplate createTemplateByPath(String viewUrl) throws ClassNotFoundException {

        String render = body(h1("Heading!").withClass("example"), img().withSrc("img/hello.png")).render();

        return new J2HtmlTemplate() {

            @Override
            public Writable make(Map<String, Object> binding) {

                return new StringWritable(render);
            }

            @Override
            public Writable make() {

                return new StringWritable(render);
            }
        };
    }

}
