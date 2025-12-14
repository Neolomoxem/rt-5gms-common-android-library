package com.fivegmag.a5gmscommonlibrary.qoeMetricsReporting

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText

/**
 * Wrapper for the InitialPlayoutDelay metric value.
 * Per TS 26.247, this must appear inside a QoeMetric element.
 */
data class InitialPlayoutDelay(
    @field:JacksonXmlText
    val value: Long
)
