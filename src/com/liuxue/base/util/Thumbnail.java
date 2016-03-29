package com.liuxue.base.util;

/**
 * 生成缩略图 
 * @author 李成龙
 *
 */

public class Thumbnail {
    /**
     *  在一个文件夹里图区图片并在另一个文件夹里创建缩略图
     * @param 原图地址
     * @param 缩略图地址
     * @param maxDim The width and height of
     * the thumbnail must
     * be maxDim pixels or less.
     */
    public static void createThumbnail(
            String srcPath, String thumbPath, int maxDim) {
        try {
            // Get the image from a file.
        	 Image inImage = null;
            if (srcPath.toLowerCase().endsWith(".bmp")) {
                inImage = getBMPImage(srcPath);
            } else {
                inImage = new ImageIcon(
                        srcPath).getImage();
            }

            // Determine the scale.
            double scale = maxDim / (
                    double) inImage.getHeight(null);
            if (inImage.getWidth(
                    null) > inImage.getHeight(null)) {
                scale = maxDim / (
                        double) inImage.getWidth(null);
            }

            // Determine size of new image.
            //One of them
            // should equal maxDim.
            int scaledW = (int) (
                    scale * inImage.getWidth(null));
            int scaledH = (int) (
                    scale * inImage.getHeight(null));

            // Create an image buffer in
            //which to paint on.
            BufferedImage outImage =
                    new BufferedImage(scaledW, scaledH,
                                      BufferedImage.TYPE_INT_RGB);

            // Set the scale.
            AffineTransform tx =
                    new AffineTransform();

            // If the image is smaller than
            // the desired image size,
            // don't bother scaling.
            if (scale < 1.0d) {
                tx.scale(scale, scale);
            }

            // Paint image.
            Graphics2D g2d =
                    outImage.createGraphics();
            g2d.drawImage(inImage, tx, null);
            g2d.dispose();

            // JPEG-encode the image
            //and write to file.
            OutputStream os =
                    new FileOutputStream(thumbPath);
            JPEGImageEncoder encoder =
                    JPEGCodec.createJPEGEncoder(os);
            encoder.encode(outImage);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据限定的宽度生成缩略图(会生成黑色背景)
     * @param srcPath String
     * @param thumbPath String
     * @param widthDim int
     */
    public static void createThumbnailLimitWidth(
            String srcPath, String thumbPath, int widthDim) {
        try {
            // Get the image from a file.
            Image inImage = null;
            if (srcPath.toLowerCase().endsWith(".bmp")) {
                inImage = getBMPImage(srcPath);
            } else {
                inImage = new ImageIcon(
                        srcPath).getImage();
            }
            // Determine the scale.
            double scale = widthDim / (double) inImage.getWidth(null);

            // Determine size of new image.
            //One of them
            // should equal maxDim.
            int scaledW = (int) (
                    scale * inImage.getWidth(null));
            int scaledH = (int) (
                    scale * inImage.getHeight(null));

            // Create an image buffer in
            // which to paint on.
            BufferedImage outImage =
                    new BufferedImage(scaledW, scaledH,
                                      BufferedImage.TYPE_INT_RGB);

            // Set the scale.
            AffineTransform tx = new AffineTransform();

            // If the image is smaller than
            // the desired image size,
            // don't bother scaling.
            // if (scale < 1.0d) {
                tx.scale(scale, scale);
            // }

            // Paint image.
            Graphics2D g2d =
                    outImage.createGraphics();
            g2d.drawImage(inImage, tx, null);
            g2d.dispose();

            // JPEG-encode the image
            //and write to file.
            OutputStream os =
                    new FileOutputStream(thumbPath);
            JPEGImageEncoder encoder =
                    JPEGCodec.createJPEGEncoder(os);
            encoder.encode(outImage);
            os.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取BMP图片
     * @param source String
     */
    private static Image getBMPImage(String source) throws Exception {
        FileInputStream fs = null;
        Image image = null;
        try {
            fs = new FileInputStream(source);
            int bfLen = 14;
            byte bf[] = new byte[bfLen];
            fs.read(bf, 0, bfLen); // 读取14字节BMP文件头
            int biLen = 40;
            byte bi[] = new byte[biLen];
            fs.read(bi, 0, biLen); // 读取40字节BMP信息头

            // 源图宽度
            int nWidth = ((bi[7] & 0xff) << 24) | ((bi[6] & 0xff) << 16) | ((bi[5] & 0xff) << 8) | bi[4] & 0xff;

            // 源图高度
            int nHeight = ((bi[11] & 0xff) << 24) | ((bi[10] & 0xff) << 16) | ((bi[9] & 0xff) << 8) | bi[8] & 0xff;

            // 位数
            int nBitCount = ((bi[15] & 0xff) << 8) | bi[14] & 0xff;

            // 源图大小
            int nSizeImage = ((bi[23] & 0xff) << 24) | ((bi[22] & 0xff) << 16) | ((bi[21] & 0xff) << 8) | bi[20] & 0xff;

            // 对24位BMP进行解析
            if (nBitCount == 24) {
                int nPad = (nSizeImage / nHeight) - nWidth * 3;
                int nData[] = new int[nHeight * nWidth];
                byte bRGB[] = new byte[(nWidth + nPad) * 3 * nHeight];
                fs.read(bRGB, 0, (nWidth + nPad) * 3 * nHeight);
                int nIndex = 0;
                for (int j = 0; j < nHeight; j++) {
                    for (int i = 0; i < nWidth; i++) {
                        nData[nWidth * (nHeight - j - 1) + i] = (255 & 0xff) << 24 | ((bRGB[nIndex + 2] & 0xff) << 16) | ((bRGB[nIndex + 1] & 0xff) << 8) | bRGB[nIndex] & 0xff;
                        nIndex += 3;
                    }
                    nIndex += nPad;
                }
                Toolkit kit = Toolkit.getDefaultToolkit();
                image = kit.createImage(new MemoryImageSource(nWidth, nHeight, nData, 0, nWidth));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fs != null) {
                try {
					fs.close();
				} catch (IOException e) {
            		e.printStackTrace();
				}
            }
        }
        return image;
    }
    
    public static void main(String[] args) {
    	createThumbnailLimitWidth("E:/universityMarketUploadImage/index/shiPin/untitled.bmp", 
    				"E:/universityMarketUploadImage/index/shiPin/untitled_suo.bmp",400);
	}
}
