Overview
========

An [Apache Tika](http://tika.apache.org/) parser which uses the 
[FFmpeg](https://www.ffmpeg.org/) command-line tool to extract metadata
from audio and video files.

The metadata is reported using part of the [PBCore 2.0 specification](http://www.pbcore.org/schema/)
in an XPath-like syntax, i.e.:

    pbcore:instantiationDuration=00:00:01.07
    pbcore:instantiationDataRate=362 kb/s
    pbcore:instantiationEssenceTrack[0]/pbcore:essenceTrackType=Video
    pbcore:instantiationEssenceTrack[0]/pbcore:essenceTrackDataRate=215 kb/s
    pbcore:instantiationEssenceTrack[0]/pbcore:essenceTrackEncoding=h264
    pbcore:instantiationEssenceTrack[0]/pbcore:essenceTrackFrameSize=480x270
    pbcore:instantiationEssenceTrack[0]/pbcore:essenceTrackFrameRate=29.97 fps
    pbcore:instantiationEssenceTrack[1]/pbcore:essenceTrackType=Audio
    pbcore:instantiationEssenceTrack[1]/pbcore:essenceTrackDataRate=46 kb/s
    pbcore:instantiationEssenceTrack[1]/pbcore:essenceTrackEncoding=aac
    pbcore:instantiationEssenceTrack[1]/pbcore:essenceTrackSamplingRate=22050 Hz