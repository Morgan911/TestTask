package testtask.sikachov;

import java.util.Arrays;
import java.util.Scanner;

public class ConsoleApp {

	private Scanner scanner;
	private WallConstructor constructor;

	public ConsoleApp() {
		scanner = new Scanner(System.in);
		constructor = new WallConstructor();
	}

	public void start() {
		while (true) {
			System.out.println("Do you want to start building? y/n");
			String input = scanner.nextLine();
			if (input.equals("n"))
				System.exit(0);
			constructor.clean();
			System.out.println("Width and height(for example:2 2) : ");
			input = scanner.nextLine();
			String[] params = input.split(" ");
			int[][] pattern = new int[Integer.parseInt(params[0])][Integer
					.parseInt(params[1])];

			for (int i = 0; i < pattern.length; i++) {
				System.out.println("Pattern for " + (pattern.length - i)
						+ " floor" + " (for example:10101) : ");
				input = scanner.nextLine();
				for (int j = 0; j < pattern[i].length; j++) {
					pattern[i][j] = Character.getNumericValue(input.charAt(j));
				}
			}
			System.out.println("Number of brick types:");
			input = scanner.nextLine();
			int numberOfBricks = Integer.parseInt(input);
			for (int i = 0; i < numberOfBricks; i++) {
				System.out.println("Input count and lenght of " + i
						+ " brick group(for example:2 2):");
				input = scanner.nextLine();
				String[] brickInfo = input.split(" ");
				constructor.addBricks(Integer.parseInt(brickInfo[0]),
						Integer.parseInt(brickInfo[1]));
			}
			if (constructor.canBeBuild(pattern))
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}

	public static void main(String[] args) {
		ConsoleApp app = new ConsoleApp();
		app.start();

	}
}
