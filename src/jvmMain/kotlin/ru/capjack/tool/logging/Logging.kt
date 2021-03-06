package ru.capjack.tool.logging

import org.slf4j.LoggerFactory
import org.slf4j.spi.LocationAwareLogger
import kotlin.reflect.KClass

actual object Logging {
	@JvmStatic
	actual fun getLogger(name: String): Logger {
		return wrap(LoggerFactory.getLogger(name))
	}
	
	@JvmStatic
	actual fun getLogger(clazz: KClass<out Any>): Logger {
		return wrap(LoggerFactory.getLogger(clazz.java))
	}
	
	@JvmStatic
	private fun wrap(logger: org.slf4j.Logger): Logger {
		return if (logger is LocationAwareLogger)
			AwareLoggerWrapper(logger)
		else
			DefaultLoggerWrapper(logger)
	}
}