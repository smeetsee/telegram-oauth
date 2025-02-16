package dev.schlaubi.telegram

import dev.schlaubi.envconf.Config
import dev.schlaubi.stdx.core.sha256

object Config : Config() {
    val BOT_USERNAME by getEnv("samplebot")
    val TELEGRAM_TOKEN by getEnv(transform = String::hashBinarySha256)
    // You can: pwgen -s 50 1
    val JWT_SECRET by getEnv("verrysecurenonsense")
    val URL by getEnv("http://localhost:8080")

    val OAUTH_REDIRECT_URIS by getEnv { it.split(",\\s*".toRegex()) }
    val OAUTH_CLIENT_ID by this
    val OAUTH_CLIENT_SECRET by this
}
