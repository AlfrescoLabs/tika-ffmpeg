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
 * 
 * This work employs PBCore. PBCore, the Public Broadcasting Metadata Dictionary Project, 
 * was created by the public broadcasting community in the United States of America for 
 * use by public broadcasters and others. Development funding for PBCore was provided by 
 * the Corporation for Public Broadcasting. PBCore is built on the foundation of the 
 * Dublin Core (ISO 15836), an international standard for resource discovery. 
 * Copyright 2011, Corporation for Public Broadcasting.
 * 
 */
package org.apache.tika.metadata;

import java.text.MessageFormat;

/**
 * Essence track properties from the PBCore specification.
 * <p>
 * 
 * Note that the extension elements, instantiationPart, and many of the optional attributes are
 * not currently supported
 *
 * @see <a href="http://www.pbcore.org/v2/elements/pbcoredescriptiondocument/pbcoreinstantiation/instantiationessencetrack/">instantiationEssenceTrack</a>
 */
public class PBCore
{
    
    public static final String NAMESPACE_URI_PBCORE = "http://www.pbcore.org/PBCore/PBCoreNamespace.html";
    public static final String PREFIX_PBCORE = "pbcore";
    public static final String ELEMENT_INSTANTIATION_ESSENCE_TRACK_FORMAT = 
            PREFIX_PBCORE + ":instantiationEssenceTrack[{0}]/";
    public static final String ELEMENT_INSTANTIATION_RELATION_FORMAT = 
            PREFIX_PBCORE + ":instantiationRelation[{0}]/";
    public static final String ELEMENT_INSTANTIATION_RIGHTS_FORMAT = 
            PREFIX_PBCORE + ":instantiationRights[{0}]/";
    public static final String ELEMENT_INSTANTIATION_PART_FORMAT = 
            PREFIX_PBCORE + ":instantiationPart[{0}]/";

    /**
     * The instantiationIdentifier employs an unambiguous reference or identifier for a 
     * particular rendition/instantiation of a media item. Best practice is to identify the 
     * media item (whether analog or digital) by means of a string or number corresponding 
     * to an established or formal identification system if one exists. Otherwise, use an 
     * identification method that is in use within your agency, station, production company, 
     * office, or institution.
     */
    public static Property INSTANTIATION_IDENTIFIER = Property.internalText(
            PREFIX_PBCORE + ":instantiationIdentifier");
    
    /**
     * Attribute source provides the name of the authority used to declare data value of the element.
     */
    public static Property INSTANTIATION_IDENTIFIER_SOURCE = Property.internalText(
            PREFIX_PBCORE + ":instantiationIdentifier/@source");
    
    /**
     * The descriptor instantiationLocation is considered to be an address for a media item. 
     * For an organization or producer acting as caretaker of a media resource, 
     * instantiationLocation may contain information about a specific shelf location for an asset, 
     * including an organization’s name, departmental name, shelf ID and contact information. 
     * The instantiationLocation for a data file or web page may include domain, path, 
     * filename or html page.
     * 
     */
    public static Property INSTANTIATION_LOCATION = Property.internalText(
            PREFIX_PBCORE + ":instantiationLocation");
    
    
    /**
     * Use the descriptor instantiationDate to specify the creation date for a particular 
     * instantiation of a media item.
     */
    public static Property INSTANTIATION_DATE = Property.internalDate(
            PREFIX_PBCORE + ":instantiationDate");
    
    /**
     * The instantiationDimensions element specifies the visual dimensions to expect when 
     * rendering a particular instance of media.
     */
    public static Property INSTANTIATION_DIMENSIONS = Property.internalText(
            PREFIX_PBCORE + ":instantiationDimensions");
    
    /**
     * Use the descriptor instantiationPhysical to identify the format of a particular 
     * instantiation of a media item as it exists in an actual physical form that occupies 
     * physical space (e.g., a tape on a shelf), rather than as a digital file residing on a 
     * server or hard drive.
     */
    public static Property INSTANTIATION_PHYSICAL = Property.internalText(
            PREFIX_PBCORE + ":instantiationPhysical");
    
    /**
     * Use the descriptor instantiationDigital to identify the format of a particular 
     * instantiation of a media item as it exists in its digital form, i.e., as a digital 
     * file on a server or hard drive. Digital media formats may be expressed with formal 
     * Internet MIME types.
     */
    public static Property INSTANTIATION_DIGITAL = Property.internalText(
            PREFIX_PBCORE + ":instantiationDigital");
    
    /**
     * Use the descriptor instantiationStandard to identify the standard of a 
     * particular instantiation of a media item as it exists.
     */
    public static Property INSTANTIATION_STANDARD = Property.internalText(
            PREFIX_PBCORE + ":instantiationStandard");
    
    /**
     * The descriptor instantiationMediaType identifies the general, high level nature 
     * of the content of a media item. It uses categories that show how content is 
     * presented to an observer, e.g., as a sound, text or moving image.
     */
    public static Property INSTANTIATION_MEDIA_TYPE = Property.internalText(
            PREFIX_PBCORE + ":instantiationMediaType");
    
    /**
     * The descriptor instantiationGenerations identifies the particular use or manner 
     * in which an instantiation of a media item is used, e.g., Audio/Narration or 
     * Moving image/Backup master.
     */
    public static Property INSTANTIATION_GENERATIONS = Property.internalTextBag(
            PREFIX_PBCORE + ":instantiationGenerations");
    
    /**
     * Use the descriptor instantiationFileSize to indicate the storage requirements or 
     * file size of a digital media item. As a standard, express the file size in bytes.
     * 
     */
    public static Property INSTANTIATION_FILE_SIZE = Property.internalText(
            PREFIX_PBCORE + ":instantiationFileSize");
    
    /**
     * The descriptor instantiationTimeStart provides a time stamp for the beginning 
     * point of playback for a time-based media item, such as digital video or audio. 
     * Use in combination with instantiationDuration to identify a sequence or segment of a 
     * media item that has a fixed start time and end time.
     */
    public static Property INSTANTIATION_TIME_START = Property.internalText(
            PREFIX_PBCORE + ":instantiationTimeStart");
    
    /**
     * The descriptor instantiationDuration provides a timestamp for the overall length or 
     * duration of a time-based media item. It represents the playback time.
     */
    public static Property INSTANTIATION_DURATION = Property.internalText(
            PREFIX_PBCORE + ":instantiationDuration");
    
    /**
     * The descriptor instantiationDataRate expresses the amount of data in a digital media 
     * file that is encoded, delivered or distributed, for every second of time. Although 
     * optimal data rates are often dependent on the codec used to compress and encode a 
     * digital file, generally speaking, a larger data rate translates into a better quality 
     * playback experience (e.g., 56 kilobits/second is lesser quality than 1 megabit/second).
     */
    public static Property INSTANTIATION_DATA_RATE = Property.internalText(
            PREFIX_PBCORE + ":instantiationDataRate");
    
    /**
     * The descriptor instantiationColors indicates the overall color, grayscale, or black and 
     * white nature of a media item, as a single occurrence or combination of occurrences 
     * in or throughout the media item.
     */
    public static Property INSTANTIATION_COLORS = Property.internalText(
            PREFIX_PBCORE + ":instantiationColors");
    
    /**
     * The descriptor instantiationTracks is simply intended to indicate the number and 
     * type of tracks that are found in a media item, whether it is analog or digital. 
     * (e.g. 1 video track, 2 audio tracks, 1 text track, 1 sprite track, etc.) Other 
     * configuration information specific to these identified tracks should be described 
     * using instantiationChannelConfiguration.
     */
    public static Property INSTANTIATION_TRACKS = Property.internalText(
            PREFIX_PBCORE + ":instantiationTracks");
    
    /**
     * The descriptor instantiationChannelConfiguration is designed to indicate the arrangement 
     * or configuration of specific channels or layers of information within a media item’s tracks. 
     * Examples are 2-track mono, 8- track stereo, or video track with alpha channel.
     */
    public static Property INSTANTIATION_CHANNEL_CONFIGURATION = Property.internalText(
            PREFIX_PBCORE + ":instantiationChannelConfiguration");
    
    /**
     * The descriptor language identifies the primary language of a media item’s audio or text. 
     * Alternative audio or text tracks and their associated languages should be identified 
     * using the descriptor instantiationAlternativeModes.
     */
    public static Property INSTANTIATION_LANGUAGE = Property.internalText(
            PREFIX_PBCORE + ":instantiationLanguage");
    
    /**
     * The descriptor instantiationAlternativeModes is a catch-all metadata element that 
     * identifies equivalent alternatives to the primary visual, sound or textual information 
     * that exists in a media item. These are modes that offer alternative ways to see, hear, 
     * and read the content of a media item. Examples include DVI (Descriptive Video Information), 
     * SAP (Supplementary Audio Program), ClosedCaptions, OpenCaptions, Subtitles, Language Dubs, 
     * and Transcripts. For each instance of available alternativeModes, the mode and its 
     * associated language should be identified together, if applicable. Examples include 
     * ‘SAP in English,’ ‘SAP in Spanish,’ ‘Subtitle in French,’ ‘OpenCaption in Arabic.’
     */
    public static Property INSTANTIATION_ALTERNATIVE_MODES = Property.internalText(
            PREFIX_PBCORE + ":instantiationAlternativeModes");
    
    
    protected static Property getIndexedEssenceTrackProperty(int index, String elementName)
    {
        return Property.internalText(
                MessageFormat.format(ELEMENT_INSTANTIATION_ESSENCE_TRACK_FORMAT, index) +
                PREFIX_PBCORE + Metadata.NAMESPACE_PREFIX_DELIMITER + elementName);
    }
    
    /**
     * The essenceTrackType element is used to label the essence track by its type, 
     * e.g. video, audio etc.
     * 
     * @param index
     * @return the essenceTrackType
     */
    public static Property ESSENCE_TRACK_TYPE(int index)
    {
        return getIndexedEssenceTrackProperty(index, "essenceTrackType");
    }
    
    /**
     * The essenceTrackIdentifier element is used to identify the essence track and 
     * differentiate it from other tracks in the instantiation.
     * 
     * @param index
     * @return the essenceTrackIdentifier
     */
    public static Property ESSENCE_TRACK_IDENTIFIER(int index)
    {
        return getIndexedEssenceTrackProperty(index, "essenceTrackIdentifier");
    }
    
    /**
     * Use the descriptor essenceTrackStandard to identify a larger technical system/standard or 
     * overarching media architecture under which various media formats exist, e.g., NTSC is a 
     * system/standard under which many video formats exist.
     * 
     * @param index
     * @return the essenceTrackStandard
     */
    public static Property ESSENCE_TRACK_STANDARD(int index)
    {
        return getIndexedEssenceTrackProperty(index, "essenceTrackStandard");
    }
    
    /**
     * The descriptor essenceTrackEncoding identifies how the actual information in a media 
     * item is compressed, interpreted, or formulated using a particular scheme. 
     * Identifying the encoding used is beneficial for a number of reasons, including as a 
     * way to achieve reversible compression; for the construction of document indices to 
     * facilitate searching and access; or for efficient distribution of the information 
     * across data networks with differing bandwidths or pipeline capacities.
     * 
     * @param index
     * @return the essenceTrackEncoding
     */
    public static Property ESSENCE_TRACK_ENCODING(int index)
    {
        return getIndexedEssenceTrackProperty(index, "essenceTrackEncoding");
    }
    
    /**
     * The essenceTrackDataRate element expresses the amount of data in a digital media 
     * file that is encoded, delivered or distributed, for every second of time. Although 
     * optimal data rates are often dependent on the codec used to compress and encode a 
     * digital file, generally speaking, a larger data rate translates into a better 
     * quality playback experience, for example 56 kilobits/second vs. 1 megabit/second.
     * 
     * @param index
     * @return the essenceTrackDataRate
     */
    public static Property ESSENCE_TRACK_DATA_RATE(int index)
    {
        return getIndexedEssenceTrackProperty(index, "essenceTrackDataRate");
    }
    
    /**
     * The essenceTrackFrameRate element indicates the frames per second found in a video, 
     * motion sequence, flash file, or animation’s playback or display.
     * 
     * @param index
     * @return the essenceTrackFrameRate
     */
    public static Property ESSENCE_TRACK_FRAME_RATE(int index)
    {
        return getIndexedEssenceTrackProperty(index, "essenceTrackFrameRate");
    }
    
    /**
     * The essenceTrackPlaybackSpeed element specifies the rate of units against time 
     * at which the media track should be rendered for human consumption. e.g., 
     * 15ips (inches per second), 24fps (frames per second)
     * 
     * @param index
     * @return the essenceTrackPlaybackSpeed
     */
    public static Property ESSENCE_TRACK_PLAYBACK_SPEED(int index)
    {
        return getIndexedEssenceTrackProperty(index, "essenceTrackPlaybackSpeed");
    }
    
    /**
     * For a media item (specifically audio), the descriptor essenceTrackSamplingRate measures 
     * How Often data is sampled when information is digitized. For a digital audio signal, 
     * the sampling rate is measured in kilohertz and is an indicator of the perceived playback 
     * quality of the media item (the higher the sampling rate, the greater the fidelity).
     * 
     * @param index
     * @return the essenceTrackSamplingRate
     */
    public static Property ESSENCE_TRACK_SAMPLING_RATE(int index)
    {
        return getIndexedEssenceTrackProperty(index, "essenceTrackSamplingRate");
    }
    
    /**
     * The essenceTrackBitDepth element specifies how much data is sampled when information 
     * is digitized, encoded, or converted for a media item (specifically, audio, video, or image). 
     * Bit depth is measured in bits and generally implies an arbitrary perception of quality 
     * during playback of a media item (the higher the bit depth, the greater the fidelity).
     * 
     * @param index
     * @return the essenceTrackBitDepth
     */
    public static Property ESSENCE_TRACK_BIT_DEPTH(int index)
    {
        return getIndexedEssenceTrackProperty(index, "essenceTrackBitDepth");
    }
    
    /**
     * The essenceTrackFrameSize element indicates the horizontal and vertical resolution 
     * of a format type. It may be expressed in pixels, pixels per inch, or in the case of 
     * ATSC digital TV, a combination of pixels measured horizontally vs. the number of 
     * pixels of image/resolution data stacked vertically (interlaced and progressive scan).
     * 
     * @param index
     * @return the essenceTrackFrameSize
     */
    public static Property ESSENCE_TRACK_FRAME_SIZE(int index)
    {
        return getIndexedEssenceTrackProperty(index, "essenceTrackFrameSize");
    }
    
    /**
     * The essenceTrackAspectRatio element indicates the ratio of horizontal to 
     * vertical proportions in the display of a static image or moving image.
     * 
     * @param index
     * @return the essenceTrackAspectRatio
     */
    public static Property ESSENCE_TRACK_ASPECT_RATIO(int index)
    {
        return getIndexedEssenceTrackProperty(index, "essenceTrackAspectRatio");
    }
    
    /**
     * The descriptor essenceTrackTimeStart provides a time stamp for the beginning point 
     * of playback for a time-based media item, such as digital video or audio. Use in 
     * combination with essenceTrackDuration to identify a sequence or segment of a media 
     * item that has a fixed start time and end time.
     * 
     * @param index
     * @return the essenceTrackTimeStart
     */
    public static Property ESSENCE_TRACK_TIME_START(int index)
    {
        return getIndexedEssenceTrackProperty(index, "essenceTrackTimeStart");
    }
    
    /**
     * The descriptor essenceTrackDuration provides a timestamp for the overall length or 
     * duration of a track. It represents the track playback time.
     * 
     * @param index
     * @return the essenceTrackDuration
     */
    public static Property ESSENCE_TRACK_DURATION(int index)
    {
        return getIndexedEssenceTrackProperty(index, "essenceTrackDuration");
    }
    
    /**
     * essenceTrackLanguage identifies the primary language of the tracks’ audio or text. 
     * Alternative audio or text tracks and their associated languages should be identified 
     * using the descriptor alternativeModes.
     * 
     * @param index
     * @return the essenceTrackLanguage
     */
    public static Property ESSENCE_TRACK_LANGUAGE(int index)
    {
        return getIndexedEssenceTrackProperty(index, "essenceTrackLanguage");
    }
    
    /**
     * The essenceTrackAnnotation element can store any supplementary information about a 
     * track or the metadata used to describe it. It clarifies element values, terms, 
     * descriptors, and vocabularies that may not be otherwise sufficiently understood.
     * 
     * @param index
     * @return the essenceTrackAnnotation
     */
    public static Property ESSENCE_TRACK_ANNOTATION(int index)
    {
        return getIndexedEssenceTrackProperty(index, "essenceTrackAnnotation");
    }
    
    protected static Property getIndexedRelationProperty(int index, String elementName)
    {
        return Property.internalText(
                MessageFormat.format(ELEMENT_INSTANTIATION_RELATION_FORMAT, index) +
                PREFIX_PBCORE + Metadata.NAMESPACE_PREFIX_DELIMITER + elementName);
    }
    
    /**
     * The descriptor instantiationRelationType identifies the type of intellectual 
     * content bond between a media item you are cataloging and some other related media item.
     * 
     * @param index
     * @return the instantiationRelationType
     */
    public static Property INSTANTIATION_RELATION_TYPE(int index)
    {
        return getIndexedRelationProperty(index, "instantiationRelationType");
    }
    
    public class PBCoreRelationType
    {
        public static final String INSTANTIATION_RELATION_TYPE_VALUE_CLONED_TO = 
                "http://pbcore.org/vocabularies/relationType%23cloned-to";
        public static final String INSTANTIATION_RELATION_TYPE_VALUE_DERIVED_FROM = 
                "http://pbcore.org/vocabularies/relationType%23derived-from";
        public static final String INSTANTIATION_RELATION_TYPE_VALUE_DUBBED_FROM = 
                "http://pbcore.org/vocabularies/relationType%23dubbed-to";
        public static final String INSTANTIATION_RELATION_TYPE_VALUE_FRAGMENTED_TO = 
                "http://pbcore.org/vocabularies/relationType%23fragmented-to";
        public static final String INSTANTIATION_RELATION_TYPE_VALUE_HAS_FORMAT = 
                "http://pbcore.org/vocabularies/relationType%23has-format";
        public static final String INSTANTIATION_RELATION_TYPE_VALUE_HAS_PART = 
                "http://pbcore.org/vocabularies/relationType%23has-part";
        public static final String INSTANTIATION_RELATION_TYPE_VALUE_HAS_VERSION = 
                "http://pbcore.org/vocabularies/relationType%23has-version";
        public static final String INSTANTIATION_RELATION_TYPE_VALUE_IS_CLONE_OF = 
                "http://pbcore.org/vocabularies/relationType%23is-clone-of";
        public static final String INSTANTIATION_RELATION_TYPE_VALUE_IS_DERIVATIVE_OF = 
                "http://pbcore.org/vocabularies/relationType%23is-derivative-of";
        public static final String INSTANTIATION_RELATION_TYPE_VALUE_IS_DUB_OF = 
                "http://pbcore.org/vocabularies/relationType%23is-dub-of";
        public static final String INSTANTIATION_RELATION_TYPE_VALUE_IS_FORMAT_OF = 
                "http://pbcore.org/vocabularies/relationType%23is-format-of";
        public static final String INSTANTIATION_RELATION_TYPE_VALUE_IS_FRAGMENT_OF = 
                "http://pbcore.org/vocabularies/relationType%23is-fragment-of";
        public static final String INSTANTIATION_RELATION_TYPE_VALUE_IS_PART_OF = 
                "http://pbcore.org/vocabularies/relationType%23is-part-of";
        public static final String INSTANTIATION_RELATION_TYPE_VALUE_IS_REFERENCED_BY = 
                "http://pbcore.org/vocabularies/relationType%23is-referenced-by";
        public static final String INSTANTIATION_RELATION_TYPE_VALUE_IS_REPLACED_BY = 
                "http://pbcore.org/vocabularies/relationType%23is-replaced-by";
        public static final String INSTANTIATION_RELATION_TYPE_VALUE_IS_REQUIRED_BY = 
                "http://pbcore.org/vocabularies/relationType%23is-required-by";
        public static final String INSTANTIATION_RELATION_TYPE_VALUE_IS_VERSION_OF = 
                "http://pbcore.org/vocabularies/relationType%23is-version-of";
        public static final String INSTANTIATION_RELATION_TYPE_VALUE_REFERENCES = 
                "http://pbcore.org/vocabularies/relationType%23references";
        public static final String INSTANTIATION_RELATION_TYPE_VALUE_REPLACES = 
                "http://pbcore.org/vocabularies/relationType%23replaces";
        public static final String INSTANTIATION_RELATION_TYPE_VALUE_REQUIRES = 
                "http://pbcore.org/vocabularies/relationType%23requires";
    }
    
    /**
     * Once the type of relationship between two media items is identified by using the 
     * descriptor instantiationRelationType, the companion descriptor 
     * instantiationRelationIdentifier is used to provide a name, locator, accession, 
     * identification number or ID where the related item can be obtained or found. The 
     * cross reference uses a unique identifier. The relationship could also describe a 
     * multi-part instantiation, such as a multi-disk DVD.
     * 
     * @param index
     * @return the instantiationRelationIdentifier
     */
    public static Property INSTANTIATION_RELATION_IDENTIFIER(int index)
    {
        return getIndexedRelationProperty(index, "instantiationRelationIdentifier");
    }
    
    protected static Property getIndexedRightsProperty(int index, String elementName)
    {
        String elementPrefix = "";
        if (!elementName.startsWith("@"))
        {
            elementPrefix = PREFIX_PBCORE + Metadata.NAMESPACE_PREFIX_DELIMITER;
        }
        return Property.internalText(
                MessageFormat.format(ELEMENT_INSTANTIATION_RIGHTS_FORMAT, index) +
                elementPrefix + elementName);
    }
    
    public static Property INSTANTIATION_RIGHTS_START_TIME(int index)
    {
        return getIndexedRightsProperty(index, "@startTime");
    }
    
    public static Property INSTANTIATION_RIGHTS_END_TIME(int index)
    {
        return getIndexedRightsProperty(index, "@endTime");
    }
    
    public static Property INSTANTIATION_RIGHTS_TIME_ANNOTATION(int index)
    {
        return getIndexedRightsProperty(index, "@timeAnnotation");
    }
    
    /**
     * Use the descriptor rightsSummary as an all-purpose container field to identify 
     * information about copyrights and property rights held in and over a media item, 
     * whether they are open access or restricted in some way. If dates, times and 
     * availability periods are associated with a right, include them. End user permissions, 
     * constraints and obligations may also be identified, as needed.
     * 
     * @param index
     * @return the rightsSummary
     */
    public static Property INSTANTIATION_RIGHTS_RIGHTS_SUMMARY(int index)
    {
        return getIndexedRightsProperty(index, "rightsSummary");
    }
    
    /**
     * A URI pointing to a declaration of rights
     * 
     * @param index
     * @return the rightsLink
     */
    public static Property INSTANTIATION_RIGHTS_RIGHTS_LINK(int index)
    {
        return getIndexedRightsProperty(index, "rightsLink");
    }
    
    /**
     * The rightsEmbedded element allows the inclusion of xml from another rights standard, 
     * e.g. ODRL, METS, etc. The included XML then defines the rights for the PBCore asset 
     * and/or PBCore instantiation.
     * 
     * @param index
     * @return the rightsEmbedded
     */
    public static Property INSTANTIATION_RIGHTS_RIGHTS_EMBEDDED(int index)
    {
        return getIndexedRightsProperty(index, "rightsEmbedded");
    }
    
    /**
     * The instantiationAnnotation element is used to catalog any supplementary information 
     * about an instantiation of the media item or the metadata used to describe it. It 
     * clarifies element values, terms, descriptors, and vocabularies that may not be otherwise 
     * sufficiently understood.
     */
    public static Property INSTANTIATION_ANNOTATION = Property.internalTextBag(
            PREFIX_PBCORE + ":instantiationAnnotation");
    
    protected static Property getIndexedPartProperty(int index, String elementName)
    {
        return Property.internalText(
                MessageFormat.format(ELEMENT_INSTANTIATION_RELATION_FORMAT, index) +
                PREFIX_PBCORE + Metadata.NAMESPACE_PREFIX_DELIMITER + elementName);
    }
    
}
