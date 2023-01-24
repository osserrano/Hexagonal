package org.xavrs.streaming.springboot3.domain.exception

open class ItemException(message: String) : RuntimeException(message)
class WrongReferenceException(message: String) : ItemException(message)
class WrongColorException(message: String) : ItemException(message)