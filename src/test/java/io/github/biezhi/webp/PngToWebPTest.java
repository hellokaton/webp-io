package io.github.biezhi.webp;

import org.junit.Test;

import java.io.File;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author jozsimezei
 * @date 2018/05/08
 */
public class PngToWebPTest extends BaseTest {

    @Test
    public void testConvertToWebp() {
        File src = new File(classPath() + "/polycode.png");
        File dest = new File("polycode.webp");

        WebpIO.create().toWEBP(src, dest);

        assertNotNull(dest);
        assertTrue(dest.exists());
        deleteTempFile("polycode.webp");
    }

}
