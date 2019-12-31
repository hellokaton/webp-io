package io.github.biezhi.webp;

import org.junit.Test;

import java.io.File;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author biezhi
 * @date 2017/10/2
 */
public class WebpToPngTest extends BaseTest {

    @Test
    public void testConvert() {
        File src  = new File(classPath() + "/heng.webp");
        File dest = new File("heng.png");

        WebpIO.create().toNormalImage(src, dest);

        assertNotNull(dest);
        assertTrue(dest.exists());
        deleteTempFile("heng.png");

    }

}
