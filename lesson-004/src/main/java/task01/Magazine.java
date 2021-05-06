package task01;

public class Magazine {

	private int id;
	private String name;
	private String isbn;
	private int genre_id;

	public Magazine(int id, String name, String isbn, int genre_id) {
		super();
		this.id = id;
		this.name = name;
		this.isbn = isbn;
		this.genre_id = genre_id;
	}

	public Magazine(String name, String isbn, int genre_id) {
		super();
		this.name = name;
		this.isbn = isbn;
		this.genre_id = genre_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getGenre_id() {
		return genre_id;
	}

	public void setGenre_id(int genre_id) {
		this.genre_id = genre_id;
	}

	@Override
	public String toString() {
		return "Magazine [id=" + id + ", name=" + name + ", isbn=" + isbn + ", genre_id=" + genre_id + "]";
	}

}