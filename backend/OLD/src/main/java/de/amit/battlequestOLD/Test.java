package de.amit.battlequestOLD;

import java.io.File;
import java.io.FileFilter;

public class Test {

	private static void list(File file, int tab) {
		final boolean isDirectory = file.isDirectory();
		if (isDirectory) {
			for (final File subFile : file.listFiles((FileFilter) f -> !f.isDirectory()))
				System.out.printf("%" + tab + "s- %s%n", "", subFile.getName());
			for (final File subFile : file.listFiles((FileFilter) File::isDirectory)) {
				System.out.printf("%" + tab + "s\\ %s%n", "", subFile.getName());
				list(subFile, tab + 1);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("Battlequest Directory");
		list(new File(System.getProperty("user.dir") + "\\src\\main"), 1);
	}
}
