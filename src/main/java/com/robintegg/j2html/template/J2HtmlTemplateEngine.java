package com.robintegg.j2html.template;

import static j2html.TagCreator.document;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Map;

import j2html.Config;
import j2html.tags.ContainerTag;

public class J2HtmlTemplateEngine {

	private final J2HtmlTemplateConfiguration templateConfiguration;
	private final J2HtmlTemplateResolver templateResolver;

	public J2HtmlTemplateEngine(J2HtmlTemplateConfiguration templateConfiguration) {
		this.templateConfiguration = templateConfiguration;
		this.templateResolver = new DefaultJ2HtmlTemplateResolver();
		this.templateResolver.configure(templateConfiguration);
		initConfig(templateConfiguration);
	}

	private void initConfig(J2HtmlTemplateConfiguration templateConfiguration) {
		Config.textEscaper = templateConfiguration.getTextEscaper();
		Config.cssMinifier = templateConfiguration.getCssMinifier();
		Config.jsMinifier = templateConfiguration.getJsMinifier();
		Config.indenter = templateConfiguration.getIndenter();
		Config.closeEmptyTags = templateConfiguration.isCloseEmptyTags();
	}

	public J2HtmlTemplateSource resolveTemplate(String templatePath) throws IOException {
		return templateResolver.resolveTemplate(templatePath);
	}

	public J2HtmlTemplate createTemplateByPath(String templatePath) throws ClassNotFoundException, IOException {

		J2HtmlTemplateSource source = templateResolver.resolveTemplate(templatePath);

		return new J2HtmlTemplate() {

			@Override
			public Writable make(Map<String, Object> model) {
				ContainerTag tag = source.make(model);
				return new StringWritable(document(tag));
			}

			@Override
			public Writable make() {
				return make(Collections.emptyMap());
			}

		};
	}

	public class DefaultJ2HtmlTemplateResolver implements J2HtmlTemplateResolver {

		private J2HtmlTemplateConfiguration configuration;

		@Override
		public void configure(J2HtmlTemplateConfiguration configuration) {
			this.configuration = configuration;
		}

		@Override
		public J2HtmlTemplateSource resolveTemplate(String templatePath) throws IOException {

			String replaceAll = templatePath.replaceAll("/", ".");

			try {
				Class<?> clazz = Class.forName(replaceAll);
				Constructor<?> constructor = clazz.getConstructor();
				return (J2HtmlTemplateSource) constructor.newInstance();
			} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
					| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
				throw new IOException(e);
			}

		}

	}

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

}
