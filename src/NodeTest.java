import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

  // -------- WAVE 1 -------

  @Test
  void testListConstructorWithThreeValues() {
    // Arrange
    List<Integer> values = List.of(5, 7, 3);

    // Act
    Node head = new Node(values);

    // Assert
    assertEquals(5, head.value);
    assertNotNull(head.next);
    assertEquals(7, head.next.value);
    assertNotNull(head.next.next);
    assertEquals(3, head.next.next.value);
    assertNull(head.next.next.next);
    assertEquals(head, head.next.prev);
    assertEquals(head.next, head.next.next.prev);
  }

@Test
void testListConstructorWithFourValues() {
  // Arrange
  List<Integer> values = List.of(96, 97, 98, 99);

  // Act
  Node head = new Node(values);

  // Assert
  assertEquals(96, head.value);
  assertNotNull(head.next);
  assertEquals(97, head.next.value);
  assertNotNull(head.next.next);
  assertEquals(98, head.next.next.value);
  assertNotNull(head.next.next.next);
  assertEquals(99, head.next.next.next.value);
  assertNull(head.next.next.next.next);

  assertNull(head.prev);
  assertEquals(head, head.next.prev);
  assertEquals(head.next, head.next.next.prev);
  assertEquals(head.next.next, head.next.next.next.prev);
}

@Test
void testListConstructorWithFiveValues() {
  // Arrange
  List<Integer> values = List.of(96, 97, 98, 99, 100);  // Five values

  // Act
  Node head = new Node(values);

  // Assert
  assertEquals(96, head.value);
  assertNotNull(head.next);
  assertEquals(97, head.next.value);
  assertNotNull(head.next.next);
  assertEquals(98, head.next.next.value);
  assertNotNull(head.next.next.next);
  assertEquals(99, head.next.next.next.value);
  assertNotNull(head.next.next.next.next);
  assertEquals(100, head.next.next.next.next.value);
  assertNull(head.next.next.next.next.next);

  assertNull(head.prev);
  assertEquals(head, head.next.prev);
  assertEquals(head.next, head.next.next.prev);
  assertEquals(head.next.next, head.next.next.next.prev);
  assertEquals(head.next.next.next, head.next.next.next.next.prev);
}    

  @Test
  void testListConstructorWithEmptyList() {
    // Arrange
    List<Integer> emptyList = new ArrayList<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new Node(emptyList),
        "Expected constructor to throw IllegalArgumentException for an empty list."
    );
  }

  @Test
  void testListConstructorWithNullList() {
    // Arrange
    List<Integer> nullList = null;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new Node(nullList),
        "Expected constructor to throw IllegalArgumentException for a null list."
    );
  }

  @Test
  void testListConstructorWithOneElementInList() {
    // Arrange
    List<Integer> oneElementList = List.of(99);
    
    // Act
    Node head = new Node(oneElementList);

    // Assert
    assertEquals(99, head.value);
    assertNull(head.next);
    assertNull(head.prev);
  }


  // -------- WAVE 2 -------

  @Test
  void testToListWithThreeValues() {
    // Arrange
    Node head = new Node(5);
    Node middle = new Node(7);
    Node tail = new Node(3);

    head.next = middle;
    middle.prev = head;
    middle.next = tail;
    tail.prev = middle;

    // Act
    List<Integer> values = head.toList();

    // Assert
    assertEquals(List.of(5, 7, 3), values);
  }

  @Test
  void testToListWithThreeValues_returnOnlyValuesFromMiddleToTail() {
    // Arrange
    Node head = new Node(5);
    Node middle = new Node(7);
    Node tail = new Node(3);

    head.next = middle;
    middle.prev = head;
    middle.next = tail;
    tail.prev = middle;

    // Act
    List<Integer> values = middle.toList();

    // Assert
    assertEquals(List.of(7, 3), values);
  }
  
  @Test
  void testToListWithThreeValues_returnOnlyTheValueofTail() {
    // Arrange
    Node head = new Node(5);
    Node middle = new Node(7);
    Node tail = new Node(3);

    head.next = middle;
    middle.prev = head;
    middle.next = tail;
    tail.prev = middle;

    // Act
    List<Integer> values = tail.toList();

    // Assert
    assertEquals(List.of(3), values);
    assertNull(tail.next);
  } 

  @Test
  void testToListWithOneNode_whenNextIsNullAndPrevIsNull() {
    // Arrange
    Node head = new Node(100);

    // Act
    List<Integer> values = head.toList();

    // Assert
    assertEquals(List.of(100), values);
    assertNull(head.next);
    assertNull(head.prev);
  }
}
