package org.example

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

fun main() {
    val doc: Document = Jsoup.connect("https://en.wikipedia.org/").get()
    //println(doc.title())

    val newsHeadLines: Elements = doc.select("#mp-itn b a")
    //println(newsHeadLines)

    for (headLine: Element in newsHeadLines) {
        println("${headLine.attr("title")}\n\t${headLine.absUrl("href")}")
    }
}