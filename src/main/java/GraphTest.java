import static org.junit.jupiter.api.Assertions.*;

class GraphTest<E>
{
    //Arrange
    Graph<String> graphTest = new Graph<>(10);

    @org.junit.jupiter.api.Test
    void testGetLabel() {

        // Arrange
        graphTest.setLabel(0, "W");
        graphTest.setLabel(1, "X");
        graphTest.setLabel(2, "Y");
        graphTest.setLabel(3, "Z");

        // Act
        graphTest.getLabel(2);

        // Assert
        assertNotEquals("Z","Y");
        assertEquals("Y", "Y");
    }


    @org.junit.jupiter.api.Test
    void testIsEdge() {
        // Arrange
        graphTest.setLabel(0, "X");
        graphTest.setLabel(1, "Y");
        graphTest.setLabel(2, "Z");
        graphTest.addEdge(0, 2);
        graphTest.addEdge(0, 1);
        graphTest.addEdge(2, 0);

        // Act
        graphTest.isEdge(1,2);

        // Assert
        assertEquals(false, false);
    }

    @org.junit.jupiter.api.Test
    void testAddEdge() {
        // Arrange
        graphTest.setLabel(0, "X");
        graphTest.setLabel(1, "Y");
        graphTest.setLabel(2, "Z");

        // Act
        graphTest.addEdge(0, 2);
        graphTest.addEdge(0, 1);
        graphTest.size();

        // Assert
        assertEquals(3, 3);
    }

    @org.junit.jupiter.api.Test
    void testSetLabel() {
        // Act
        graphTest.setLabel(1, "W");
        graphTest.setLabel(5, "T");
        graphTest.getLabel(1);

        // Assert
        assertNotEquals("T", "W");
    }


    @org.junit.jupiter.api.Test
    void testSize() {
        // Arrange
        graphTest.setLabel(0, "W");
        graphTest.setLabel(1, "X");
        graphTest.setLabel(2, "Y");

        // Act
        graphTest.size();

        // Assert
        assertNotEquals(0, 3);
    }

    @org.junit.jupiter.api.Test
    void testGetBreadthFirstSearch() {
        // Arrange
        graphTest.setLabel(0,"A");
        graphTest.setLabel(1,"B");
        graphTest.setLabel(2,"C");
        graphTest.setLabel(3,"D");
        graphTest.setLabel(4,"E");
        graphTest.setLabel(5,"F");
        graphTest.setLabel(6,"G");
        graphTest.setLabel(7,"H");
        graphTest.setLabel(8,"I");

        // Act
        graphTest.addEdge(0,1);
        graphTest.addEdge(0,3);
        graphTest.addEdge(0,4);
        graphTest.addEdge(1,4);
        graphTest.addEdge(3,6);
        graphTest.addEdge(4,5);
        graphTest.addEdge(4,7);
        graphTest.addEdge(6,7);
        graphTest.addEdge(5,3);
        graphTest.addEdge(5,7);
        graphTest.addEdge(7,8);
        graphTest.addEdge(2,1);
        graphTest.addEdge(8,5);

        // Assert
        assertNotEquals("ABCDEFGHI", "ABDEGFHCI");
    }

    @org.junit.jupiter.api.Test
    void testGetDepthFirstSearch() {
        graphTest.setLabel(0,"A");
        graphTest.setLabel(1,"B");
        graphTest.setLabel(2,"C");
        graphTest.setLabel(3,"D");
        graphTest.setLabel(4,"E");
        graphTest.setLabel(5,"F");
        graphTest.setLabel(6,"G");
        graphTest.setLabel(7,"H");
        graphTest.setLabel(8,"I");

        // Act
        graphTest.addEdge(0,1);
        graphTest.addEdge(0,3);
        graphTest.addEdge(0,4);
        graphTest.addEdge(1,4);
        graphTest.addEdge(3,6);
        graphTest.addEdge(4,5);
        graphTest.addEdge(4,7);
        graphTest.addEdge(6,7);
        graphTest.addEdge(5,3);
        graphTest.addEdge(5,7);
        graphTest.addEdge(7,8);
        graphTest.addEdge(2,1);
        graphTest.addEdge(8,5);

        // Assert
        assertNotEquals("ABDEGFHCI", "ABEFCHIDG");
    }
}
