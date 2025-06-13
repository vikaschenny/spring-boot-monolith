# Java Best Practice Rules Test Files

This directory contains Java test files designed to trigger the best practice rules implemented in `bestpractice.go`.

## Test Files Overview

### 1. StringBuilderTest.java
**Triggers:** BP-JAVA-001 (UseStringBuilderRule)
- String concatenation inside for loops
- String concatenation inside while loops  
- String concatenation inside enhanced for loops

### 2. FinalizerTest.java
**Triggers:** BP-JAVA-002 (AvoidEmptyFinalizerRule)
- Empty finalize() methods
- finalize() methods with only comments

### 3. CollectionTest.java
**Triggers:** 
- BP-JAVA-003 (PreferCollectionIsEmptyRule) - `size() == 0`
- BP-JAVA-013 (UseCollectionIsEmptyAdvancedRule) - Various size() comparisons
- BP-JAVA-014 (UseEnumCollectionsRule) - HashSet/HashMap with enum types

### 4. ExceptionResourceTest.java
**Triggers:**
- BP-JAVA-004 (AvoidCatchingGenericExceptionRule) - Catching generic Exception
- BP-JAVA-007 (UseProperResourceManagementRule) - Resources not in try-with-resources
- BP-JAVA-009 (UseStandardCharsetsRule) - Charset.forName() with standard charsets 
- BP-JAVA-010 (UseTryWithResourcesRule) - Try-finally with manual resource closing

### 5. StructureTest.java
**Triggers:**
- BP-JAVA-005 (AvoidDeepNestingRule) - Deeply nested control structures
- BP-JAVA-006 (UseEnumsInsteadOfConstantsRule) - Multiple constants of same type
- BP-JAVA-008 (UseVarargsRule) - Array parameters that could be varargs

### 6. UnusedCodeTest.java
**Triggers:**
- BP-JAVA-011 (UnusedPrivateFieldRule) - Unused private fields
- BP-JAVA-012 (UnusedPrivateMethodRule) - Unused private methods
- BP-JAVA-015 (UnusedAssignmentRule) - Unused assignments
- BP-JAVA-016 (UnusedFormalParameterRule) - Unused method parameters
- BP-JAVA-017 (UnusedLocalVariableAdvancedRule) - Unused local variables

### 7. UnitTestAnnotationTest.java
**Triggers:**
- BP-JAVA-018 (UnitTestShouldUseBeforeAnnotationRule) - setUp() methods without @Before annotation
- BP-JAVA-019 (UnitTestShouldUseTestAnnotationRule) - test methods without @Test annotation

### 8. VarargsArrayTest.java
**Triggers:**
- BP-JAVA-020 (UnnecessaryVarargsArrayCreationRule) - Unnecessary array creation for varargs

### 9. SystemAndAssertionTest.java
**Triggers:**
- BP-JAVA-021 (SystemPrintlnRule) - System.out/err usage for debugging
- BP-JAVA-022 (UnitTestAssertionsShouldIncludeMessageRule) - Assertions without messages
- BP-JAVA-023 (UnitTestContainsTooManyAssertsRule) - Tests with too many assertions
- BP-JAVA-024 (UnitTestShouldIncludeAssertRule) - Tests without any assertions

### 10. LegacyCollectionsTest.java
**Triggers:**
- BP-JAVA-025 (ReplaceEnumerationWithIteratorRule) - Enumeration usage instead of Iterator
- BP-JAVA-026 (ReplaceHashtableWithMapRule) - Hashtable usage instead of Map
- BP-JAVA-027 (ReplaceVectorWithListRule) - Vector usage instead of List
- BP-JAVA-028 (SimplifiableTestAssertionRule) - Test assertions that can be simplified

### 11. NewRulesTest.java
**Triggers:**
- BP-JAVA-029 (OneDeclarationPerLineRule) - Multiple variable declarations on the same line
- BP-JAVA-030 (PreserveStackTraceRule) - Exceptions that don't preserve original stack trace
- BP-JAVA-031 (PrimitiveWrapperInstantiationRule) - Usage of deprecated primitive wrapper constructors

### 12. ComprehensiveTest.java
**Triggers:** Multiple rules in one file
- Combines violations from all the above rules including new ones
- Useful for testing rule interactions and comprehensive analysis

## Rule Coverage

| Rule ID | Rule Name | Test Files |
|---------|-----------|------------|
| BP-JAVA-001 | UseStringBuilderRule | StringBuilderTest.java, ComprehensiveTest.java |
| BP-JAVA-002 | AvoidEmptyFinalizerRule | FinalizerTest.java, ComprehensiveTest.java |
| BP-JAVA-003 | PreferCollectionIsEmptyRule | CollectionTest.java, ComprehensiveTest.java |
| BP-JAVA-004 | AvoidCatchingGenericExceptionRule | ExceptionResourceTest.java, ComprehensiveTest.java |
| BP-JAVA-005 | AvoidDeepNestingRule | StructureTest.java, ComprehensiveTest.java |
| BP-JAVA-006 | UseEnumsInsteadOfConstantsRule | StructureTest.java, ComprehensiveTest.java |
| BP-JAVA-007 | UseProperResourceManagementRule | ExceptionResourceTest.java, ComprehensiveTest.java |
| BP-JAVA-008 | UseVarargsRule | StructureTest.java, ComprehensiveTest.java |
| BP-JAVA-009 | UseStandardCharsetsRule | ExceptionResourceTest.java, ComprehensiveTest.java |
| BP-JAVA-010 | UseTryWithResourcesRule | ExceptionResourceTest.java, ComprehensiveTest.java |
| BP-JAVA-011 | UnusedPrivateFieldRule | UnusedCodeTest.java, ComprehensiveTest.java |
| BP-JAVA-012 | UnusedPrivateMethodRule | UnusedCodeTest.java, ComprehensiveTest.java |
| BP-JAVA-013 | UseCollectionIsEmptyAdvancedRule | CollectionTest.java, ComprehensiveTest.java |
| BP-JAVA-014 | UseEnumCollectionsRule | CollectionTest.java, ComprehensiveTest.java |
| BP-JAVA-015 | UnusedAssignmentRule | UnusedCodeTest.java, ComprehensiveTest.java |
| BP-JAVA-016 | UnusedFormalParameterRule | UnusedCodeTest.java, ComprehensiveTest.java |
| BP-JAVA-017 | UnusedLocalVariableAdvancedRule | UnusedCodeTest.java, ComprehensiveTest.java |
| BP-JAVA-018 | UnitTestShouldUseBeforeAnnotationRule | UnitTestAnnotationTest.java, ComprehensiveTest.java |
| BP-JAVA-019 | UnitTestShouldUseTestAnnotationRule | UnitTestAnnotationTest.java, ComprehensiveTest.java |
| BP-JAVA-020 | UnnecessaryVarargsArrayCreationRule | VarargsArrayTest.java, ComprehensiveTest.java |
| BP-JAVA-021 | SystemPrintlnRule | SystemAndAssertionTest.java, ComprehensiveTest.java |
| BP-JAVA-022 | UnitTestAssertionsShouldIncludeMessageRule | SystemAndAssertionTest.java, ComprehensiveTest.java |
| BP-JAVA-023 | UnitTestContainsTooManyAssertsRule | SystemAndAssertionTest.java, ComprehensiveTest.java |
| BP-JAVA-024 | UnitTestShouldIncludeAssertRule | SystemAndAssertionTest.java, ComprehensiveTest.java |
| BP-JAVA-025 | ReplaceEnumerationWithIteratorRule | LegacyCollectionsTest.java, ComprehensiveTest.java |
| BP-JAVA-026 | ReplaceHashtableWithMapRule | LegacyCollectionsTest.java, ComprehensiveTest.java |
| BP-JAVA-027 | ReplaceVectorWithListRule | LegacyCollectionsTest.java, ComprehensiveTest.java |
| BP-JAVA-028 | SimplifiableTestAssertionRule | LegacyCollectionsTest.java, ComprehensiveTest.java |
| BP-JAVA-029 | OneDeclarationPerLineRule | NewRulesTest.java |
| BP-JAVA-030 | PreserveStackTraceRule | NewRulesTest.java |
| BP-JAVA-031 | PrimitiveWrapperInstantiationRule | NewRulesTest.java |

## Usage

These test files can be used to:
1. Verify that the best practice rules are working correctly
2. Test the static analyzer against known code patterns
3. Validate rule accuracy and reduce false positives
4. Benchmark rule performance

Each file contains comments indicating which specific rules should be triggered by each code pattern.

## New Rules Details

### BP-JAVA-029: OneDeclarationPerLineRule
- **Classification:** Maintainability
- **Description:** Detects multiple variable declarations on the same line and suggests separating them
- **Example:** `String name, description;` should be `String name; String description;`
- **Benefits:** Enhances code readability and makes debugging easier

### BP-JAVA-030: PreserveStackTraceRule  
- **Classification:** Maintainability
- **Description:** Reports exceptions thrown from catch blocks that don't preserve the original exception
- **Example:** `catch(IOException e) { throw new RuntimeException("error"); }` should preserve `e`
- **Benefits:** Maintains debugging information and stack trace context

### BP-JAVA-031: PrimitiveWrapperInstantiationRule
- **Classification:** Maintainability  
- **Description:** Detects usage of deprecated primitive wrapper constructors (since Java 9)
- **Example:** `new Integer(42)` should be `Integer.valueOf(42)`
- **Benefits:** Uses modern Java patterns and avoids deprecated constructors 