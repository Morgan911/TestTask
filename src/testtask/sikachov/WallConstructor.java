package testtask.sikachov;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import testtask.sikachov.entities.Brick;

public class WallConstructor {

	private List<Brick> bricks;

	public WallConstructor() {
		bricks = new ArrayList<Brick>();
	}

	public boolean canBeBuild(int[][] pattern) {
		for (int i = pattern.length - 1; i >= 0; i--) {
			int fillSize = 0;
			for (int j = 0; j < pattern[i].length; j++) {
				if (pattern[i][j] == 1) {
					++fillSize;
				} else {
					if (!buildBricksForSize(fillSize))
						return false;
					fillSize = 0;
				}
			}
			if (!buildBricksForSize(fillSize))
				return false;
		}
		return true;
	}

	public void addBricks(int count, int lenght) {
		for (int i = 0; i < count; i++) {
			bricks.add(new Brick(lenght));
		}
		Collections.sort(bricks, new Comparator<Brick>() {
			@Override
			public int compare(Brick b1, Brick b2) {
				if (b1.getLenght() > b2.getLenght())
					return -1;
				else
					return (b1.getLenght() < b2.getLenght()) ? 1 : 0;
			}
		});
	}

	private boolean buildBricksForSize(int size) {
		int lastSize = size;
		for (Brick brick : bricks) {
			if (!brick.isUsed() && lastSize > 0
					&& lastSize >= brick.getLenght()) {
				brick.setUsed(true);
				lastSize -= brick.getLenght();
			}
		}
		return (lastSize == 0) ? true : false;
	}

	public void clean() {
		bricks.clear();
	}
}
