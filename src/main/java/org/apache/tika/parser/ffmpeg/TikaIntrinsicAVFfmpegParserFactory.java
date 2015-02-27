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

import java.util.HashMap;
import java.util.regex.Pattern;

import org.apache.tika.metadata.PBCore;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.external.WaitingExternalParser;

/**
 * Creates instances of {@link ExternalParser} configured for FFmpeg
 * and {@link PBCore} metadata.
 */
public class TikaIntrinsicAVFfmpegParserFactory
{
    private static final String FFMPEG_OPTIONS = "-i ${INPUT}";
    public static final int NUM_SUPPORTED_TRACKS = 4;
    private static final String STREAM_PREFIX_FORMAT = "#0[:\\.]";
    
    private TikaIntrinsicAVFfmpegParserFactory()
    {
    }
    
    /**
     * Creates an {@link ExternalParser} configured for FFmpeg which
     * parses into {@link PBCore} metadata.
     *  
     * @param runtimeFfmpegExecutable
     * @return the new Parser
     */
    public static Parser createInstance(String runtimeFfmpegExecutable)
    {
        WaitingExternalParser parser = new WaitingExternalParser();
        
        String[] command = new String[] { runtimeFfmpegExecutable + " " + FFMPEG_OPTIONS };
        
        HashMap<Pattern, String> extractionPatterns = new HashMap<Pattern, String>();
        
        extractionPatterns.put(
                Pattern.compile("Duration: (\\d+:\\d+:\\d+\\.?\\d?\\d?), "),
                PBCore.INSTANTIATION_DURATION.getName());
        extractionPatterns.put(
                Pattern.compile("Duration: .*bitrate: (\\d+ kb/s)"),
                PBCore.INSTANTIATION_DATA_RATE.getName());
        
        for (int i = 0; i < NUM_SUPPORTED_TRACKS; i++)
        {
            extractionPatterns.put(
                    Pattern.compile(STREAM_PREFIX_FORMAT + i + ".*: (\\w*):"),
                    PBCore.ESSENCE_TRACK_TYPE(i).getName());
// TODO
//            extractionPatterns.put(
//                    Pattern.compile(""),
//                    PBCore.ESSENCE_TRACK_IDENTIFIER(i).getName());
//            extractionPatterns.put(
//                    Pattern.compile(""),
//                    PBCore.ESSENCE_TRACK_STANDARD(i).getName());
            extractionPatterns.put(
                    Pattern.compile(STREAM_PREFIX_FORMAT + i + ".*: (\\w*)( \\(|,)"),
                    PBCore.ESSENCE_TRACK_ENCODING(i).getName());
            extractionPatterns.put(
                    Pattern.compile(STREAM_PREFIX_FORMAT + i + ".*, (\\d+ kb/s)"), 
                    PBCore.ESSENCE_TRACK_DATA_RATE(i).getName());
            extractionPatterns.put(
                    Pattern.compile(STREAM_PREFIX_FORMAT + i + ".*, (\\d+\\.?\\d+ fps)"), 
                    PBCore.ESSENCE_TRACK_FRAME_RATE(i).getName());
// TODO
//          extractionPatterns.put(
//          Pattern.compile(""),
//          PBCore.ESSENCE_TRACK_PLAYBACK_SPEED(i).getName());
            extractionPatterns.put(
                    Pattern.compile(STREAM_PREFIX_FORMAT + i + ".*, (\\d+ Hz)"), 
                    PBCore.ESSENCE_TRACK_SAMPLING_RATE(i).getName());
// TODO
//          extractionPatterns.put(
//          Pattern.compile(""),
//          PBCore.ESSENCE_TRACK_BIT_DEPTH(i).getName());
            extractionPatterns.put(
                    Pattern.compile(STREAM_PREFIX_FORMAT + i + ".*, (\\d+x\\d+)"), 
                    PBCore.ESSENCE_TRACK_FRAME_SIZE(i).getName());
            extractionPatterns.put(
                    Pattern.compile(STREAM_PREFIX_FORMAT + i + ".*DAR (\\d+:\\d+)]"), 
                    PBCore.ESSENCE_TRACK_ASPECT_RATIO(i).getName());
// TODO
//          extractionPatterns.put(
//          Pattern.compile(""),
//          PBCore.ESSENCE_TRACK_TIME_START(i).getName());
//          extractionPatterns.put(
//          Pattern.compile(""),
//          PBCore.ESSENCE_TRACK_DURATION(i).getName());
            extractionPatterns.put(
                    Pattern.compile(STREAM_PREFIX_FORMAT + i + "\\((\\w+)\\)"), 
                    PBCore.ESSENCE_TRACK_LANGUAGE(i).getName());
// TODO
//          extractionPatterns.put(
//          Pattern.compile(""),
//          PBCore.ESSENCE_TRACK_ANNOTATION(i).getName());
        }
        
        parser.setCommand(command);
        parser.setMetadataExtractionPatterns(extractionPatterns);
        
        return parser;
    }
    
}
