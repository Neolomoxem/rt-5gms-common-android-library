/*
License: 5G-MAG Public License (v1.0)
Author: Maximilian Rieger
Copyright: (C) 2024 Fraunhofer FOKUS
For full license terms please see the LICENSE file distributed with this
program. If this file is missing then the license can be retrieved from
https://drive.google.com/file/d/1cinCiA778IErENZ3JN52VFW-1ffHpx7Z/view
*/

package com.fivegmag.a5gmscommonlibrary.qoeMetricsReporting

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

/**
 * Represents SupplementQoEMetricType containing DeviceInformation
 * Based on 3GPP TS 26.247 clause 10.2.10
 */
data class SupplementQoeMetric(
    @field:JacksonXmlProperty(localName = "Entry")
    @field:JacksonXmlElementWrapper(useWrapping = false)
    val deviceInformation: DeviceInformation? = null
)

/**
 * Represents DeviceInformationType containing a list of DeviceInformationEntry
 */
data class DeviceInformation(
    @field:JacksonXmlProperty(localName = "Entry")
    @field:JacksonXmlElementWrapper(useWrapping = false)
    val entries: ArrayList<DeviceInformationEntry>
)

/**
 * Represents DeviceInformationEntryType with all required attributes
 * Based on XSD definition from 3GPP TS 26.247
 */
data class DeviceInformationEntry(
    @field:JacksonXmlProperty(isAttribute = true)
    val start: String,

    @field:JacksonXmlProperty(isAttribute = true)
    val mstart: String,

    @field:JacksonXmlProperty(isAttribute = true)
    val videoWidth: Int,

    @field:JacksonXmlProperty(isAttribute = true)
    val videoHeight: Int,

    @field:JacksonXmlProperty(isAttribute = true)
    val screenWidth: Int,

    @field:JacksonXmlProperty(isAttribute = true)
    val screenHeight: Int,

    @field:JacksonXmlProperty(isAttribute = true)
    val pixelWidth: Double,

    @field:JacksonXmlProperty(isAttribute = true)
    val pixelHeight: Double,

    @field:JacksonXmlProperty(isAttribute = true)
    val fieldOfView: Double
)
