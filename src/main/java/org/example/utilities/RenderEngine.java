package org.example.utilities;

import org.jetbrains.annotations.NotNull;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

public class RenderEngine {

    @NotNull
    public static TemplateEngine thymeleafEngine() {
        var resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix("/templates");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML");

        var engine = new TemplateEngine();
        engine.setTemplateResolver(resolver);
        return engine;
    }

}
