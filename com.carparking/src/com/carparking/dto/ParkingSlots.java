package com.carparking.dto;

public class ParkingSlots {

	private char[][][] parking = new char[3][4][4];
	private int[][][] slots = new int[3][4][4];

	private int floor_count = parking[0].length * parking[0][0].length;
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

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
