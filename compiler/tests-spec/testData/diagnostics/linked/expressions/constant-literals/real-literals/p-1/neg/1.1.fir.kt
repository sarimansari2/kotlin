/*
 * KOTLIN DIAGNOSTICS SPEC TEST (NEGATIVE)
 *
 * SPEC VERSION: 0.1-100
 * MAIN LINK: expressions, constant-literals, real-literals -> paragraph 1 -> sentence 1
 * NUMBER: 1
 * DESCRIPTION: Real literals separeted by comments.
 */

// TESTCASE NUMBER: 1
val value_1 = 0./**/99901

// TESTCASE NUMBER: 2
val value_2 = 2./** some doc */1

// TESTCASE NUMBER: 3
val value_3 = 9999./** some doc *//**/1

// TESTCASE NUMBER: 4
val value_4 = 9999./** some /** some doc */ doc */1

// TESTCASE NUMBER: 5
val value_5 = 9999./**/
1

// TESTCASE NUMBER: 6
val value_6 = 1000000.//0
0