package myExeption;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchFiles {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, URISyntaxException {
        long startTime = System.currentTimeMillis();
        String path1 = "/home/alexander/projects/gloria_hybris";//25/19
        String path3 = "/home/alexander/projects/gloria_hybris/gj_store/hybris/bin/";//24/18
        String path33 = "/home/alexander/projects/gloria_hybris/gj_store/hybris/bin/";//24/18
        String path2 = "src/";
        String path4 = "/home/alexander/projects/gloria_hybris/dl_gj_store/hybris/bin/custom";//${HYBRIS_BIN_DIR} //0/0
        String path5 = path4.replace("dl_gj_store","gj_store");
        //path5 = path3 /home/alexander/projects/gloria_hybris/gj_store/hybris/bin/custom
        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current absolute path is: " + s);

        System.out.println(Paths.get(".").toAbsolutePath().normalize().toString());

//        URL resource = SearchFiles.class.getResource("kkk");
//        Paths.get(resource.toURI()).toFile();
//        System.out.println("");


//        Pattern patternDecorator = Pattern.compile("\\w*Decorator(?=\\])");
//        Pattern patternDecorator = Pattern.compile("(ru\\.)[^=]*Decorator(?=.*)");//24/18
        Pattern patternDecorator = Pattern.compile("(ru\\.)[^=;]*Decorator(?=.*)");//
//        \\S - непробельные символы * - 1 или более раз
//        Pattern patternTranslator = Pattern.compile("\\w*Translator(?=.*)");
        Pattern patternTranslator = Pattern.compile("(ru\\.)[^=;]*Translator(?=.*)");//ProductOnlineDateCellTranslator

        String nameDecorator = "Decorator";
        String nameTranslator = "Translator";
        SearchFiles searchFiles = new SearchFiles();

        List<String> decoratorList = searchFiles.find(path33, patternDecorator, nameDecorator);
        List<String> translatorList = searchFiles.find(path33, patternTranslator, nameTranslator);

        for (String el : decoratorList) {
            System.out.println(el);
        }
        System.out.println(decoratorList.size());
        System.out.println("___________________");

        for (String el : translatorList) {
            System.out.println(el);
        }
        System.out.println(translatorList.size());
        System.out.println("___________________");
        System.out.println("___________________");

//        List<String> testList = new ArrayList<>();
//        testList.add("MyExeption.PriceRowCurrencyDecorator");
//        testList.add("MyExeption.Europe1PricesTranslator");
//
//        for (String el : testList) {
//            Class<?> clazz = Class.forName(el);
//            Object data = clazz.newInstance();
//            System.out.println(data.getClass().toString()+ "  " +data);
//        }

        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) + "ms");
    }

    public List<String> find(String filePath, Pattern pattern, String name) {
        List<String> list = new ArrayList<>();
        try (
                Stream<Path> paths = Files.walk(Paths.get(filePath))) {
            paths
                    .filter(path -> Files.isRegularFile(path) && (path.toString().endsWith("xml") | path.toString().endsWith("impex")) )
                    .peek(path -> {
                        try {
                            try (BufferedReader br = new BufferedReader(new FileReader(path.toString()))) {
                                String line;
                                while ((line = br.readLine()) != null) {
                                    Matcher matcher = pattern.matcher(line);
//                                    while (line.contains(name) & matcher.find()) {
                                    while (!line.contains("<!--") && (line.contains(name) & matcher.find())) {
                                        list.add(matcher.group());
                                    }
                                }
                            }
                        } catch (IOException ioe) {
                            System.out.println("Error while opening the file !");
                        }
                    })
                    .count();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return list.stream().filter(el -> !el.startsWith(name)).distinct().sorted().collect(Collectors.toList());
    }

    public void create(List<String> list) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Object object = Class.forName(list.get(0));
        System.out.println(object.toString());
    }
}