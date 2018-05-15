package module.manager_mall.goods.entity;

/**
 * MmImages entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class MmImages implements java.io.Serializable {

	// Fields

	private MmImagesId id;

	// Constructors

	/** default constructor */
	public MmImages() {
	}

	/** full constructor */
	public MmImages(MmImagesId id) {
		this.id = id;
	}

	// Property accessors

	public MmImagesId getId() {
		return this.id;
	}

	public void setId(MmImagesId id) {
		this.id = id;
	}

}