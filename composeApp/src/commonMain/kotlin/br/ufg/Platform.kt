package br.ufg

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform