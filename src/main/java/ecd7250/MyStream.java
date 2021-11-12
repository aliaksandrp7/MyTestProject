package ecd7250;

import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import org.springframework.util.StreamUtils;

import javax.imageio.ImageIO;


public class MyStream {
    public static void main(String[] args) {
        List<UploadMediaData> results = new ArrayList<>();

        try (ZipInputStream zin = new ZipInputStream(new FileInputStream("/home/alexander/LIGA/Gloria_Tasks/7250/7250.zip"))) {
            ZipEntry entry;
            String name;
            long size;
            UploadMediaData data = null;
//        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            while ((entry = zin.getNextEntry()) != null) {
                name = entry.getName(); // получим название файла
                size = entry.getSize();  // получим его размер в байтах
                System.out.printf("File name: %s \t File size: %d \n", name, size);

                String fileName = Paths.get(entry.getName()).getFileName().toString();

                File tempFile = File.createTempFile("temp", null);
                System.out.println("size1 = " + tempFile.length());
                ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(tempFile));
                ZipEntry newEntry = new ZipEntry(entry);
                zout.putNextEntry(newEntry);
                FileInputStream fis= new FileInputStream(tempFile);
                System.out.println("size2 = " + tempFile.length());
                // считываем содержимое файла в массив byte
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                // добавляем содержимое к архиву
                zout.write(buffer);
                // закрываем текущую запись для новой записи
                zout.closeEntry();

                ZipInputStream newZin = new ZipInputStream(new FileInputStream(tempFile));
                for (ZipEntry e; (e = newZin.getNextEntry()) != null;) {
                    if (e.getName().equals(newEntry)) {

                    }
                }
                System.out.println(newZin.available());

                BufferedImage image;
                image = ImageIO.read(newZin);
                System.out.println("size: " + (image.getWidth() >= 740 && image.getHeight() >= 740));

// сделать копию ентри файла - сделать файл из ентри - получить изображение из файла
                data = new UploadMediaData(StreamUtils.nonClosing(zin), fileName, "application/octet-stream");

                if (data.getMediaStream().markSupported()) {
                    System.out.println("data markSupported");
                    InputStream inputStream = data.getMediaStream();
                    inputStream.mark(0);
                    BufferedImage bi;
                    try {
                        bi = ImageIO.read(inputStream);
                        inputStream.reset();
                        System.out.println(bi.getWidth() >= 740 && bi.getHeight() >= 740);
                    } catch (IOException e) {
                        System.out.println("media is not correct");
                    }
                } else {
                    System.out.println("data не поддерживает markSupported");
                    InputStream is = new ByteArrayInputStream(IOUtils.toByteArray(data.getMediaStream()));
                    if (is.markSupported()) {
                        System.out.println("biFromZip.markSupported: " + is.markSupported());
                        is.mark(0);
                    }
                    File tempFileSec = File.createTempFile(fileName, null);
                    FileOutputStream fout = new FileOutputStream(tempFileSec);
                    BufferedImage imageSec;

                    try {
                        byte[] tempBuffer = new byte[1024];
                        int bytesLen = 0;
                        while ((bytesLen = is.read(tempBuffer)) != -1) {
                            fout.write(tempBuffer, 0, bytesLen);
                        }
                        is.reset();
                        imageSec = ImageIO.read(tempFileSec);

                        System.out.println("size: " + (imageSec.getWidth() >= 740 && imageSec.getHeight() >= 740));
                    } catch (IOException e) {
                        System.out.println("media is not correct");
                    }

                }

                System.out.println("повторное использование ");
                InputStream inputStream = data.getMediaStream();
                BufferedImage bio;
                try {
                    bio = ImageIO.read(inputStream);
                    System.out.println(bio.getWidth() >= 740 && bio.getHeight() >= 740);
                } catch (IOException e) {
                    System.out.println("media is not correct");
                }

            }
            //////////////////////////////////////////////////////////////////////////////////////////////////
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
