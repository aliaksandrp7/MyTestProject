package velocityJson;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.json.JSONArray;

import java.io.StringWriter;
import java.util.Arrays;

public class Data {
    public static void main(String[] args) {
        String res ="/home/alexander/projects/MyTestProject/src/main/java/velocityJson/jsontemplates/package.json";

        VelocityEngine vEngine = new VelocityEngine();
//Set velocity class loader as to refer templates from resources directory.
        vEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        vEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());

//Initialize the Velocity runtime engine
        vEngine.init();

        Template t = vEngine.getTemplate(res);
        VelocityContext ctx = new VelocityContext();
        ctx.put("firstName", "testing");
        ctx.put("lastName", "Mag");
        ctx.put("street", "");
        ctx.put("city", "");
        ctx.put("state", "");
        ctx.put("country", "");
        ctx.put("role", new JSONArray(Arrays.asList("admin","contributor")));
        ctx.put("email","admin@testingmag.in");
        ctx.put("mobile", "");

// Merges a template and puts the rendered stream into the writer
        StringWriter wrt = new StringWriter();
        t.merge(ctx, wrt);

        System.out.print(wrt.toString());
    }
}
