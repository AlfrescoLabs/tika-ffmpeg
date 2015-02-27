/*
 * Copyright (C) 2005-2015 Alfresco Software Limited.
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
 * 
 * This work employs PBCore. PBCore, the Public Broadcasting Metadata Dictionary Project, 
 * was created by the public broadcasting community in the United States of America for 
 * use by public broadcasters and others. Development funding for PBCore was provided by 
 * the Corporation for Public Broadcasting. PBCore is built on the foundation of the 
 * Dublin Core (ISO 15836), an international standard for resource discovery. 
 * Copyright 2011, Corporation for Public Broadcasting.
 * 
 */
package org.apache.tika.parser.external;

import java.io.IOException;
import java.io.InputStream;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

/**
 * External parser that waits just a bit for the pattern matching
 * (done in a separate thread) to complete after the command-line
 * process has finished.
 */
public class WaitingExternalParser extends ExternalParserNew {

    private static final long serialVersionUID = -6609930740380464837L;
    
    @Override
    public void parse(
            InputStream stream, ContentHandler handler,
            Metadata metadata, ParseContext context)
            throws IOException, SAXException, TikaException {
        super.parse(stream, handler, metadata, context);
        // Pattern checking is done in a new Thread which must be allowed to finish
        waitForParserToFinish(super.stderrParser);
        waitForParserToFinish(super.stdoutParser);
    }

    private void waitForParserToFinish(Thread parser)
    {
        if (parser != null)
        {
            try 
            {
                System.out.println(System.currentTimeMillis() + " Waiting for parser.");
                parser.join();
                System.out.println(System.currentTimeMillis() + " Parser completed.");
            }
            catch (InterruptedException e)
            {
                // Do nothing
            }
        }
    }
}
