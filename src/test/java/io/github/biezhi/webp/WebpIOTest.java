package io.github.biezhi.webp;

import org.junit.Test;

import java.io.File;

/**
 * @author biezhi
 * @date 2017/10/2
 */
public class WebpIOTest {

    @Test
    public void testConvert() throws Exception {
        File src = new File(WebpIOTest.class.getResource("/heng.webp").getPath());
//        System.out.println(src);
        File dest = new File("heng.png");

        WebpIO.toNormalImage(src, dest);

    }

    public static void main(String[] args) {
        String osName = System.getProperty("os.name"); //操作系统名称
        String osArch = System.getProperty("os.arch"); //操作系统构架
        System.out.println(osName.replace(" ", "") + "_" + osArch);
    }
}
