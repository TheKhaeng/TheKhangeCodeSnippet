/****************************************/
/** Created by TheKhaeng on 7/23/2016. **/
/****************************************/

Test level
Unit testing : stup/mock, Test class/method it works?
Integration testing : use real class
System Testing :
UAT :

Stup
- fake object
- break dependency (TestObject implement interface)
- instead External resource (ex. FileSystem)
- test end result with CUT

Mock
- fake object and interact
- test method call, interact with CUT

Stup vs Mock
- Stub cannot fail test but Mock can.

// Stup/Mock framework (not use inner class)
- jMock
- EasyMock
- Mockito

// [ Assert ]
assertArrayEquals( msg, arrayExpects[], arrayActuals[]);
assertEquals( msg, expect, actual, delta );
assertFalse( msg, boolean );
assertTrue( msg, boolean );
assertNull( msg, obj );
assertNotNull( msg, obj );
assertSame( msg, expectObj, actualObj );
assertNotSame( msg, unexpectObj, actualObj );
assertThat( msg, actual, hamcrestMatcher );


// [ Hamcreat Matcher ] (most usage)
// anything, allOf, anyOf
// is, not
// notNullValue, nullValue
// hasItem, hasItems
// instanceOf, isCompatibleType
// sameInstance
// hasEntry, hasKey, hasValue
// containsString, endsWith, startsWith
