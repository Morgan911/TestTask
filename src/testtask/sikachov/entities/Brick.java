package testtask.sikachov.entities;

public class Brick {

	private int lenght;
	private boolean used;
	
	public Brick(int lenght){
		setLenght(lenght);
		setUsed(false);
	}

	public int getLenght() {
		return lenght;
	}

	public void setLenght(int lenght) {
		this.lenght = lenght;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}
}