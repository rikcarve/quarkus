package ch.carve.quarkus;

import java.io.File;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;

public class Main {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        String path = "/C:/Users/rik/.m2/repository/io/quarkus/arc/arc/0.20.0/arc-0.20.0.jar";
//        String path = "C:\\Users\\rik\\.m2\\repository\\io\\quarkus\\arc\\arc\\0.20.0\\arc-0.20.0.jar";
        URL url = new File(URLDecoder.decode(path, StandardCharsets.UTF_8.name())).toURL();
        System.out.println(url.getPath());
        String s = new File(URLDecoder.decode(url.getPath(), StandardCharsets.UTF_8.name())).getAbsolutePath();
        System.out.println(s);
        Set<File> set = new HashSet<>();
        File file = new File(s);
        set.add(file);

        System.out.println(file.getPath());
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        DiagnosticCollector<JavaFileObject> diagnosticListener = new DiagnosticCollector<>();
        StandardJavaFileManager fm = compiler.getStandardFileManager(diagnosticListener, null, null);
        fm.setLocation(StandardLocation.CLASS_PATH, set);
    }

}
