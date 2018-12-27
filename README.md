# webp-io

the **webp-io** is convert normal image and `webp` file.

[![](https://img.shields.io/travis/biezhi/webp-io.svg)](https://travis-ci.org/biezhi/webp-io)
[![](https://img.shields.io/badge/license-Apache2-FF0080.svg)](https://github.com/biezhi/webp-io/blob/master/LICENSE)

## Usage

**Maven dependency**

```xml
<dependency>
    <groupId>io.github.biezhi</groupId>
    <artifactId>webp-io</artifactId>
    <version>0.0.5</version>
</dependency>
```

**API**

```java
String src  = "a.webp";
String dest = "a.png";
WebpIO.create().toNormalImage(src, dest);
```

Okay, lets go.

