package br.com.studies.storeapi.commons.extensions

import br.com.studies.storeapi.commons.text.EMPTY_OR_NULL_EMAIL_MESSAGE
import br.com.studies.storeapi.commons.text.MAIL_REGEX

fun String.isEmailInvalid(): Boolean = !Regex(MAIL_REGEX).matches(this)

fun String?.getNonNullValue(): String {
    return if (!this.isNullOrBlank()) this else throw IllegalArgumentException(EMPTY_OR_NULL_EMAIL_MESSAGE)
}
