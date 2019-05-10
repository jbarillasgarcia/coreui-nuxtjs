package com.wau.genesis.jwtauthservice.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import javax.imageio.ImageIO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Josue Barillas (jbarillas)
 */
public class Base64Encoder {
    
    private Logger logger = LoggerFactory.getLogger(Base64Encoder.class);
    
    private static final String IMAGE_FILE = "/home/abarillas/Pictures/fat16clustersize.png";

    public static void main(String[] args) throws IOException {
        new Base64Encoder().doEncode(null);
    }
    
    public void doEncode(String input) throws IOException {
        BufferedImage image = ImageIO.read(new File(IMAGE_FILE));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "png", outputStream);
        
        logger.info("**************************************************************************");        
        logger.info(String.format("ENCODED = %s", Base64.getEncoder().encodeToString(outputStream.toByteArray())));
        logger.info("**************************************************************************");
    }

}
