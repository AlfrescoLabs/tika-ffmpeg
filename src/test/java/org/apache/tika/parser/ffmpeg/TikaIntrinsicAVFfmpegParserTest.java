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
    public void testExtractMp4() throws Exception
    {
        Parser parser = TikaIntrinsicAVFfmpegParserFactory.createInstance("ffmpeg");
        
        Metadata extractedMetadata = new Metadata();
        Metadata metadata = new Metadata();
        
        String testFilePath = "/test-documents/testMP4.mp4";
        
        InputStream stream = this.getClass().getResourceAsStream(testFilePath);
        
        parser.parse(stream, new ToTextContentHandler(), extractedMetadata, new ParseContext());
        
        // Immediately copy to avoid polluting our test of timing with assertions or logging
        for (String tikaKey : extractedMetadata.names()) 
        {
            metadata.add(tikaKey, extractedMetadata.get(tikaKey));
        }
        
        // Let's see what we've got
        for (String copyKey : metadata.names()) {
            logger.debug("(" + testFilePath + ") " + copyKey + "=" + metadata.get(copyKey));
        }
        
        String duration = metadata.get(PBCore.INSTANTIATION_DURATION);
        assertNotNull("Duration was null", duration);
        // Last digit may vary on FFmpeg version
        assertTrue("Expected duration to start with 00:00:01.0",
                duration.startsWith("00:00:01.0"));
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
    }
    
    @Test
    public void testExtractMov() throws Exception
    {
        for (int i = 0; i < 1000; i ++)
        {
            System.out.println("i=" + i);
            testExtractMovImpl();
            Thread.sleep((long) (Math.random() * 10)); 
        }
    }
    
    public void testExtractMovImpl() throws Exception
    {
        Parser parser = TikaIntrinsicAVFfmpegParserFactory.createInstance("ffmpeg");
        
        Metadata extractedMetadata = new Metadata();
        Metadata metadata = new Metadata();
        
        String testFilePath = "/test-documents/testMOV.mov";
        
        InputStream stream = this.getClass().getResourceAsStream(testFilePath);
        
        parser.parse(stream, new ToTextContentHandler(), extractedMetadata, new ParseContext());
        
        // Immediately copy to avoid polluting our test of timing with assertions or logging
        for (String tikaKey : extractedMetadata.names()) 
        {
            metadata.add(tikaKey, extractedMetadata.get(tikaKey));
        }
        
        // Let's see what we've got
        for(String tikaKey : metadata.names()) 
        {
            logger.debug("(" + testFilePath + ") " + tikaKey + "=" + metadata.get(tikaKey));
        }

        System.out.println("Printing extractedMetadata after calling parse and before asserting. \n" + extractedMetadata);
        System.out.println("Done printing extractedMetadata object.");
        
        System.out.println("Printing metadata after calling parse and before asserting. \n" + metadata);
        System.out.println("Done printing metadata object.");
        
        String duration = metadata.get(PBCore.INSTANTIATION_DURATION);
//        if (duration == null) 
//            System.out.println("Duration was null");
//        else
//        {
        // Last digit may vary on FFmpeg version
        assertTrue("Expected duration to start with 00:00:01.0",
                duration.startsWith("00:00:01.0"));
//        }
        assertEquals("Video", metadata.get(PBCore.ESSENCE_TRACK_TYPE(0)));
        assertEquals("h264", metadata.get(PBCore.ESSENCE_TRACK_ENCODING(0)));
        assertEquals("29.97 fps", metadata.get(PBCore.ESSENCE_TRACK_FRAME_RATE(0)));
        assertEquals("480x270", metadata.get(PBCore.ESSENCE_TRACK_FRAME_SIZE(0)));
        assertEquals("eng", metadata.get(PBCore.ESSENCE_TRACK_LANGUAGE(0)));
        
        assertEquals("Audio", metadata.get(PBCore.ESSENCE_TRACK_TYPE(1)));
        assertEquals("pcm_s16le", metadata.get(PBCore.ESSENCE_TRACK_ENCODING(1)));
        assertEquals("48000 Hz", metadata.get(PBCore.ESSENCE_TRACK_SAMPLING_RATE(1)));
        assertEquals("eng", metadata.get(PBCore.ESSENCE_TRACK_LANGUAGE(1)));
        
        assertEquals("Audio", metadata.get(PBCore.ESSENCE_TRACK_TYPE(2)));
        assertEquals("pcm_s16le", metadata.get(PBCore.ESSENCE_TRACK_ENCODING(2)));
        assertEquals("48000 Hz", metadata.get(PBCore.ESSENCE_TRACK_SAMPLING_RATE(2)));
        assertEquals("eng", metadata.get(PBCore.ESSENCE_TRACK_LANGUAGE(2)));
        
        assertEquals("Subtitle", metadata.get(PBCore.ESSENCE_TRACK_TYPE(3)));
        assertEquals("eia_608", metadata.get(PBCore.ESSENCE_TRACK_ENCODING(3)));
        assertEquals("eng", metadata.get(PBCore.ESSENCE_TRACK_LANGUAGE(3)));
    }

}
