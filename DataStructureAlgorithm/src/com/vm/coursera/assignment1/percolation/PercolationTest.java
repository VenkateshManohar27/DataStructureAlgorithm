package com.vm.coursera.assignment1.percolation;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * 
 * @author Venkatesh Manohar
 *
 */
public class PercolationTest {
	/**
	 * Test creation of percolation
	 */
	@Test
	public void TestCreationOfPercolation() {
		Percolation p = new Percolation(2);
		assertEquals(p.numberOfOpenSites(), 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void TestConstructorFialure() {
		new Percolation(0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void TestConstructorFialureWithNegativeNumbers() {
		new Percolation(-1);
	}

	@Test
	public void TestIsOpenOnCreation() {
		Percolation p = new Percolation(2);
		assertFalse(p.isOpen(1, 1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void TestOpenInvalidIndex() {
		Percolation p = new Percolation(2);
		p.open(2, 3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void TestOpenZeroIndex() {
		Percolation p = new Percolation(2);
		p.open(0, 3);
	}

	@Test
	public void TestFirstCellIsFullOnCreation() {
		Percolation p = new Percolation(2);
		assertFalse(p.isFull(1, 1));
	}

	@Test
	public void TestOpenFirstCellAndTestIsFull() {
		Percolation p = new Percolation(2);
		p.open(1, 1);
		assertEquals(1, p.numberOfOpenSites());
		assertTrue(p.isFull(1, 1));
	}

	@Test
	public void TestIsFullSecondRowSecondsite() {
		Percolation p = new Percolation(2);
		p.open(1, 1);
		p.open(1, 2);
		p.open(2, 2);
		assertEquals(3, p.numberOfOpenSites());
		assertTrue(p.isFull(2, 2));
	}

	@Test
	public void TestPercolates2x2() {
		Percolation p = new Percolation(2);
		p.open(1, 1);
		p.open(1, 2);
		p.open(2, 2);
		assertEquals(3, p.numberOfOpenSites());
		assertTrue(p.percolates());
	}

	@Test
	public void TestCornerCaseForN1() {
		Percolation p = new Percolation(1);
		p.open(1, 1);
		assertTrue(p.percolates());
	}

	@Test
	public void TestCornerCaseForN2() {
		Percolation p = new Percolation(2);
		p.open(1, 1);
		p.open(2, 2);
		p.open(1, 2);
		assertTrue(p.percolates());
	}

	@Test
	public void TestCornerCaseForN1NoInput() {
		Percolation p = new Percolation(1);
		assertFalse(p.percolates());
	}

	@Test
	public void TestCornerCaseForN3() {
		Percolation p = new Percolation(3);
		p.open(1, 3);
		p.open(2, 3);
		p.open(3, 3);
		p.open(3, 1);
		assertFalse(p.isFull(3, 1));
		p.open(2, 1);
		p.open(1, 1);
		assertTrue(p.percolates());
	}
	
	@Test
	public void TestCornerCaseForN4() {
		Percolation p = new Percolation(4);
		p.open(4, 1);
		p.open(3, 1);
		p.open(2, 1);
		p.open(1, 1);
		p.open(1, 4);
		p.open(2, 4);
		p.open(4, 4);
		assertFalse(p.isFull(4, 4));
		p.open(3,4);
		assertTrue(p.percolates());
	}
}
