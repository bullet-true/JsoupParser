package org.example

import org.jsoup.Jsoup
import org.jsoup.nodes.Document

fun main() {
    println("Введите номер страницы, с которой хотите получить цитаты (всего 125 страниц):")
    val pageNumber = readln().toInt()
    println("ЦИТАТЫ СО СТРАНИЦЫ $pageNumber")
    
    val doc: Document =
        Jsoup.connect("https://mybook.ru/author/duglas-adams/avtostopom-po-galaktike-restoran-u-konca-vselennoj/citations/?page=$pageNumber")
            .get()

    val quotes = doc.select("div.sc-2aegk7-2.bzpNIu")

    quotes.forEachIndexed { index, quote ->
        println("${index + 1}. ${quote.text()}\n")
    }
}