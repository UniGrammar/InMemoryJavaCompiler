package org.mdkt.compiler;

import java.io.IOException;
import java.net.URI;

import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;

/**
 * Created by trung on 5/3/15.
 */
public class SourceCode extends SimpleJavaFileObject {
	private String contents = null;
	private String className;

	public SourceCode(String className, String contents) throws Exception {
		super(URI.create("string:///" + className.replace('.', '/')
				+ JavaFileObject.Kind.SOURCE.extension), JavaFileObject.Kind.SOURCE);
		this.contents = contents;
		this.className = className;
	}

	public String getClassName() {
		return className;
	}

	@Override
	public CharSequence getCharContent(boolean ignoreEncodingErrors)
			throws IOException {
		return contents;
	}
}
