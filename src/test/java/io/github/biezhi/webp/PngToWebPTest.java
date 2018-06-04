package io.github.biezhi.webp;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author jozsimezei
 * @date 2018/05/08
 */
public class PngToWebPTest {

    @Test
    public void testConvertToWebp() throws IOException {
        File src = new File(PngToWebPTest.class.getResource("/polycode.png").getPath());
//        System.out.println(src);
        File dest = new File("polycode.webp");

        WebpIO.toWEBP(src, dest);
        WebpIO.close();
    }

    public static void main(String[] args) {
        String osName = System.getProperty("os.name");
        String osArch = System.getProperty("os.arch");
        System.out.println(osName.replace(" ", "") + "_" + osArch);
    }
}
