/*
 * Copyright 2019 sethuraman.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.biezhi.webp;

/**
 *
 * @author sethuraman
 */
public class Example {
    
    public static void main(String[] args) {
        final String libPath = "";
        String src = "";
        String dest = "";
        
        // Still Works
        WebpIO.create().toWEBP(src, dest);
        
        // Copies cwebp lib to a custom Path
        WebpIO.create(libPath).toWEBP(src, dest);
    }
    
}
