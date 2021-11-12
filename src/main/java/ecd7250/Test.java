//package ecd7250;
//
//import java.io.InputStream;
//import java.util.Collections;
//
//public class test {
//    @Override
//    public MediaModel createMediaForPointOfService(GJPointOfServiceMediaInfo mediaInfo, InputStream stream, String name, String contentType) {
//        MediaModel mediaModel;
//        CatalogVersionModel mediaCatalogVersion = getMediaCatalogVersion();
//        String mediaCode = mediaInfo.getMediaCode();
//
//        try {
//            mediaModel = mediaService.getMedia(mediaCatalogVersion, mediaCode);
//        } catch (UnknownIdentifierException | AmbiguousIdentifierException ignore) {
//            LOG.debug("Media by code " + mediaInfo.getGjPointOfServiceName() + " not found");
//            mediaModel = modelService.create(MediaModel.class);
//            mediaModel.setCode(mediaCode);
//            mediaModel.setCatalogVersion(mediaCatalogVersion);
//        }
//        mediaModel.setFolder(mediaService.getFolder(gjPosFolder));
//        mediaModel.setMediaFormat(mediaService.getFormat(SYSTEM_FORMAT_CODE));
//        LOG.info("mediaModel under save : "  + mediaModel.getFolder() + " " + mediaModel.getMediaFormat()+ " " + mediaModel.getPk());
//        modelService.save(mediaModel);
//        LOG.info("mediaModel upper save : "  + mediaModel.getFolder() + " " + mediaModel.getMediaFormat() + " " + mediaModel.getPk());
//        mediaService.setStreamForMedia(mediaModel, stream, name, contentType);
//        LOG.info("mediaModel upper setStreamForMedia() : "  + mediaModel.getFolder() + " " + mediaModel.getMediaFormat() + " " + mediaModel.getPk());
//        MediaContainerModel mediaContainer = mediaModel.getMediaContainer();
////        if (mediaContainer != null) {
////            mediaConversionService.deleteConvertedMedias(mediaContainer);
////            LOG.info("mediaContainer under save : "  + mediaContainer.getName() + " " + mediaContainer.getPosImageConversionStatus() + " " + mediaContainer.getPk());
////            mediaContainer.setPosImageConversionStatus(POSImageConversionStatus.UNCONVERTED);
////            modelService.save(mediaContainer);
////            LOG.info("mediaContainer upper save : "  + mediaContainer.getName() + " " + mediaContainer.getPosImageConversionStatus()+ " " + mediaContainer.getPk());
////        } else {
//        mediaConversionService.deleteConvertedMedias(mediaContainer);
//        mediaContainer = new MediaContainerModel();
//        mediaContainer.setQualifier(mediaModel.getCode());
//        mediaContainer.setCatalogVersion(mediaModel.getCatalogVersion());
//        mediaContainer.setConversionGroup(findPosConversionGroup());
//        mediaContainer.setPosImageConversionStatus(POSImageConversionStatus.UNCONVERTED);
//        modelService.save(mediaContainer);
//        LOG.info("NEW mediaContainer under save : "  + mediaContainer.getName() + " " + mediaContainer.getPosImageConversionStatus());
//        modelService.save(mediaContainer);
//        LOG.info("NEW mediaContainer upper save : "  + mediaContainer.getName() + " " + mediaContainer.getPosImageConversionStatus());
//
//        gjMediaContainerService.addMediaToContainer(mediaContainer, Collections.singletonList(mediaModel));
////        }
//        LOG.info("mediaModel under refresh : "  + mediaModel.getFolder() + " " + mediaModel.getMediaFormat()+ " " + mediaModel.getPk());
//        modelService.refresh(mediaModel);
//        LOG.info("mediaModel upper refresh : "  + mediaModel.getFolder() + " " + mediaModel.getMediaFormat()+ " " + mediaModel.getPk());
//        return mediaModel;
//    }
//}
