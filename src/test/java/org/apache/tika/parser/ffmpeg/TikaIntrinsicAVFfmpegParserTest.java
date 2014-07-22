/*
 * Copyright (C) 2005-2014 Alfresco Software Limited.
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.tika.parser.ffmpeg;

import static org.junit.Assert.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.InputStream;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.PBCore;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.ToTextContentHandler;
import org.junit.Test;

public class TikaIntrinsicAVFfmpegParserTest
{
    private static final Log logger = LogFactory.getLog(TikaIntrinsicAVFfmpegParserTest.class);

    @Test
    public void testExtract() throws Exception
    {
        Parser parser = TikaIntrinsicAVFfmpegParserFactory.createInstance("ffmpeg");
        
        Metadata metadata = new Metadata();
        
        InputStream stream = this.getClass().getResourceAsStream("/test-documents/testMP4.mp4");
        
        parser.parse(stream, new ToTextContentHandler(), metadata, new ParseContext());
        
        // Pattern checking is done in a new Thread which must be allowed to finish
        Thread.sleep(500);
        
        assertEquals("00:00:01.07", metadata.get(PBCore.INSTANTIATION_DURATION));
        assertEquals("362 kb/s", metadata.get(PBCore.INSTANTIATION_DATA_RATE));
        
        assertEquals("Video", metadata.get(PBCore.ESSENCE_TRACK_TYPE(0)));
        assertEquals("h264", metadata.get(PBCore.ESSENCE_TRACK_ENCODING(0)));
        assertEquals("215 kb/s", metadata.get(PBCore.ESSENCE_TRACK_DATA_RATE(0)));
        assertEquals("29.97 fps", metadata.get(PBCore.ESSENCE_TRACK_FRAME_RATE(0)));
        assertEquals("480x270", metadata.get(PBCore.ESSENCE_TRACK_FRAME_SIZE(0)));
        assertEquals("16:9", metadata.get(PBCore.ESSENCE_TRACK_ASPECT_RATIO(0)));
        assertEquals("eng", metadata.get(PBCore.ESSENCE_TRACK_LANGUAGE(0)));
        
        assertEquals("Audio", metadata.get(PBCore.ESSENCE_TRACK_TYPE(1)));
        assertEquals("aac", metadata.get(PBCore.ESSENCE_TRACK_ENCODING(1)));
        assertEquals("46 kb/s", metadata.get(PBCore.ESSENCE_TRACK_DATA_RATE(1)));
        assertEquals("22050 Hz", metadata.get(PBCore.ESSENCE_TRACK_SAMPLING_RATE(1)));
        assertEquals("eng", metadata.get(PBCore.ESSENCE_TRACK_LANGUAGE(1)));
        
        for(String tikaKey : metadata.names()) 
        {
            logger.debug(tikaKey + "=" + metadata.get(tikaKey));
//            System.out.println(tikaKey + "=" + metadata.get(tikaKey));
        }
    }

}
