package com.robintegg.j2html.template;

import java.io.IOException;
import java.io.Writer;

public interface Writable {

    Writer writeTo(Writer out) throws IOException;

}
