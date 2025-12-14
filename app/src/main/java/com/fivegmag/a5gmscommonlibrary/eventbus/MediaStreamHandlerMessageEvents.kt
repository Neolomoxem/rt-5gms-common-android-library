/*
License: 5G-MAG Public License (v1.0)
Author: Daniel Silhavy
Copyright: (C) 2023 Fraunhofer FOKUS
For full license terms please see the LICENSE file distributed with this
program. If this file is missing then the license can be retrieved from
https://drive.google.com/file/d/1cinCiA778IErENZ3JN52VFW-1ffHpx7Z/view
*/

@file:Suppress("UnsafeOptInUsageError")

package com.fivegmag.a5gmscommonlibrary.eventbus

import android.telephony.CellInfo
import androidx.media3.exoplayer.analytics.AnalyticsListener.EventTime
import androidx.media3.exoplayer.source.LoadEventInfo
import androidx.media3.exoplayer.source.MediaLoadData

class DownstreamFormatChangedEvent(
    val eventTime: EventTime,
    val mediaLoadData: MediaLoadData
)

class PlaybackStateChangedEvent(
    val eventTime: EventTime,
    val playbackState: String
)

class LoadStartedEvent(
    val eventTime: EventTime,
    val loadEventInfo: LoadEventInfo,
    val mediaLoadData: MediaLoadData
)

class LoadCompletedEvent(
    val eventTime: EventTime,
    val loadEventInfo: LoadEventInfo,
    val mediaLoadData: MediaLoadData
)

class CellInfoUpdatedEvent(
    val cellInfoList: MutableList<CellInfo>
)

/**
 * Event fired when the first media segment fetch begins
 * Used for Initial Playout Delay QoE metric per TS 26.247 clause 10.2.5
 * Start time is measured from this event.
 */
class FirstMediaSegmentRequestedEvent(
    /** Elapsed real-time in milliseconds when the first media segment fetch started */
    val realtimeMs: Long
)

/**
 * Event fired when the first video frame is rendered after playback request
 * Used for Initial Playout Delay QoE metric per TS 26.247 clause 10.2.5
 * End time is measured from this event.
 */
class FirstFrameRenderedEvent(
    /** Elapsed real-time in milliseconds when the first frame was rendered */
    val realtimeMs: Long
)

/**
 * Event fired when the video display size changes (e.g., orientation change, fullscreen toggle)
 * Used for Device Information QoE metric per TS 26.247 clause 10.2.10
 */
class VideoSizeChangedEvent(
    val videoWidth: Int,
    val videoHeight: Int,
    val screenWidth: Int,
    val screenHeight: Int
)

