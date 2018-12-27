package io.github.biezhi.webp;

import java.io.*;
import java.util.Objects;

/**
 * Webp converter
 *
 * @author biezhi
 * @date 2017/10/2
 */
public class WebpIO {

    /**
     * cwebp/dwebp/gif2webp
     * <p>
     * binary command file path
     */
    private static final String OS_NAME  = System.getProperty("os.name").toLowerCase();
    private static final String OS_ARCH  = System.getProperty("os.arch").toLowerCase();
    private static final String DEV_MODE = System.getProperty("webp-io.devMode", "false");

    private String commandDir;
    private String webpTmpDir = "cwebp_tmp";

    public WebpIO() {
        this.init();
    }

    private void init() {
        String osName   = getOsName();
        String webpPath = "cwebp/" + osName;

        if (Boolean.TRUE.toString().equals(DEV_MODE.toUpperCase())) {
            this.commandDir = WebpIO.class.getResource("/").getPath() + webpPath;
            return;
        }

        // copy to tmp dir
        File tmp = new File(webpTmpDir);
        if (!tmp.exists()) {
            tmp.mkdirs();
        }

        this.commandDir = tmp.getPath();

        String extension = getExtensionByOs(osName);

        InputStream dwebp    = getInputStream("/" + webpPath + "/dwebp" + extension);
        InputStream cwebp    = getInputStream("/" + webpPath + "/cwebp" + extension);
        InputStream gif2webp = getInputStream("/" + webpPath + "/gif2webp" + extension);

        try {
            copy(dwebp, new File(tmp.getPath() + "/dwebp" + extension));
            copy(cwebp, new File(tmp.getPath() + "/cwebp" + extension));
            copy(gif2webp, new File(tmp.getPath() + "/gif2webp" + extension));
        } catch (Exception e) {
            throw new WebpIOException(e);
        }
    }

    public static WebpIO create() {
        return new WebpIO();
    }

    private InputStream getInputStream(String subPath) {
        return WebpIO.class.getResourceAsStream(subPath);
    }

    /**
     * Converter webp file to normal image
     *
     * @param src  webp file path
     * @param dest normal image path
     */
    public void toNormalImage(String src, String dest) {
        toNormalImage(new File(src), new File(dest));
    }

    /**
     * Converter webp file to normal image
     *
     * @param src  webp file path
     * @param dest normal image path
     */
    public void toNormalImage(File src, File dest) {
        String command = commandDir + (dest.getName().endsWith(".gif") ? "/gif2webp" : "/dwebp ") + src.getPath() + " -o " + dest.getPath();
        this.executeCommand(command);
    }

    /**
     * Convert normal image to webp file
     *
     * @param src  nomal image path
     * @param dest webp file path
     */
    public void toWEBP(String src, String dest) {
        toWEBP(new File(src), new File(dest));
    }

    /**
     * Convert normal image to webp file
     *
     * @param src  nomal image path
     * @param dest webp file path
     */
    public void toWEBP(File src, File dest) {
        try {
            String command = commandDir + (src.getName().endsWith(".gif") ? "/gif2webp " : "/cwebp ") + src.getPath() + " -o " + dest.getPath();
            this.executeCommand(command);
        } catch (Exception e) {
            throw new WebpIOException(e);
        }
    }

    /**
     * execute command
     *
     * @param command command direct
     * @return
     */
    private String executeCommand(String command) {
        System.out.println("Execute: " + command);

        StringBuilder output = new StringBuilder();
        Process       p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String         line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
        } catch (Exception e) {
            throw new WebpIOException(e);
        }
        if (!"".equals(output.toString())) {
            System.out.println("Output: " + output);
        }
        return "";
    }

    /**
     * delete temp dir and commands
     */
    public void close() {
        File tmp = new File(webpTmpDir);
        if (tmp.exists() && tmp.isDirectory()) {
            File[] files = tmp.listFiles();
            for (File file : Objects.requireNonNull(files)) {
                file.delete();
            }
            tmp.delete();
        }
    }

    private void copy(InputStream in, File dest) throws IOException {
        OutputStream out    = new FileOutputStream(dest);
        byte[]       buffer = new byte[1024];
        int          length;
        //copy the file content in bytes
        while ((length = in.read(buffer)) > 0) {
            out.write(buffer, 0, length);
        }
        dest.setExecutable(true);
        in.close();
        out.close();
    }

    /**
     * get os name and arch
     *
     * @return
     */
    private String getOsName() {
        // windows
        if (OS_NAME.contains("win")) {
            boolean is64bit = (System.getenv("ProgramFiles(x86)") != null);
            return "windows_" + (is64bit ? "x86_64" : "x86");
        } else if (OS_NAME.contains("mac")) {
            // mac osx
            return "mac_" + OS_ARCH;
        } else if (OS_NAME.contains("nix") || OS_NAME.contains("nux") || OS_NAME.indexOf("aix") > 0) {
            // unix
            return "amd64".equalsIgnoreCase(OS_ARCH) ? "linux_x86_64" : "linux_" + OS_ARCH;
        } else {
            throw new WebpIOException("Hi boy, Your OS is not support!!");
        }
    }

    /**
     * Return the Os specific extension
     *
     * @param os: operating system name
     */
    private String getExtensionByOs(String os) {
        if (os == null || os.isEmpty()) return "";
        else if (os.contains("win")) return ".exe";
        return "";
    }

}
