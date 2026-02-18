package com.fivegmag.a5gmscommonlibrary.qoeMetricsReporting

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText

/**
 * Wrapper for the PlayoutDelayforMediaStartup metric value.
 * Per TS 26.247, this must appear inside a QoeMetric element.
 * Note: lowercase 'f' in 'for' per the normative XML schema.
 */
data class PlayoutDelayforMediaStartup(
    @field:JacksonXmlText
    val value: Long
)
