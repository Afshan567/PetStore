package PojoPackage;

public class PojoClass {

	int id;
	String name;
	String[] photoUrls;
	String status;
	
	public PojoClass(int id, String name, String[] photoUrls, String status) {
		super();
		this.id = id;
		this.name = name;
		this.photoUrls = photoUrls;
		this.status = status;
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
	public String[] getPhotoUrls() {
		return photoUrls;
	}
	public void setPhotoUrls(String[] photoUrls) {
		this.photoUrls = photoUrls;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}