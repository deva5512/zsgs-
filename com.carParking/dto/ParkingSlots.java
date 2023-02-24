package com.carparking.dto;

public class ParkingSlots {

	private char[][][] parking = new char[3][4][4];
	private int[][][] slots = new int[3][4][4];

	private int floor_count = parking[0].length * parking[0][0].length;
	private int first_floor_start = 0;
	private int first_floor_end = floor_count;
	private int second_floor_start = floor_count + 1;
	private int second_floor_end = floor_count * 2;
	private int third_floor_start = floor_count * 2 + 1;
	private int third_floor_end = floor_count * 3;
	private int total = floor_count * parking.length;

	public ParkingSlots() {
		fillSlot(slots);
		fillSlot(parking);
	}

	public char[][][] getParking() {
		return parking;
	}

	public int[][][] getSlots() {
		return slots;
	}

	public int getFloor_count() {
		return floor_count;
	}

	public void setFloor_count(int floor_count) {
		this.floor_count = floor_count;
	}

	public int getFirst_floor_start() {
		return first_floor_start;
	}

	public void setFirst_floor_start(int first_floor_start) {
		this.first_floor_start = first_floor_start;
	}

	public int getFirst_floor_end() {
		return first_floor_end;
	}

	public void setFirst_floor_end(int first_floor_end) {
		this.first_floor_end = first_floor_end;
	}

	public int getSecond_floor_start() {
		return second_floor_start;
	}

	public void setSecond_floor_start(int second_floor_start) {
		this.second_floor_start = second_floor_start;
	}

	public int getSecond_floor_end() {
		return second_floor_end;
	}

	public void setSecond_floor_end(int second_floor_end) {
		this.second_floor_end = second_floor_end;
	}

	public int getThird_floor_start() {
		return third_floor_start;
	}

	public void setThird_floor_start(int third_floor_start) {
		this.third_floor_start = third_floor_start;
	}

	public int getThird_floor_end() {
		return third_floor_end;
	}

	public void setThird_floor_end(int third_floor_end) {
		this.third_floor_end = third_floor_end;
	}

	private void fillSlot(int[][][] slots) {
		int val = 1;
		for (int[][] a : slots) {
			for (int[] b : a) {
				for (int i = 0; i < b.length; i++) {
					b[i] = val++;
				}
			}
		}
	}

	private void fillSlot(char[][][] slots) {
		int val = 1;
		for (char[][] a : slots) {
			for (char[] b : a) {
				for (int i = 0; i < b.length; i++) {
					b[i] = 'O';
				}
			}
		}
	}

	private void print(int[][][] arr) {
		for (int i = -1; i < arr[0].length; i++) {

			for (int a = 0; a < arr.length; a++) {
				if (i == -1)
					System.out.print("  Floor " + a + "   ");
				else {
					for (int b = 0; b < arr[a][i].length; b++) {
						System.out.print(arr[a][i][b] + "  ");
					}
				}
				System.out.print("     ");
			}
			System.out.println("\n");
		}
	}

	private void print(char[][][] arr) {
		for (int i = -1; i < arr[0].length; i++) {

			for (int a = 0; a < arr.length; a++) {
				if (i == -1)
					System.out.print("  Floor " + a + "   ");
				else {
					for (int b = 0; b < arr[a][i].length; b++) {
						System.out.print(arr[a][i][b] + "  ");
					}
				}
				System.out.print("     ");
			}
			System.out.println("\n");
		}
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
