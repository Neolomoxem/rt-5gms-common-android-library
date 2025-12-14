/*
License: 5G-MAG Public License (v1.0)
Author: Daniel Silhavy
Copyright: (C) 2023 Fraunhofer FOKUS
For full license terms please see the LICENSE file distributed with this
program. If this file is missing then the license can be retrieved from
https://drive.google.com/file/d/1cinCiA778IErENZ3JN52VFW-1ffHpx7Z/view
*/

package com.fivegmag.a5gmscommonlibrary.qoeMetricsReporting

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

/**
 * PlayList metric per TS 26.247 clause 10.2.7
 * Records the playback timeline including representation switches, seeks, rebuffering, and stop events.
 *
 * XSD Definition:
 * <xs:complexType name="PlayListType">
 *     <xs:choice>
 *         <xs:element name="Trace" maxOccurs="unbounded" type="PlayListEntryType" />
 *     </xs:choice>
 *     <xs:anyAttribute processContents="skip" />
 * </xs:complexType>
 */
data class PlayList(
    @field:JacksonXmlProperty(localName = "Trace")
    @field:JacksonXmlElementWrapper(useWrapping = false)
    val entries: ArrayList<PlayListEntry>
)

/**
 * PlayList entry (Trace element) per TS 26.247 clause 10.2.7
 * Represents a continuous playback session from a specific start point.
 *
 * XSD Definition:
 * <xs:complexType name="PlayListEntryType">
 *     <xs:choice>
 *         <xs:element name="TraceEntry" maxOccurs="unbounded" type="PlayListTraceEntryType" />
 *     </xs:choice>
 *     <xs:attribute name="start" type="xs:dateTime" use="required" />
 *     <xs:attribute name="mstart" type="xs:duration" use="required" />
 *     <xs:attribute name="startType" type="StartType" use="required" />
 *     <xs:anyAttribute processContents="skip" />
 * </xs:complexType>
 */
data class PlayListEntry(
    /** Real time when playback started (xs:dateTime format) */
    @field:JacksonXmlProperty(isAttribute = true)
    val start: String,

    /** Media time when playback started (xs:duration format, e.g., PT10.5S) */
    @field:JacksonXmlProperty(isAttribute = true)
    val mstart: String,

    /** Type of start event */
    @field:JacksonXmlProperty(isAttribute = true)
    val startType: StartType,

    /** List of trace entries within this playback session */
    @field:JacksonXmlProperty(localName = "TraceEntry")
    @field:JacksonXmlElementWrapper(useWrapping = false)
    val traceEntries: ArrayList<PlayListTraceEntry>
)

/**
 * PlayList trace entry per TS 26.247 clause 10.2.7
 * Records details about a specific segment of playback within a playlist entry.
 *
 * XSD Definition:
 * <xs:complexType name="PlayListTraceEntryType">
 *     <xs:attribute name="representationId" type="xs:string" use="optional" />
 *     <xs:attribute name="subrepLevel" type="xs:unsignedInt" use="optional" />
 *     <xs:attribute name="start" type="xs:dateTime" use="required" />
 *     <xs:attribute name="sstart" type="xs:duration" use="required" />
 *     <xs:attribute name="duration" type="xs:unsignedInt" use="required" />
 *     <xs:attribute name="playbackSpeed" type="xs:double" use="optional" />
 *     <xs:attribute name="stopReason" type="StopReasonType" use="optional" />
 *     <xs:attribute name="stopReasonOther" type="xs:string" use="optional" />
 *     <xs:anyAttribute processContents="skip" />
 * </xs:complexType>
 */
data class PlayListTraceEntry(
    /** Real time when this trace entry started (xs:dateTime format) */
    @field:JacksonXmlProperty(isAttribute = true)
    val start: String,

    /** Segment start time in media timeline (xs:duration format) */
    @field:JacksonXmlProperty(isAttribute = true)
    val sstart: String,

    /** Duration of playback in milliseconds */
    @field:JacksonXmlProperty(isAttribute = true)
    val duration: Long,

    /** Representation ID being played (optional) */
    @field:JacksonXmlProperty(isAttribute = true)
    val representationId: String? = null,

    /** Sub-representation level if applicable (optional) */
    @field:JacksonXmlProperty(isAttribute = true)
    val subrepLevel: Int? = null,

    /** Playback speed (1.0 = normal, optional) */
    @field:JacksonXmlProperty(isAttribute = true)
    val playbackSpeed: Double? = null,

    /** Reason for stopping playback (optional) */
    @field:JacksonXmlProperty(isAttribute = true)
    val stopReason: StopReasonType? = null,

    /** Custom stop reason if stopReason is OTHER (optional) */
    @field:JacksonXmlProperty(isAttribute = true)
    val stopReasonOther: String? = null
)

/**
 * Start type for PlayList entries per TS 26.247 clause 10.2.7
 * Indicates how playback was initiated.
 */
enum class StartType {
    /** New playback session started */
    NEW,
    /** Playback resumed after pause */
    RESUME,
    /** User performed a seek operation */
    SEEK,
    /** Other/unknown start type */
    OTHER
}

/**
 * Stop reason for PlayList trace entries per TS 26.247 clause 10.2.7
 * Indicates why playback stopped or paused.
 */
enum class StopReasonType {
    /** Representation switch occurred */
    REP_SWITCH,
    /** Rebuffering/stalling occurred */
    REBUFFERING,
    /** User initiated pause */
    USER_REQUEST,
    /** End of content reached */
    END_OF_CONTENT,
    /** End of Period in MPD */
    END_OF_PERIOD,
    /** End of a metrics collection period */
    METRICS_COLLECTION_PERIOD,
    /** Playback failure/error */
    FAILURE,
    /** Other reason (use stopReasonOther for details) */
    OTHER
}
