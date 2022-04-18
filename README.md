# webp-io

The **webp-io** is convert normal image and `webp` file.

[![](https://img.shields.io/travis/hellokaton/webp-io.svg)](https://travis-ci.org/hellokaton/webp-io)
[![](https://img.shields.io/badge/license-Apache2-FF0080.svg)](https://github.com/biezhi/webp-io/blob/master/LICENSE)

## Usage

**Maven dependency**

```xml
<dependency>
    <groupId>com.hellokaton</groupId>
    <artifactId>webp-io</artifactId>
    <version>0.0.6</version>
</dependency>
```

**API**

```java
String src  = "a.webp";
String dest = "a.png";
WebpIO.create().toNormalImage(src, dest);

WebpIO.create().toWEBP("hello.png", "hello.webp");
```

Okay, lets go.

