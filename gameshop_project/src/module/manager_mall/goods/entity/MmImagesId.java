package module.manager_mall.goods.entity;

/**
 * MmImagesId entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class MmImagesId implements java.io.Serializable {

	// Fields

	private String imageUri;
	private MmGoods mmGoods;

	// Constructors

	/** default constructor */
	public MmImagesId() {
	}

	/** full constructor */
	public MmImagesId(String imageUri, MmGoods mmGoods) {
		this.imageUri = imageUri;
		this.mmGoods = mmGoods;
	}

	// Property accessors

	public String getImageUri() {
		return this.imageUri;
	}

	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}

	public MmGoods getMmGoods() {
		return this.mmGoods;
	}

	public void setMmGoods(MmGoods mmGoods) {
		this.mmGoods = mmGoods;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MmImagesId))
			return false;
		MmImagesId castOther = (MmImagesId) other;

		return ((this.getImageUri() == castOther.getImageUri()) || (this
				.getImageUri() != null && castOther.getImageUri() != null && this
				.getImageUri().equals(castOther.getImageUri())))
				&& ((this.getMmGoods() == castOther.getMmGoods()) || (this
						.getMmGoods() != null && castOther.getMmGoods() != null && this
						.getMmGoods().equals(castOther.getMmGoods())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getImageUri() == null ? 0 : this.getImageUri().hashCode());
		result = 37 * result
				+ (getMmGoods() == null ? 0 : this.getMmGoods().hashCode());
		return result;
	}

}