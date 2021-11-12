package ecd7250;

public class BadPractic {
    //    private boolean checkMinImageFormat(UploadMediaData mediaResult) {
//        InputStream inputStream = mediaResult.getMediaStream();
//        inputStream.mark(0);
//        BufferedImage bi;
//        try {
//            bi = ImageIO.read(mediaResult.getMediaStream());
//            inputStream.reset();
//            return bi.getWidth() >= uploadPhotoWidthLimit && bi.getHeight() >= uploadPhotoHeightLimit;
//        } catch (IOException e) {
//            LOG.error("media size is not correct", e);
//        }
//        return false;
//    }

//    private boolean checkMinImageFormat(Media media) {
//        InputStream inputStream = media.getStreamData();
//        inputStream.mark(0);
//        BufferedImage bi;
//        try {
//            bi = ImageIO.read(inputStream);
//            inputStream.reset();
//            return bi.getWidth() >= uploadPhotoWidthLimit && bi.getHeight() >= uploadPhotoHeightLimit;
//        } catch (IOException e) {
//            LOG.error("media size is not correct", e);
//        }
//        return false;
//    }

//    private boolean checkMinImageFormat(InputStream inputStream) {
//
//
//        try {
//            if (mediaResult.getMediaStream().available() > 0) {
//
//                if (mediaResult.getMediaStream().markSupported()) {
//                    InputStream inputStream = mediaResult.getMediaStream();
//                    inputStream.mark(0);
//                    BufferedImage bi;
//                    try {
//                        bi = ImageIO.read(inputStream);
//                        inputStream.reset();
//                        return bi.getWidth() >= uploadPhotoWidthLimit && bi.getHeight() >= uploadPhotoHeightLimit;
//                    } catch (IOException e) {
//                        LOG.error("media is not correct", e);
//                    }
//                } else {
//
//                    try {
////                        BufferedInputStream biZip = new BufferedInputStream(mediaResult.getMediaStream());
//
////                        ByteArrayInputStream bais = new ByteArrayInputStream(IOUtils.toByteArray(StreamUtils.nonClosing(mediaResult.getMediaStream())));
//                        InputStream is = new ByteArrayInputStream(IOUtils.toByteArray(StreamUtils.nonClosing(mediaResult.getMediaStream())));
//
//                        is.mark(0);
//                        BufferedImage bim;
//                        try {
//                            bim = ImageIO.read(is);
//                            is.reset();
//                            return bim.getWidth() >= uploadPhotoWidthLimit && bim.getHeight() >= uploadPhotoHeightLimit;
//                        } catch (IOException e) {
//                            LOG.error("media is not correct", e);
//                        }
//
//
//                        ImageInputStream in = ImageIO.createImageInputStream(StreamUtils.nonClosing(mediaResult.getMediaStream()));
//                        final Iterator<ImageReader> readers = ImageIO.getImageReaders(in);
////                        in.reset();
//                        if (readers.hasNext()) {
//                            ImageReader reader = readers.next();
//                            try {
//                                reader.setInput(in);//true false
//                                int width = reader.getWidth(0);
//                                int height = reader.getHeight(0);
//                                return width >= uploadPhotoWidthLimit && height >= uploadPhotoHeightLimit;
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            } finally {
//                                reader.dispose();
//                            }
//                        }
//
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//
//
//                }
//
//
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return false;
//    }


//    private boolean checkMinZipImageFormat(InputStream mediaResult) {
//        try {
//            ImageInputStream in = ImageIO.createImageInputStream(StreamUtils.nonClosing(mediaResult));
//            final Iterator<ImageReader> readers = ImageIO.getImageReaders(in);
//            if (readers.hasNext()) {
//                ImageReader reader = readers.next();
//                try {
//                    reader.setInput(in); //true false | ff+ | tf+ | tt+ | ft+
//                    return reader.getWidth(0) >= uploadPhotoWidthLimit && reader.getHeight(0) >= uploadPhotoHeightLimit;
//                } catch (IOException e) {
//                    e.printStackTrace();
//                } finally {
//                    reader.dispose();
//                }
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }

//    private boolean checkMinZipImageFormat(ZipEntry mediaResult) {
//        try {
//            BufferedInputStream bufferedInputStream = new BufferedInputStream()
//            InputStream inputStream = new ByteArrayInputStream(mediaResult.getExtra());//!non
//            inputStream.mark(0);
//            BufferedImage bi;
//            bi = ImageIO.read(inputStream);
//            inputStream.reset();
//            return bi.getWidth() >= uploadPhotoWidthLimit && bi.getHeight() >= uploadPhotoHeightLimit;
//        } catch (IOException e) {
//            LOG.error("media size is not correct", e);
//        }
//        return false;
//    }

}
