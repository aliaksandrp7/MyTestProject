package ecd7250;

import java.io.*;

public class TestBufferedInputStream
{
    public static void main(String[] args)
    {
        String fileName = "myFile";
        String text = "Hello world!";
        byte[] buffer = text.getBytes();
        ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
        File tempFile = null;

        try {
            tempFile = File.createTempFile(fileName, null);
            FileOutputStream fout = new FileOutputStream(tempFile);
            BufferedInputStream bis = new BufferedInputStream(bais);
            bis.mark(0);
            int c;
            while((c = bis.read()) != -1){
                System.out.println ((char)c);
            }
            bis.reset();
            int s;
            byte[] tempBuffer = new byte[1024];
            int bytesLen = 0;
            while ((bytesLen = bis.read(tempBuffer)) != -1) {
                fout.write(tempBuffer, 0, bytesLen);
            }

            System.out.println(tempBuffer.length);
            System.out.println(tempFile.length());

            fout.close();
            bais.close();
            if (fout!=null){
                fout.close();
            }

            bais.close();



        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
