package ru.capjack.kt.logging

import kotlin.test.Test
import kotlin.test.assertEquals

class TestLogging {
	
	@Test
	fun getLoggerPassesNoErrors() {
		Logging.getLogger("foo.bar")
		Logging.getLogger(StubClass::class)
		Logging.getLogger<StubClass>()
	}
	
	@Test
	fun getLoggerByNameReturnsEqualObjects() {
		val a = Logging.getLogger("foo.bar")
		val b = Logging.getLogger("foo.bar")
		
		assertEquals(a, b)
	}
	
	@Test
	fun getLoggerByClassReturnsEqualObjects() {
		val a = StubClass().logger
		val b = Logging.getLogger<StubClass>()
		
		assertEquals(a, b)
	}
	
	@Test
	fun getLoggerByClassAndNameReturnsEqualObjects() {
		val a = StubClass().logger
		val b = Logging.getLogger("ru.capjack.kt.logging.StubClass")
		
		assertEquals(a, b)
	}
}