package ecd7250;

import java.io.InputStream;

public class UploadMediaData {
    private InputStream mediaStream;
    private String filePath;
    private String contentType;

    public UploadMediaData(InputStream mediaStream, String filePath, String contentType) {
        this.mediaStream = mediaStream;
        this.filePath = filePath;
        this.contentType = contentType;
    }

    public InputStream getMediaStream() {
        return mediaStream;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getContentType() {
        return contentType;
    }
}

