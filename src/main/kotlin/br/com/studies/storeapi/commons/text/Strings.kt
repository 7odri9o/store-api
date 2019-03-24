package br.com.studies.storeapi.commons.text

const val MAIL_REGEX = ("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
        + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
        + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
        + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$")

internal const val EMPTY_OR_NULL_EMAIL_MESSAGE = "Email cannot be empty or null"
internal const val EMAIL_NOT_REGISTERED_MESSAGE = "Email Not Registered"
internal const val EMAIL_MUST_BE_VALID = "Email must be valid"
internal const val USER_NOT_FOUND_MESSAGE = "User Not Found"
internal const val USER_FOUND_MESSAGE = "User Found"
internal const val USER_CREATED = "User Created"
internal const val STATUS_SUCCESS = "success"
internal const val INVALID_PAYLOAD = "Invalid Payload"
internal const val INVALID_QUERY_STRING = "Invalid Query String"